/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.dao.impl.relacional;

import Classes.Pedido;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mercado.dao.api.PedidoDaoInterface;

/**
 *
 * @author juliano.lopes
 */
public class PedidoDaoRelacional implements PedidoDaoInterface {

    private ConexaoInterface conexao;

    public PedidoDaoRelacional(ConexaoInterface conexao) {
        this.conexao = conexao;
    }

    @Override
    public List<Pedido> listarPedidos() {
        List<Pedido> pedidos;
        pedidos = new ArrayList<>();
        try {
            Statement st;
            st = conexao.getConnection().createStatement();
            String sql = "SELECT * FROM pedido";
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {

                String n = resultados.getString("cpf");

                int b = resultados.getInt("cod_produto");

                int q = resultados.getInt("qtd");
                
                int i = resultados.getInt("id");

                Pedido p = new Pedido(n, b, q, i);
                pedidos.add(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pedidos;
    }
}
