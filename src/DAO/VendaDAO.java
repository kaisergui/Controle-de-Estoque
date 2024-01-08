 
package DAO;

import Classes.Venda;
import Util.ConexaoAulaDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class VendaDAO {

    private Connection conn;

    public VendaDAO() throws ErpDAOException {
        try {
            this.conn = ConexaoAulaDAO.getConnection();
        } catch (Exception e) {
            throw new ErpDAOException("Erro de conexão: " + ":\n" + e.getMessage());
        }
    }

    public ArrayList listar() throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;

        try {
            String SQL = "SELECT * FROM venda ORDER BY venda_id";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            ArrayList Varejo = new ArrayList();

            while (rs.next()) {
                int venda_id = rs.getInt("venda_id");
                Date data_venda = rs.getDate("data_venda");
                Time horario = rs.getTime("horario");
                float total = rs.getInt("total");
                int cliente_id = rs.getInt("cliente_id");
                int produto_id = rs.getInt("produto_id");
                int quantidade = rs.getInt("quantidade");
                Varejo.add(new Venda(venda_id, data_venda, horario, total, cliente_id, produto_id, quantidade));

            }

            return Varejo;

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao listar vendas " + sqle);
        } finally {
            ConexaoAulaDAO.close(connL, ps);
        }
    }

    public void inserir(Venda venda) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        if (venda == null) {
            throw new ErpDAOException("O objeto venda não pode ser nulo.");
        }
        try {
            String SQL = "INSERT INTO venda (data_venda, horario, total, quantidade,cliente_id, produto_id) "
                    + "values (?,?,?,?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            
            
          java.util.Date dataJAVA = venda.getData_venda();  // Data da classe Java Util
            java.sql.Time timeSQL = venda.getHorario();
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(1, dataSQL);
            ps.setTime(2, timeSQL);
            ps.setFloat(3, venda.getTotal());
            ps.setInt(4, venda.getQuantidade());
            ps.setInt(5, venda.getCliente_id());
            ps.setInt(6, venda.getProduto_id());
    
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao inserir uma nova venda " + sqle);
        } finally {
            ConexaoAulaDAO.close(connL, ps);
        }
    }

    public void atualizar(Venda venda) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        if (venda == null) {
            throw new ErpDAOException("O objeto venda não pode ser nulo.");
        }

        try {
            String SQL = "UPDATE venda set data_venda=?, horario=?, total=?, cliente_id=?, produto_id=?, quantidade=? WHERE venda_id=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
                java.util.Date dataJAVA = venda.getData_venda();  // Data da classe Java Util
            java.sql.Date dataSQL = new java.sql.Date(dataJAVA.getTime()); // Data da classe SQL
            ps.setDate(1, dataSQL);
            java.sql.Time timeSQL = venda.getHorario();
            ps.setTime(2, timeSQL);
            ps.setFloat(3, venda.getTotal());
            ps.setInt(4, venda.getCliente_id());
            ps.setInt(5, venda.getProduto_id());
            ps.setInt(6, venda.getQuantidade());
            ps.setInt(7, venda.getVenda_id());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao editar venda " + sqle);
        } finally {
            ConexaoAulaDAO.close(connL, ps);
        }
    }

    public Venda procurar(int codigo) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;

        try {
            String SQL = "SELECT venda_id, data_venda, horario, total, cliente_id, produto_id, quantidade FROM venda WHERE venda_id = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            Venda venda = new Venda();
            venda = null;

            while (rs.next()) {
                int venda_id = rs.getInt("venda_id");
                Date data_venda = rs.getDate("data_venda");
                Time horario = rs.getTime("horario");
                float total = rs.getInt("total");
                int cliente_id = rs.getInt("cliente_id");
                int produto_id = rs.getInt("produto_id");
                int quantidade = rs.getInt("quantidade");
                venda = (new Venda(venda_id, data_venda, horario, total, cliente_id, produto_id, quantidade));

            }

            return venda;

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao procurar venda " + sqle);
        } finally {
            // ConexaoAulaDAO.close(connL,ps);
        }
    }

    public void excluir(int codigo) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        if (codigo == 0) {
            throw new ErpDAOException("O objeto venda não pode ser nulo.");
        }

        try {
            String SQL = "DELETE FROM venda WHERE venda_id=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao excluir venda " + sqle);
        } finally {
            ConexaoAulaDAO.close(connL, ps);
        }
    }

}
