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
public class AtualizarPedido {

    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://127.0.0.1:1527/mercado_virtual_proj";
        String usuario = "app";
        String senha = "app";
        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        Statement st = conexao.createStatement();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Atualização de pedido: ");
        System.out.print("Digite o cpf: ");
        String cpf = entrada.nextLine();
        entrada.nextLine();
        System.out.print("Digite o código do produto: ");
        int codProd = entrada.nextInt();
        System.out.print("Digite a quantidade: ");
        int qtd = entrada.nextInt();
        String sql = "UPDATE produtos ";
        sql += " SET ('" + cpf + "'," + codProd + "," + qtd + ")";
        st.executeUpdate(sql);
        System.out.println("Pedido inserido com sucesso!");
        conexao.close();
    }

}
