/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo2_jumanji;

import java.util.*;
import java.io.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import static java.lang.Integer.compare;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Objects;

/**
 *
 * @author vigab
 */
public class Zoo {

    private final Scanner scan = new Scanner(System.in);
  
    private final List<Animal> animais = new ArrayList<>();
    private final List<Instalacao> instalacoes = new ArrayList();
    private final List<Especie> especies = new ArrayList();
    private final List<Carateristica> carateristicas = new ArrayList();
    private final List<Mutacao> mutacoes = new ArrayList();
    private int ano = 2000;
    private double saldo = 100000;
    private double saldoUsadoAnimais = 0;
    private double saldoUsadoInstalacoes = 0;
    private int animalId = 0;

    public static void main(String[] args) {

        //criação do Zoo
        Zoo newZoo = new Zoo();

        newZoo.startMenu(); //chamando a função para iniciar a aplicação  

    }

    public void startMenu() {

        int opcao ;
        boolean sair = false;
        load(); //Carregar Zoo a partir dos ficheiros
        while (!sair) {
            opcao = 0;
            System.out.println("==================================================");
            System.out.println("     Bem vindo ao Zoo da UMa Ano: " + ano + "   Saldo: " + saldo + ". ");
            System.out.println("==================================================");
            System.out.println("1.Adquirir animal aleatório                       ");
            System.out.println("2.Adquirir animal com caraterística genética      ");
            System.out.println("3.Construir instalação                            ");
            System.out.println("4.Colocar animal em instalação                    ");
            System.out.println("5.Calendário chinês                               ");
            System.out.println("6.Listar animais                                  ");
            System.out.println("7.Listar animais com dada caraterística genética  ");
            System.out.println("8.Listar animais com dada mutação                 ");
            System.out.println("9.Listar instalações                              ");
            System.out.println("10.Retrato de família animal                      ");
            System.out.println("11.Obituário                                      ");
            System.out.println("12.Histórico                                      ");
            System.out.println("13.Período contabilístico                         ");
            System.out.println("14.Jumanji                                        ");
            System.out.println("15.Sair da aplicação                              ");
            System.out.println("                                                  ");
            System.out.println("O que deseja fazer:                               ");
            try {
                opcao = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input!");
                scan.nextLine();
            } //switch com diferentes metodos disponiveis atravez do menu
            switch (opcao) {
                case 1 -> {
                    adquirirAnimal();
                    break;
                }
                case 2 -> {
                    adquirirAnimalComCarateristica();
                    break;
                }
                case 3 -> {
                    construirInstalacao();
                    break;
                }
                case 4 -> {
                    colocarAnimalEmInstalacao();
                    break;
                }
                case 5 -> {
                    calendarioChines();
                    break;
                }
                case 6 -> {

                    listarAnimais();
                    break;
                }
                case 7 -> {
                    listarAnimaisComCarateristica();
                    break;
                }
                case 8 -> {
                    listarAnimaisComMutacao();
                    break;
                }
                case 9 -> {
                    listarInstalacoes();
                    break;
                }
                case 10 -> {
                    familiaAnimal();
                    break;
                }
                case 11 -> {
                    listarObituarios();
                    break;
                }
                case 12 -> {
                    historico();
                    break;
                }
                case 13 -> {
                    periodoContabilistico();
                    break;
                }
                case 14 -> {
                    jumanji();
                    break;
                }
                case 15 -> {
                    save();
                    sair = true;
                    break;
                }
                
                //METODOS EXTRA e não na UI
                case 20 -> {
                    adicionarCarateristicaAEspecie();
                    break;
                }
                case 21 -> {
                    printEspecie();
                    break;
                }
                case 22 -> {
                    printCarateristicas();
                    break;
                }
                case 23 -> {
                    printInstalacoes();
                    break;
                }
                case 24 -> {
                    load();
                    break;
                }
                case 25 -> {
                    save();
                    break;
                }
                case 30 -> {
                    adicionarCarateristica();
                    break;
                }
                case 31 -> {
                    adicionarEspecie();
                    break;
                }
                case 32 -> {
                    adicionarMutacao();
                    break;
                }
                case 33 -> {
                    adicionarCarateristicaAEspecie();
                    break;
                }
                case 34 -> {
                    adicionarMutacaoAAnimal();
                    break;
                }
                case 35 -> {
                    prejuizo();
                    break;
                }


            }
        }

    }
    
    
//fazer os métodos aqui

    

//      METODOS MENU PRINCIPAL
    public void adquirirAnimal() {
        Animal animal;
        int raridade;

        List<Animal> animaisOpcoes = new ArrayList();

        for (int i = 1; i <= 3; i++) { //Criar 3 animais para dar como opções
            raridade = (int) (Math.pow(Math.random(), 4) * 9 + 1); //raridade random

            List<Especie> especieOpcoes = new ArrayList();
            while (especieOpcoes.isEmpty()) {
                for (Especie especie : especies) {
                    if (especie.getRaridade() == raridade) { //vê se a especie é da raridade random
                        especieOpcoes.add(especie);
                    }

                }
                raridade--; //se não houver nenhuma especie com esta raridade diminui a raridade e tenta outra vez
            }
            
            int randomEspecie = (int) (Math.random() * (especieOpcoes.size() - 1)); //das especies de raridade random, escolhe 1
            int idade = (int) (Math.random() * especieOpcoes.get(randomEspecie).getEsperancaVida()); //random idade entre 0 e esperança de vida da especie
            try {
                animal = new Animal(animalId, getRandomNameFromFile(), idade, especieOpcoes.get(randomEspecie)); //cria as instancias dos animais que vão ser mostrados para escolher
                animaisOpcoes.add(animal);
                System.out.println("opção nº" + i + ": " + animal.getNome() + ", " + especieOpcoes.get(randomEspecie).getNome() + ", idade: " + animal.getIdade() + " Preço: " + animal.calculaPreco());
            } catch (Exception e) { 
                System.out.println("especie invalida"); 
            }

        }
        System.out.println("Qual animal é que deseja adquirir?");
        int opcao;
        boolean animalEscolhido = false;
        while (!animalEscolhido) {
            
            try {
                opcao = scan.nextInt();
                
                if (saldo >= animaisOpcoes.get(opcao - 1).calculaPreco()) { //se saldo > custo do animal escolhido
                    adicionarListaAnimais(animaisOpcoes.get(opcao - 1));
                    incrementaAnimalId();
                    probMutacoes(animaisOpcoes.get(opcao - 1)); //ver se o animal vai ter mutações
                    saldo -= animaisOpcoes.get(opcao - 1).calculaPreco();
                    saldoUsadoAnimais += animaisOpcoes.get(opcao - 1).calculaPreco();

                    ArrayList<String> dados = new ArrayList<>(); // recolhe informação para guardar no historico
                    dados.add("Nome:");
                    dados.add(animaisOpcoes.get(opcao - 1).getNome());
                    dados.add("Id:");
                    dados.add(animaisOpcoes.get(opcao - 1).getIdString());
                    dados.add("Idade:");
                    dados.add(animaisOpcoes.get(opcao - 1).getIdadeString());
                    dados.add("Especie:");
                    dados.add(animaisOpcoes.get(opcao - 1).getEspecie().getNome());
                    dados.add("Mutacoes:");
                    for (Mutacao mutacao : animaisOpcoes.get(opcao - 1).getMutacoesLista()) {
                        dados.add(mutacao.getNome());
                    }
                    guardaRegistoHistorico("COMPRA", dados); //guardar no historico
                    animalEscolhido= true;
                }
                else{
                    System.out.println("Dinheiro insufeciente, cancelando");
                    return;
                }

            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }


    }

    public void adquirirAnimalComCarateristica() {
        int opcao;

        List<Especie> possiveisEspecies = new ArrayList<>();
        int i = 0;
        for (Carateristica carateristica : carateristicas) { //imprimir carateristicas existentes
            System.out.println(i + ") " + carateristica.getNome());
            i++;
        }
        System.out.println("Selecione o numero carateristica que quer:");
        try{
            opcao = scan.nextInt();
        
        

        for (Especie especie : especies) { //procura especies com carateristica escolhida
            for (Carateristica carateristicaProcura : especie.getCarateristicas()) {
                if (carateristicaProcura.equals(carateristicas.get(opcao))) {
                    possiveisEspecies.add(especie);
                }
            }
        }
        }
        catch(Exception e){
            System.out.println("Invalid input");
        }
        if (!possiveisEspecies.isEmpty()) {
            int randomEspecie = (int) (Math.random() * (possiveisEspecies.size() - 1)); //random especie das possiveis
            int idade = (int) (Math.random() * possiveisEspecies.get(randomEspecie).getEsperancaVida()); //random idade entre 0 e esperanca da vida da especie
            Animal animal = new Animal(this.getAnimalId(), getRandomNameFromFile(), idade, possiveisEspecies.get(randomEspecie));
            if (saldo >= animal.calculaPreco()) { //verifica de tem saldo para comprar o animal
                System.out.println("Animal adquirido: " + animal.getEspecie().getNome() + " custo: " + animal.calculaPreco());
                adicionarListaAnimais(animal);
                incrementaAnimalId();
                probMutacoes(animal); //Verifica se o animal vai ter mutações
                saldo -= animal.calculaPreco();
                saldoUsadoAnimais += animal.calculaPreco();

                ArrayList<String> dados = new ArrayList<>();//guardar dados para meter no historico
                dados.add("Nome:");
                dados.add(animal.getNome());
                dados.add("Id:");
                dados.add(animal.getIdString());
                dados.add("Idade:");
                dados.add(animal.getIdadeString());
                dados.add("Especie:");
                dados.add(animal.getEspecie().getNome());
                dados.add("Mutacoes:");
                for (Mutacao mutacao : animal.getMutacoesLista()) {
                    dados.add(mutacao.getNome());
                }
                guardaRegistoHistorico("COMPRA", dados); //mete no historico
            }
        } else {
            System.out.println("Não existem especies com estas carateristicas");
        }

    }

    public void construirInstalacao() {
        String opcao;
        System.out.println("Tamanho da instalação [Pequena, Media, Grande]: ");
        opcao = scan.next(); //saber qual o tamanho da instalação que se quer

        int lotacao[] = new int[3];
        double preco[] = new double[3];
        switch (opcao) {  //cria o "concurso" entre 3 empresas, lotação e preços
            case "pequena" -> {
                System.out.println("Resultado do concurso:");
                for (int i = 0; i < 3; i++) {
                    lotacao[i] = (int) ((Math.random() * 4) + 1);
                    preco[i] = (double) (lotacao[i] * ((Math.random() * 250) + 500));
                    System.out.println("Empresa " + (i + 1) + " - Lotação:" + lotacao[i] + " Preço: " + preco[i]);
                }
            }

            case "media" -> {
                System.out.println("Resultado do concurso:");
                for (int i = 0; i < 3; i++) {
                    lotacao[i] = (int) ((Math.random() * 5) + 5);
                    preco[i] = (double) (lotacao[i] * ((Math.random() * 250) + 500));
                    System.out.println("Empresa " + (i + 1) + " - Lotação:" + lotacao[i] + " Preço: " + preco[i]);
                }
            }

            case "grande" -> {
                System.out.println("Resultado do concurso:");
                for (int i = 0; i < 3; i++) {
                    lotacao[i] = (int) ((Math.random() * 5) + 10);
                    preco[i] = (double) (lotacao[i] * ((Math.random() * 250) + 500));
                    System.out.println("Empresa " + (i + 1) + " - Lotação:" + lotacao[i] + " Preço: " + preco[i]);
                }
            }
            default -> {
                System.out.println("Seleção invalida");
                construirInstalacao(); 
                return;
            }

        }
        System.out.println("Escolha o numero da empresa ou qualquer outra chave para cancelar:");
        opcao = scan.next();
        int indice = 0;
        try {
            indice = Integer.parseInt(opcao);
        } catch (Exception e) {
            System.out.println("Construção de Instalação cancelada.");
        }
        if ((indice == 1 || indice == 2 || indice == 3) && saldo >= preco[indice - 1]) { //se saldo > preço constroi instalação
            Instalacao instalacao = new Instalacao(instalacoes.size(), lotacao[indice - 1]);
            instalacoes.add(instalacao);
            saldo -= preco[indice - 1];
            saldoUsadoInstalacoes += preco[indice - 1];
            ArrayList<String> dados = new ArrayList<>(); //prepara dados para adicionar historico
            dados.add("ID:");
            dados.add(instalacao.getIdString());
            dados.add("Lotação:");
            dados.add(instalacao.getLotacaoString());
            guardaRegistoHistorico("CONTRUÇÃO", dados); // adiciona ao historico
        }
    }

    public void colocarAnimalEmInstalacao() {
        if(instalacoes.isEmpty()){
            System.out.println("Não existem instalações");
            return;
        }
        String opcao;
        Animal animalEscolhido = null;
        Animal animalRemover = null;
        ArrayList<String> dados = new ArrayList<>();
        int idAnimal;
        Instalacao instalacaoEscolhida;
        int idInstalacao;
        int idAnimalRemover;
        for (Animal animal : animais) { //imprime todos os animais existentes
            System.out.print("id: " + animal.getId() + " Nome: " + animal.getNome() + " Especie:" + animal.getEspecieString());
            if (animal.getInstalacao() != null) {
                System.out.println(" Instalação: " + animal.getInstalacao().getId());
            } else {
                System.out.println();
            }

        }
        System.out.println("Insira o id do Animal a mover: ");
        opcao = scan.next();
        try { 
            idAnimal = Integer.parseInt(opcao);
        } catch (Exception e) {
            System.out.println("Id invalido");
            colocarAnimalEmInstalacao();
            return;
        }

        for (Animal animal : animais) { //para cada animal seleciona o pretendido
            if (idAnimal == animal.getId()) {

                animalEscolhido = animal;
                break;
            }
        }
        if (animalEscolhido == null) {
            System.out.println("Não existe animal com este ID");
            colocarAnimalEmInstalacao();
            return;
        }
        instalacaoEscolhida = null; 
        while (instalacaoEscolhida == null) {
            System.out.println("Escolha uma das instalações: ");
            int i = 0;
            for (Instalacao instalacao : instalacoes) { //imprime todas as instalações
                i++;
                System.out.print(i + ") Lotação: " + instalacao.getLotacao());
                if (!instalacao.getAnimais().isEmpty()) {
                    System.out.print(" - Animais nesta instalacao: ");
                    for (Animal animal : instalacao.getAnimais()) {
                        System.out.println();
                        System.out.print("Id: " + animal.getIdString() + " Nome: " + animal.getNome() + " Especie: " + animal.getEspecie().getNome());
                    }
                }
                System.out.println();
            }
            opcao = scan.next(); //id da instalação onde se pretende colocar o animal
            try {
                idInstalacao = Integer.parseInt(opcao);
                instalacaoEscolhida = instalacoes.get(idInstalacao - 1);
            } catch (Exception e) {
                System.out.println("Id invalido");
            }
        }

        if (instalacaoEscolhida.getAnimais().size() == instalacaoEscolhida.getLotacao()) { //se instalação estiver cheia
            //Retira um animal para colocar o novo

            System.out.println("Esta instalação já está cheia, Que animal deseja retirar?");
            System.out.println("Lotação da instalação: " + instalacaoEscolhida.getLotacao() + " - Animais nesta Instalação:");
            boolean animalEscolhidoRemover = false;

            while (!animalEscolhidoRemover) { 
                for (Animal animal : instalacaoEscolhida.getAnimais()) { //imprimir animais na instalação
                    System.out.print("Id: ");
                    System.out.print(animal.getId());
                    System.out.print(" Nome: ");
                    System.out.print(animal.getNome());
                    System.out.print(" Idade: ");
                    System.out.print(animal.getIdade());
                    System.out.print(" Especie: ");
                    System.out.print(animal.getEspecie().getNome());
                    System.out.print(" Atratividade: ");
                    System.out.format("%.2f", animal.calculaAtratividade());
                    System.out.println();

                    
                }
                System.out.println("Insira o ID do animal a remover:");
                opcao = scan.next();
                    try {
                        idAnimalRemover = Integer.parseInt(opcao);
                        for (Animal animalPossiveisRemover : instalacaoEscolhida.getAnimais()) {
                            if (animalPossiveisRemover.getId() == idAnimalRemover) { //encontra o animal correcto
                                animalEscolhidoRemover = true;
                                animalRemover = animalPossiveisRemover; 
                                instalacaoEscolhida.getAnimais().remove(animalRemover);//remove animal antigo
                                animalRemover.setInstalacao(); //remove instalação do animal antigo
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Id invalido");
                    }
            }
            dados = new ArrayList<>(); //prepara dados para guardar no historico
            dados.add("ID_animal:");
            dados.add(animalRemover.getIdString());
            dados.add(" Nome_Animal: ");
            dados.add(animalRemover.getNome());
            guardaRegistoHistorico("RETIRAR_INSTALAÇÃO", dados); //guarda no historico
        }
        //Mete novo animal na instalação
        instalacaoEscolhida.addAnimalInstalacao(animalEscolhido);
        dados = new ArrayList<>(); //prepara dados para guardar no historico
        dados.add("ID_animal:");
        dados.add(animalEscolhido.getIdString());
        dados.add("Nova_Instalação:"); 
        dados.add(instalacaoEscolhida.getIdString());
        guardaRegistoHistorico("MOVER", dados); //guarda no historico

        if (animalEscolhido.getInstalacao() != null) {
            //Retira animal da instalação se tiver
            animalEscolhido.getInstalacao().getAnimais().remove(animalEscolhido);
            dados = new ArrayList<>(); //prepara dados para guardar no historico
            dados.add("ID_animal:");
            dados.add(animalEscolhido.getIdString());
            dados.add(" Nome_Animal: ");
            dados.add(animalEscolhido.getNome());
            guardaRegistoHistorico("RETIRAR_DE_INSTALAÇÃO", dados); //guarda no historico
        }
        animalEscolhido.setInstalacao(instalacaoEscolhida);

    }

    public void calendarioChines() {
        int opcao;
        String especieString = "";
        opcao = (this.getAno() % 12) + 1; //vê qual é o animal correspondente no calendario chines
        switch (opcao) {
            case 1 -> {
                especieString = "macaco";

            }
            case 2 -> {
                especieString = "galinha";

            }
            case 3 -> {
                especieString = "cao";
            }
            case 4 -> {
                especieString = "porco";
            }
            case 5 -> {
                especieString = "rato";
            }
            case 6 -> {
                especieString = "vaca";
            }
            case 7 -> {
                especieString = "tigre";
            }
            case 8 -> {
                especieString = "coelho";
            }
            case 9 -> {
                especieString = "dragao";
            }
            case 10 -> {
                especieString = "serpente";
            }
            case 11 -> {
                especieString = "cavalo";
            }
            case 12 -> {
                especieString = "cabra";

            }
            default -> {
                System.out.println("ERRO");
            }
        }
        for (Especie especie : especies) { //procura a especie correcta e aumenta atratividade
            if (especie.getNome().toLowerCase().equals(especieString)) {
                especie.aumentaAtratividade();
                System.out.println("A atratividade dos " + especie.getNome() + " aumentou para " + especie.getAtratividadeBase());
            }
        }
    }

    public void listarAnimais() {
        if(animais.isEmpty()){
            System.out.println("Não existem animais");
            return;
        }
        for (Animal animal : animais) {
            System.out.print(animal.getNome() + " id: " + animal.getId() + " Especie: " + animal.getEspecie().getNome() + " Idade: " + animal.getIdade());
            if (!animal.getMutacoesLista().isEmpty()) {
                System.out.print(" Mutações: ");
                for (Mutacao mutacao : animal.getMutacoesLista()) {
                    System.out.print(mutacao.getNome() + " ");
                }
            }
            System.out.println();
        }
    }

    public void listarAnimaisComCarateristica() {
        int opcao;
        int i = 0;
        for (Carateristica carateristica : carateristicas) { //lista todas as carateristicas para poder escolher

            System.out.println(i + ") " + carateristica.getNome());
            i++;
        }
        System.out.println("Selecione o numero carateristica que quer:");
        opcao = scan.nextInt();
        for (Animal animal : animais) { //para cada animal a qual esta carateristica se aplique, imprime
            for (Carateristica carateristicaAnimal : animal.getEspecie().getCarateristicas()) {
                if (carateristicaAnimal.equals(carateristicas.get(opcao))) {
                    System.out.println(animal.getNome() + " id: " + animal.getId() + " Especie: " + animal.getEspecie().getNome() + " Idade: " + animal.getIdade());
                }
            }
        }
    }

    public void listarAnimaisComMutacao() {
        int opcao;
        boolean encontrado = false;
        int i = 1;
        for (Mutacao mutacao : mutacoes) { //lista todas as mutações para poder escolher
            System.out.println(i + ") " + mutacao.getNome());
            i++;
        }
        System.out.println("Selecione o numero da Mutação que quer:");
        opcao = scan.nextInt();
        System.out.println("Animais com a mutação " + mutacoes.get(opcao - 1).getNome() + ":");
        for (Animal animal : animais) { //para cada animal a qual esta mutação se aplica, imprime
            for (Mutacao mutacaoAnimal : animal.getMutacoesLista()) {
                if (mutacaoAnimal.equals(mutacoes.get(opcao - 1))) {
                    encontrado = true;
                    System.out.println(animal.getNome() + " id: " + animal.getId() + " Especie: " + animal.getEspecie().getNome() + " Idade: " + animal.getIdade());
                }
            }
        }
        if (!encontrado) {
            System.out.println("Não Existem animais com esta Mutação");
        }
    }

    public void listarInstalacoes() {
        if(instalacoes.isEmpty()){
            System.out.println("Não existem instalações");
            return;
        }
        System.out.println("Instalações do zoo: ");

        for (Instalacao instalacao : instalacoes) {
            System.out.println("id: " + instalacao.getId() + " Lotação:" + instalacao.getLotacao());
        }
    }

    public void familiaAnimal() {
        System.out.println("Instalações:");
        for (Instalacao instalacao : instalacoes) { //imprime cada instalação e seus animais
            System.out.print("id: " + instalacao.getId() + " Lotação: " + instalacao.getLotacao());
            if (!instalacao.getAnimais().isEmpty()) {
                System.out.print(" - Animais: ");
                for(Animal animal :instalacao.getAnimais()){
                    System.out.print("Id: " + animal.getId() + " Nome: " + animal.getNome());
                }
                

            } 
            System.out.println();
           
        }
        System.out.println("Animais");
        listarAnimais();

        System.out.println("Especies:");
        printEspecie();

        System.out.println("Carateristicas:");
        printCarateristicas();

    }

    public void historico() { //imprime historico
        try {
            File ficheiro = new File("Historico.txt");
            Scanner reader = new Scanner(ficheiro);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");

        }
    }

    public void periodoContabilistico() {
        double custoAnual;
        List<Animal> animaisBebes = new ArrayList();
        List<Animal> animaisMortos = new ArrayList();
        Animal bebe;
        aumentaIdade();

        for (Animal animal : animais) {
            if (animal.checkVida()) { //check se o animal morre
                animal.morre(this); //animal "morre"
                animaisMortos.add(animal); 
            }
            if (animal.checkNascimento()) { //check se um animal tem cria
                bebe = new Animal(this.getAnimalId(), getRandomNameFromFile(), 0, animal.getEspecie());
                incrementaAnimalId();
                probMutacoes(bebe);
                animaisBebes.add(bebe);

                ArrayList<String> dados = new ArrayList<>(); //prepara dados para historico
                dados.add("Nome: ");
                dados.add(bebe.getNome());
                dados.add("Id: ");
                dados.add(bebe.getIdString());
                dados.add("Idade: ");
                dados.add(bebe.getIdadeString());
                dados.add("Especie: ");
                dados.add(bebe.getEspecie().getNome());
                dados.add("Mutações: ");
                for (Mutacao mutacao : bebe.getMutacoesLista()) {
                    dados.add(mutacao.getNome() + " ");
                }
                guardaRegistoHistorico("NASCEU", dados); //imprime no historico

            }
        }
        System.out.println("Nascimentos: ");
        for (int i = 0; i < animaisBebes.size(); i++) { //imprime animais que nasceram
            adicionarListaAnimais(animaisBebes.get(i));
            System.out.println("Nome: " + animaisBebes.get(i).getNome() + ". Espécie: " + animaisBebes.get(i).getEspecie().getNome());
        }
        System.out.println("Óbitos:"); //imprime animais que morreram
        for (int i = 0; i < animaisMortos.size(); i++) {
            animais.remove(animaisMortos.get(i));
            if (animaisMortos.get(i).getInstalacao() != null) {
                animaisMortos.get(i).morre(this);
            }
            System.out.println("Nome: " + animaisMortos.get(i).getNome() + ". Espécie: " + animaisMortos.get(i).getEspecie().getNome() + ". Idade: " + animaisMortos.get(i).getIdade());
        }
        ano++;

        System.out.println("Rendimentos");
        System.out.println("Este ano os animais renderam: " + rendimentoAnimais());
        System.out.println("Custos");
        System.out.println("Este ano foi gasto em aquisições de animais: " + saldoUsadoAnimais + " euros.");
        System.out.println("Este ano foi gasto em construções de instalações: " + saldoUsadoInstalacoes + " euros.");
        System.out.println("Este ano foi gasto na manutenção do zoo: " + custosManutencao() + " euros.");
        custoAnual = saldoUsadoAnimais + saldoUsadoInstalacoes + custosManutencao();
        System.out.println("Custo total deste ano: " + custoAnual);
        saldo -= custosManutencao();
        saldo += rendimentoAnimais();
        prejuizo(); //metodo para arranjar a situação caso saldo < 0 no fim do ano
        saldoUsadoAnimais = 0;
        saldoUsadoInstalacoes = 0;
    }

    public void jumanji() {

        System.out.println("----JUMANJI----");
        List<Animal> animaisEscapados = new ArrayList<>();
        for (Animal animal : animais) { //30% chance de fujir
            if (Math.random() >= .7) {
                animaisEscapados.add(animal);
            }
        }
        for (Animal animalEscapado : animaisEscapados) { //dos animais que escaparam...
            int numCarateristicas = animalEscapado.getEspecie().getCarateristicas().size();
            int carateristicaEscolhida = (int) (Math.random() * (numCarateristicas - 1)); //escolhe uma das carateristicas do animal para usar a sua habilidade
            System.out.println(animalEscapado.getNome() + " " + animalEscapado.getEspecie().getCarateristicas().get(carateristicaEscolhida).getAbilidade());
            if (Math.random() >= .5) { // 50% chance do animal fujir de vez
                System.out.println("Este animal escapou");
                if (animalEscapado.getInstalacao() != null) {
                    animalEscapado.getInstalacao().getAnimais().remove(animalEscapado);
                }

                animalEscapado.setInstalacao();
                animais.remove(animalEscapado);

                ArrayList<String> dados = new ArrayList<>(); //prepara dados para historico
                dados.add("Nome: ");
                dados.add(animalEscapado.getNome());
                dados.add("Id: ");
                dados.add(animalEscapado.getIdString());
                dados.add("Idade: ");
                dados.add(animalEscapado.getIdadeString());
                dados.add("Especie: ");
                dados.add(animalEscapado.getEspecie().getNome());
                dados.add("Mutações: ");
                for (Mutacao mutacao : animalEscapado.getMutacoesLista()) {
                    dados.add(mutacao.getNome() + " ");
                }
                guardaRegistoHistorico("FUJIU", dados); //guarda no historico

            }
        }

    }

    public double rendimentoAnimais() { //calcula o dinheiro ganho com cada animal
        double rendimentosAnimais = 0;
        double rendimentoAnimal = 0;
        for (Animal animal : animais) {
            if (animal.getInstalacao() != null) { //se tiver instalação
                rendimentoAnimal += 150*animal.getEspecie().getAtratividadeBase() * 2-(animal.getIdade()/animal.getEspecie().getEsperancaVida());

                if (animal.getMutacoesLista() != null) {
                    for (Mutacao mutacao : animal.getMutacoesLista()) {
                        rendimentoAnimal *= mutacao.getModAtract();
                    }
                } 
            }
            rendimentosAnimais +=rendimentoAnimal;
        }
        return rendimentosAnimais;
    }



    //      METODOS PARA CARREGAR / SALVAR
    public void save() {
        salvarEspecies();
        salvarAnimais();
        salvarMutacoes();
        salvarInstalacoes();
        salvarCarateristicas();
    }
    public void load() {
        carregarCarateristicas();
        carregarEspecies();
        carregarMutacoes();
        carregarInstalacoes();
        carregarAnimais();
        atualizarId();
        //atualizarAnimaisNasInstalacoes();

    }

    public void carregarEspecies() {
        String[] linha;
        Especie especie;

        try {
            File ficheiro = new File("Especies.txt");
            Scanner reader = new Scanner(ficheiro);
            while (reader.hasNextLine()) {
                String dados = reader.nextLine();
                linha = dados.split(" ");
                try {
                    int atratividade = Integer.parseInt(linha[0]);

                    int raridade = Integer.parseInt(linha[2]);

                    int esperancaVida = Integer.parseInt(linha[3]);
                    int apetiteReprodutivo = Integer.parseInt(linha[4]);

                    especie = new Especie(atratividade, linha[1], raridade, esperancaVida,apetiteReprodutivo , this, true);
                    if (linha.length > 5) {

                        for (int i = 5; i < linha.length; i++) {

                            for (Carateristica carateristica : carateristicas) {
                                if (carateristica.getNome().equals(linha[i])) {
                                    especie.getCarateristicas().add(carateristica);
                                }
                            }
                        }

                    }

                   

                } catch (Exception e) {
                    System.out.println("Ficheiro corrupto Carateristicas, Cancelado");
                    return;
                }

                especies.add(especie);

            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");

            
        }

    }
    public void salvarEspecies() {
        try {
            FileWriter writer = new FileWriter("Especies.txt");
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
            writer.close();
            System.out.println("Successfully wrote ESPECIES to the file.");
        } catch (IOException e) {
            System.out.println("Erro 001");
        }
    }

    public void carregarAnimais() {
        String[] linha;
        Animal animal;
        Especie especieFinal = null;

        try {
            File ficheiro = new File("Animais.txt");
            Scanner reader = new Scanner(ficheiro);
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
                } catch (Exception e) {
                    System.out.println("Ficheiro Mutacoes corrupto, Cancelado");
                    return;
                }
                animais.add(animal);

            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            
        }
        
    }
    public void salvarAnimais() {
        try {
            FileWriter writer = new FileWriter("Animais.txt");
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
            writer.close();
            System.out.println("Successfully wrote ANIMAIS to the file.");
        } catch (IOException e) {
            System.out.println("Erro 001");
        }
    }

    public void carregarCarateristicas() {
        String[] linha;
        Carateristica carateristica;

        try {
            File ficheiro = new File("Carateristicas.txt");
            Scanner reader = new Scanner(ficheiro);
            while (reader.hasNextLine()) {
                String dados = reader.nextLine();
                linha = dados.split(" ");
                try {
                    double custos = Double.parseDouble(linha[1]);
                    carateristica = new Carateristica(linha[0], custos, linha[2]);
                    carateristicas.add(carateristica);
                    
                } catch (Exception e) {
                    System.out.println("Ficheiro Carateristicas corrupto, Cancelado");
                    return;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
           
        }

    }
    public void salvarCarateristicas() {
        try {
            FileWriter writer = new FileWriter("Carateristicas.txt");
            for (Carateristica carateristica : carateristicas) {
                writer.write(carateristica.getNome() + " ");
                writer.write(carateristica.getCustos() + " ");
                writer.write(carateristica.getAbilidade() + " ");
                writer.write("\n");
            }
            writer.close();
            System.out.println("Successfully wrote Carateristicas to the file.");
        } catch (IOException e) {
            System.out.println("Erro 001");
        }
    }

    public void carregarMutacoes() {
        String[] linha;
        Mutacao mutacao;
        try {
            File ficheiro = new File("Mutacoes.txt");
            Scanner reader = new Scanner(ficheiro);
            while (reader.hasNextLine()) {
                String dados = reader.nextLine();
                linha = dados.split(" ");
                try {
                    int modAtract = Integer.parseInt(linha[1]);
                    mutacao = new Mutacao(linha[0], modAtract);
                    mutacoes.add(mutacao);
                } catch (Exception e) {
                    System.out.println("Ficheiro Mutacoes corrupto, Cancelado");
                   
                }

            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            
        }

    }
    public void salvarMutacoes() {
        try {
            FileWriter writer = new FileWriter("Mutacoes.txt");
            for (Mutacao mutacao : mutacoes) {
                writer.write(mutacao.getNome() + " ");
                writer.write(mutacao.getModAtract() + " ");
                writer.write("\n");
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Erro 001");
        }
    }

    public void carregarInstalacoes() {
        String[] linha;
        Instalacao instalacao;
        List<Integer> animaisId = new ArrayList<>();

        try {
            File ficheiro = new File("Instalacoes.txt");
            Scanner reader = new Scanner(ficheiro);
            while (reader.hasNextLine()) {
                String dados = reader.nextLine();
                linha = dados.split(" ");
                try {
                    int id = Integer.parseInt(linha[0]);
                    int lotacao = Integer.parseInt(linha[1]);                    
                    
                    if(linha.length > 2){
                        for(int i = 2; i <linha.length; i++){
                            animaisId.add(Integer.parseInt(linha[i]));
                        }
                    }
                    instalacao = new Instalacao(id, lotacao, animaisId);
                    instalacoes.add(instalacao);
                    
                    System.out.println("Instalacoes ok");
                } catch (Exception e) {
                    System.out.println("Ficheiro Instalacoes corrupto, Cancelado");
                    
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            
        }

    }
    public void salvarInstalacoes() {
        try {
            FileWriter writer = new FileWriter("Instalacoes.txt");
            for (Instalacao instalacao : instalacoes) {
                writer.write(instalacao.getId() + " ");
                writer.write(instalacao.getLotacao() + " ");

                for (Animal animal : instalacao.getAnimais()) {
                    writer.write(animal.getId() + " ");
                    
                }   
                writer.write("\n");
            }
            writer.close();
            System.out.println("Successfully wrote INSTALAÇÕES to the file.");
        } catch (IOException e) {
            System.out.println("Erro 001");
        }
    }
    
    public void guardaRegistoHistorico(String tipo, ArrayList<String> dados) {
        try {
            FileWriter fw = new FileWriter("Historico.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            fw.write("\n" + tipo + " Ano: " + ano + " - ");

            for (String dado : dados) {
                fw.write(dado + " ");
            }
            System.out.println("Registo Acidionado");
            pw.flush();
            pw.close();
            bw.close();
            fw.close();
        } catch (Exception o) {
            System.out.println("Erro a adicionar registo ao historico");
        }
    }

    //      METODOS AUXILIARES
    public void prejuizo() {
        if (animais.isEmpty() && saldo < 0) { //se não há animais e saldo negativo
            System.out.println("O Zoo não tem nenhum animal. A pedir emprestimo a fundo perdido");
            saldo = 10000; //"emprestimo" no valor do saldo negativo + 10.000€
        } else {
            if (saldo < 0) {
                int mutacaoModAttract;
                int opcao;
                Animal animalVender = animais.get(0);
                while (saldo < 0) { //enquando tiver animais e o saldo continuar negativo...
                    System.out.println("Houve prejuízo este ano, animais têm que ser vendidos!");
                    for (Animal animal : animais) { //lista todos os animais e seu preço de venda (80% do preço do animal)
                        mutacaoModAttract = 1;
                        if (!animal.getMutacoesLista().isEmpty()) {
                            for (Mutacao mutacao : animal.getMutacoesLista()) {
                                mutacaoModAttract += mutacao.getModAtract();
                            }
                        }
                        System.out.println("Id: " + animal.getIdString() + " Nome: " + animal.getNome() + " Especie: " + animal.getEspecie().getNome() + " Valor de venda: " + animal.calculaPreco() * 0.8);
                    }
                    System.out.println("Selecione o ID do animal para vender:");
                    opcao = scan.nextInt();
                    try {
                        for (Animal animal : animais) { //apanha o animal correcto para vender

                            if (compare(animal.getId(), opcao) == 0) {

                                animalVender = animal;
                            }
                        }
                        mutacaoModAttract = 1;
                        if (!animalVender.getMutacoesLista().isEmpty()) {
                            for (Mutacao mutacao : animalVender.getMutacoesLista()) {
                                mutacaoModAttract += mutacao.getModAtract();
                            }
                        }
                        saldo += animalVender.calculaPreco() * 0.8; //adiciona valor de venda do animal ao saldo
                        
                        if (animalVender.getInstalacao() != null) { //retira esse animal da instalação onde tava
                            animalVender.getInstalacao().getAnimais().remove(animalVender);
                        }
                        animais.remove(animalVender); //remove animal da lista de animais vivos

                        ArrayList<String> dados = new ArrayList<>(); //prepara dados para historico
                        dados.add("Nome:");
                        dados.add(animalVender.getNome());
                        dados.add("Id:");
                        dados.add(animalVender.getIdString());
                        dados.add("Idade:");
                        dados.add(animalVender.getIdadeString());
                        dados.add("Especie:");
                        dados.add(animalVender.getEspecie().getNome());
                        dados.add("Mutacoes:");
                        for (Mutacao mutacao : animalVender.getMutacoesLista()) {
                            dados.add(mutacao.getNome());
                        }

                        guardaRegistoHistorico("VENDA", dados); //guarda no historico

                    } catch (Exception e) {
                        System.out.println("ERRO");
                    }
                }
            }
        }
    }

    public double custosManutencao() {
        double custosManutencao = 0;
        for (Instalacao instalacao : instalacoes) { //para cada instalação...
            custosManutencao += instalacao.getCustoManutencao() * instalacao.getLotacao(); //calcula custos da mesma e adiciona ao total
        }
        for (Animal animal : animais) { //para cada animal soma os seus custos aos custos finais
            custosManutencao += 100 * animal.getEspecie().getAtratividadeBase();
            custosManutencao += 1000 * animal.getEspecie().getRaridade();
        }
        return custosManutencao;
    }

    public void probMutacoes(Animal animal) {
        for (Mutacao mutacao : mutacoes) { //"calcula" quais mutações o animal vai ter
            int i = -Objects.hash(animal.getId(), animal.getEspecie(), animal.getIdade(), animal.getMutacoesLista(), mutacao.getNome(), mutacao.getModAtract()) % 20;
            if (i == 0) {
                animal.addMutacao(mutacao);
            }
        }
    }
    public void atualizarId() { //vê todos os id dos animais existentes e dos já mortos e atualiza o id que o proximo animal terá
       
        int maiorId = 0;
        for (Animal animal : animais) { //encontra o maior id entre os animais vivos
            if (animal.getId() > maiorId) {
                maiorId = animal.getId();
            }
        }
        try { //encontra os id's dos animais já mortos
            String[] linha;
            File ficheiro = new File("Obitos.txt");
            Scanner reader = new Scanner(ficheiro);
            while (reader.hasNextLine()) {
                String dados = reader.nextLine();
                linha = dados.split(" ");
                try {

                    if (Integer.parseInt(linha[1]) > maiorId) { // se o id for maior do que maiorId, então maiorId = esse id

                        maiorId = Integer.parseInt(linha[1]);
                    }
                } catch (Exception e) {

                    System.out.println("Ficheiro Obitos corrupto, Cancelado");
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        
        animalId = maiorId + 1; //o novo id terá que ser sempre +1 do que o antigo maior id
    }
    public void aumentaIdade() {
        for (Animal animal : animais) {
            animal.incrementaIdade();
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
            System.out.println("An error occurred.");
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
            System.out.println("An error occurred.");
        }
        return nome[0]; 
    }

    public void printAnimal() {
        for (Animal animal : animais) {
            System.out.println(animal.getNome() + " id: " + animal.getId() + " Especie: " + animal.getEspecie().getNome() + " Idade: " + animal.getIdade());
        }
    }
    public void printEspecie() {
        for (Especie especie : especies) {
            System.out.print("Nome: " + especie.getNome() + " Raridade: " + especie.getRaridade() + " Esperança de Vida: " + especie.getEsperancaVida() + " Apetite Reprodutivo: " + especie.getApetiteReprodutivo());
            if (!especie.getCarateristicas().isEmpty()) {
                System.out.print(" - Carateristicas: ");
            }
            for (Carateristica carateristica : especie.getCarateristicas()) {
                System.out.print(carateristica.getNome() + " ");
            }
            System.out.println();
        }
    }
    public void printCarateristicas() {
        for (Carateristica carateristica : carateristicas) {
            System.out.println(carateristica.getNome() + " Abilidade: " + carateristica.getAbilidade());
        }
    }
    public void printInstalacoes() {
        for (Instalacao instalacao : instalacoes) {
            System.out.println(instalacao.getId() + " Lotação:" + instalacao.getLotacao());
        }
    }
    public void listarObituarios() { //abre o ficheiro e imprime os obitos
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
                } catch (Exception e) {
                    System.out.println("Ficheiro Obtitos corrupto, Cancelado");
                    return;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");

        }

    }

    public void adicionarListaAnimais(Animal animal) {
        animais.add(animal);

    }
    public void adicionarCarateristica() { //metodo auxilidar para adicionar carateristicas em runtime
        String nome;
        double custos;
        String abilidade;

        System.out.println("Nome:");
        nome = scan.next();
        System.out.println("custos:");
        custos = (Double) (scan.nextDouble());
        System.out.println("abilidade:");
        abilidade = scan.next();

        Carateristica carateristica = new Carateristica(nome, custos, abilidade);
        carateristicas.add(carateristica);
    }
    public void adicionarEspecie() {
        int atratividade;
        String nome;
        int raridade;
        int esperancaVida;
        int apetiteReprodutivo;

        System.out.println("atratividade:");
        atratividade = scan.nextInt();
        System.out.println("nome:");
        nome = scan.next();
        System.out.println("raridade:");
        raridade = scan.nextInt();
        System.out.println("esperancaVida:");
        esperancaVida = scan.nextInt();
        System.out.println("apetiteReprodutivo:");
        apetiteReprodutivo = scan.nextInt();

        Especie especie = new Especie(atratividade, nome, raridade, esperancaVida, apetiteReprodutivo, this, true);
        especies.add(especie);
    } //metodo auxiliar para adicionar especies em runtime
    public void adicionarMutacao() {
        String nome;
        int modAtract;

        System.out.println("Nome:");
        nome = scan.next();
        System.out.println("modAtract:");
        modAtract = scan.nextInt();

        Mutacao mutacao = new Mutacao(nome, modAtract);
        mutacoes.add(mutacao);
    } //metodo auxiliar para adicionar mutações em runtime
    public void adicionarCarateristicaAEspecie() {
        for (Especie especie : especies) {
            System.out.println("1- " + especie.getNome());
        }
        int opcao;
        opcao = scan.nextInt();
        if (opcao <= especies.size()) {
            System.out.println(especies.get(opcao - 1).getNome());
            int i = 0;
            for (Carateristica carateristica : carateristicas) {
                System.out.println(i + "- " + carateristica.getNome());
                i++;

            }

            int opcao2;
            opcao2 = scan.nextInt();

            System.out.println(carateristicas.size());
            System.out.println(opcao2);
            if (opcao2 < carateristicas.size()) {

                especies.get(opcao - 1).adicionarCarateristica(carateristicas.get(opcao2));

            }
        }
    } //metodo auxiliar para adicionar carateristicas a especies em runtime
    public void adicionarMutacaoAAnimal() {
        int i = 0;
        for (Animal animal : animais) {
            System.out.println(i + "- " + animal.getNome());
            i++;
        }
        int opcao;
        opcao = scan.nextInt();
        if (opcao <= animais.size()) {
            System.out.println(animais.get(opcao).getNome());
            i = 0;
            for (Mutacao mutacao : mutacoes) {
                System.out.println(i + "- " + mutacao.getNome());
                i++;

            }
            int opcao2;
            opcao2 = scan.nextInt();

            if (opcao2 < mutacoes.size()) {
             
                animais.get(opcao).addMutacao(mutacoes.get(opcao2));
             
            }
        }
    } //metodo auxiliar para adicionar mutações a um animal em runtime

    // GETS E SETS
    public List<Carateristica> getCarateristicas() {
        return carateristicas;
    }

    public int getAno() {
        return ano;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void incrementaAnimalId() {
        animalId++;
    }
}
