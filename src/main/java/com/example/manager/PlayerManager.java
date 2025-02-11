package com.example.manager;

import com.example.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private static final List<Player> players = new ArrayList<>();

    public void initPlayers() {
        System.out.println("初始化玩家列表");
        players.clear();
        players.add(new Player("玩家1"));
        players.add(new Player("玩家2"));
        players.add(new Player("玩家3"));
        players.add(new Player("玩家4"));
        System.out.println("成功初始化玩家列表");
    }

    public static List<Player> getPlayers() {
        return players;
    }
}
