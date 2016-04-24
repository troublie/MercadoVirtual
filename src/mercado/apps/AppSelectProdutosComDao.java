/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.apps;

import Classes.Produto;
import java.util.List;
import mercado.dao.api.ProdutoDaoInterface;
import mercado.dao.impl.relacional.ConexaoInterface;
import mercado.dao.impl.relacional.ProdutoDaoRelacional;
import mercado.dao.impl.relacional.javadb.ConexaoJavaDb;

/**
 *
 * @author camil
 */
public class AppSelectProdutosComDao {

    public static void main(String[] args) {
        ConexaoInterface conexao = new ConexaoJavaDb("app", "app", "127.0.0.1", 1527, "mercado_virtual_proj");
        ProdutoDaoInterface dao = new ProdutoDaoRelacional(conexao);
        List<Produto> produtos = dao.listarProdutos();
        for (Produto p : produtos) {
            System.out.println("Código do produto:" + p.getCod_prod() + " - Nome: " + p.getNome() + " - Descrição: "
                    + p.getDescricao() + " - Quantidade" + p.getQuantidade() + " - Preço: " + p.getPreco());
        }
    }
}
