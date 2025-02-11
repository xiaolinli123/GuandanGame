package com.example.app;



/*public class App {
    public static void main(String[] args) {
        System.out.println("排序前：" + cardOrder);
        // LinkedHashMap<String, List<String>> groupedCards = new LinkedHashMap<>();

        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n<html>\n<head>\n")
                .append("<meta charset=\"UTF-8\">\n")
                .append("<title>Grouped Cards by Rank</title>\n")
                .append("<style>\n")
                .append("  body { text-align: center; font-family: Arial, sans-serif; }\n")
                .append("  .table { display: flex; justify-content: center; gap: 7px; margin-bottom: 20px; }\n")
                .append("  .column { display: flex; flex-direction: column; align-items: center; }\n")
                .append("  .card { display: block; width: 35px; padding: 10px; font-size: 24px; font-weight: bold; text-align: center; }\n")
                .append("  .red { color: red; }\n")
                .append("  .joker { font-size: 28px; font-weight: bold; color: purple; }\n")
                .append("  .hand-title { font-size: 20px; font-weight: bold; margin: 10px 0; }\n")
                .append("</style>\n</head>\n<body>\n");

        // ------------------------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要设为最大牌的值（2-10, J, Q, K, A）：");
        String userInput = scanner.nextLine().toUpperCase();

        // 检查输入合法性
        if (!cardOrder.containsKey(userInput)) {
            System.out.println("无效输入！请输入 2-10, J, Q, K, A 之一。");
            return;
        }
        System.out.println(cardOrder);

        CardComparator.adjustOrderWithJipai(userInput);
        // ------------------------------------------------------------------------------


        PokerGame pokerGame = new PokerGame();
        pokerGame.initPlayers();
        pokerGame.showPlayers();

        for (int i = 1; i <= 5; i++) {
            pokerGame.initCard();
            System.out.println("扑克牌总数为" + pokerGame.pokerCards.size());
            pokerGame.shuffle();
            //每位玩家发27张牌
            pokerGame.deal(27);
            pokerGame.showPlayerCards(pokerGame.players.get(0));
            //以下处理手牌的排序和html显示

            List<String> cards = new ArrayList<>(Arrays.asList(cardsStr.split(",")));
            LinkedHashMap<String, List<String>> groupedCards = new LinkedHashMap<>();

            System.out.println("Cards before sorting: " + cards);
            System.out.println(cardOrder);


            // 按新的规则排序
            cards.sort((c1, c2) -> {
                String rank1 = c1.replaceAll("[♠♣♦♥]", "");
                String rank2 = c2.replaceAll("[♠♣♦♥]", "");

                int value1 = cardOrder.get(rank1);
                int value2 = cardOrder.get(rank2);

                if (value1 != value2) {
                    return Integer.compare(value2, value1); // 降序排序
                }

                int suit1 = c1.startsWith("0JOKER") ? jokerSuitOrder.get(rank1) : suitOrder.get(c1.charAt(c1.length() - 1));
                int suit2 = c2.startsWith("0JOKER") ? jokerSuitOrder.get(rank2) : suitOrder.get(c2.charAt(c2.length() - 1));

                return Integer.compare(suit2, suit1);
            });

            System.out.println("级牌排序后" + cards);

            // 按点数分组
            //LinkedHashMap<String, List<String>> groupedCards = new LinkedHashMap<>();
            for (String card : cards) {
                String rank = card.replaceAll("[♠♣♦♥]", ""); // 去除花色
                groupedCards.computeIfAbsent(rank, k -> new ArrayList<>()).add(card);
            }

            // 添加手牌标题
            html.append("<div class='hand-title'>Hand ").append(i).append("<div class='hand-title'>" + "本局打" + userInput).append("</div>\n");
            html.append("<div class='table'>\n");

            // 渲染手牌
            for (Map.Entry<String, List<String>> entry : groupedCards.entrySet()) {
                html.append("<div class='column'>");
                for (String card : entry.getValue()) {
                    if (card.equals("0JOKER_B")) {
                        html.append("<span class='card joker'>🃏B</span>");
                    } else if (card.equals("0JOKER_R")) {
                        html.append("<span class='card joker'>🃏R</span>");
                    } else {
                        char suit = card.charAt(card.length() - 1);
                        String rank = card.replaceAll("[♠♣♦♥]", "");

                        if (rank.equals(userInput) && suit == '♥') { // 用户输入的牌且是红心
                            html.append("<span class='card red'>")
                                    .append(rank)  // 替换为红色五角星
                                    .append("★")
                                    .append("</span>");
                        } else {
                            boolean isRed = (suit == '♦' || suit == '♥');
                            html.append("<span class='card ")
                                    .append(isRed ? "red" : "")
                                    .append("'>")
                                    .append(card)
                                    .append("</span>");
                        }
                    }
                }
                html.append("</div>\n");
            }

            html.append("</div>\n"); // 结束一副手牌

            cardsStr = "";
            pokerGame.players.get(0).cards.clear();

        }
        html.append("</body>\n</html>");

        // 输出 HTML 文件
        String filePath = "grouped_cards" + userInput + ".html";
        try (
                FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(html.toString());
            System.out.println("HTML 文件已生成: " + filePath);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        //以上处理手牌的排序和html显示

    }

}*/


import com.example.ui.CardRenderer;
import com.example.util.GetFivePlayerCard;

public class App {
    public static PokerGame game;

    public static void main(String[] args) {
        game = new PokerGame(); // 启动游戏
        game.startGame();

    }
}
