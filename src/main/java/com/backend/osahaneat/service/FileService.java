package com.backend.osahaneat.service;

import com.backend.osahaneat.service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService implements FileServiceImp {

    @Value("${fileUpLoad.rootPath}")
    private String rootPath;
    private Path root;

    public void init(){
        root = Paths.get(rootPath);
        if(!Files.exists(root)){
            try {
                Files.createDirectories(root);

            } catch (IOException e) {
                System.out.println( "Error, create folder :" +e.getMessage());;
            }
        }
    }

    @Override
    public boolean saveFile(MultipartFile file) {
        init();
        try {
            Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println( "Error, save file :" +e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Resource loadFile(String fileName) {
        init();
        Path file = root.resolve(fileName);
        try {
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
        } catch (MalformedURLException e) {
            System.out.println( "Error, load file :" +e.getMessage());
        }
        return null;
    }
}
