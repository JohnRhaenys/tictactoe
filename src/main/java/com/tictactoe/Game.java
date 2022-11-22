package com.tictactoe;

import static com.tictactoe.utils.Constants.GO_SIGNAL;
import static com.tictactoe.utils.Constants.WAIT_SIGNAL;

public class Game {
    private final Player xPlayer;
    private final Player circlePlayer;
    private final PlayerTurnManager playerTurnManager;

    private boolean isRunning;

    public Game(Player xPlayer, Player circlePlayer, PlayerTurnManager playerTurnManager) {
        this.isRunning = false;
        this.xPlayer = xPlayer;
        this.circlePlayer = circlePlayer;
        this.playerTurnManager = playerTurnManager;
    }

    public PlayerTurnManager getPlayerTurnManager() {
        return playerTurnManager;
    }

    public void start() {
        this.isRunning = true;
        this.playerTurnManager.setCurrent(this.circlePlayer);
        this.circlePlayer.setLabelText(GO_SIGNAL);
        this.playerTurnManager.setNext(this.xPlayer);
        this.xPlayer.setLabelText(WAIT_SIGNAL);
    }

    private boolean isOver() {
        // TODO - Implement this logic
        return false;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
