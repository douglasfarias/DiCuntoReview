/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author Usuário
 */
public class FXMLPrincipalController {

    @FXML
    private void mouseClickButton(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Em BREVE");
        alert.setContentText("I have a great message for you!");

        alert.showAndWait();

    }

    @FXML
    public void sair() throws Exception {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Quer mesmo sair?");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {

            System.exit(0);
            
            
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    @FXML
    public void startCaixa() throws Exception {

        try {
            new Caixa().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void startFrmCadastro() throws Exception {

        try {
            new FrmCadastro().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void startProduto() throws Exception {

        try {
            new Produto().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mouseClickLogo() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Em BREVE");
        alert.setContentText("I have a great message for you!");

        alert.showAndWait();
    }


}
