package com.backend.osahaneat.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name= "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name="res_id")
    private Restaurant restaurant;

    @Column(name="create_date")
    private Date createDate;

    public Set<OrderItem> getListOfOrderItem() {
        return listOfOrderItem;
    }

    public void setListOfOrderItem(Set<OrderItem> listOfOrderItem) {
        this.listOfOrderItem = listOfOrderItem;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "orders")
    private Set<OrderItem> listOfOrderItem;

}
