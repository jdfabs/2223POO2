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
public abstract class Animal {
    protected int id;
    protected String nome;
    protected int idade;
    protected Especie especie ;
    protected List<Mutacao> mutacoes = new ArrayList<>();
    protected Instalacao instalacao;  
    

   public Animal() {}
    
    public String getNome(){
        return nome;
    }


}

