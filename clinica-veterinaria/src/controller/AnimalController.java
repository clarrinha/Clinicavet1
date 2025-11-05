package controller;

import java.util.ArrayList;
import java.util.List;

public class AnimalController {

    public static class Animal {
        public String nome;
        public String especie;
        public String dono;

        public Animal(String nome, String especie, String dono) {
            this.nome = nome;
            this.especie = especie;
            this.dono = dono;
        }
    }

    private List<Animal> animais = new ArrayList<>();

    public AnimalController() {
        System.out.println("Modo offline: gerenciamento de animais em memória.");
    }

    public void cadastrarAnimal(String nome, String especie, String dono) {
        animais.add(new Animal(nome, especie, dono));
        System.out.println(" Animal cadastrado com sucesso!");
    }

    public void listarAnimais() {
        if (animais.isEmpty()) {
            System.out.println(" Nenhum animal cadastrado.");
            return;
        }
        System.out.println("\n--- Lista de Animais ---");
        int i = 1;
        for (Animal a : animais) {
            System.out.println(i++ + ". Nome: " + a.nome + " | Espécie: " + a.especie + " | Dono: " + a.dono);
        }
    }

    public List<Animal> getAnimais() {
        return animais;
    }
}
