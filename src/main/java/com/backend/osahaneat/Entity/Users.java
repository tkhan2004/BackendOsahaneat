package com.backend.osahaneat.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="user_name")
    private String username;

    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Column(name="fullname")
    private String fullname;

    public Set<RatingFood> getListRatingFoods() {
        return listRatingFoods;
    }

    public void setListRatingFoods(Set<RatingFood> listRatingFoods) {
        this.listRatingFoods = listRatingFoods;
    }

    @Column(name="create_date")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Roles roles;

    @OneToMany(mappedBy = "users")
    private Set<RatingFood> listRatingFoods ;

    public Set<RatingRestaurant> getListRatingRestaurants() {
        return listRatingRestaurants;
    }

    public void setListRatingRestaurants(Set<RatingRestaurant> listRatingRestaurants) {
        this.listRatingRestaurants = listRatingRestaurants;
    }

    @OneToMany(mappedBy = "users")
    private Set<RatingRestaurant> listRatingRestaurants;

    public Set<Orders> getListOrder() {
        return listOrder;
    }

    public void setListOrder(Set<Orders> listOrder) {
        this.listOrder = listOrder;
    }

    @OneToMany(mappedBy = "users")
    private Set<Orders> listOrder;
}
