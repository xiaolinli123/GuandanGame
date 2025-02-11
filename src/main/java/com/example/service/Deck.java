package com.example.service;

import com.example.model.Card;
import com.example.model.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    public final List<Card> cardDeck;

    public Deck() {
        this.cardDeck = new ArrayList<>();
    }

   /* public void init() {
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] nums = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (int i = 0; i < 2; i++) {
            for (String color : colors) {
                for (String num : nums) {
                    cards.add(new Card(color, num));
                }
            }
            cards.add(new Card("JOKER_B", "0"));
            cards.add(new Card("JOKER_R", "0"));
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void deal(List<Player> players, int numCards) {
        for (Player player : players) {
            for (int i = 0; i < numCards; i++) {
                player.addCard(cards.remove(0));
            }
        }
    }*/

    //初始化两副扑克牌
    public void initCard() {
        System.out.println("初始化扑克牌…………");
        cardDeck.clear();
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] nums = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (int i = 0; i < 2; i++) {
            for (String color : colors) {
                for (String num : nums) {
                    cardDeck.add(new Card(color, num));
                }
            }
            cardDeck.add(new Card("R", "JOKER"));
            cardDeck.add(new Card("B", "JOKER"));
        }
        System.out.println("初始化扑克牌结束");

    }

    // 对扑克牌进行洗牌
    public void shuffle() {
        System.out.println("进行洗牌");
        for (int i = 0; i < 5; i++) {
            cutDeck();
            Collections.shuffle(cardDeck);
        }
        System.out.println("洗牌结束");
    }

    // 切牌方法
    private void cutDeck() {
        int cutPoint = cardDeck.size() / 2 + new Random().nextInt(10) - 5; // 在中间附近随机切牌

        List<Card> top = new ArrayList<>(cardDeck.subList(0, cutPoint));
        List<Card> bottom = new ArrayList<>(cardDeck.subList(cutPoint, cardDeck.size()));

        cardDeck.clear();
        cardDeck.addAll(bottom);
        cardDeck.addAll(top);
    }

    /**
     * 给每位玩家发牌
     *
     * @param cardsPerDeal 每位玩家发到的张数
     */
    public void deal(List<Player> players, int cardsPerDeal) {
        System.out.println("开始发牌");
        for (Player player : players) {
            for (int i = 0; i < cardsPerDeal; i++) {
                player.cards.add(cardDeck.get(0));
                cardDeck.remove(0);
            }
        }
        System.out.println("发牌结束");
    }

}
