
package Classes;

import java.util.Date;
import java.sql.Time;

public class Venda {
    int venda_id;
    Date data_venda;
    Time horario;
    float total;
    int cliente_id;
    int produto_id;
    int quantidade;
    
    public int getVenda_id() {
        return venda_id;
    }

    public void setVenda_id(int venda_id) {
        this.venda_id = venda_id;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Venda() {
    }

    public Venda(int venda_id, Date data_venda, Time horario, float total, int cliente_id, int produto_id, int quantidade) {
        this.venda_id = venda_id;
        this.data_venda = data_venda;
        this.horario = horario;
        this.total = total;
        this.cliente_id = cliente_id;
        this.produto_id = produto_id;
        this.quantidade = quantidade;
    }

   
    
}
