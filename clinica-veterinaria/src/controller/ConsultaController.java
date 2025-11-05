package controller;

import controller.ClienteController.Cliente;
import controller.FuncionarioController.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class ConsultaController {

    public static class Consulta {
        public Cliente cliente;
        public Funcionario funcionario;
        public String data;
        public String descricao;

        public Consulta(Cliente cliente, Funcionario funcionario, String data, String descricao) {
            this.cliente = cliente;
            this.funcionario = funcionario;
            this.data = data;
            this.descricao = descricao;
        }
    }

    private List<Consulta> consultas = new ArrayList<>();

    public void agendarConsulta(Cliente cliente, Funcionario funcionario, String data, String descricao) {
        consultas.add(new Consulta(cliente, funcionario, data, descricao));
        System.out.println(" Consulta agendada com sucesso!");
    }

    public void listarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println(" Nenhuma consulta agendada.");
            return;
        }
        System.out.println("\n--- Consultas Agendadas ---");
        int i = 1;
        for (Consulta c : consultas) {
            System.out.println(i++ + ". Cliente: " + c.cliente.nome +
                               " | Veterinário: " + c.funcionario.nome +
                               " | Data: " + c.data +
                               " | Descrição: " + c.descricao);
        }
    }
}
