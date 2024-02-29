module pl.gornik.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.gornik.calculator to javafx.fxml;
    exports pl.gornik.calculator;
}