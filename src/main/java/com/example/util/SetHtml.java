package com.example.util;

public class SetHtml {

    StringBuilder htmlHead = new StringBuilder();
    StringBuilder htmlEnd = new StringBuilder();

    public String setHtmlHead() {

        // HTML 头部
        htmlHead.append("<!DOCTYPE html>\n<html lang='zh-CN'>\n<head>\n")
                .append("<meta charset='UTF-8'>\n<title>玩家手牌</title>\n")
                .append("<style>\n")
                .append("body { font-family: Arial, sans-serif; background-color: #d39e5e; padding: 190px; text-align: center; }\n")

                // 牌组容器：水平排列，自然对齐
                .append(".card-container { display: flex; justify-content: center; gap: 65px; margin-bottom: 200px;}\n")

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
                .append(".suit-large { font-size: 60px; margin-top: 21px; line-height: 1; }\n")

                .append(".joker-text { position: absolute; top: 4px; left: 4px; font-size: 19px; font-weight: bold; color: inherit; display: flex; flex-direction: column; align-items: center; line-height: 1; letter-spacing: 1px; }\n")

                .append(".icon { display: flex; justify-content: center; align-items: center; width: 60%; height: 60%; }\n")
                .append(".icon img { max-width: 42px; max-height: 56px;  object-fit: contain; }\n")

                .append("</style>\n</head>\n<body>\n").toString();

        return htmlHead.toString();

    }

    public String setHtmlEnd() {
        htmlEnd.append("</body>\n</html>").toString();
        return htmlEnd.toString();
    }
}
