package com.example.haeun_kim.hackpretty.dto;

public class DetailData {

    private String prod_id;
    private String brand;
    private String name;
    private String corp;
    private String img_path;
    private String score;

    private String score1;
    private String score2;
    private String score3;
    private String score4;


    public DetailData(String prod_id, String brand, String name, String corp, String img_path, String score, String score1, String score2, String score3, String score4) {
        this.prod_id = prod_id;
        this.brand = brand;
        this.name = name;
        this.corp = corp;
        this.img_path = img_path;
        this.score = score;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
    }

    public String getProd_id() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }


    public String getScore1() {
        return score1;
    }

    public void setScore1(String score1) {
        this.score1 = score1;
    }

    public String getScore2() {
        return score2;
    }

    public void setScore2(String score2) {
        this.score2 = score2;
    }

    public String getScore3() {
        return score3;
    }

    public void setScore3(String score3) {
        this.score3 = score3;
    }

    public String getScore4() {
        return score4;
    }

    public void setScore4(String score4) {
        this.score4 = score4;
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