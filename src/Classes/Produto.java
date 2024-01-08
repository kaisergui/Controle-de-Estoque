
package Classes;

public class Produto {
    int produto_id;
    String nome;
    float preco;
    int quantidade_estoque;
    int fornecedor_id;
    int categoria_id;

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public int getFornecedor_id() {
        return fornecedor_id;
    }

    public void setFornecedor_id(int fornecedor_id) {
        this.fornecedor_id = fornecedor_id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public Produto() {
    }

    public Produto(int produto_id, String nome, float preco, int quantidade_estoque, int fornecedor_id, int categoria_id) {
        this.produto_id = produto_id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade_estoque = quantidade_estoque;
        this.fornecedor_id = fornecedor_id;
        this.categoria_id = categoria_id;
    }
    
}
