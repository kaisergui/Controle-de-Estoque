
package DAO;
import Classes.Cliente;
import Util.ConexaoAulaDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
      
   private Connection conn;
     public ClienteDAO() {
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
        ArrayList clientes = new ArrayList();

        try {
            String SQL = "SELECT * FROM cliente ORDER BY nome";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                int cliente_id = rs.getInt("cliente_id");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                clientes.add(new Cliente(cliente_id, nome, endereco, telefone, email));

            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            ConexaoAulaDAO.close(connL, ps);
        }

        return clientes;
    }
    
    public void inserir(Cliente cliente) {         
        PreparedStatement ps = null;
        Connection connL = null;        
        if (cliente == null){
            System.out.println("O objeto cliente não pode ser nulo.");
        }
        try{
            String SQL = "INSERT INTO cliente (nome, endereco, telefone, email) " +
                    "values (?,?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);           
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
	    ps.setString(3, cliente.getTelefone());
             ps.setString(4, cliente.getEmail());
            ps.executeUpdate();

        }catch(SQLException sqle){
            System.out.println("Erro ao inserir um novo cliente" + sqle);
        }
        finally{
           ConexaoAulaDAO.close(connL,ps);
        }
    }
    
    public Cliente procurar(int codigo) {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;
        Cliente cliente = new Cliente();
        cliente = null;

        try{
            String SQL = "SELECT cliente_id, nome, endereco, telefone, email FROM cliente WHERE cliente_id = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
           
            
            while( rs.next()){
              int cliente_id = rs.getInt("cliente_id");
              String nome = rs.getString("nome");
              String endereco = rs.getString("endereco");
              String telefone = rs.getString("telefone");
              String email = rs.getString("email");
              cliente = new Cliente(cliente_id, nome, endereco, telefone, email); 
              
            }
            
            
            
        }catch(SQLException sqle){
            System.out.println("Erro ao procurar cliente " + sqle);
        }
        finally{
          // ConexaoAulaDAO.close(connL,ps);
        }
        return cliente;
    }   
    
    public void excluir(int codigo) throws ErpDAOException{
        PreparedStatement ps = null;
        Connection connL = null;
        if (codigo == 0) {
            throw new ErpDAOException("O objeto cliente não pode ser nulo.");
        }

        try {
            String SQL = "DELETE FROM cliente WHERE cliente_id=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao excluir cliente " + sqle);
        } finally {
            ConexaoAulaDAO.close(connL, ps);
        }
    }
          public void atualizar(Cliente cliente) {
        PreparedStatement ps = null;
        Connection connL = null;
        if (cliente == null){
             System.out.println("O objeto Cliente não pode ser nulo.");
        }

        try{
            String SQL = "UPDATE cliente set nome=?,endereco=?,telefone=?, email=? WHERE cliente_id=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL); 
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getEmail());
            ps.setInt(5, cliente.getCliente_id());
            ps.executeUpdate();

        }catch(SQLException sqle){
            System.out.println("Erro ao editar Cliente " + sqle);
        }
        finally{
           ConexaoAulaDAO.close(connL,ps);
        }
    }

    
    
   
}
