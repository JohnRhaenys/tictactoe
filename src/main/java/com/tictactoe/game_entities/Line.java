package com.tictactoe.game_entities;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

import static com.tictactoe.utils.Helpers.getFilename;

public record Line(ArrayList<ImageView> items) {
    public Player getWinner(Player current, Player next) {
        String currentPlayerFileName = getFilename(current.getGamerImagePath());
        boolean currentWins = this.items.stream().allMatch(item -> {
            if (item == null) {
                return false;
            }
            if (item.getImage() == null) {
                return false;
            }
            String cellFileName = getFilename(item.getImage().getUrl());
            return cellFileName.equals(currentPlayerFileName);
        });

        String nextPlayerFileName = getFilename(next.getGamerImagePath());
        boolean nextWins = this.items.stream().allMatch(item -> {
            if (item.getImage() == null) {
                return false;
            }
            String cellFileName = getFilename(item.getImage().getUrl());
            return cellFileName.equals(nextPlayerFileName);
        });

        if (currentWins) {
            return current;
        }
        else if (nextWins) {
            return next;
        }
        return null;
    }
}
