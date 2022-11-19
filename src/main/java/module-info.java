module com.example.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.tictactoe to javafx.fxml;
    exports com.tictactoe;
}