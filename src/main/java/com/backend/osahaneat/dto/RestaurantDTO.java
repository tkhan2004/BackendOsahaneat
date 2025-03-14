package com.backend.osahaneat.dto;

public class RestaurantDTO {
    private String image;
    private String title;
    private double rating;
    private String subTitle;
    private String desc;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isFreship() {
        return isFreship;
    }

    public void setFreship(boolean freship) {
        isFreship = freship;
    }

    private boolean isFreship;
}
