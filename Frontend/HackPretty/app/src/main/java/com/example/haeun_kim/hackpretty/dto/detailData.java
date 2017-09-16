package com.example.haeun_kim.hackpretty.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunpil on 2017-09-16.
 */

public class detailData {

    String name;
    String brand;
    String image;

    List<String> ingredient;
    List<Review> reivewList;


    static class Review{
        String auth;
        String score;
        String content;
    }


    //생성자
    public detailData() {
        this.ingredient = new ArrayList<>();
        this.reivewList = new ArrayList<>();
    }
}
