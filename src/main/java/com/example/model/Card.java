package com.example.model;

/**
 * Created by Administrator on 2016/10/3.
 */
public class Card {
    private final String color;
    private final String num;

    public Card(String color, String num) {
        this.color = color;
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public String getNum() {
        return num;
    }

    @Override
    public String toString() {
        return color + num;  // 例如 ♠A, ♥K, ♦10
    }
}
