/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.apps;

import Classes.Cliente;
import java.util.List;
import mercado.dao.api.ClienteDaoInterface;
import mercado.dao.api.DaoException;
import mercado.dao.impl.relacional.ClienteDaoRelacional;
import mercado.dao.impl.relacional.ConexaoInterface;
import mercado.dao.impl.relacional.javadb.ConexaoJavaDb;

/**
 *
 * @author camil
 */
public class AppSelectClientesComDao {

    public static void main(String[] args) throws DaoException {
        ConexaoInterface conexao = new ConexaoJavaDb("app", "app", "127.0.0.1", 1527, "mercado_virtual_proj");
        ClienteDaoInterface dao = new ClienteDaoRelacional(conexao);
        List<Cliente> clientes = dao.listarTodos();
        for (Cliente c : clientes) {
            System.out.println("Nome do cliente:" + c.getNome() + " - CPF: " + c.getCpf() + " - Endereço: "
                    + c.getEndereco() + " - Email"+c.getEmail()+ " - CEP:"+c.getCep());
        }
    }
}
