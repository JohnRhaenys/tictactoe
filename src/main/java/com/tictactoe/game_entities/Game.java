package com.tictactoe.game_entities;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.HashMap;

import static com.tictactoe.utils.Constants.*;
import static com.tictactoe.utils.Helpers.getValuesFromHashMap;

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

    public Player getWinner(GridPane gameGrid) {
        for (Line line : getAllPossibleLines(gameGrid)) {
            Player winner = line.getWinner(
                    this.getPlayerTurnManager().getCurrent(),
                    this.getPlayerTurnManager().getNext()
            );
            if (winner != null) {
                return winner;
            }
        }
        return null;
    }

    private ArrayList<Line> getAllPossibleLines(GridPane gameGrid) {
        ObservableList<Node> children = gameGrid.getChildren();
        HashMap<Integer, Line> rows = new HashMap<>();
        HashMap<Integer, Line> columns = new HashMap<>();
        HashMap<Integer, Line> diagonals = new HashMap<>();

        for (Node node : children) {
            if (node instanceof ImageView) {
                Integer rowIndex = GridPane.getRowIndex(node);
                if (rowIndex == null) {
                    rowIndex = 0;
                }
                Integer columnIndex = GridPane.getColumnIndex(node);
                if (columnIndex == null) {
                    columnIndex = 0;
                }
                rows.computeIfAbsent(rowIndex, k -> new Line(new ArrayList<>()));
                rows.get(rowIndex).items().add((ImageView) node);

                columns.computeIfAbsent(columnIndex, k -> new Line(new ArrayList<>()));
                columns.get(columnIndex).items().add((ImageView) node);

                if (rowIndex.equals(columnIndex)) {
                    diagonals.computeIfAbsent(MAIN_DIAGONAL_INDEX, k -> new Line(new ArrayList<>()));
                    diagonals.get(MAIN_DIAGONAL_INDEX).items().add((ImageView) node);
                }
                if (rowIndex + columnIndex == MAX_COLUMN_NUMBER - 1) {
                    diagonals.computeIfAbsent(SECONDARY_DIAGONAL_INDEX, k -> new Line(new ArrayList<>()));
                    diagonals.get(SECONDARY_DIAGONAL_INDEX).items().add((ImageView) node);
                }
            }
        }

        ArrayList<Line> possibleLines = new ArrayList<>();
        possibleLines.addAll(getValuesFromHashMap(rows));
        possibleLines.addAll(getValuesFromHashMap(columns));
        possibleLines.addAll(getValuesFromHashMap(diagonals));
        return possibleLines;
    }
}
