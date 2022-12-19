/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo2_jumanji;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jdfab
 */
public class Especie {
    protected int atratividadeBase;
    protected int raridade;
    protected int esperacaVida = 10;
    protected List<Carateristica> carateristicas = new ArrayList<>(); 
    public Especie(){
        
    }
    public int getEsperancaVida(){
        return esperacaVida;
    }
    public String getEspecieString(){
        return this.getClass().getSimpleName();
    }
}
