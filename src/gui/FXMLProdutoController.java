/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

/**
 *
 * @author Usuário
 */
public class FXMLProdutoController {

    @FXML
    private void mouseClickButton(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Em BREVE");
        alert.setContentText("I have a great message for you!");

        alert.showAndWait();

    }
}
