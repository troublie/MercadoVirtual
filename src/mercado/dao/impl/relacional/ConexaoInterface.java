/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.dao.impl.relacional;

import java.sql.Connection;

/**
 *
 * @author 31550525
 */
public interface ConexaoInterface {
    Connection getConnection();
    void close();
}
