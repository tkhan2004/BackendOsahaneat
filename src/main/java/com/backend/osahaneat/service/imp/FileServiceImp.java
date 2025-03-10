package com.backend.osahaneat.service.imp;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileServiceImp {

    boolean saveFile(MultipartFile file);
    Resource loadFile(String fileName);
}
