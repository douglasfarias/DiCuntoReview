package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Usuário
 */
public class FXMLAcessoController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtSenha;
    @FXML
    private Button btnAcessar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void acessar() throws IOException {

        System.out.println("Usuario: " + txtUsuario.getText() + " Senha: " + txtSenha.getText());

        if ("gigasoft.admin".equals(txtUsuario.getText()) && "123".equals(txtSenha.getText())) {

            try {

                startPrincipal();

                btnAcessar.getScene().getWindow().hide();

            } catch (Exception ex) {
                Logger.getLogger(FXMLAcessoController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Dados incorretos");
            alert.setContentText("Dados incorretos!");

            alert.showAndWait();
        }

    }

    @FXML
    public void fecharLogin(Stage stage) throws IOException {

        Acesso login = new Acesso();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAcesso.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.close();

    }

    @FXML
    public void startPrincipal() throws Exception {

        try {
            new Principal().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
