package view;

import controller.ClienteController;
import controller.ClienteController.Cliente;
import controller.ConsultaController;
import controller.FuncionarioController;
import controller.FuncionarioController.Funcionario;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private ClienteController clienteController;
    private FuncionarioController funcionarioController;
    private ConsultaController consultaController;

    public Menu() {
        scanner = new Scanner(System.in);
        clienteController = new ClienteController();
        funcionarioController = new FuncionarioController();
        consultaController = new ConsultaController();
        menuPrincipal();
    }

    private void menuPrincipal() {
        int opcao;
        do {
            System.out.println("\n=== Menu da Clínica Veterinária ===");
            System.out.println("1. Adicionar cadastros");
            System.out.println("2. Listar cadastros");
            System.out.println("3. Agendar consulta");
            System.out.println("4. Ver consultas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa buffer

            switch (opcao) {
                case 1 -> menuCadastro();
                case 2 -> menuListagem();
                case 3 -> agendarConsulta();
                case 4 -> listarConsultas();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
        scanner.close();
    }

    private void menuCadastro() {
        int opcao;
        do {
            System.out.println("\n--- Menu Adicionar ---");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Adicionar Funcionário");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa buffer

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> cadastrarFuncionario();
                case 0 -> System.out.println("Voltando ao Menu Principal...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void menuListagem() {
        int opcao;
        do {
            System.out.println("\n--- Menu Listar ---");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Listar Funcionários");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa buffer

            switch (opcao) {
                case 1 -> clienteController.exibirClientes();
                case 2 -> funcionarioController.exibirFuncionarios();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void cadastrarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Endereço do cliente: ");
        String endereco = scanner.nextLine();

        System.out.print("Telefone do cliente: ");
        String telefone = scanner.nextLine();

        clienteController.cadastrarCliente(nome, endereco, telefone);
        System.out.println(" Cliente cadastrado com sucesso!");
    }

    private void cadastrarFuncionario() {
        System.out.print("Nome do funcionário: ");
        String nome = scanner.nextLine();

        System.out.print("Cargo do funcionário: ");
        String cargo = scanner.nextLine();

        funcionarioController.cadastrarFuncionario(nome, cargo);
        System.out.println(" Funcionário cadastrado com sucesso!");
    }

    private void agendarConsulta() {
        List<Cliente> clientes = clienteController.listarClientes();
        List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();

        if (clientes.isEmpty() || funcionarios.isEmpty()) {
            System.out.println(" É necessário ter pelo menos 1 cliente e 1 funcionário cadastrados.");
            return;
        }

        System.out.println("\n--- Selecionar Cliente ---");
        for (int i = 0; i < clientes.size(); i++)
            System.out.println((i + 1) + ". " + clientes.get(i).nome);
        System.out.print("Escolha o número do cliente: ");
        int clienteIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println("\n--- Selecionar Funcionário ---");
        for (int i = 0; i < funcionarios.size(); i++)
            System.out.println((i + 1) + ". " + funcionarios.get(i).nome);
        System.out.print("Escolha o número do funcionário: ");
        int funcIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Data da consulta (ex: 10/11/2025): ");
        String data = scanner.nextLine();

        System.out.print("Descrição da consulta: ");
        String descricao = scanner.nextLine();

        consultaController.agendarConsulta(
                clientes.get(clienteIndex),
                funcionarios.get(funcIndex),
                data,
                descricao);

        System.out.println("Consulta agendada com sucesso!");
    }

    private void listarConsultas() {
        consultaController.listarConsultas();
    }
}
