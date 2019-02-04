package conexaobanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;

public class ConexaoMySQL {

    public static String status = "Não conectou...";

    public ConexaoMySQL() {
    }

    public static void main(String args[]) {

        getConexaoMySQL();

        statusConection();

        System.out.println(status);

    }

    public static java.sql.Connection getConexaoMySQL() {

        Connection connection = null;

        try {

            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);

            String serverName = "localhost";

            String mydatabase = "dicunto";

            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "root";
            String password = "";
            
            
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Banco de dados");
        alert.setContentText("Conexão bem sucedida"); 

            } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Banco de dados");
        alert.setContentText("Não foi possivel realizar conexão"); 

            }

            return connection;

        } catch (ClassNotFoundException e) {

            System.out.println("O driver expecificado nao foi encontrado.");

            return null;

        } catch (SQLException e) {

            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;

        }

    }

    public static String statusConection() {

        return status;

    }

    public static boolean fecharConexao() {

        try {

            ConexaoMySQL.getConexaoMySQL().close();

            return true;

        } catch (SQLException e) {

            return false;

        }

    }

    public static java.sql.Connection reiniciarConexao() {

        fecharConexao();

        return ConexaoMySQL.getConexaoMySQL();

    }

}
