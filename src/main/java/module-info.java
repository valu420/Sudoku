module com.example.sudoku {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sudoku to javafx.fxml;
    exports com.example.sudoku;
    exports com.example.sudoku.controller to javafx.fxml;
}