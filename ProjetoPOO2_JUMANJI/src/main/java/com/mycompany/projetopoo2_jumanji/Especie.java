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
    protected int atratividadeBase;
    protected String nome;
    protected int raridade;
    protected int esperacaVida = 10;
    protected int apetiteReprodutivo = 10;
    protected List<Carateristica> carateristicas = new ArrayList<>(); 
    protected Zoo zoo;
    
    
    public Especie(int atratividade, String nome, int raridade, int esperancaVida, Zoo zoo) {
        this.atratividadeBase = atratividade;
        this.nome = nome;
        this.raridade = raridade;
        this.esperacaVida = esperancaVida;
        this.zoo = zoo;
        setupCarateristicas();
    }
    public Especie(int atratividade, String nome, int raridade, int esperancaVida, Zoo zoo, boolean semSetup) {
        this.atratividadeBase = atratividade;
        this.nome = nome;
        this.raridade = raridade;
        this.esperacaVida = esperancaVida;
        this.zoo = zoo;
        
    }
    
    public void setupCarateristicas() {
        //Imprime carateristicas disponieis        
        Scanner input = new Scanner(System.in);
        boolean escolhido = false;
        int opcao =-1;
        char opcaoChar;
        System.out.println("Carateristicas existentes:");
        for (Carateristica carateristica : zoo.getCarateristicas()) {
            System.out.println("1 - " + carateristica.getNome());
        }
        System.out.println("Introduza a carateristica que quer adicionar ou [ZERO] para sair:");
        while (!escolhido) {
            try {
                opcao = input.nextInt() - 1;
            } catch (Exception e) {
               System.out.println("Input invalido!");
            }
            if (opcao == -1){
                return;
            }
            else if(opcao <= zoo.getCarateristicas().size() && opcao >= 0){
                escolhido = true;
            }
            else if (opcao >= zoo.getCarateristicas().size()+1){
                System.out.println("Indice invalido");
            }
        }
        escolhido = false;
        carateristicas.add(zoo.getCarateristicas().get(opcao));
        System.out.println("Carateristica adicionada. Adicionar mais carateristicas? [y/N]");
        while (!escolhido) {
            opcaoChar = input.next().charAt(0);
            if (opcaoChar == 'y'){
                setupCarateristicas();
                
            }
            return;
        }
    }
    
    public void adicionaCarateristica(Carateristica carateristica){
        carateristicas.add(carateristica);
    }
    
    public int getAtratividadeBase(){
        return atratividadeBase;
    }
    public String getNome(){
        return nome;
    }    
    public int getRaridade(){
        return raridade;
    }
    public int getEsperancaVida(){
        return esperacaVida;
    }
    public List<Carateristica> getCarateristicas(){
        return carateristicas;
    }
    public void adicionarCarateristica(Carateristica carateristica){
        this.carateristicas.add(carateristica);
        
    
    }
    
    
    
    public String getEspecieString(){
        return this.getClass().getSimpleName();
    }
    
    public void AumentaAtratividade(){
        atratividadeBase += 5;
    }
}
