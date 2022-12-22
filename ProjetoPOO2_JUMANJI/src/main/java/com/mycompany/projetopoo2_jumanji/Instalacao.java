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
    private int id;
    private int lotacao = 0;
    private double custosRacao = 0;
    private double custosCuidadores = 0;
    private double custoManutencao = 100;
    private Animal animal;
    private int animalId;
    
    
    public Instalacao(int id, int lotacao, int animalId){
        this.id=id;
        this.lotacao = lotacao;
        this.animalId = animalId;
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
    public void setAnimal(Animal animal){
        this.animal = animal;
    }
    public void setAnimal(){
        this.animal = null;
    }
   
}
