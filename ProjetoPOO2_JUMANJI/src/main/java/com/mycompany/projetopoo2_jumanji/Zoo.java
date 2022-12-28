/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo2_jumanji;

import java.util.*;
import static java.lang.Integer.compare;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Objects;

/**
 *
 * @author vigab
 */
public class Zoo {
    
    private FileManager fileManager = new FileManager();
    private MenuManager menuManager = new MenuManager();

    private final Scanner scan = new Scanner(System.in);
    private  ArrayList<Animal> animais = new ArrayList<>();
    private  ArrayList<Instalacao> instalacoes = new ArrayList();
    private  ArrayList<Especie> especies = new ArrayList();
    private  ArrayList<Carateristica> carateristicas = new ArrayList();
    private  ArrayList<Mutacao> mutacoes = new ArrayList();
    private int ano;
    private double saldo;
    private double saldoUsadoAnimais = 0;
    private double saldoUsadoInstalacoes = 0;
    private int animalId = 0;
    

    public static void main(String[] args) {

        //criação do Zoo
        Zoo newZoo = new Zoo();
        newZoo.startUp();
        newZoo.startMenu(); //chamando a função para iniciar a aplicação  

    }

  public void startMenu() {
    int opcao = 0;
    boolean sair = false;     
    while (!sair) {
        menuManager.printMainMenu(ano, saldo);
        try {
            opcao = scan.nextInt();
        } catch (Exception e) {
            menuManager.printInputDoTipoErrado();
            scan.nextLine();
            continue;
        }
        // Validate input to ensure it is a valid menu option
        if (opcao < 1 || opcao > 35) {
            menuManager.printInputForaDoIntervalo();
            continue;
        }
        //switch com diferentes metodos disponiveis atravez do menu
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
                menuManager.listarAnimais(animais);
                break;
            }
            case 7 -> {
                menuManager.listarAnimaisComCarateristica(animais, carateristicas);
                break;
            }
            case 8 -> {
                menuManager.listarAnimaisComMutacao(animais, mutacoes);
                break;
            }
            case 9 -> {
                menuManager.listarInstalacoes(instalacoes);
                break;
            }
            case 10 -> {
                menuManager.familiaAnimal(animais, instalacoes, especies, carateristicas);
                break;
            }
            case 11 -> {
                fileManager.listarObituarios();
                break;
            }
            case 12 -> {
                fileManager.historico();
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
                fileManager.save(especies, animais, mutacoes, carateristicas, instalacoes, ano, saldo);
                sair = true;
                break;
            }
                
            //METODOS EXTRA e não na UI
            case 20 -> {
                adicionarCarateristicaAEspecie();
                break;
            }
            case 21 -> {
                menuManager.listarEspecies(especies);
                break;
            }
            case 22 -> {
                menuManager.printCarateristicas(carateristicas);
                break;
            }
            case 23 -> {
                menuManager.listarInstalacoes(instalacoes);
                break;
            }
            case 24 -> {
                fileManager.load(this);
                break;
            }
            case 25 -> {
                fileManager.save(especies, animais, mutacoes, carateristicas, instalacoes, ano, saldo);
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
public void startUp(){
    fileManager.load(this); //Carregar Zoo a partir dos ficheiros
        animalId = fileManager.atualizarId(animais);
}
    

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
                animal = new Animal(animalId, fileManager.getRandomNameFromFile(), idade, especieOpcoes.get(randomEspecie)); //cria as instancias dos animais que vão ser mostrados para escolher
                animaisOpcoes.add(animal);
                
                System.out.print("opção nº" + i + ": ");   
                menuManager.printAnimal(animal);
                System.out.println(" Preço: " + animal.calculaPreco());
                
            } catch (Exception e) {
                System.out.println("especie invalida");
            }

        }
        int opcao1;

        while (true) {
            System.out.println("Qual animal é que deseja adquirir? ([ZERO] para cancelar)");

            try {
                opcao1 = scan.nextInt();

                if (opcao1 >= 0 && opcao1 <= 3) {
                    switch (opcao1) {
                        case 1:
                        case 2:
                        case 3:
                            if (saldo >= animaisOpcoes.get(opcao1 - 1).calculaPreco()) {
                                adicionarListaAnimais(animaisOpcoes.get(opcao1 - 1));
                                incrementaAnimalId();
                                probMutacoes(animaisOpcoes.get(opcao1 - 1));
                                saldo -= animaisOpcoes.get(opcao1 - 1).calculaPreco();
                                saldoUsadoAnimais += animaisOpcoes.get(opcao1 - 1).calculaPreco();

                                ArrayList<String> dados = new ArrayList<>();
                                dados.add("Nome:");
                                dados.add(animaisOpcoes.get(opcao1 - 1).getNome());
                                dados.add("Id:");
                                dados.add(animaisOpcoes.get(opcao1 - 1).getIdString());
                                dados.add("Idade:");
                                dados.add(animaisOpcoes.get(opcao1 - 1).getIdadeString());
                                dados.add("Especie:");
                                dados.add(animaisOpcoes.get(opcao1 - 1).getEspecie().getNome());
                                dados.add("Mutacoes:");
                                for (Mutacao mutacao : animaisOpcoes.get(opcao1 - 1).getMutacoesLista()) {
                                    dados.add(mutacao.getNome());
                                }
                                fileManager.guardaRegistoHistorico("COMPRA", dados, ano);
                            } else {
                                menuManager.printSemDinheiroCancelar();
                                return;
                            }
                            break;
                        case 0:
                            menuManager.printCancelado();
                            return;           
                            
                    }
                    break; // break out of the loop once a valid input has been entered
                } else {
                    menuManager.printInputForaDoIntervalo();
                }
            } catch (InputMismatchException e) {
                menuManager.printInputDoTipoErrado();
                scan.nextLine(); 
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
               
        while (true) {
            System.out.println("Selecione o numero carateristica que quer ou [-1] para cancelar");
            try {
                opcao = scan.nextInt();
                if(opcao == -1){
                    menuManager.printCancelado();
                    return;
                } 
                else if(opcao >= 0 && opcao <= carateristicas.size()){
                    for (Especie especie : especies) {
                        for (Carateristica carateristicaProcura : especie.getCarateristicas()) {
                            if (carateristicaProcura.equals(carateristicas.get(opcao))) {
                                possiveisEspecies.add(especie);
                            }
                        }
                    }
                    break;
                }
                else{
                    menuManager.printInputForaDoIntervalo();
                }
            } catch (Exception e) {
                menuManager.printInputDoTipoErrado();
                scan.nextLine(); 
            }
        }
        if (!possiveisEspecies.isEmpty()) {
            int randomEspecie = (int) (Math.random() * (possiveisEspecies.size() - 1));
            int idade = (int) (Math.random() * possiveisEspecies.get(randomEspecie).getEsperancaVida());
            Animal animal = new Animal(this.getAnimalId(), fileManager.getRandomNameFromFile(), idade, possiveisEspecies.get(randomEspecie));
            if (saldo >= animal.calculaPreco()) {
                
                System.out.print("Animal adquirido: ");
                menuManager.printAnimal(animal);
                  System.out.println(      " Custo: " + animal.calculaPreco());
                  
                adicionarListaAnimais(animal);
                incrementaAnimalId();
                probMutacoes(animal);
                saldo -= animal.calculaPreco();
                saldoUsadoAnimais += animal.calculaPreco();

                ArrayList<String> dados = new ArrayList<>();
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
                fileManager.guardaRegistoHistorico("COMPRA", dados,ano);
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
                menuManager.printInputDoTipoErrado();
                construirInstalacao(); 
                return;
            }

        }
        int opcaoInt;
     
        
        while (true) {
            System.out.println("Escolha o numero da empresa ou [ZERO] para cancelar:");

            try {
                opcaoInt = scan.nextInt();

                if (opcaoInt == 0) {
                    System.out.println("Cancelado!");
                    return;
                }      
                else if(opcaoInt < 1 || opcaoInt > 3) {
                    menuManager.printInputForaDoIntervalo();
                }
                else if (opcaoInt >= 1 && opcaoInt <= 3 && saldo >= preco[opcaoInt - 1]) { //se saldo > preço constroi instalação
                    Instalacao instalacao = new Instalacao(instalacoes.size(), lotacao[opcaoInt - 1]);
                    instalacoes.add(instalacao);
                    saldo -= preco[opcaoInt - 1];
                    saldoUsadoInstalacoes += preco[opcaoInt - 1];
                    ArrayList<String> dados = new ArrayList<>(); //prepara dados para adicionar historico
                    dados.add("ID:");
                    dados.add(instalacao.getIdString());
                    dados.add("Lotação:");
                    dados.add(instalacao.getLotacaoString());
                    fileManager.guardaRegistoHistorico("CONTRUÇÃO", dados, ano); // adiciona ao historico
                    return;
                } else if ((opcaoInt >= 1 && opcaoInt <= 3 && saldo <= preco[opcaoInt - 1])) {
                    menuManager.printSemDinheiroCancelar();
                    return;
                }
                
            } catch (InputMismatchException e) {
                menuManager.printInputDoTipoErrado();
                scan.nextLine();
            }
        }

    }

    public void colocarAnimalEmInstalacao() {
        if (instalacoes.isEmpty()) {
            System.out.println("Não existem instalações");
            return;
        }
        if(animais.isEmpty()){
            System.out.println("Não existem animais no zoo");
            return;
        }
        ArrayList<String> dados = new ArrayList<>();
        Animal animalEscolhido = null;
        Animal animalRemover = null;
        int idAnimal;
        Instalacao instalacaoEscolhida;
        int idInstalacao;
        int idAnimalRemover;
        menuManager.printAnimais(animais);

        System.out.println("Insira o id do Animal a mover: ");
        idAnimal = scan.nextInt();
        for (Animal animal : animais) { // encontra o animal correcto
            if (idAnimal == animal.getId()) {
                animalEscolhido = animal;
                break;
            }
        }
        if (animalEscolhido == null) {
            System.out.println("Não existe animal com este ID");
            return;
        }

        // escolher instalação
        instalacaoEscolhida = null;
        while (instalacaoEscolhida == null) {
            System.out.println("Escolha uma das instalações: ");
            int i = 0;
            for (Instalacao instalacao : instalacoes) {//imprime todas as instalações

                System.out.print(i + ") ");
                menuManager.printInstalacao(instalacao);                
                System.out.println();
                i++;
            }
            idInstalacao = scan.nextInt();
            try {
                instalacaoEscolhida = instalacoes.get(idInstalacao);
            } catch (Exception e) {
                System.out.println("Id inválido");
            }
        }

        if (instalacaoEscolhida.getAnimais().size() == instalacaoEscolhida.getLotacao()) { //se instalação estiver cheia, remover um animal 
            System.out.println("Esta instalação já está cheia, Que animal deseja retirar?");
            System.out.println("Lotação da instalação: " + instalacaoEscolhida.getLotacao() + " - Animais nesta Instalação:");
            boolean animalEscolhidoRemover = false;

            while (!animalEscolhidoRemover) {
                for (Animal animal : instalacaoEscolhida.getAnimais()) {
                    System.out.println("id: " + animal.getId() + " Nome: " + animal.getNome() + " Especie: " + animal.getEspecieString());
                }
                System.out.println("Insira o ID do animal a remover:");

                try {
                    idAnimalRemover = scan.nextInt();
                    for (Animal animal : instalacaoEscolhida.getAnimais()) {
                        if (animal.getId() == idAnimalRemover) {
                            animalRemover = animal;
                            animalEscolhidoRemover = true;
                            break;
                        }
                    }
                    if (!animalEscolhidoRemover) {
                        System.out.println("Não existe animal com este id nesta instalação");
                    }
                } catch (InputMismatchException e) {
                    menuManager.printInputDoTipoErrado();
                    scan.next();
                }
            }
            dados = new ArrayList<>(); //prepara dados para guardar no historico
            dados.add("ID_animal:");
            dados.add(animalRemover.getIdString());
            dados.add(" Nome_Animal: ");
            dados.add(animalRemover.getNome());
            fileManager.guardaRegistoHistorico("RETIRAR_INSTALAÇÃO", dados, ano); //guarda no historico
            instalacaoEscolhida.getAnimais().remove(animalRemover);
            animalRemover.setInstalacao();
        }
            
        if(animalEscolhido.getInstalacao()!= null){
            animalEscolhido.getInstalacao().getAnimais().remove(animalEscolhido);
            animalEscolhido.setInstalacao();
        }
        instalacaoEscolhida.getAnimais().add(animalEscolhido);

        dados = new ArrayList<>(); //prepara dados para guardar no historico
        dados.add("ID_animal:");
        dados.add(animalEscolhido.getIdString());
        dados.add("Nova_Instalação:");
        dados.add(instalacaoEscolhida.getIdString());
        fileManager.guardaRegistoHistorico("MOVER", dados, ano); //guarda no historico       

        animalEscolhido.setInstalacao(instalacaoEscolhida);

    }


    public void calendarioChines() {
        if(especies.isEmpty()){
            System.out.println("Não existem especies no zoo");
            return;
        }
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
                especieString = "dragão";
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
                System.out.println("Cancelado");
                return;
            }
        }
        for (Especie especie : especies) { //procura a especie correcta e aumenta atratividade
            if (especie.getNome().toLowerCase().equals(especieString)) {
                especie.aumentaAtratividade();
            }
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
                bebe = new Animal(this.getAnimalId(), fileManager.getRandomNameFromFile(), 0, animal.getEspecie());
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
                fileManager.guardaRegistoHistorico("NASCEU", dados, ano); //imprime no historico

            }
        }
        System.out.println("Nascimentos: ");
        for (int i = 0; i < animaisBebes.size(); i++) { //imprime animais que nasceram
            adicionarListaAnimais(animaisBebes.get(i));
            menuManager.printAnimal(animaisBebes.get(i));
            System.out.println();

        }
        System.out.println("Óbitos:"); //imprime animais que morreram
        for (int i = 0; i < animaisMortos.size(); i++) {
            animais.remove(animaisMortos.get(i));
            if (animaisMortos.get(i).getInstalacao() != null) {
                animaisMortos.get(i).morre(this);
            }
            menuManager.printAnimal( animaisMortos.get(i));
            System.out.println();
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
            menuManager.printAnimal(animalEscapado);
            System.out.println(" " + animalEscapado.getEspecie().getCarateristicas().get(carateristicaEscolhida).getAbilidade());
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
                fileManager.guardaRegistoHistorico("FUJIU", dados, ano); //guarda no historico

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
                        menuManager.printAnimal(animal);
                        System.out.println(" Valor de venda: " + animal.calculaPreco() * 0.8);
                        
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

                        fileManager.guardaRegistoHistorico("VENDA", dados, ano); //guarda no historico

                    } catch (Exception e) {
                        menuManager.printCancelado();
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
    
    public void aumentaIdade() {
        for (Animal animal : animais) {
            animal.incrementaIdade();
        }
    }    

    

   
    

    public void adicionarListaAnimais(Animal animal) {
        animais.add(animal);

    }

    public void adicionarCarateristica() { //metodo auxilidar para adicionar carateristicas em runtime
        try {
            String nome;
            double custos;
            String abilidade;

            while (true) {
                try {
                    System.out.println("Nome:");
                    nome = scan.next();
                    System.out.println("custos:");
                    custos = (Double) (scan.nextDouble());
                    System.out.println("abilidade:");
                    abilidade = scan.next();
                    break;
                } catch (InputMismatchException e) {
                    menuManager.printInputDoTipoErrado();
                    scan.next();
                }
            }
            Carateristica carateristica = new Carateristica(nome, custos, abilidade);
            carateristicas.add(carateristica);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao adicionar a característica");
        }
    }
    
    public void adicionarEspecie() {//metodo auxiliar para adicionar especies em runtime
        try {
            int atratividade;
            String nome;
            int raridade;
            int esperancaVida;
            int apetiteReprodutivo;

            while (true) {
                try {
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
                    break;
                } catch (InputMismatchException e) {
                    menuManager.printInputDoTipoErrado();
                    scan.next();
                }
            }
            Especie especie = new Especie(atratividade, nome, raridade, esperancaVida, apetiteReprodutivo, this, true);
            especies.add(especie);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao adicionar a espécie");
        }
    }




    public void adicionarMutacao() {
        try {
            String nome;
            int modAtract;
            while (true) {
                try {
                    System.out.println("Nome:");
                    nome = scan.next();
                    System.out.println("modAtract:");
                    modAtract = scan.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    menuManager.printInputDoTipoErrado();
                    scan.next();
                }
            }
            Mutacao mutacao = new Mutacao(nome, modAtract);
            mutacoes.add(mutacao);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao adicionar a mutação");
        }
    } //metodo auxiliar para adicionar mutações em runtime


    public void adicionarCarateristicaAEspecie() {
        try {
            for (Especie especie : especies) {
                System.out.println("1- " + especie.getNome());
            }
            int opcao;
            while (true) {
                try {
                    opcao = scan.nextInt();
                    if (opcao <= 0 || opcao > especies.size()) {
                        throw new IndexOutOfBoundsException();
                    }
                    break;
                } catch (InputMismatchException e) {
                    menuManager.printInputDoTipoErrado();
                    scan.next();
                } catch (IndexOutOfBoundsException e) {
                    menuManager.printInputForaDoIntervalo();
                }
            }
            System.out.println(especies.get(opcao - 1).getNome());
            int i = 0;
            for (Carateristica carateristica : carateristicas) {
                System.out.println(i + "- " + carateristica.getNome());
                i++;
            }

            int opcao2;
            while (true) {
                try {
                    opcao2 = scan.nextInt();
                    if (opcao2 < 0 || opcao2 >= carateristicas.size()) {
                        throw new IndexOutOfBoundsException();
                    }
                    break;
                } catch (InputMismatchException e) {
                    menuManager.printInputDoTipoErrado();
                    scan.next();
                } catch (IndexOutOfBoundsException e) {
                    menuManager.printInputForaDoIntervalo();
                }
            }
            especies.get(opcao - 1).adicionarCarateristica(carateristicas.get(opcao2));
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao adicionar a característica à espécie");
        }
    } //metodo auxiliar para adicionar carateristicas a especies em runtime

    public void adicionarMutacaoAAnimal() {
        try {
            int i = 0;
            for (Animal animal : animais) {
                System.out.println(i + "- " + animal.getNome());
                i++;
            }
            int opcao;
            while (true) {
                try {
                    opcao = scan.nextInt();
                    if (opcao < 0 || opcao >= animais.size()) {
                        throw new IndexOutOfBoundsException();
                    }
                    break;
                } catch (InputMismatchException e) {
                    menuManager.printInputDoTipoErrado();
                    scan.next();
                } catch (IndexOutOfBoundsException e) {
                    menuManager.printInputForaDoIntervalo();
                }
            }
            System.out.println(animais.get(opcao).getNome());
            i = 0;
            for (Mutacao mutacao : mutacoes) {
                System.out.println(i + "- " + mutacao.getNome());
                i++;

            }
            int opcao2;
            while (true) {
                try {
                    opcao2 = scan.nextInt();
                    if (opcao < 0 || opcao2 >= mutacoes.size()) {
                        throw new IndexOutOfBoundsException();
                    }
                    break;
                } catch (InputMismatchException e) {
                    menuManager.printInputDoTipoErrado();
                    scan.next();
                } catch (IndexOutOfBoundsException e) {
                    menuManager.printInputForaDoIntervalo();
                }
            }
            animais.get(opcao).addMutacao(mutacoes.get(opcao2));
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao adicionar a mutação ao animal");
        }
    } //metodo auxiliar para adicionar mutações a um animal em runtime

    // GETS E SETS
    public ArrayList<Carateristica> getCarateristicas() {
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
    
    public FileManager getFileManager(){
        return fileManager;
    }
    
    public void setCarateristicas(ArrayList<Carateristica> carateristicas){
        this.carateristicas = carateristicas;
    }
    public void setEspecies(ArrayList<Especie> especies){
        this.especies = especies;
    }
    public void setMutacoes(ArrayList<Mutacao> mutacoes){
        this.mutacoes = mutacoes;
    }
    public void setInstalacoes(ArrayList<Instalacao> instalacoes){
        this.instalacoes = instalacoes;
    }
    public void setAnimais(ArrayList<Animal> animais){
        this.animais = animais;
    }
    
 
    public ArrayList<Especie>  getEspecies(){
        return especies;
    }
    public ArrayList<Mutacao>  getMutacoes(){
        return mutacoes;
    }
    public ArrayList<Instalacao>  getInstalacoes(){
        return instalacoes;
    }
    public ArrayList<Animal>  getAnimais(){
        return animais;
    }

    void setAno(int ano) {
        this.ano = ano;
        System.out.println("ano ano");
    }
    void setSaldo(double saldo){
        this.saldo = saldo;
        System.out.println("saldo saldo");
    }
    
    
}
