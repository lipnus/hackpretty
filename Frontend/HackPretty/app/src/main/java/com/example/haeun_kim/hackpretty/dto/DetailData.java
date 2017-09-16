package com.example.haeun_kim.hackpretty.dto;

public class DetailData {

    private String prod_id;
    private String brand;
    private String name;
    private String corp;
    private String img_path;
    private String score;

    public DetailData(String prod_id, String brand, String name, String corp, String img_path, String score) {
        this.prod_id = prod_id;
        this.brand = brand;
        this.name = name;
        this.corp = corp;
        this.img_path = img_path;
        this.score = score;
    }

    public String getProd_id() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCorp() {
        return corp;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}