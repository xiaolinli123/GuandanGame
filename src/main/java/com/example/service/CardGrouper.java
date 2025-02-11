package com.example.service;

import com.example.model.Card;

import java.util.*;



public class CardGrouper {

    /**
     * 对已排序的手牌按点数进行分组
     * @param sortedCards 已排序的手牌
     * @return 按点数分组的 Map
     */
    public static Map<String, List<Card>> groupByNumber(List<Card> sortedCards) {
        Map<String, List<Card>> groupedCards = new LinkedHashMap<>(); // 保持原有顺序

        for (Card card : sortedCards) {
            String key;
            // 分别处理大王和小王
            if ("R".equals(card.getColor())) {
                key = "RJOKER";  // 大王单独分组
            } else if ("B".equals(card.getColor())) {
                key = "BJOKER";  // 小王单独分组
            } else {
                key = card.getNum();  // 其他牌按点数分组
            }
            groupedCards.computeIfAbsent(key, k -> new ArrayList<>()).add(card);
        }

        return groupedCards;
    }
}

