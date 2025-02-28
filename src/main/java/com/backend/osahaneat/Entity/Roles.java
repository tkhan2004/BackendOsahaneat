package com.backend.osahaneat.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name="roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name="role_name")
    private String roleName;

    @Column(name="create_date")
    private Date createDate;

    public Set<Users> getListUser() {
        return listUser;
    }

    public void setListUser(Set<Users> listUser) {
        this.listUser = listUser;
    }

    @OneToMany(mappedBy = "roles")
    private Set<Users> listUser;
}
