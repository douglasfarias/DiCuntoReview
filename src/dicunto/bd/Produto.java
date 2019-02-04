package dicunto.bd;

import conexaobanco.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Produto {
    
    public String id,
            nome,
            idFornecedor,
            idCategoria,
            quantidade,
            descricao,
            preco,
            peso;

    public static void setInserirProduto(String v_nome, String v_desc, String qtd, String preco) {
        
        try(Connection conn = ConexaoMySQL.getConexaoMySQL()){
            PreparedStatement insert = conn.prepareStatement("INSERT INTO Produto (NOME, DESCRICAO, QUANTIDADE, PRECO)" +
                    " VALUES ( '" +
                    v_nome + "', '" +
                    v_desc + "', '" +
                    qtd + "', '" +
                    preco + "') ");
            
            insert.executeUpdate();
        
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static ArrayList<Produto> getProdutos(){
        try(Connection cn = ConexaoMySQL.getConexaoMySQL();
                PreparedStatement cmd = cn.prepareStatement("SELECT * FROM PRODUTO");
                ResultSet r = cmd.executeQuery()){
            
            ArrayList<Produto> array = null;
            
            while(r.next()){
                Produto p = new Produto();
                
                p.id = r.getString("ID");
                p.nome = r.getString("NOME");
                p.idFornecedor = r.getString("ID_FORNECEDOR");
                p.idCategoria = r.getString("ID_CATEGORIA");
                p.quantidade = r.getString("QUANTIDADE");
                p.descricao = r.getString("DESCRICAO");
                p.preco = r.getString("PRECO");
                p.peso = r.getString("PESO");
                
                array.add(p);
            }
            
            return array;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }


}