package com.backend.osahaneat.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name="restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="subtitle")
    private String subtitle;

    @Column(name="Description")
    private String Desc;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public boolean isFreeship() {
        return isFreeship;
    }

    public void setFreeship(boolean freeship) {
        isFreeship = freeship;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    @Column(name="image")
    private String image;

    @Column(name="is_freeship")
    private boolean isFreeship;

    @Column(name="address")
    private String address;

    @Column(name="open_date")
    private Date openDate;

    public Set<RatingRestaurant> getListRatingRestaurant() {
        return listRatingRestaurant;
    }

    public Set<Orders> getListOrders() {
        return listOrders;
    }

    public void setListOrders(Set<Orders> listOrders) {
        this.listOrders = listOrders;
    }

    public void setListRatingRestaurant(Set<RatingRestaurant> listRatingRestaurant) {
        this.listRatingRestaurant = listRatingRestaurant;
    }

    @OneToMany(mappedBy = "restaurant")
    private Set<RatingRestaurant> listRatingRestaurant;

    @OneToMany(mappedBy = "restaurant")
    private Set<Orders> listOrders;

    public Set<MenuRestaurant> getMenuRestaurant() {
        return menuRestaurant;
    }

    public void setMenuRestaurant(Set<MenuRestaurant> menuRestaurant) {
        this.menuRestaurant = menuRestaurant;
    }

    @OneToMany(mappedBy = "restaurant")
    private Set<MenuRestaurant> menuRestaurant;

    public Set<Promo> getListPromo() {
        return listPromo;
    }

    public void setListPromo(Set<Promo> listPromo) {
        this.listPromo = listPromo;
    }

    @OneToMany(mappedBy = "restaurant")
    private Set<Promo> listPromo;

}
