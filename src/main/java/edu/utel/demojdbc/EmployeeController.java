package edu.utel.demojdbc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EmployeeController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void buscar(ActionEvent actionEvent) {
    }

    public void cancelar(ActionEvent actionEvent) {
    }

    public void guardar(ActionEvent actionEvent) {
    }
}