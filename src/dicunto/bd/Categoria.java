package dicunto.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import conexaobanco.ConexaoMySQL;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Categoria {

    public static void inserirCategoria(String nome, String descricao) {

        try(Connection con = ConexaoMySQL.getConexaoMySQL();
            PreparedStatement insert = con.prepareStatement("INSERT INTO CATEGORIA (NOME, DESCRICAO) VALUES ( '" + nome + "', '" + descricao + "') ")){

            insert.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ArrayList<String> getNomeCategoria() {

        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement statement = conn.prepareStatement("SELECT nome FROM categoria");
                ResultSet result = statement.executeQuery()) {

            ArrayList<String> array = new ArrayList<>();

            while (result.next()) {
                System.out.println(result.getString("nome"));
                array.add(result.getString("nome"));
            }

            System.out.println("SELECT EFETUADO COM SUCESSO !");
            return array;
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
            return null;
        }
    }
    
    public static ArrayList<String> getCategoria(int index) {

        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement statement = conn.prepareStatement("SELECT * FROM categoria where id = " + index);
                ResultSet result = statement.executeQuery()) {

            ArrayList<String> array = new ArrayList<>();

            while (result.next()) {
                array.add(result.getString("id"));
                array.add(result.getString("nome"));
                array.add(result.getString("descricao"));
            }
            return array;
            
        } catch (Exception e) {
            
            System.out.println("ERRO: " + e);
            return null;
            
        }
    }
    
    public static void excluirCategoria(int index) {

        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement statement = conn.prepareStatement("Delete FROM categoria where id = " + index)) {
            
            statement.execute();

        } catch (Exception e) {
            System.out.println("ERRO: " + e);            
        }
    }
    
    public static void atualizarCategoria(int index, String nome, String desc) {

        try(Connection conn = ConexaoMySQL.getConexaoMySQL();
            PreparedStatement command = conn.prepareStatement("UPDATE CATEGORIA SET NOME = '" + nome + "', DESCRICAO = '" + desc + "' WHERE ID = " + index)){

            command.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
