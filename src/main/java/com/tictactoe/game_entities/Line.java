package com.tictactoe.game_entities;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public record Line(ArrayList<ImageView> items) {
    public Player getWinner(Player current, Player next) {
        boolean currentWins = this.items.stream().allMatch(item -> {
            if (item == null) {
                return false;
            }
            if (item.getImage() == null) {
                return false;
            }
            return item.getImage().getUrl().equals(current.getGamerImagePath());
        });

        boolean nextWins = this.items.stream().allMatch(item -> {
            if (item.getImage() == null) {
                return false;
            }
            return item.getImage().getUrl().equals(next.getGamerImagePath());
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
