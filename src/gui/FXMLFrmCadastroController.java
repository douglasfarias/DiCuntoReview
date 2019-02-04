/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dicunto.bd.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *
 * @author Usuário
 */
public class FXMLFrmCadastroController {

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
    private TextField txtCelular;
    @FXML
    private TextField txtDtNascimento;
    @FXML
    private TextField txtCargo;
    @FXML
    private TextField txtSetor;
    @FXML
    private RadioButton rbCliente;
    @FXML
    private RadioButton rbFuncionario;
    @FXML
    private RadioButton rbFornecedor;

    @FXML
    private void inserirCadastro(ActionEvent event) {

        String selecao = null;

        if (rbCliente.isSelected()) {

            selecao = "Cliente";
        } else if (rbFornecedor.isSelected()) {
            selecao = "Fornecedor";
        } else if (rbFuncionario.isSelected()) {
            selecao = "Funcionario";
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Tipo de cadastro");
            alert.setContentText("Você precisa escolher um tipo de cadastro");

            alert.showAndWait();

        }

        switch (selecao) {
            case "Cliente":
                Alert alertCliente = new Alert(Alert.AlertType.INFORMATION);
                alertCliente.setTitle("Information Dialog");
                alertCliente.setHeaderText("Inclusão");
                alertCliente.setContentText("Cliente incluido com sucesso");

                alertCliente.showAndWait();
                
                break;
                
                
            case "Funcionario":
                Alert alertFuncionario = new Alert(Alert.AlertType.INFORMATION);
                alertFuncionario.setTitle("Information Dialog");
                alertFuncionario.setHeaderText("Inclusão");
                alertFuncionario.setContentText("Funcionário incluido com sucesso");

                alertFuncionario.showAndWait();

                break;
                
            case "Fornecedor":
                Alert alertFornecedor = new Alert(Alert.AlertType.INFORMATION);
                alertFornecedor.setTitle("Information Dialog");
                alertFornecedor.setHeaderText("Inclusão");
                alertFornecedor.setContentText("Fornecedor incluido com sucesso");

                alertFornecedor.showAndWait();

                break;
                
            default:
                
                                Alert alertDefault = new Alert(Alert.AlertType.INFORMATION);
                alertDefault.setTitle("Information Dialog");
                alertDefault.setHeaderText("Inclusão");
                alertDefault.setContentText("Verifique os dados");

                alertDefault.showAndWait();
                

        }

    }
}
