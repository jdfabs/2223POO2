package com.mycompany.projetopoo2_jumanji;

import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jdfab
 */
public class Instalacao {
    private int id;
    private int lotacao = 0;
    private double custoRacao = 50;
    private double custoCuidadores = 25;
    private double custoManutencao = 100;
    private List<Animal> animais = new ArrayList<>();
    private List<Integer> animalId = new ArrayList<>() ;
    
    
    public Instalacao(int id, int lotacao, int animalId){
        this.id=id;
        this.lotacao = lotacao;
        for(int i = 0; i < lotacao; i++){
            animalId.add( new Integer(-1);
        }
    }
    public int getId(){
        return id;
    }
     public String getIdString(){
         Integer idInt = id;
         return idInt.toString();
     }
    public int getAnimalId(){
        return animalId;
    }
    public int getLotacao(){
        return lotacao;
    }
    public int getAnimalID(){
        return animalId;
    }
    public void setAnimalID(int id){
        animalId = id;
    }
    
     public String getLotacaoString(){
         Integer lotacaoInt = lotacao;
         return lotacaoInt.toString();
     }
    public Animal getAnimal(){
        return animal;
    }
    public double getCustoRacao(){
        return custoRacao;
    }
    public double getCustoCuidadores(){
        return custoCuidadores;
    }
    public double getCustoManutencao(){
        return custoManutencao;
    }
    public void setAnimal(Animal animal){
        this.animal = animal;
    }
    public void setAnimal(){
        this.animal = null;
    }
   
}
