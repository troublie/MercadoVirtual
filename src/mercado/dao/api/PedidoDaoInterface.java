/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.dao.api;

import Classes.Pedido;
import java.util.List;

/**
 *
 * @author juliano.lopes
 */
public interface PedidoDaoInterface {
    List<Pedido> listarPedidos();
}
