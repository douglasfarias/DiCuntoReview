package dicunto.bd;

import conexaobanco.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Pedido {

    public Pedido() {
    }

    public static void inserirRegistro(int id_func, int id_cli, int pro, int quant) {

        try (Connection con = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement insert = con.prepareStatement("INSERT INTO PEDIDO (ID_FUNCIONARIO, ID_CLIENTE, PRODUTO, QUANTIDADE) VALUES ( '" + id_func + "', '" + id_cli + "', '" + pro + "','" + quant + "')")) {

            insert.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ArrayList<String> getPedido(int index) {

        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement statement = conn.prepareStatement("SELECT * FROM produto where id = " + index);
                ResultSet result = statement.executeQuery()) {

            ArrayList<String> array = new ArrayList<>();

            while (result.next()) {
                array.add(result.getString("ID_FUNCIONARIO"));
                array.add(result.getString("ID_CLIENTE"));
                array.add(result.getString("PRODUTO"));
                array.add(result.getString("QUANTIDADE"));

            }
            return array;

        } catch (Exception e) {

            System.out.println("ERRO: " + e);
            return null;

        }
    }

}
