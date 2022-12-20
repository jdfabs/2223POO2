package com.mycompany.projetopoo2_jumanji;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jdfab
 */
public class Instalacao {
    
    private int lotacao = 0;
    private double custosRacao = 0;
    private double custosCuidadores = 0;
    private double custoManutencao = 100;
    private Animal animal;
    
    
    public Instalacao(int lotacao){
        this.lotacao = lotacao;
    }
    public int getLotacao(){
        return lotacao;
    }
    public Animal getAnimal(){
        return animal;
    }
    public void setAnimal(Animal animal){
        this.animal = animal;
    }
    public void setAnimal(){
        this.animal = null;
    }
}
