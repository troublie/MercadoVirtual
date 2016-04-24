package Classes;


import java.sql.Connection;
import java.sql.DriverManager;
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
public class InserirProduto {

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://127.0.0.1:1527/mercado_virtual_proj";
        String usuario = "app";
        String senha = "app";
        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        Statement st = conexao.createStatement();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Inserção de novo produto: ");
        System.out.print("Digite o código do produto: ");
        int codProd = entrada.nextInt();
        System.out.print("Digite o nome do produto: ");
        String nome = entrada.nextLine();
        System.out.print("Digite a descrição do Produto: ");
        String desc = entrada.nextLine();
        System.out.print("Digite a quantidade do Produto: ");
        int qtd = entrada.nextInt();
        String sql = "INSERT INTO produtos ";
        sql += " VALUES (" + codProd + ",'" + nome + "','" + desc + "'," +qtd+")";
        st.executeUpdate(sql);
        System.out.println("Produto inserido com sucesso!");
        conexao.close();
    }
}
