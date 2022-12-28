/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo2_jumanji;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jdfab
 */
public class FileManager {

    public void historico() { //imprime historico
        try {
            File ficheiro = new File("Historico.txt");
            Scanner reader = new Scanner(ficheiro);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado.");

        }
    }

    public void save(ArrayList<Especie> especies, ArrayList<Animal> animais, ArrayList<Mutacao> mutacoes, ArrayList<Carateristica> carateristicas, ArrayList<Instalacao> instalacoes, int ano , double saldo) {
        salvarEspecies(especies);
        salvarAnimais(animais);
        salvarMutacoes(mutacoes);        
        salvarCarateristicas(carateristicas);
        salvarInstalacoes(instalacoes);
        salvarAnoSaldo(ano, saldo);
    }

    public void load(Zoo zoo) {
        

        try {
            zoo.setCarateristicas(carregarCarateristicas());
            zoo.setEspecies(carregarEspecies(zoo.getCarateristicas(), zoo));
            zoo.setMutacoes(carregarMutacoes());
            zoo.setInstalacoes(carregarInstalacoes());
            zoo.setAnimais(carregarAnimais(zoo.getEspecies(), zoo.getInstalacoes(), zoo.getMutacoes()));
            
            for (Instalacao instalacao: zoo.getInstalacoes() ){
                for(Integer id : instalacao.getAnimaisId()){
                    for(Animal animal: zoo.getAnimais()){
                        if(animal.getId() == id){
                            instalacao.addAnimalInstalacao(animal);
                            break;
                        }
                    }
                    
                }
            }
            
            zoo.setAno(Integer. parseInt((carregarAnoSaldo().get(0))));
            zoo.setSaldo(Double. parseDouble((carregarAnoSaldo().get(1))));
            
        } catch (Exception e) {
            System.out.println("An error occurred while loading data from files.");
        }

    }

    public int atualizarId(ArrayList<Animal> animais) {
        // Encontra maior Id nos animais vivos
        int maiorId = 0;
        for (Animal animal : animais) {
            if (animal.getId() > maiorId) {
                maiorId = animal.getId();
            }
        }


        File ficheiro = new File("Obitos.txt");
        if (!ficheiro.exists()) {
            return maiorId + 1;
        }

        // bloco try-with-resources para fechar Scanner quando acabar
        try (Scanner reader = new Scanner(ficheiro)) {
            while (reader.hasNextLine()) {
                String dados = reader.nextLine();
                String[] linha = dados.split(" ");
                try {
                    int id = Integer.parseInt(linha[1]);
                    if (id > maiorId) {
                        maiorId = id;
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Ficheiro Obitos corrupto, Cancelado");
                    return -1;
                }
            }
        } catch (Exception e) {
            
            System.out.println("Erro");
            return -1;
        }

        return maiorId + 1; // Novo Id será sempre +1 do que o maior que já existe
    }

   
    public ArrayList<Especie> carregarEspecies(ArrayList<Carateristica> carateristicas, Zoo zoo) {
        String[] linha;
        Especie especie;
        ArrayList<Especie> especies = new ArrayList<>();

        
        File ficheiro = new File("Especies.txt");
        if (!ficheiro.exists()) {
            System.out.println("Ficheiro de especies não encontrado");
            return null;
        }

       
        try (Scanner reader = new Scanner(ficheiro)) {
            while (reader.hasNextLine()) {
                String dados = reader.nextLine();
                linha = dados.split(" ");
                try {
                    int atratividade = Integer.parseInt(linha[0]);
                    int raridade = Integer.parseInt(linha[2]);
                    int esperancaVida = Integer.parseInt(linha[3]);
                    int apetiteReprodutivo = Integer.parseInt(linha[4]);

                    especie = new Especie(atratividade, linha[1], raridade, esperancaVida, apetiteReprodutivo, zoo, true);
                    if (linha.length > 5) {

                        for (int i = 5; i < linha.length; i++) {

                            for (Carateristica carateristica : carateristicas) {
                                if (carateristica.getNome().equals(linha[i])) {
                                    especie.getCarateristicas().add(carateristica);
                                }
                            }
                        }

                    }

                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Ficheiro corrupto Carateristicas, Cancelado");
                    return null;
                }

                especies.add(especie);

            }
        } catch (Exception e) {
           
            System.out.println("Erro");
            return null;
        }

        return especies;
    } 

    
    public void salvarEspecies(ArrayList<Especie> especies) {
       
        File ficheiro = new File("Especies.txt");
        if (!ficheiro.exists()) {
            return;
        }

        
        try (FileWriter writer = new FileWriter("Especies.txt")) {
            for (Especie especie : especies) {
                writer.write(especie.getAtratividadeBase() + " ");
                writer.write(especie.getNome() + " ");
                writer.write(especie.getRaridade() + " ");
                writer.write(especie.getEsperancaVida() + " ");
                writer.write(especie.getApetiteReprodutivo() + " ");
                for (Carateristica carateristica : especie.getCarateristicas()) {
                    writer.write(carateristica.getNome() + " ");
                }
                writer.write("\n");
            }
            System.out.println("ESPECIES escrito com sucesso");
        } catch (IOException e) {
            System.out.println("Erro 001");
        }
    } 

   
    public ArrayList<Animal> carregarAnimais(ArrayList<Especie> especies, ArrayList<Instalacao> instalacoes, ArrayList<Mutacao> mutacoes) {
        String[] linha;
        Animal animal;
        Especie especieFinal = null;
        ArrayList<Animal> animais = new ArrayList<>();

        
        File ficheiro = new File("Animais.txt");
        if (!ficheiro.exists()) {
            System.out.println("Ficheiro de animais não encontrado");
            return null;
        }

       
        try (Scanner reader = new Scanner(ficheiro)) {
            while (reader.hasNextLine()) {
                String dados = reader.nextLine();
                linha = dados.split(" ");

                try {
                    int id = Integer.parseInt(linha[0]);
                    int idade = Integer.parseInt(linha[2]);
                    int instalacaoId = Integer.parseInt(linha[4]);

                    for (Especie especie : especies) {
                        if (especie.getNome().equals(linha[3])) {
                            especieFinal = especie;
                        }
                    }
                    animal = new Animal(id, linha[1], idade, especieFinal);
                    for (Instalacao instalacao : instalacoes) {
                        if (instalacao.getId() == instalacaoId) {
                            animal.setInstalacao(instalacao);
                            instalacao.addAnimalInstalacao(animal);
                        }
                    }

                    if (linha.length > 5) {

                        for (int i = 5; i < linha.length; i++) {
                            for (Mutacao mutacao : mutacoes) {
                                if (mutacao.getNome().toLowerCase().equals(linha[i].toLowerCase())) {
                                    animal.getMutacoesLista().add(mutacao);
                                }
                            }
                        }
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Ficheiro de animais corrupto, Cancelado");
                    return null;
                }

                animais.add(animal);

            }
        } catch (Exception e) {
          
            System.out.println("Erro");
            return null;
        }

        return animais;
    }

    
    public void salvarAnimais(ArrayList<Animal> animais) {
        try {
            File file = new File("Animais.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            try (FileWriter writer = new FileWriter(file)) {
                for (Animal animal : animais) {
                    writer.write(animal.getId() + " ");
                    writer.write(animal.getNome() + " ");
                    writer.write(animal.getIdade() + " ");
                    writer.write(animal.getEspecieString() + " ");
                    if (animal.getInstalacao() != null) {
                        writer.write(animal.getInstalacao().getId() + " ");
                    } else {
                        writer.write("-1 ");
                    }

                    for (Mutacao mutacao : animal.getMutacoesLista()) {
                        writer.write(mutacao.getNome() + " ");
                    }
                    writer.write("\n");
                }
                System.out.println("ANIMAIS escrito com sucesso");
            }
        } catch (IOException e) {
            System.out.println("Erro 001");
        }
    } 

   
    public ArrayList<Carateristica> carregarCarateristicas() {
        String[] linha;
        Carateristica carateristica;
        ArrayList<Carateristica> carateristicas = new ArrayList<>();

        
        File ficheiro = new File("Carateristicas.txt");
        if (!ficheiro.exists()) {
            System.out.println("Ficheiro de características não encontrado");
            return null;
        }

       
        try (Scanner reader = new Scanner(ficheiro)) {
            while (reader.hasNextLine()) {
                String dados = reader.nextLine();
                linha = dados.split(" ");
                try {
                    double custos = Double.parseDouble(linha[1]);
                    carateristica = new Carateristica(linha[0], custos, linha[2]);
                    carateristicas.add(carateristica);

                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Ficheiro de características corrupto, Cancelado");
                    return null;
                }
            }
        } catch (Exception e) {
            
            System.out.println("Erro");
            return null;
        }

        return carateristicas;
    } 

    public void salvarCarateristicas(ArrayList<Carateristica> carateristicas) {
        try {
            File file = new File("Carateristicas.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            try (FileWriter writer = new FileWriter(file)) {
                for (Carateristica carateristica : carateristicas) {
                    writer.write(carateristica.getNome() + " ");
                    writer.write(carateristica.getCustos() + " ");
                    writer.write(carateristica.getAbilidade() + " ");
                    writer.write("\n");
                }
                System.out.println("Carateristicas escrito com sucesso");
            }
        } catch (IOException e) {
            System.out.println("Erro 001");
        }
    } 

   
    public ArrayList<Mutacao> carregarMutacoes() {
        String[] linha;
        Mutacao mutacao;
        ArrayList<Mutacao> mutacoes = new ArrayList<>();

        // Check if the file exists before reading from it
        File ficheiro = new File("Mutacoes.txt");
        if (!ficheiro.exists()) {
            System.out.println("Ficheiro de mutações não encontrado");
            return null;
        }

        // Use a try-with-resources block to automatically close the Scanner object
        try (Scanner reader = new Scanner(ficheiro)) {
            while (reader.hasNextLine()) {
                String dados = reader.nextLine();
                linha = dados.split(" ");
                try {
                    int modAtract = Integer.parseInt(linha[1]);
                    mutacao = new Mutacao(linha[0], modAtract);
                    mutacoes.add(mutacao);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Ficheiro de mutações corrupto, Cancelado");
                    return null;
                }
            }
        } catch (Exception e) {
            // Catch any other exceptions that may be thrown
            System.out.println("An error occurred.");
            return null;
        }

        return mutacoes;
    } 

   
    public void salvarMutacoes(ArrayList<Mutacao> mutacoes) {
        try {
            File file = new File("Mutacoes.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            
            try (FileWriter writer = new FileWriter(file)) {
                for (Mutacao mutacao : mutacoes) {
                    writer.write(mutacao.getNome() + " ");
                    writer.write(mutacao.getModAtract() + " ");
                    writer.write("\n");
                }
                System.out.println("Mutacoes gravadas com sucesso");
            } catch (IOException e) {
                System.out.println("Erro ao escrever ficheiro");
            }
        } catch (IOException e) {
            System.out.println("Erro 001");
        }
    } 

   
    public ArrayList<Instalacao> carregarInstalacoes() {
        String[] linha;
        Instalacao instalacao;
        List<Integer> animaisId = new ArrayList<>();
        ArrayList<Instalacao> instalacoes = new ArrayList<>();

        
        File ficheiro = new File("Instalacoes.txt");
        if (!ficheiro.exists()) {
            System.out.println("Ficheiro de instalações não encontrado");
            return null;
        }

      
        try (Scanner reader = new Scanner(ficheiro)) {
            while (reader.hasNextLine()) {
                String dados = reader.nextLine();
                linha = dados.split(" ");
                try {
                    int id = Integer.parseInt(linha[0]);
                    int lotacao = Integer.parseInt(linha[1]);

                    if (linha.length > 2) {
                        for (int i = 2; i < linha.length; i++) {
                            animaisId.add(Integer.parseInt(linha[i]));
                        }
                    }
                    instalacao = new Instalacao(id, lotacao, animaisId);
                    instalacoes.add(instalacao);

                    System.out.println("Instalações ok");
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Ficheiro de instalações corrupto, Cancelado");
                    return null;
                }
            }
        } catch (Exception e) {
            
            System.out.println("Erro");
            return null;
        }

        return instalacoes;
    } 

    
    public void salvarInstalacoes(ArrayList<Instalacao> instalacoes) {
        try {
            File file = new File("Instalacoes.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            
            try (FileWriter writer = new FileWriter(file)) {
                for (Instalacao instalacao : instalacoes) {
                    writer.write(instalacao.getId() + " ");
                    writer.write(instalacao.getLotacao() + " ");

                    for (Animal animal : instalacao.getAnimais()) {
                        writer.write(animal.getId() + " ");

                    }
                    writer.write("\n");
                }
                System.out.println("Successfully wrote INSTALAÇÕES to the file.");
            } catch (IOException e) {
                System.out.println("Erro ao escrever ficheiro");
            }
        } catch (IOException e) {
            System.out.println("Erro 001");
        }
    } 

    
    
    
    public void salvarAnoSaldo(int ano, double saldo) {
        try {
            File file = new File("AnoSaldo.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
          
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(Integer.toString(ano));
                writer.write("\n");
                writer.write(Double.toString(saldo));
                
                System.out.println("Successfully wrote AnoSaldo to the file.");
            } catch (IOException e) {
                System.out.println("Erro ao escrever ficheiro");
            }
        } catch (IOException e) {
            System.out.println("Erro 001");
        }
    }
    
    public ArrayList<String> carregarAnoSaldo(){
        
        ArrayList<String> lista = new ArrayList<>();
        
        File ficheiro = new File("AnoSaldo.txt");
        if (!ficheiro.exists()) {
            System.out.println("Ficheiro de instalações não encontrado");
            return null;
        }
 // Use a try-with-resources block to automatically close the Scanner object
        try (Scanner reader = new Scanner(ficheiro)) {
            
            while (reader.hasNextLine()) {
                String dados = reader.nextLine();
                lista.add(dados);         
                
                
            }
            System.out.println("Ano e Saldo ok");
        } catch (Exception e) {
            
            System.out.println("Erro");
            return null;
        }

        return lista;
        
    }
    
    
    
    public void guardaRegistoHistorico(String tipo, ArrayList<String> dados, int ano) {
        
        try (FileWriter fw = new FileWriter("Historico.txt", true)) {
            fw.write("\n" + tipo + " Ano: " + ano + " - ");
            for (String dado : dados) {
                fw.write(dado + " ");
            }
            
        } catch (IOException e) {
            System.out.println("Erro ao escrever ficheiro");
        }
    }

   
    public String getRandomNameFromFile() { //Encontra nome ao calhas a partir do ficheiro nomes
        int numNomes = 0;
        String[] nome = new String[10];
        String linha = "";
        Scanner reader;
        int rand;
        try {
            File ficheiro = new File("Nomes.txt");
            reader = new Scanner(ficheiro);
            while (reader.hasNextLine()) { //conta os nomes na lista
                reader.nextLine();
                numNomes++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado");
        }
        rand = (int) (Math.random() * numNomes); //random entre 0 e (numero de nomes no ficheiro - 1)
        try {
            File ficheiro = new File("Nomes.txt");
            reader = new Scanner(ficheiro);
            for (int i = 0; i < rand; i++) {
                linha = reader.nextLine();
            }
            nome = linha.split(" ", 2)[0].split(",", 2); //apenas o primeiro nome interessa
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado");
        }
        return nome[0];
    }

    public void listarObituarios() {
        String[] linha;
        try {
            File ficheiro = new File("Obitos.txt");
            Scanner reader = new Scanner(ficheiro);
            while (reader.hasNextLine()) {
                String dados = reader.nextLine();
                linha = dados.split(" ");
                try {
                    System.out.println("Ano: " + linha[0] + " Id: " + linha[1] + " Nome: " + linha[2] + " Idade: " + linha[3] + " Especie: " + linha[4]);
                    if (linha.length > 5) {
                        for (int i = 5; i < linha.length; i++) {
                            System.out.println(" " + linha[i]);
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                   
                    System.out.println("Ficheiro Obtitos corrupto, linha ignorada");
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro Obitos não encontrado");
        } catch (Exception e) {
         
            System.out.println("Ocorreu um erro ao ler o ficheiro Obitos");

        }
    } 

    
}
