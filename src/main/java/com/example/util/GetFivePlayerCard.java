package com.example.util;

import com.example.manager.PlayerManager;
import com.example.service.CardGrouper;
import com.example.ui.CardRenderer;

import static com.example.app.App.game;

public class GetFivePlayerCard {

     StringBuilder htmlContent = new StringBuilder();

     public String setHtmlContent() {
        for (int i = 0; i < 5; i++) {
            game.startPratice();
            htmlContent.append(CardRenderer.renderGroupedCardsAsHTML(CardGrouper.groupByNumber(PlayerManager.getPlayers().get(0).getCards())));
        }
        return htmlContent.toString();
    }


}
