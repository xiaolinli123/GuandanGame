package com.example.app;


import com.example.manager.ModeManager;
import com.example.manager.PlayerManager;
import com.example.manager.TrumpCardManager;
import com.example.model.Card;
import com.example.service.CardGrouper;
import com.example.service.CardSorter;
import com.example.service.Deck;
import com.example.ui.ConsoleDisplay;
import com.example.ui.GameDisplay;

import java.util.List;
import java.util.Map;

/**
 * Created by jyp on 2016/10/3.
 *//*
public class PokerGame {
    public final List<Card> pokerCards;
    public final List<Player> players;
    public static String cardsStr = "";

    public PokerGame() {
        pokerCards = new ArrayList<>();
        players = new ArrayList<>();
    }

    //显示扑克牌List
    public void showPokeCards() {
        System.out.print("为：[ ");
        for (Card c : pokerCards) {
            System.out.print(c.getColor() + c.getNum() + " ");
        }
        System.out.println("]");
    }

    //显示玩家List
    public void showPlayers() {
        System.out.print("玩家列表为：[");
        for (Player player : players) {
            System.out.print(player.getName() + " ");
        }
        System.out.println("]");
    }

    //显示玩家的手牌
    public void showPlayerCards(Player player) {
        System.out.println(player.getName() + "手牌为:");
        System.out.print("[");
        for (Card c : player.cards) {
            cardsStr += c.getNum() + c.getColor() + ",";
        }
        cardsStr = cardsStr.substring(0, cardsStr.length() - 1);
        System.out.println("玩家手牌" + cardsStr);
        System.out.print("]");
        System.out.println();
    }

    //-------------------------------------用于显示牌的排序--------------------------------------------



    //-------------------------------------用于显示牌的排序--------------------------------------------

    //初始化玩家列表
    public void initPlayers() {
        System.out.println("初始化玩家…………");
        Player player1 = new Player("玩家1");
        Player player2 = new Player("玩家2");
        Player player3 = new Player("玩家3");
        Player player4 = new Player("玩家4");
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        System.out.println("初始化玩家结束…………");
    }

    //初始化两副扑克牌
    public void initCard() {
        System.out.println("初始化扑克牌…………");
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] nums = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (int i = 0; i < 2; i++) {
            for (String color : colors) {
                for (String num : nums) {
                    pokerCards.add(new Card(color, num));
                }
            }
            pokerCards.add(new Card("JOKER_B", "0"));
            pokerCards.add(new Card("JOKER_R", "0"));
        }
        System.out.println("初始化结束");
        System.out.println("------------创建成功------------");
        this.showPokeCards();
    }

    // 对扑克牌进行洗牌
    public void shuffle() {
        System.out.println("进行洗牌");
        for (int i = 0; i < 5; i++) { // 洗牌 3 次
            Collections.shuffle(pokerCards);
        }
        this.showPokeCards();
    }
    //发牌


    public void deal(int num) {
        System.out.println("开始发牌…………");
        for (int i = 0; i < 4; i++) {
            Player p = players.get(i);
            for (int j = 0; j < num; j++) {
                p.cards.add(pokerCards.get(0));
                pokerCards.remove(0);
            }
        }
        System.out.println("发牌结束");
    }

    //以下处理手牌的排序和html显示


}*/

public class PokerGame {
    protected final Deck deck;
    protected final PlayerManager playerManager;
    protected TrumpCardManager trumpCardManager;  // 级牌由 TrumpCardManager 提供
    protected ModeManager modeManager;

    public PokerGame() {
        trumpCardManager = new TrumpCardManager();
        modeManager = new ModeManager();
        deck = new Deck();
        playerManager = new PlayerManager();
    }


    public void startGame() {
        System.out.println("欢迎来到扑克游戏！");
        int mode = modeManager.selectGameMode(); // 选择游戏模式

        if (mode == 1) {
            System.out.println("已进入普通模式：");
            trumpCardManager.setTrumpCard();
            NormalMode();
        } else if (mode == 2) {
            System.out.println("已进入训练模式模式：");
            trumpCardManager.setTrumpCard();
            TrainingMode();
        } else {
            System.out.println("无效选择，默认进入普通模式。");
            NormalMode();
        }


    }


    public void NormalMode() {
        deck.initCard();
        deck.shuffle();
        // trumpCardManager.setTrumpCard();
        playerManager.initPlayers();
        ConsoleDisplay.showPlayers(PlayerManager.getPlayers());
        deck.deal(PlayerManager.getPlayers(), 27);
        List<Card> playerCards = PlayerManager.getPlayers().get(0).getCards();
        ConsoleDisplay.showAllPlayersCards(PlayerManager.getPlayers());

        List<Card> sortedCards = CardSorter.sort(playerCards, trumpCardManager.getTrumpCard());
        Map<String, List<Card>> groupedCards = CardGrouper.groupByNumber(sortedCards);
        ConsoleDisplay.showPalyerGroupedCards(groupedCards);
        GameDisplay.normalGameDisplayAsHtml();
    }

    public void TrainingMode() {
        GameDisplay.practiceGameDisplayAsHtml();
    }

    public void startPratice() {

        deck.initCard();
        deck.shuffle();
        // trumpCardManager.setTrumpCard();
        playerManager.initPlayers();
        ConsoleDisplay.showPlayers(PlayerManager.getPlayers());
        deck.deal(PlayerManager.getPlayers(), 27);
        List<Card> playerCards = PlayerManager.getPlayers().get(0).getCards();
        ConsoleDisplay.showCards(playerCards);

        List<Card> sortedCards = CardSorter.sort(playerCards, trumpCardManager.getTrumpCard());
        Map<String, List<Card>> groupedCards = CardGrouper.groupByNumber(sortedCards);
        ConsoleDisplay.showPalyerGroupedCards(groupedCards);

    }


    public TrumpCardManager getTrumpCardManager() {
        return trumpCardManager;
    }


}

