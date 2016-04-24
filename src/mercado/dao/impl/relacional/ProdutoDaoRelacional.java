/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.dao.impl.relacional;

import Classes.Produto;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mercado.dao.api.ProdutoDaoInterface;

/**
 *
 * @author juliano.lopes
 */
public class ProdutoDaoRelacional implements ProdutoDaoInterface {

    private ConexaoInterface conexao;
    
    public ProdutoDaoRelacional(){};

    public ProdutoDaoRelacional(ConexaoInterface conexao) {
        this.conexao = conexao;
    }

    @Override
    public List<Produto> listarProdutos() {
        List<Produto> produtos;
        produtos = new ArrayList<>();
        try {
            Statement st;
            st = conexao.getConnection().createStatement();
            String sql = "SELECT * FROM produto";
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {

                int a = resultados.getInt("cod_prod");
                int b = resultados.getInt("qtd");
                String c = resultados.getString("nome");
                String d = resultados.getString("descricao");
                double e = resultados.getDouble("preco");

                Produto p = new Produto(a, e, c, d, b);
                produtos.add(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return produtos;
    }
}
