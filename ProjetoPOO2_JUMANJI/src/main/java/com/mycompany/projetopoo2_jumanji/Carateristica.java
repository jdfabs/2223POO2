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

    
    private  String nome;
    private  double custos;
    private  String habilidade;

    
     public Carateristica(String nome, double custos,String habilidade ){
     this.nome = nome;   
     
     this.habilidade = habilidade;
    }
    
    public String getNome(){
        return nome;
    }
    public String getAbilidade(){
        return habilidade;
    }
    public double getCustos(){
        return custos;
        
    }
}
