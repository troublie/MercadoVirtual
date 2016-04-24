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
public class InserirCliente {

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://127.0.0.1:1527/mercado_virtual_proj";
        String usuario = "app";
        String senha = "app";
        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        Statement st = conexao.createStatement();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Inserção de novo cliente: ");
        System.out.print("Digite o nome: ");
        String nome = entrada.nextLine();
        entrada.nextLine();
        System.out.print("Digite o cpf: ");
        String cpf = entrada.nextLine();
        entrada.nextLine();
        System.out.print("Digite o endereco: ");
        String end = entrada.next();
        System.out.print("Digite o email: ");
        String email = entrada.next();
        System.out.print("Digite o cep: ");
        String cep = entrada.next();
        String sql = "INSERT INTO produtos ";
        sql += " VALUES ('" + nome + "','" + cpf + "','" + end + "','" +email+ "','" +cep+"')";
        st.executeUpdate(sql);
        System.out.println("Cliente inserido com sucesso!");
        conexao.close();
    }
}
