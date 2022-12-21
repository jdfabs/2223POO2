/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo2_jumanji;

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
        return this.especie.getEspecieString();
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
    
    public List<Mutacao> getMutacoesLista(){
        return mutacoes;
    }


}

