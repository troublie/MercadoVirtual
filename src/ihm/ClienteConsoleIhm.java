package ihm;

import Classes.Cliente;
import java.util.List;
import java.util.Scanner;
import mercado.dao.api.ClienteDaoInterface;
import mercado.dao.api.DaoException;

public class ClienteConsoleIhm {

    private ClienteDaoInterface dao;
    private Scanner sc;

    public ClienteConsoleIhm(ClienteDaoInterface dao) {
        this.dao = dao;
        sc = new Scanner(System.in);
    }

    public void executar() throws DaoException {
        boolean sair = false;
        while (!sair) {
            int opcao = interacaoMenuPrincipal();
            List<Cliente> clientes = null;
            String id;
            switch (opcao) {
                case 7:
                    sair = true;
                    break;
                case 1: // listar todos
                    clientes = dao.listarTodos();
                    interacaoMostrar(clientes);
                    break;
                case 2: // buscar pelo nome
                    String nome = interacaoSolicitarNome();
                    clientes = dao.buscarPeloNome(nome);
                    interacaoMostrar(clientes);
                    break;
                case 3: // buscar pelo id
                    System.out.println("");
                    System.out.println("BUSCA PELO CPF");
                    id = interacaoSolicitarId();
                    Cliente c = dao.buscarPeloId(id);
                    interacaoMostrar(c);
                    break;
                case 4: // criar
                    Cliente novo = interacaoNovoCliente();
                    Cliente completo = dao.criar(novo);
                    interacaoMostrar(completo);
                    break;
                case 5: // atualizar
                    Cliente modificado = interacaoAtualizar();
                    dao.atualizar(modificado);
                    break;
                case 6: // apagar
                    System.out.println("");
                    System.out.println("REMOÇÃO DE CLIENTE");
                    id = interacaoSolicitarId();
                    dao.apagar(id);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private int interacaoMenuPrincipal() {
        boolean valida = false;
        int opcao = -1;
        while (!valida) {
            System.out.println("");
            System.out.println("MENU PRINCIPAL");
            System.out.println("--------------");
            System.out.println("1 - Listar todos");
            System.out.println("2 - Buscar pelo nome");
            System.out.println("3 - Buscar pelo id");
            System.out.println("4 - Criar novo cliente");
            System.out.println("5 - Atualizar cliente");
            System.out.println("6 - Apagar cliente");
            System.out.println("7 - Sair");
            System.out.print("Opção escolhida: ");
            try {
                opcao = Integer.parseInt(sc.nextLine());
                valida = true;
            } catch (NumberFormatException e) {
                System.out.println("Entre um número inteiro!");
                System.out.println("");
            }
        }
        return opcao;
    }

    private void interacaoMostrar(List<Cliente> clientes) {
        System.out.println("");
        System.out.println("LISTA DE TODOS OS USUÁRIOS");
        if (clientes != null && clientes.size() > 0) {
            for (Cliente c : clientes) {
                System.out.println("Nome: " + c.getNome() + "; CPF: " + c.getCpf()
                        + "; endereço: " + c.getEndereco() + "; email: " + c.getEmail() + "; CEP: " + c.getCep());
            }
        } else {
            System.out.println("NENHUM CLIENTE ENCONTRADO!");
        }
    }

    private String interacaoSolicitarNome() {
        System.out.println("");
        System.out.println("BUSCA PELO NOME");
        System.out.print("Digite o nome a ser buscado: ");
        String nome = sc.nextLine();
        return nome;
    }

    private String interacaoSolicitarId() {
        boolean valido = false;
        String id=null;
        while (!valido) {
            System.out.print("Digite o CPF: ");
            id = sc.nextLine();
            valido = true;
        }   
           return id;
    }

    private void interacaoMostrar(Cliente c) {
        System.out.println("");
        if (c != null) {
            System.out.println("DADOS DO USUÁRIO");
            System.out.println("Nome: " + c.getNome() + "; CPF: " + c.getCpf()
                    + "; endereço: " + c.getEndereco() + "; email: " + c.getEmail() + "; CEP: " + c.getCep());
        } else {
            System.out.println("NENHUM CLIENTE ENCONTRADO!");
        }
    }

    private Cliente interacaoNovoCliente() {
        System.out.println("");
        System.out.println("CRIAÇÃO DE NOVO CLIENTE");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.println("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("CEP: ");
        String cep = sc.nextLine();
        Cliente c = new Cliente(nome, cpf, endereco, email, cep);
        return c;
    }

    private Cliente interacaoAtualizar() {
        System.out.println("");
        System.out.println("ATUALIZAÇÃO DE UM CLIENTE");
        String id = interacaoSolicitarId();
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        System.out.println("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("CEP: ");
        String cep = sc.nextLine();
        Cliente c = new Cliente(nome, cpf, endereco, email, cep);
        return c;
    }

}
