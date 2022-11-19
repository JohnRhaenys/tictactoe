package com.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import static com.tictactoe.utils.Constants.GO_SIGNAL;
import static com.tictactoe.utils.Constants.WAIT_SIGNAL;

public class WindowController {

    @FXML
    private Button startButton;

    @FXML
    private ImageView circleImage;

    @FXML
    private ImageView xImage;

    @FXML
    private Label xPlayerSignalLabel;

    @FXML
    private Label circlePlayerSignalLabel;

    @FXML
    private GridPane gameGrid;

    @FXML
    void startButtonPressed(ActionEvent event) {
        circlePlayerSignalLabel.setText(GO_SIGNAL);
        xPlayerSignalLabel.setText(WAIT_SIGNAL);
    }
}