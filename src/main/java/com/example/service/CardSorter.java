package com.example.service;

import com.example.model.Card;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CardSorter {
    // 定义牌面点数的大小顺序
    private static final Map<String, Integer> CARD_RANKS = Map.ofEntries(
            Map.entry("2", 2),
            Map.entry("3", 3),
            Map.entry("4", 4),
            Map.entry("5", 5),
            Map.entry("6", 6),
            Map.entry("7", 7),
            Map.entry("8", 8),
            Map.entry("9", 9),
            Map.entry("10", 10),
            Map.entry("J", 11),
            Map.entry("Q", 12),
            Map.entry("K", 13),
            Map.entry("A", 14),
            Map.entry("JOKER", 15)  // 表示大小王
    );


    public static List<Card> sort(List<Card> cards, String trumpNum) {

        cards.sort(Comparator.comparingInt((Card c) -> getCardWeight(c, trumpNum))
                .thenComparingInt(c -> CARD_RANKS.getOrDefault(c.getNum(), 0))
                .thenComparing(Card::getColor).reversed()) ;
        return cards;
    }

    // 计算牌的权重
    private static int getCardWeight(Card card, String trumpNum) {
        if ("R".equals(card.getColor())) return 4; // 大王
        if ("B".equals(card.getColor())) return 3; // 小王
        if (card.getNum().equals(trumpNum)) return 2;    // 级牌
        return 1;                                        // 普通牌
    }
}
