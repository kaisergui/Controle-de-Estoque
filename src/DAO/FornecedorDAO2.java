
package DAO;
import Classes.Fornecedor;
import Util.ConexaoAulaDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FornecedorDAO2 {
      
   private Connection conn;
     public FornecedorDAO2() {
        try{
            this.conn = ConexaoAulaDAO.getConnection();
        }catch(Exception e){
            System.out.println(e.getMessage());;
        }
    }

    public ArrayList listar() {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        ArrayList fornecedores = new ArrayList();

        try {
            String SQL = "SELECT * FROM fornecedor ORDER BY fornecedor_id";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int fornecedor_id = rs.getInt("fornecedor_id");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                fornecedores.add(new Fornecedor(fornecedor_id, nome, endereco, telefone, email));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            ConexaoAulaDAO.close(connL, ps);
        }

        return fornecedores;
    }
    
 
    
    
   
}
