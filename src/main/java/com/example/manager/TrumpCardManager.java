package com.example.manager;

import java.util.Arrays;
import java.util.Scanner;

public class TrumpCardManager {
    private String trumpCard;

    // 设置级牌
    public void setTrumpCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入本局的级牌 (2, 3, ..., A)：");
        String input = scanner.nextLine();

        while (!isValidTrump(input)) {
            System.out.print("无效的级牌，请重新输入 (2, 3, ..., A)：");
            input = scanner.nextLine();
        }

        this.trumpCard = input;
        System.out.println("本局的级牌设置为: " + trumpCard);
    }

    // 检查级牌是否合法
    private boolean isValidTrump(String cardNum) {
        String[] validCards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        return Arrays.asList(validCards).contains(cardNum);
    }

    public String getTrumpCard() {
        return trumpCard;
    }
}
