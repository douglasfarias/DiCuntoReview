package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuário
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtEndereco;
    @FXML
    private TextField txtBairro;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtCpfCnpj;
    @FXML
    private TextField txtTelefone;
    @FXML
    private TextField txtCep;
    @FXML
    private TextField txtNumero;
    @FXML
    private TextField txtEstado;
    @FXML
    private TextField txtCelular;
    @FXML
    private TextField txtDtNascimento;
    @FXML
    private TextField txtCargo;
    @FXML
    private TextField txtSetor;
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtSenha;
    @FXML
    private Button btnAcessar;



    
    @FXML
    private void mouseClickButton(ActionEvent event) {

        JOptionPane.showMessageDialog(null, "EM BREVE!");

    }

    @FXML
    public void sair() throws Exception {

        int op = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair ?", "Sair do programa?", JOptionPane.WARNING_MESSAGE);
        if (op == 0) {
            System.exit(0);
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

        JOptionPane.showMessageDialog(null, "Dicunto automação, por Gigasoft.");

    }

    @FXML
    public void mouseEntered() {
        System.out.println("Mouse entrou");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void editarCadastro() {

        String valorBusca = JOptionPane.showInputDialog("Digite o CPF/CNPJ para buscar");

        System.out.println(valorBusca);

    }

    @FXML
    public void acessar() throws IOException {

        System.out.println("Usuario: " + txtUsuario.getText() + " Senha: " + txtSenha.getText());

        if ("gigasoft.admin".equals(txtUsuario.getText()) && "123".equals(txtSenha.getText())) {

            try {
                
                startPrincipal();
                
                btnAcessar.getScene().getWindow().hide();
                
            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }


        } else {

            JOptionPane.showMessageDialog(null, "Dados incorretos");
        }

    }

    @FXML
    public void fecharLogin(Stage stage) throws IOException{
        
                    
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

    @FXML
    public void inserirCadastro(ActionEvent aE) {

        System.out.println(txtNome.getText() + ""
                + txtEndereco.getText() + ""
                + txtBairro.getText() + ""
                + txtEmail.getText() + ""
                + txtCidade.getText() + ""
                + txtCpfCnpj.getText() + ""
                + txtTelefone.getText() + ""
                + txtCep.getText() + ""
                + txtNumero.getText() + ""
                + txtEstado.getText() + ""
                + txtCelular.getText() + ""
                + txtDtNascimento.getText() + ""
                + txtCargo.getText() + ""
                + txtSetor.getText());

    }

    @FXML
    public void editarCadastro(ActionEvent aE) {

    String chaveEditar =  JOptionPane.showInputDialog("Por favor, digite o CPF ou CNPJ de quem deseja editar.");
        
        System.out.println(chaveEditar);

    }

    @FXML
    public void excluirCadastro(ActionEvent aE) {

        
    String chaveExcluir =  JOptionPane.showInputDialog("Por favor, digite o CPF ou CNPJ de quem deseja excluir.");
        
        System.out.println(chaveExcluir);

    }

}
