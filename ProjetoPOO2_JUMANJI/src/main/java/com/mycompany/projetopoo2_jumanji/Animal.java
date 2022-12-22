/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo2_jumanji;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vigab
 */
public class Animal {
    protected int id;
    protected String nome;
    protected int idade;
    protected Especie especie ;
    protected Instalacao instalacao;  
    protected List<Mutacao> mutacoes = new ArrayList<>();
    
   
    
    

   public Animal(int id, String nome, int idade, Especie especie) {
       this.id = id;
       this.nome = nome;
       this.idade = idade;
       this.especie = especie;
   }
   
   
     public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public int getIdade(){
        return idade;
    }
   
    public Especie getEspecie(){
        return especie;
    }

    public String getEspecieString(){
        return this.especie.getNome();
    }
    public Instalacao getInstalacao(){
        return instalacao;
    }

    public void setInstalacao(Instalacao instalacao){
        this.instalacao = instalacao;
    }
    public void setInstalacao(){
        this.instalacao = null;
    }
    public void addMutacao(Mutacao mutacao){
        this.mutacoes.add(mutacao);
    }
    
    public List<Mutacao> getMutacoesLista(){
        return mutacoes;
    }
    public void incrementaIdade(){
        idade++;
    }
    
    public double calculaPreco(){
        double preco = 50;
        preco *= especie.getAtratividadeBase();
        preco *= especie.getRaridade();
        preco *= especie.getEsperancaVida()-idade;
        preco *= especie.getAtratividadeBase();
        
        return preco;
    }
    
    public boolean CheckVida(){
        
        int esperancaVida = this.getEspecie().getEsperancaVida();
        double racioIdadeEsperancaVida = (double)(idade/esperancaVida);
        double probMorrer = (Math.pow(((racioIdadeEsperancaVida-(0.5))*(0.7)),2)+.05);
        double random = Math.random();            
        return probMorrer > random;        
    }
    
    public void AdicionarObito(Animal animal) {
        try {
            FileWriter fw = new FileWriter("Obitos.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            fw.write(animal.getId() + " ");
            fw.write(animal.getNome() + " ");
            fw.write(animal.getIdade() + " ");
            fw.write(animal.getEspecie().getNome() + " ");
            if (!animal.getMutacoesLista().isEmpty()) {
                for (Mutacao mutacao : animal.getMutacoesLista()) {
                    fw.write( animal.getId() + " ");
                }
            }
            

            System.out.println("Animal adicionado aos obitos");
            pw.flush();
            pw.close();
            bw.close();
            fw.close();
        } catch(Exception o) {
            System.out.println("Erro a adicionar animal aos obitos");
        }

    }
}

