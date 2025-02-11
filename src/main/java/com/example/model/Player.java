package com.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/3.
 */
public class Player {

    private final String name;
    //使用List存储Card，方便排序
    public List<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

}
