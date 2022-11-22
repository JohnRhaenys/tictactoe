package com.tictactoe.game_entities;

public class PlayerTurnManager {
    private Player current;
    private Player next;

    public void setCurrent(Player player) {
        this.current = player;
    }

    public Player getCurrent() {
        return current;
    }

    public void setNext(Player next) {
        this.next = next;
    }

    public Player getNext() {
        return next;
    }

    public void switchTurns() {
        Player tmp = current;
        current = next;
        next = tmp;
    }
}
