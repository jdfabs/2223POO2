/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo2_jumanji;

/**
 *
 * @author jdfab
 */
public class Carateristica {
    private final String nome;
    private final double custos;
    private final String abilidade;
    
    public Carateristica(String nome, double custos,String abilidade ){
     this.nome = nome;   
     this.custos = custos;
     this.abilidade = abilidade;
    }
    
    public String getNome(){
        return nome;
    }
    public double getCustos(){
        return custos;
    }
    public String getAbilidade(){
        return abilidade;
    }
}
