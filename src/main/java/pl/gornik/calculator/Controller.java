package pl.gornik.calculator;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label lblResoult;

    @FXML
    private TextField txtNumber;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnSub;

    @FXML
    private Button btnMult;

    @FXML
    private Button btnDiv;

    @FXML
    private Label lblInfo;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnEquals;

    private double result;
    private String operation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnClose.setOnAction(event -> Platform.exit());

        btnClear.setOnAction(event -> {
            txtNumber.clear();
            lblResoult.setText("");
            lblInfo.setText("");
            txtNumber.requestFocus();
        });
        btnAdd.setOnAction(event -> {
            operation = "+";
            runAction();

        });
        btnSub.setOnAction(event -> {
            operation = "-";
            runAction();
        });
        btnMult.setOnAction(event -> {
            operation = "*";
            runAction();
        });
        btnDiv.setOnAction(event -> {
            operation = "/";
            runAction();
        });

        btnEquals.setOnAction(event -> {
            try {
                switch (operation) {
                    case "/" -> {
                        if(Double.parseDouble(txtNumber.getText()) != 0){
                            result /= Double.parseDouble(txtNumber.getText());
                            displayInfo();
                        }
                        else{
                            lblInfo.setText("Nie dzieli sie przez zero!");
                            txtNumber.clear();
                            txtNumber.requestFocus();
                        }

                    }
                    case "+" -> {
                        result += Double.parseDouble(txtNumber.getText());
                displayInfo();
                    }
                    case "-" -> {
                        result -= Double.parseDouble(txtNumber.getText());
                        displayInfo();

                    }
                    case "*" -> {
                        result *= Double.parseDouble(txtNumber.getText());
                        displayInfo();

                    }

                }
            } catch (Exception e) {
                lblInfo.setText("Musisz podac liczbe");
                txtNumber.clear();
                txtNumber.requestFocus();
            }
        });
    }
        public void runAction() {
            try {
                result = Double.parseDouble(txtNumber.getText());
                lblResoult.setText(txtNumber.getText() + operation);
              lblInfo.setText("");
            } catch (Exception e) {
                lblInfo.setText("Musisz podawać liczby");
            }
            txtNumber.clear();
            txtNumber.requestFocus();
        }
        public void displayInfo(){
            lblResoult.setText(lblResoult.getText() + txtNumber.getText() + " = " + result);
            txtNumber.clear();
            txtNumber.requestFocus();

        }
    }




















