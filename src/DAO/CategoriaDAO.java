/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Categoria;
import Util.ConexaoAulaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO {

    private Connection conn;

    public CategoriaDAO() throws ErpDAOException {
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
            String SQL = "SELECT * FROM categoria ORDER BY categoria_id";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            ArrayList Categorias = new ArrayList();

            while (rs.next()) {
                int categoria_id = rs.getInt("categoria_id");
                String nome = rs.getString("nome");
                Categorias.add(new Categoria(categoria_id, nome));

            }

            return Categorias;

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao listar estoque " + sqle);
        } finally {
            ConexaoAulaDAO.close(connL, ps);
        }
    }

   
}
