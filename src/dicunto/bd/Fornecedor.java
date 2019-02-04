package dicunto.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import conexaobanco.ConexaoMySQL;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Fornecedor {
    
    public String id,
                nome,
                endereco,
                bairro,
                numero,
                cidade,
                cep,
                estado,
                email,
                cnpj,
                dataCadastro,
                celular,
                telefone,
                telefone2;

    public static void setInserirFornecedor(String nome, String endreco, String bairro, int numero,
            String cidade, int cep, String estado, String email, String cnpj,
            int dtcadastro, int celular, int telefone, int telefone2) {

        try(Connection con = ConexaoMySQL.getConexaoMySQL();
            PreparedStatement insert = con.prepareStatement("INSERT INTO FORNECEDOR (NOME, ENDERECO, BAIRRO, NUMERO, CIDADE, CEP, ESTADO, EMAIL, CNPJ, DATA_CADASTRO, CELULAR, TELEFONE, TELEFONE2) "
                    + "VALUES ( '" + nome +
                    "', '" + endreco +
                    "', '" + bairro +
                    "', '" + numero + 
                    "','" + cidade +
                    "', '" + cep +
                    "', '" + estado +
                    "', '" + email + 
                    "','" + cnpj + 
                    "', '" + dtcadastro + 
                    "', '" + celular + 
                    "', '" + telefone + 
                    "', '" + telefone2 + "' ) ");){
            
            insert.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static ArrayList<String> getFornecedor() {

        try(Connection conn = ConexaoMySQL.getConexaoMySQL();
            PreparedStatement statement = conn.prepareStatement("SELECT nome FROM fornecedor");
            ResultSet result = statement.executeQuery()){
            
            ArrayList<String> array = new ArrayList<>();

            while (result.next()) {
                array.add(result.getString("nome"));
            }

            System.out.println("SELECT EFETUADO COM SUCESSO !");
            return array;
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
            return null;
        }
    }
    
    public static ArrayList<Fornecedor> getFornecedores() {

        try(Connection conn = ConexaoMySQL.getConexaoMySQL();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM fornecedor");
            ResultSet result = statement.executeQuery()){
            
            ArrayList<Fornecedor> array = new ArrayList<>();

            while (result.next()) {
                Fornecedor f = new Fornecedor();
                f.id = result.getString("ID");
                f.nome = result.getString("NOME");
                f.endereco = result.getString("ENDERECO");
                f.bairro = result.getString("BAIRRO");
                f.numero = result.getString("NUMERO");
                f.cidade = result.getString("CIDADE");
                f.cep = result.getString("CEP");
                f.estado = result.getString("ESTADO");
                f.email = result.getString("EMAIL");
                f.cnpj = result.getString("CNPJ");
                f.dataCadastro = result.getString("DATA_CADASTRO");
                f.celular = result.getString("CELULAR");
                f.telefone = result.getString("TELEFONE");
                f.telefone2 = result.getString("TELEFONE2");
                array.add(f);
            }

            System.out.println("SELECT EFETUADO COM SUCESSO !");
            return array;
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
            return null;
        }
    }
    
    public static void excluirFornecedor(int index) {

        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement statement = conn.prepareStatement("Delete FROM FORNECEDOR where id = " + index)) {
            
            statement.execute();

        } catch (Exception e) {
            System.out.println("ERRO: " + e);            
        }
    }
    
    public static void atualizarFornecedor(int index, String nome, String endereco, String bairro, int numero,
            String cidade, int cep, String estado, String email, String cpf,
            int dtnascimento, int celular, int telefone, int telefone2) {

        try (Connection con = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement command = con.prepareStatement("UPDATE FORNECEDOR SET NOME = '" + nome + "', ENDERECO = '" + endereco + "',"
                        + " BAIRRO = '" + bairro + "', NUMERO = '" + numero + "', CIDADE = '" + cidade + "', CEP = '" + cep + "',"
                        + " ESTADO = '" + estado + "', EMAIL = '" + email + "', CPF = '" + cpf + "', DATA_NASCIMENTO = '" + dtnascimento + "',"
                        + " CELULAR = '" + celular + "', TELEFONE = '" + telefone + ", TELEFONE2 = " + telefone2 + "' WHERE ID = " + index)) {
            command.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static ArrayList<String> getFornecedor(int index) {

        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement statement = conn.prepareStatement("SELECT * FROM FORNECEDOR where id = " + index);
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
                array.add(result.getString("CNPJ"));
                array.add(result.getString("DATA_CADASTRO"));
                array.add(result.getString("CELULAR"));
                array.add(result.getString("TELEFONE"));
                array.add(result.getString("TELEFONE2"));
            }
            return array;
            
        } catch (Exception e) {
            
            System.out.println("ERRO: " + e);
            return null;
            
        }
    }

}
