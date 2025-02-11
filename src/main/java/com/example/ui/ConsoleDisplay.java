package com.example.ui;

import com.example.model.Card;
import com.example.model.Player;

import java.util.List;
import java.util.Map;

public class ConsoleDisplay {
    public static void showPlayers(List<Player> players) {
        System.out.print("玩家列表为：[");
        for (Player player : players) {
            System.out.print(player.getName() + " ");
        }
        System.out.println("]");
    }

    public static void showPlayerCards(Player player) {
        System.out.print(player.getName() + " 的手牌为: [ ");
        for (Card card : player.getCards()) {
            System.out.print(card.getColor() + card.getNum() + " ");
        }
        System.out.println("]");
    }

    public static void showAllPlayersCards(List<Player> players) {
        for (Player player : players) {
            System.out.print(player.getName() + " 的手牌为: [ ");
            for (Card card : player.getCards()) {
                System.out.print(card.getColor() + card.getNum() + " ");
            }
            System.out.println("]");
        }
    }

    public static void showCards(List<Card> cards) {
        for (Card card : cards) {
            System.out.print(card.getColor() + card.getNum() + " ");
        }
        System.out.println();
    }

    /**
     * 展示分组后的手牌
     *
     * @param groupedCards 分组后的牌
     */
    public static void showPalyerGroupedCards(Map<String, List<Card>> groupedCards) {
        for (Map.Entry<String, List<Card>> entry : groupedCards.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
