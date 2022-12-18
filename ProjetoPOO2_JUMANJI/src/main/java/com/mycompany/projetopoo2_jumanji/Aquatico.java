/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo2_jumanji;
import com.mycompany.projetopoo2_jumanji.Animal;
import com.mycompany.projetopoo2_jumanji.Especie;
import com.mycompany.projetopoo2_jumanji.Instalacao;
import com.mycompany.projetopoo2_jumanji.Mutacao;
import java.util.ArrayList;



/**
 *
 * @author jdfab
 */
public class Aquatico extends Animal{
    public Aquatico(int id, String nome, int idade,  Especie especie, ArrayList<Mutacao> mutacoes, Instalacao instalacao){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.especie = especie;
        this.mutacoes = mutacoes;
        this.instalacao = instalacao;
    }

}
