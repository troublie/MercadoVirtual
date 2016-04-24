package Classes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class ExcluirProduto {

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://127.0.0.1:1527/mercado_virtual_proj";
        String usuario = "app";
        String senha = "app";
        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        Statement st = conexao.createStatement();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Insira o código do produto que deseja remover:");
        int codProd = entrada.nextInt();
        String sql = "DELETE PRODUTO WHERE COD_PROD="+codProd;
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.executeUpdate();
        System.out.println("Registro removido!!");
        conexao.close();
    }
}
