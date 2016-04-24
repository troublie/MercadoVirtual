/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.List;
import mercado.dao.api.ProdutoDaoInterface;
import mercado.dao.impl.relacional.ProdutoDaoRelacional;

/**
 *
 * @author 31550525
 */
public class Gerenciador {

    private static ProdutoDaoInterface dao;

    public static void main(String[] args) {
        dao = new ProdutoDaoRelacional();

        System.out.println("Lista de Produtos");
        List<Produto> produtos = dao.listarProdutos();
                
    }
}
