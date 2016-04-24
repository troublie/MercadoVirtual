/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.apps;


import Classes.Pedido;
import java.util.List;
import mercado.dao.api.PedidoDaoInterface;
import mercado.dao.impl.relacional.ConexaoInterface;
import mercado.dao.impl.relacional.PedidoDaoRelacional;
import mercado.dao.impl.relacional.javadb.ConexaoJavaDb;

/**
 *
 * @author camil
 */
public class AppSelectPedidosComDao {

    public static void main(String[] args) {
        ConexaoInterface conexao = new ConexaoJavaDb("app", "app", "127.0.0.1", 1527, "mercado_virtual_proj");
        PedidoDaoInterface dao = new PedidoDaoRelacional(conexao);
        List<Pedido> pedidos = dao.listarPedidos();
        for (Pedido p : pedidos) {
            System.out.println("ID do Pedido:" + p.getId() + " - CPF: " + p.getCpf() + " - Código do Produto: "
                    + p.getCod_produto() + " - Quantidade: " + p.getQtd());
        }
    }
}
