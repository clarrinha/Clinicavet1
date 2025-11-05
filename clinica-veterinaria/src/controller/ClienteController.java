package controller;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    public static class Cliente {
        public String nome;
        public String endereco;
        public String telefone;

        public Cliente(String nome, String endereco, String telefone) {
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
        }
    }

    private static List<Cliente> clientes = new ArrayList<>();

    public ClienteController() {
        System.out.println("Modo offline: gerenciamento de clientes em memória.");
    }

    public void cadastrarCliente(String nome, String endereco, String telefone) {
        clientes.add(new Cliente(nome, endereco, telefone));
        System.out.println(" Cliente cadastrado com sucesso!");
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public void exibirClientes() {
        if (clientes.isEmpty()) {
            System.out.println(" Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("\n--- Lista de Clientes ---");
        int i = 1;
        for (Cliente c : clientes) {
            System.out.println(i++ + ". Nome: " + c.nome + " | Endereço: " + c.endereco + " | Telefone: " + c.telefone);
        }
    }
}
