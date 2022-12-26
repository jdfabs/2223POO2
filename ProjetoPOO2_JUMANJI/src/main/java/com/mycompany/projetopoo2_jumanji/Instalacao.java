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
    private final int id;
    private int lotacao = 0;
    private final double custoRacao = 50;
    private final double custoCuidadores = 25;
    private final double custoManutencao = 100;
    private final List<Animal> animaisInstalacao = new ArrayList<>();
    private final List<Integer> animaisId = new ArrayList<>();

    public Instalacao(int id, int lotacao){
        this.id=id;
        this.lotacao = lotacao;
    }
    
    
    public Instalacao(int id, int lotacao, List<Integer> animalIds){
        this.id = id;
        this.lotacao = lotacao;
        for(Integer idInt :animalIds){
            animaisId.add(idInt);
        }
    }
    public int getId(){
        return id;
    }
     public String getIdString(){
         Integer idInt = id;
         return idInt.toString();
     }
    
    public int getLotacao(){
        return lotacao;
    }

    public List<Animal> getAnimais(){
        return animaisInstalacao;
    }
 

    
     public String getLotacaoString(){
         Integer lotacaoInt = lotacao;
         return lotacaoInt.toString();
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
    public List<Integer> getAnimaisId(){
        return animaisId;
    }

      public void addAnimalInstalacao(Animal animal){
        if(this.lotacao < animaisInstalacao.size()){
            this.animaisInstalacao.add(animal);
        }
        else{
            while(animaisInstalacao.size() == this.lotacao){
                for(Animal animalInstalacao: animaisInstalacao)
                if(Math.random()*100+1 <50){
                    System.out.println("Animal removido: " + animalInstalacao.getNome());
                    animaisInstalacao.remove(animalInstalacao);
                }
            }
            animaisInstalacao.add(animal);
            
        }
    }
}
