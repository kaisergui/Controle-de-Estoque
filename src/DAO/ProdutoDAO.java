/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Produto;
import Util.ConexaoAulaDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {

    private Connection conn;

    public ProdutoDAO() throws ErpDAOException {
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
            String SQL = "SELECT * FROM produto ORDER BY nome";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            rs = ps.executeQuery();

            ArrayList Estoque = new ArrayList();

            while (rs.next()) {
                int produto_id = rs.getInt("produto_id");
                String nome = rs.getString("nome");
                float preco = rs.getFloat("preco");
                int quantidade_estoque = rs.getInt("quantidade_estoque");
                int fornecedor_id = rs.getInt("fornecedor_id");
                int categoria_id = rs.getInt("categoria_id");
                Estoque.add(new Produto(produto_id, nome, preco, quantidade_estoque, fornecedor_id, categoria_id));

            }

            return Estoque;

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao listar estoque " + sqle);
        } finally {
            ConexaoAulaDAO.close(connL, ps);
        }
    }

    public void inserir(Produto produto) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        if (produto == null) {
            throw new ErpDAOException("O objeto produto não pode ser nulo.");
        }
        try {
            String SQL = "INSERT INTO produto (nome,preco,quantidade_estoque,fornecedor_id,categoria_id) "
                    + "values (?,?,?,?,?)";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setString(1, produto.getNome());
            ps.setFloat(2, produto.getPreco());
            ps.setInt(3, produto.getQuantidade_estoque());
            ps.setInt(4, produto.getFornecedor_id());
            ps.setInt(5, produto.getCategoria_id());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao inserir uma novos produtos " + sqle);
        } finally {
            ConexaoAulaDAO.close(connL, ps);
        }
    }

    public void atualizar(Produto produto) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        if (produto == null) {
            throw new ErpDAOException("O objeto produto não pode ser nulo.");
        }

        try {
            String SQL = "UPDATE produto set nome=?, preco=?, quantidade_estoque=?, fornecedor_id=?, categoria_id=? WHERE produto_id=?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setString(1, produto.getNome());
            ps.setFloat(2, produto.getPreco());
            ps.setInt(3, produto.getQuantidade_estoque());
            ps.setInt(4, produto.getFornecedor_id());
            ps.setInt(5, produto.getCategoria_id());
            ps.setInt(6, produto.getProduto_id());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao editar produto " + sqle);
        } finally {
            ConexaoAulaDAO.close(connL, ps);
        }
    }

    public Produto procurar(int codigo) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        ResultSet rs = null;

        try {
            String SQL = "SELECT produto_id, nome, preco, quantidade_estoque, fornecedor_id, categoria_id FROM produto WHERE produto_id = ?";
            connL = this.conn;
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            Produto produto = new Produto();
            produto = null;

            while (rs.next()) {

                int produto_id = rs.getInt("produto_id");
                String nome = rs.getString("nome");
                float preco = rs.getFloat("preco");
                int quantidade_estoque = rs.getInt("quantidade_estoque");
                int fornecedor_id = rs.getInt("fornecedor_id");
                int categoria_id = rs.getInt("categoria_id");
                produto = new Produto(produto_id, nome, preco, quantidade_estoque, fornecedor_id, categoria_id);

            }

            return produto;

        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao procurar produto " + sqle);
        } finally {
            // ConexaoAulaDAO.close(connL,ps);
        }
    }

    public void excluir(int codigo) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        if (codigo == 0) {
            throw new ErpDAOException("O objeto produto não pode ser nulo.");
        }

        try {
            String SQL = "DELETE FROM produto WHERE produto_id=?";
            connL = this.conn;

            ps = connL.prepareStatement(SQL);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new ErpDAOException("Erro ao excluir produto " + sqle);
        } finally {
            ConexaoAulaDAO.close(connL, ps);
        }
    }

    public void atualizarQuantidade(int produtoId, int novaQuantidade) throws ErpDAOException {
        PreparedStatement ps = null;
        Connection connL = null;
        try {
            connL = this.conn;
            String SQL = "UPDATE produto SET quantidade_estoque = ? WHERE produto_id = ?";
            ps = connL.prepareStatement(SQL);
            ps.setInt(1, novaQuantidade);
            ps.setInt(2, produtoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new ErpDAOException("Erro ao atualizar quantidade do produto", e);
        } finally {
            ConexaoAulaDAO.close(connL, ps);
        }
    }

}
