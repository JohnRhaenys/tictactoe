module com.example.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.tictactoe to javafx.fxml;
    exports com.tictactoe;
    exports com.tictactoe.utils;
    opens com.tictactoe.utils to javafx.fxml;
    exports com.tictactoe.game_entities;
    opens com.tictactoe.game_entities to javafx.fxml;
    exports com.tictactoe.controllers;
    opens com.tictactoe.controllers to javafx.fxml;
}