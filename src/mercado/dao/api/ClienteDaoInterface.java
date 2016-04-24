/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.dao.api;

import Classes.Cliente;
import java.util.List;

/**
 *
 * @author juliano.lopes
 */
public interface ClienteDaoInterface {
    List<Cliente> listarTodos() throws DaoException;
    List<Cliente> buscarPeloNome(String nome) throws DaoException;
    Cliente buscarPeloId(String id) throws DaoException;
    Cliente criar(Cliente novo) throws DaoException;
    void atualizar(Cliente c) throws DaoException;
    void apagar(String id) throws DaoException;
}
