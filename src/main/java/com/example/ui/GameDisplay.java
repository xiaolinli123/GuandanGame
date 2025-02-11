package com.example.ui;

import com.example.manager.PlayerManager;
import com.example.model.Player;
import com.example.service.CardGrouper;
import com.example.util.GetFivePlayerCard;

import static com.example.app.App.game;

import com.example.app.PokerGame.*;
import com.example.util.SetHtml;

public class GameDisplay {
    public static void normalGameDisplayAsHtml() {
        SetHtml setHtml = new SetHtml();
        String html = setHtml.setHtmlHead()
                + CardRenderer.renderGroupedCardsAsHTML(CardGrouper.groupByNumber((PlayerManager.getPlayers().get(0)).getCards()))
                + setHtml.setHtmlEnd();
        CardRenderer.saveHTMLToFile(html, "player_cards" + game.getTrumpCardManager().getTrumpCard() + ".html");
    }

    public static void practiceGameDisplayAsHtml() {
        GetFivePlayerCard getFivePlayerCard = new GetFivePlayerCard();
        SetHtml setHtml = new SetHtml();
        String html = setHtml.setHtmlHead() + getFivePlayerCard.setHtmlContent() + setHtml.setHtmlEnd();
        CardRenderer.saveHTMLToFile(html, "five_player_cards" + game.getTrumpCardManager().getTrumpCard() + ".html");
    }
}
