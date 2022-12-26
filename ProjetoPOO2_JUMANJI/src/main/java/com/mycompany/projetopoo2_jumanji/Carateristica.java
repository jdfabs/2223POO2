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
    private final String habilidade;
    
    public Carateristica(String nome, String habilidade ){
     this.nome = nome;   
     
     this.habilidade = habilidade;
    }
    
    public String getNome(){
        return nome;
    }
    public String getAbilidade(){
        return habilidade;
    }
}
