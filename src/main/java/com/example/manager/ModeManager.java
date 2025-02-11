package com.example.manager;

import java.util.Scanner;

public class ModeManager {

    // 选择游戏模式
    public int selectGameMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择游戏模式：");
        System.out.println("1. 普通模式");
        System.out.println("2. 训练模式");
        System.out.print("请输入 1 或 2: ");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            choice = 1; // 默认选择普通模式
        }
        return choice;
    }
}
