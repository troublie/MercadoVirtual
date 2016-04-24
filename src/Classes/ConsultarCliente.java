package Classes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author camil
 */
public class ConsultarCliente {
       public static void main(String[] args)
            throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://127.0.0.1:1527/mercado_virtual_proj";
        String usuario = "app";
        String senha = "app";
        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        Statement st = conexao.createStatement();
        Scanner entrada = new Scanner(System.in);
        String sql = "SELECT * FROM CLIENTE";
        ResultSet resultados = st.executeQuery(sql);
        System.out.println("Dados dos Clientes:");
        while(resultados.next()){
            System.out.println("Nome: "+resultados.getString("NOME"));
            System.out.println("CPF: "+resultados.getString("CPF"));
            System.out.println("Endereço: "+resultados.getString("ENDERECO"));
            System.out.println("Email: "+resultados.getString("EMAIL"));
            System.out.println("CEP: "+resultados.getString("CEP"));
        }
        conexao.close();
    }
}