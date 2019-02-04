package dicunto.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import conexaobanco.ConexaoMySQL;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.scene.control.Alert;

public class Cliente {

    public String id,
            nome,
            endereco,
            bairro,
            numero,
            cidade,
            cep,
            email,
            cpf,
            dtNascimento,
            celular,
            telefone;

    public static void inserirCliente(String nome, String endereco, String bairro, String numero,
            String cidade, String cep, String email, String cpf,
            String dtnascimento, String celular, String telefone) {

        try (Connection con = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement insert = con.prepareStatement("INSERT INTO CLIENTE (NOME, ENDERECO, BAIRRO, NUMERO, "
                        + "CIDADE, CEP, EMAIL, CPF, DATA_NASCIMENTO, CELULAR, TELEFONE) "
                        + "VALUES ( '" + nome + "', '" + endereco + "', '" + bairro + "', "
                        + "'" + numero + "','" + cidade + "', '" + cep + "', "
                        + "'" + email + "','" + cpf + "', '" + dtnascimento + "', '" + celular + "', '" + telefone + "' ) ");) {

            insert.executeUpdate();
            
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Inclusão de cadastro");
        alert.setContentText("Cliente incluído com sucesso");

        alert.showAndWait();

        } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Inclusão de cadastro");
        alert.setContentText("Revise os dados");        }
    }

    public static void atualizarCliente(int index, String nome, String endereco, String bairro, int numero,
            String cidade, int cep, String estado, String email, String cpf,
            int dtnascimento, int celular, int telefone) {

        try (Connection con = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement command = con.prepareStatement("UPDATE CLIENTE SET NOME = '" + nome + "', ENDERECO = '" + endereco + "',"
                        + " BAIRRO = '" + bairro + "', NUMERO = '" + numero + "', CIDADE = '" + cidade + "', CEP = '" + cep + "',"
                        + " ESTADO = '" + estado + "', EMAIL = '" + email + "', CPF = '" + cpf + "', DATA_NASCIMENTO = '" + dtnascimento + "',"
                        + " CELULAR = '" + celular + "', TELEFONE = '" + telefone + "' WHERE ID = " + index)) {
            command.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ArrayList<String> getCliente(int index) {

        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement statement = conn.prepareStatement("SELECT * FROM cliente where id = " + index);
                ResultSet result = statement.executeQuery()) {

            ArrayList<String> array = new ArrayList<>();

            while (result.next()) {
                array.add(result.getString("ID"));
                array.add(result.getString("NOME"));
                array.add(result.getString("ENDERECO"));
                array.add(result.getString("BAIRRO"));
                array.add(result.getString("NUMERO"));
                array.add(result.getString("CIDADE"));
                array.add(result.getString("CEP"));
                array.add(result.getString("ESTADO"));
                array.add(result.getString("EMAIL"));
                array.add(result.getString("CPF"));
                array.add(result.getString("DATA_NASCIMENTO"));
                array.add(result.getString("CELULAR"));
                array.add(result.getString("TELEFONE"));
            }
            return array;

        } catch (Exception e) {

            System.out.println("ERRO: " + e);
            return null;

        }
    }

    public static void excluirCliente(int index) {

        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement statement = conn.prepareStatement("Delete FROM cliente where id = " + index)) {

            statement.execute();

        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }
    }

    public static ArrayList<dicunto.bd.Cliente> getClientes() {

        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement statement = conn.prepareStatement("SELECT * FROM cliente");
                ResultSet result = statement.executeQuery()) {

            ArrayList<Cliente> array = new ArrayList<>();

            while (result.next()) {
                Cliente c = new Cliente();
                c.id = result.getString("ID");
                c.nome = result.getString("NOME");
                c.endereco = result.getString("ENDERECO");
                c.bairro = result.getString("BAIRRO");
                c.numero = result.getString("NUMERO");
                c.cidade = result.getString("CIDADE");
                c.cep = result.getString("CEP");
                c.email = result.getString("EMAIL");
                c.cpf = result.getString("CPF");
                c.dtNascimento = result.getString("DATA_NASCIMENTO");
                c.celular = result.getString("CELULAR");
                c.telefone = result.getString("TELEFONE");
                array.add(c);

            }
            return array;
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
            return null;
        }
    }
}
