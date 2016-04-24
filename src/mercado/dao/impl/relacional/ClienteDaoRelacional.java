package mercado.dao.impl.relacional;

import Classes.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mercado.dao.api.ClienteDaoInterface;
import mercado.dao.api.DaoException;

public class ClienteDaoRelacional implements ClienteDaoInterface {

    private static final String sqlListarTodos
            = "SELECT * FROM cliente";
    private static final String sqlBuscarPeloNome
            = "SELECT * FROM cliente WHERE nome = ?";
    private static final String sqlBuscarPeloId
            = "SELECT * FROM cliente WHERE cpf = ?";
    private static final String sqlCriar
            = "INSERT INTO cliente (nome, cpf, endereco, email, cep) VALUES (?, ?, ?, ?, ?)";
    private static final String sqlAtualizar
            = "UPDATE cliente SET nome = ?, endereco = ?, email = ?, cep = ? WHERE cpf = ?";
    private static final String sqlApagar
            = "DELETE FROM cliente WHERE cpf = ?";
    private Connection conexao;
    private PreparedStatement pstmListarTodos;
    private PreparedStatement pstmBuscarPeloNome;
    private PreparedStatement pstmBuscarPeloId;
    private PreparedStatement pstmCriar;
    private PreparedStatement pstmAtualizar;
    private PreparedStatement pstmApagar;

    public ClienteDaoRelacional() {
    }

    public ClienteDaoRelacional(ConexaoInterface c) throws DaoException {
        conexao = c.getConnection();
        try {
            prepararSentencas(conexao);
        } catch (Exception ex) {
            throw new DaoException();
        }
    }

    public void setConexao(ConexaoInterface c) throws DaoException {
        this.conexao = c.getConnection();
        try {
            prepararSentencas(conexao);
        } catch (Exception ex) {
            throw new DaoException();
        }
    }

    private void prepararSentencas(Connection con) throws SQLException {
        pstmListarTodos = con.prepareStatement(sqlListarTodos);
        pstmBuscarPeloNome = con.prepareStatement(sqlBuscarPeloNome);
        pstmBuscarPeloId = con.prepareStatement(sqlBuscarPeloId);
        pstmCriar = con.prepareStatement(sqlCriar);
        pstmAtualizar = con.prepareStatement(sqlAtualizar);
        pstmApagar = con.prepareStatement(sqlApagar);

    }

    @Override
    public List<Cliente> listarTodos() throws DaoException {
        List<Cliente> clientes = new ArrayList<>();
        try {
            ResultSet rs = pstmListarTodos.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("CPF");
                String endereco = rs.getString("endereco");
                String email = rs.getString("email");
                String cep = rs.getString("cep");
                Cliente c = new Cliente(nome, cpf, endereco, email, cep);
                clientes.add(c);
            }
        } catch (Exception e) {
            throw new DaoException();
        }
        return clientes;
    }

    @Override
    public List<Cliente> buscarPeloNome(String nome) throws DaoException {
        List<Cliente> clientes = new ArrayList<>();
        try {
            pstmBuscarPeloNome.setString(1, nome);
            ResultSet rs = pstmBuscarPeloNome.executeQuery();
            while (rs.next()) {
                String cpf = rs.getString("CPF");
                String endereco = rs.getString("endereco");
                String email = rs.getString("email");
                String cep = rs.getString("cep");
                Cliente c = new Cliente(nome, cpf, endereco, email, cep);
                clientes.add(c);
            }
        } catch (Exception e) {
            throw new DaoException();
        }
        return clientes;
    }

    @Override
    public Cliente buscarPeloId(String id) throws DaoException {
        Cliente c = null;
        try {
            pstmBuscarPeloId.setString(1, id);
            ResultSet rs = pstmBuscarPeloId.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String email = rs.getString("email");
                String cep = rs.getString("cep");
                c = new Cliente(nome, id, endereco, email, cep);
            }
        } catch (Exception e) {
            throw new DaoException();
        }
        return c;
    }

    @Override
    public Cliente criar(Cliente novo) throws DaoException {
        try {
            pstmCriar.setString(1, novo.getNome());
            pstmCriar.setString(2, novo.getCpf());
            pstmCriar.setString(3, novo.getEndereco());
            pstmCriar.setString(4, novo.getEmail());
            pstmCriar.setString(5, novo.getCep());
            pstmCriar.executeUpdate();
            ResultSet rs = pstmCriar.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String endereco = rs.getString("endereco");
                String email = rs.getString("email");
                String cep = rs.getString("cep");
                Cliente c = new Cliente(nome, cpf, endereco, email, cep);
            }
        } catch (Exception e) {
            throw new DaoException();
        }
        return novo;
    }

    @Override
    public void atualizar(Cliente c) throws DaoException {
        try {
            pstmAtualizar.setString(1, c.getNome());
            pstmAtualizar.setString(2, c.getCpf());
            pstmAtualizar.setString(3, c.getEndereco());
            pstmAtualizar.setString(4, c.getEmail());
            pstmAtualizar.setString(5, c.getCep());
            pstmAtualizar.executeUpdate();
        } catch (Exception e) {
            throw new DaoException();
        }
    }

    @Override
    public void apagar(String id) throws DaoException {
        try {
            pstmApagar.setString(1, id);
            pstmApagar.executeUpdate();
        } catch (Exception e) {
            throw new DaoException();
        }
    }

}
