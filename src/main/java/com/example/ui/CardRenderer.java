package com.example.ui;

import com.example.model.Card;

import java.util.List;
import java.util.Map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;


public class CardRenderer {

    public static String renderGroupedCardsAsHTML(Map<String, List<Card>> groupedCards) {
        StringBuilder html = new StringBuilder();

        // HTML 头部
        /*html.append("<!DOCTYPE html>\n<html lang='zh-CN'>\n<head>\n");
        html.append("<meta charset='UTF-8'>\n<title>玩家手牌</title>\n");
        html.append("<style>\n")
                .append("body { font-family: Arial, sans-serif; background-color: #d39e5e; padding: 190px; text-align: center; }\n")

                // 牌组容器：水平排列，自然对齐
                .append(".card-container { display: flex; justify-content: center; gap: 65px;margin-bottom: 300px;}\n")

                // 每组牌堆样式
                .append(".card-stack { position: relative; display: inline-block; height: 180px; }\n")

                // 扑克牌样式
                .append(".card { width: 76px; height: 106px; background-color: #ffffff; border: 1px solid #D3D3D3; ")
                .append("border-radius: 8px; display: flex; flex-direction: column; justify-content: space-between; ")
                .append("align-items: center; padding: 4px; box-shadow: 1px 1px 4px rgba(0,0,0,0.3); position: absolute; ")
                .append("transition: transform 0.2s, background-color 0.3s; }\n")

                // 鼠标悬停效果
                .append(".card:hover { background-color: #ffeb3b; transform: scale(1.1); cursor: pointer; z-index: 10; }\n")

                // 数字与小花色水平排列
                .append(".corner { position: absolute; top: 4px; left: 4px; display: flex; align-items: center; gap: 2px; font-size: 23px; font-weight: bold; }\n")
                .append(".suit-small { font-size: 18px; line-height: 1; }\n")  // 小花色符号

                // 大花色符号
                .append(".suit-large { font-size: 60px; margin-top: 15px; line-height: 1; }\n")

                .append(".joker-text { position: absolute; top: 4px; left: 4px; font-size: 20px; font-weight: bold; color: inherit; display: flex; flex-direction: column; align-items: center; line-height: 1; letter-spacing: 1px; }\n")


                .append("</style>\n</head>\n<body>\n");*/

        html.append("<div class='card-container'>\n");

        // 渲染每组牌堆
        int groupIndex = groupedCards.size(); // 用于控制组的 z-index（组的顺序越靠后，z-index 越大）
        for (Map.Entry<String, List<Card>> entry : groupedCards.entrySet()) {
            html.append("<div class='card-stack' style='z-index: ").append(groupIndex).append(";'>\n");

            List<Card> cards = entry.getValue();
            int totalCards = cards.size();

            for (int i = 0; i < totalCards; i++) {
                Card card = cards.get(i);
                int offset = i * 30; // 堆叠偏移

                // 判断是否为大小王，显示竖排的 'JOKER'
                boolean isJoker = card.getNum().equals("JOKER");
                String displaySuit = isJoker ? "J<br>O<br>K<br>E<br>R" : card.getColor();
                String textColor = card.getColor().equals("R") ? "#FF0000" : card.getColor().equals("B") ? "#000000" : getCardTextColor(card.getColor());
                // 牌的 z-index：确保组内的牌按顺序堆叠
                int cardZIndex = totalCards - i;  // 数值越大越在上面

                html.append("<p>").append("<div class='card' style='bottom: ").append(offset)
                        .append("px; color:").append(textColor)
                        .append("; z-index: ").append(cardZIndex).append(";'>")
                        .append("<div class='corner'>")
                        .append(isJoker ? "" : "<span>" + card.getNum() + "</span>")  // 如果是王则不显示点数
                        .append("<span class='suit-small ").append(isJoker ? "joker-text" : "").append("' style='color: ")
                        .append(isJoker ? (card.getColor().equals("R") ? "#FF0000" : "#000000") : "inherit")
                        .append(";'>")
                        .append(displaySuit).append("</span>")   // JOKER 或普通花色
                        .append("</div>")
                        .append("<div class='suit-large ").append(isJoker ? "joker-text" : "").append("' style='color: ")
                        .append(textColor).append(";'>")
                        .append(isJoker ? "<img src='joker_" + (card.getColor().equals("R") ? "big" : "small") + ".png' alt='Joker' class='icon'>" : displaySuit) // 如果是王则显示图案，否则正常显示
                        .append("</div>")

                        .append("</div>\n");
            }

            html.append("</div>\n");  // 结束当前堆叠组
            groupIndex++; // 逐渐减少 z-index，确保后一组在上
        }
        html.append("</div>");

      //  html.append("</div>\n</body>\n</html>");
        return html.toString();
    }


    // 根据花色返回卡片的字体颜色
    public static String getCardTextColor(String color) {
        return switch (color) {
            case "♥", "♦" -> "#FF0000"; // 红色字体
            case "♠", "♣" -> "#000000"; // 黑色字体
            default -> "#000000"; // 默认黑色
        };
    }

    public static void saveHTMLToFile(String htmlContent, String filePath) {
        try {
            Files.writeString(Paths.get(filePath), htmlContent);
            System.out.println("HTML 文件已成功保存到: " + filePath);
        } catch (IOException e) {
            System.err.println("保存 HTML 文件失败: " + e.getMessage());
        }
    }


}
