package com.tictactoe.game_entities;

import javafx.scene.control.Label;

public class Player {
    private final Label label;
    private final String gamerImagePath;

    public Player(Label label, String gamerImagePath) {
        this.label = label;
        this.gamerImagePath = gamerImagePath;
    }

    public void setLabelText(String text) {
        this.label.setText(text);
    }

    public String getGamerImagePath() {
        return gamerImagePath;
    }
}
