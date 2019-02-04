package dicunto.bd;

import conexaobanco.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Funcionario {
    
    public String id,
            nome,
            endereco,
            bairro,
            cidade,
            estado,
            email,
            numero,
            cep,
            cpf,
            dtAdmissao,
            dtNascimento,
            celular,
            telefone,
            cargo,
            setor;

    public static void inserirFuncionario(String nome, String cargo, String setor, String endreco, String bairro, int numero,
            String cidade, int cep, String estado, String email, String cpf,
            String dtadmissao, String dtnascimento, String celular, String telefone) {

        try(Connection con = ConexaoMySQL.getConexaoMySQL();
            PreparedStatement insert = con.prepareStatement("INSERT INTO FUNCIONARIO (NOME, CARGO, SETOR, ENDERECO, BAIRRO, NUMERO, CIDADE, CEP, ESTADO, EMAIL, CPF, DATA_ADMISSAO, DATA_NASCIMENTO, CELULAR, TELEFONE) "
                    + "VALUES ( '" + nome + "', '" +
                    cargo + "', '" +
                    setor + "','" + 
                    endreco + "', '" + 
                    bairro + "', '" + 
                    numero + "','" +
                    cidade + "', '" + 
                    cep + "', '" + 
                    estado + "', '" + 
                    email + "','" + 
                    cpf + "', '" + 
                    dtadmissao + "', '" + 
                    dtnascimento + "','" +
                    celular + "', '" + 
                    telefone + "')")){

            insert.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public static ArrayList<Funcionario> getFuncionarios(){
        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement statement = conn.prepareStatement("SELECT * FROM funcionario");
                ResultSet result = statement.executeQuery()) {

                    
            ArrayList<Funcionario> array = new ArrayList<>();

            while (result.next()) {
                Funcionario c = new Funcionario();
                c.id = result.getString("ID");
                c.nome = result.getString("NOME");
                c.endereco = result.getString("ENDERECO");
                c.bairro = result.getString("BAIRRO");
                c.numero = result.getString("NUMERO");
                c.cidade = result.getString("CIDADE");
                c.cep = result.getString("CEP");
                c.estado = result.getString("ESTADO");
                c.email = result.getString("EMAIL");
                c.cpf = result.getString("CPF");
                c.dtAdmissao = result.getString("DATA_ADMISSAO");
                c.dtNascimento = result.getString("DATA_NASCIMENTO");
                c.celular = result.getString("CELULAR");
                c.telefone = result.getString("TELEFONE");
                c.cargo = result.getString("CARGO");
                c.setor = result.getString("SETOR");
                array.add(c);

            }
            return array;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public static void atualizarFuncionario(int index, String nome, String endereco, String bairro, int numero,
            String cidade, int cep, String estado, String email, String cpf,
            int dtnascimento, int celular, int telefone, String cargo, String setor) {

        try (Connection con = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement command = con.prepareStatement("UPDATE FUNCIONARIO SET NOME = '" + nome + "', ENDERECO = '" + endereco + "',"
                        + " BAIRRO = '" + bairro + "', NUMERO = '" + numero + "', CIDADE = '" + cidade + "', CEP = '" + cep + "',"
                        + " ESTADO = '" + estado + "', EMAIL = '" + email + "', CPF = '" + cpf + "', DATA_NASCIMENTO = '" + dtnascimento + "',"
                        + " CELULAR = '" + celular + "', TELEFONE = '" + telefone + "', CARGO = '" + cargo + 
                        ", SETOR = '" + setor + " WHERE ID = " + index)) {
           
            command.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getVerificaSenha() {

        return 0;
    }
    
    public static void excluirFuncionario(int index) {
        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement statement = conn.prepareStatement("Delete FROM FUNCIONARIO where id = " + index)) {
            
            statement.execute();

        } catch (Exception e) {
            System.out.println("ERRO: " + e);            
        }
    }
    
    public static ArrayList<String> getFuncionario(int index){
        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement statement = conn.prepareStatement("SELECT * FROM funcionario WHERE ID = " + index);
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
                array.add(result.getString("DATA_ADMISSAO"));
                array.add(result.getString("CELULAR"));
                array.add(result.getString("TELEFONE"));
                array.add(result.getString("CARGO"));
                array.add(result.getString("SETOR"));
            }
            return array;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    

}
