package controller;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {

    public static class Funcionario {
        public String nome;
        public String cargo;

        public Funcionario(String nome, String cargo) {
            this.nome = nome;
            this.cargo = cargo;
        }
    }

    private static List<Funcionario> funcionarios = new ArrayList<>();

    public FuncionarioController() {
        System.out.println("Modo offline: gerenciamento de funcionários em memória.");
    }

    public void cadastrarFuncionario(String nome, String cargo) {
        funcionarios.add(new Funcionario(nome, cargo));
        System.out.println(" Funcionário cadastrado com sucesso!");
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    public void exibirFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println(" Nenhum funcionário cadastrado.");
            return;
        }
        System.out.println("\n--- Lista de Funcionários ---");
        int i = 1;
        for (Funcionario f : funcionarios) {
            System.out.println(i++ + ". Nome: " + f.nome + " | Cargo: " + f.cargo);
        }
    }
}
