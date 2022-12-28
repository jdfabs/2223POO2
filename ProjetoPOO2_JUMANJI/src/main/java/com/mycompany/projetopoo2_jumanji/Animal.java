/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo2_jumanji;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vigab
 */
public class Animal {
    private int id;
    private String nome;
    private int idade;
    private Especie especie ;
    private Instalacao instalacao;  
    private List<Mutacao> mutacoes = new ArrayList<>();
    

   public Animal(int id, String nome, int idade, Especie especie) {
       this.id = id;
       this.nome = nome;
       this.idade = idade;
       this.especie = especie;
   }
   
    public int getId() {
        return id;
    }

    public String getIdString() {
        Integer idInt = id;
        return idInt.toString();
    }

    public String getIdadeString() {
        Integer idadeInt = idade;
        return idadeInt.toString();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Especie getEspecie() {
        return especie;
    }

    public String getEspecieString() {
        return this.especie.getNome();
    }

    public Instalacao getInstalacao() {
        return instalacao;
    }
     public List<Mutacao> getMutacoesLista() {
        return mutacoes;
    }

    public void setInstalacao(Instalacao instalacao) {
        this.instalacao = instalacao;
    }

    public void setInstalacao() {
        this.instalacao = null;
    }

    

   

    public void addMutacao(Mutacao mutacao) {
        this.mutacoes.add(mutacao);
    }

    public void incrementaIdade() {
        idade++;
    }

    public double calculaPreco() {
        double preco = 50;
        preco *= especie.getAtratividadeBase();
        preco *= especie.getRaridade();
        preco *= 2 - idade / Double.valueOf(especie.getEsperancaVida());
        

        return preco;
    }

    public boolean checkVida() {

        int esperancaVida = this.getEspecie().getEsperancaVida();
        double racioIdadeEsperancaVida = (double) (idade / esperancaVida);
        //função matematica para ver se morre (chance media de morrer com idade 0, baixa se o animal estiver no "auge" da vida e muito alta se idade passar da esperança da vida (se animal tiver o dobro da esperança da vida chance é 100% ))
        double probMorrer = (Math.pow(((racioIdadeEsperancaVida - (0.5)) * (0.7)), 2) + .05); 
        double random = Math.random();
        return probMorrer > random;
    }

    public boolean checkNascimento() {
        return Math.random() <= Double.valueOf(especie.getApetiteReprodutivo()) / 10; //por cada 1 de apetite reprodutivo na especie = 10% chance de ter bebé
    }

    public void morre(Zoo zoo) {
        adicionarObito(zoo);
        if (instalacao != null) {
            this.getInstalacao().getAnimais().remove(this);
        }
    }

    public void adicionarObito(Zoo zoo) {
        try {
            FileWriter fw = new FileWriter("Obitos.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            //fw.write("\n");
            fw.write(zoo.getAno() + " ");
            fw.write(this.getId() + " ");
            fw.write(this.getNome() + " ");
            fw.write(this.getIdade() + " ");
            fw.write(this.getEspecie().getNome() + " ");
            if (!mutacoes.isEmpty()) {
                fw.write(" Mutações: ");
                for (Mutacao mutacao : mutacoes) {
                    fw.write(mutacao.getNome() + " ");
                }
            }

            
            pw.flush();
            pw.close();
            bw.close();
            fw.close();
        } catch (Exception o) {
            System.out.println("Erro a adicionar animal aos obitos");
        }

        ArrayList<String> dados = new ArrayList<>();
        dados.add("Nome:");
        dados.add(this.getNome());
        dados.add("Id:");
        dados.add(this.getIdString());
        dados.add("Idade:");
        dados.add(this.getIdadeString());
        dados.add("Especie:");
        dados.add(this.getEspecie().getNome());
        if (!mutacoes.isEmpty()) {
            dados.add("Mutacoes:");
            for (Mutacao mutacao : mutacoes) {
                dados.add(mutacao.getNome());
            }
        }

        zoo.getFileManager().guardaRegistoHistorico("MORTE", dados, zoo.getAno());

    }

    public double calculaAtratividade() {
        double atratividade = especie.getAtratividadeBase();
        atratividade *= 1 - ((idade / especie.getEsperancaVida()) * 0.2);
        for (Mutacao mutacao : mutacoes) {
            atratividade *= mutacao.getModAtract();
        }

        return atratividade;
    }

}
