/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo2_jumanji;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jdfab
 */
public class Especie {

    private String nome;
    private int atratividadeBase;    
    private int raridade;
    private int esperacaVida;
    private int apetiteReprodutivo = 10;
    private List<Carateristica> carateristicas = new ArrayList<>();
    private Zoo zoo;

    public Especie(int atratividade, String nome, int raridade, int esperancaVida, int apetiteReprodutivo, Zoo zoo) {
        this.atratividadeBase = atratividade;
        this.nome = nome;
        this.raridade = raridade;
        this.esperacaVida = esperancaVida;
        this.zoo = zoo;
        this.apetiteReprodutivo = apetiteReprodutivo;
        setupCarateristicas();
    }

    public Especie(int atratividade, String nome, int raridade, int esperancaVida, int apetiteReprodutivo, Zoo zoo, boolean semSetup) {
        this.atratividadeBase = atratividade;
        this.nome = nome;
        this.raridade = raridade;
        this.esperacaVida = esperancaVida;
        this.apetiteReprodutivo = apetiteReprodutivo;
        this.zoo = zoo;

    }

    public int getApetiteReprodutivo() {
        return apetiteReprodutivo;
    }

    public int getAtratividadeBase() {
        return atratividadeBase;
    }

    public String getNome() {
        return nome;
    }

    public int getRaridade() {
        return raridade;
    }

    public int getEsperancaVida() {
        return esperacaVida;
    }

    public List<Carateristica> getCarateristicas() {
        return carateristicas;
    }

    public String getEspecieString() {
        return this.getClass().getSimpleName();
    }

    public void adicionarCarateristica(Carateristica carateristica) {
        this.carateristicas.add(carateristica);

    }

    public void aumentaAtratividade() {
        if (atratividadeBase < 10) {
            atratividadeBase += 1;
            System.out.println("A atratividade dos " + nome + " aumentou para " + atratividadeBase);
        }
        else{
            System.out.println("A atratividade deste animal ("+ nome +") já está no máximo");
        }
    }

    public final void setupCarateristicas() {
           
        Scanner input = new Scanner(System.in);
        boolean escolhido = false;
        int opcao = -1;
        char opcaoChar;
        System.out.println("Carateristicas existentes:");
        for (Carateristica carateristica : zoo.getCarateristicas()) {//Imprime carateristicas disponieis     
            System.out.println("1 - " + carateristica.getNome());
        }
        System.out.println("Introduza a carateristica que quer adicionar ou [ZERO] para sair:");
        while (!escolhido) {
            try {
                opcao = input.nextInt() - 1;
            } catch (Exception e) {
                System.out.println("Input invalido!");
            }
            if (opcao == -1) {
                return;
            } else if (opcao <= zoo.getCarateristicas().size() && opcao >= 0) {
                escolhido = true;
            } else if (opcao >= zoo.getCarateristicas().size() + 1) {
                System.out.println("Indice invalido");
            }
        }
        escolhido = false;
        carateristicas.add(zoo.getCarateristicas().get(opcao)); //adiciona carateristica escolhida ao animal
        System.out.println("Carateristica adicionada. Adicionar mais carateristicas? [y/N]"); 
        while (!escolhido) {
            opcaoChar = input.next().charAt(0);
            if (opcaoChar == 'y') {
                setupCarateristicas();
            }
            return;
        }
    }

}
