package com.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import static com.tictactoe.FilePaths.CIRCLE_IMAGE_PATH;
import static com.tictactoe.FilePaths.X_IMAGE_PATH;
import static com.tictactoe.utils.Constants.GO_SIGNAL;
import static com.tictactoe.utils.Constants.WAIT_SIGNAL;

public class WindowController implements Initializable {

    private Game game;

    @FXML
    private Label xPlayerSignalLabel;

    @FXML
    private Label circlePlayerSignalLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.game = new Game(
                new Player(xPlayerSignalLabel, X_IMAGE_PATH),
                new Player(circlePlayerSignalLabel, CIRCLE_IMAGE_PATH),
                new PlayerTurnManager()
        );
    }

    @FXML
    void startButtonPressed(ActionEvent event) {
        if (this.game.isRunning()) {
            return;
        }
        this.game.start();
    }

    @FXML
    public void gridClicked(MouseEvent event) {
        if (!this.game.isRunning()) {
            return;
        }
        Node clickedNode = event.getPickResult().getIntersectedNode();
        if (clickedNode instanceof ImageView imageView) {
            if (imageView.getImage() == null) {
                this.setGridCellImage(this.game.getPlayerTurnManager().getCurrent(), imageView);
                this.game.getPlayerTurnManager().switchTurns();
                this.game.getPlayerTurnManager().getCurrent().setLabelText(GO_SIGNAL);
                this.game.getPlayerTurnManager().getNext().setLabelText(WAIT_SIGNAL);
            }
        }
    }

    private void setGridCellImage(Player player, ImageView imageView) {
        String imagePath = Paths.get(player.getGamerImagePath()).toString();
        File file = new File(imagePath);
        Image image = new Image(file.toURI().toString());
        imageView.setFitHeight(72);
        imageView.setFitWidth(60);
        GridPane.setHalignment(imageView, HPos.CENTER);
        imageView.setImage(image);
    }
}