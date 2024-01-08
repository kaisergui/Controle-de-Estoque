
package DAO;
import Classes.Fornecedor;
import Util.ConexaoAulaDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FornecedorDAO {
      
   private Connection conn;
     public FornecedorDAO() {
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
            String SQL = "SELECT * FROM fornecedor ORDER BY nome";
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
    
    public void inserir(Fornecedor fornecedor) {         
        PreparedStatement ps = null;
        Connection connL = null;        
        if (fornecedor == null){
            System.out.println("O objeto fornecedor não pode ser nulo.");
        }
        try{
            String SQL = "INSERT INTO fornecedor (nome, endereco, telefone, email) " +
                    "values (?,?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);           
            ps.setString(1, fornecedor.getNome());
            ps.setString(2, fornecedor.getEndereco());
	    ps.setString(3, fornecedor.getTelefone());
             ps.setString(4, fornecedor.getEmail());
            ps.executeUpdate();

        }catch(SQLException sqle){
            System.out.println("Erro ao inserir um novo fornecedor" + sqle);
        }
        finally{
           ConexaoAulaDAO.close(connL,ps);
        }
    }
    
    public Fornecedor procurar(int codigo) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Fornecedor fornecedor = new Fornecedor();
        fornecedor = null;

        try{
            String SQL = "SELECT fornecedor_id, nome, endereco, telefone, email FROM fornecedor WHERE fornecedor_id = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
           
            
            while( rs.next()){
              int fornecedor_id = rs.getInt("fornecedor_id");
              String nome = rs.getString("nome");
              String endereco = rs.getString("endereco");
              String telefone = rs.getString("telefone");
              String email = rs.getString("email");
              fornecedor = new Fornecedor(fornecedor_id, nome, endereco, telefone, email); 
              
            }
            
            
            
        }catch(SQLException sqle){
            System.out.println("Erro ao procurar fornecedor " + sqle);
        }
        finally{
          // ConexaoAulaDAO.close(connL,ps);
        }
        return fornecedor;
    }   
    
    public void excluir(int codigo) throws ErpDAOException{
        PreparedStatement ps = null;
        Connection connL = null;
        if (codigo == 0) {
            throw new ErpDAOException("O objeto fornecedor não pode ser nulo.");
        }

        try {
            String SQL = "DELETE FROM fornecedor WHERE fornecedor_id=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao excluir fornecedor " + sqle);
        } finally {
            ConexaoAulaDAO.close(connL, ps);
        }
    }
          public void atualizar(Fornecedor fornecedor) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (fornecedor == null){
             System.out.println("O objeto Fornecedor não pode ser nulo.");
        }

        try{
            String SQL = "UPDATE fornecedor set nome=?,endereco=?,telefone=?, email=? WHERE fornecedor_id=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL); 
            ps.setString(1, fornecedor.getNome());
            ps.setString(2, fornecedor.getEndereco());
            ps.setString(3, fornecedor.getTelefone());
            ps.setString(4, fornecedor.getEmail());
            ps.setInt(5, fornecedor.getFornecedor_id());
            ps.executeUpdate();

        }catch(SQLException sqle){
            System.out.println("Erro ao editar Fornecedor " + sqle);
        }
        finally{
           ConexaoAulaDAO.close(connL,ps);
        }
    }

    
    
   
}
