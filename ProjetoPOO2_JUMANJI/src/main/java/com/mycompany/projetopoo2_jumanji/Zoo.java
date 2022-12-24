/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo2_jumanji;

import java.util.*;
import java.io.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Objects;

/**
 *
 * @author vigab
 */
public class Zoo {

    private Scanner scan = new Scanner(System.in);
    private Random rand = new Random();
    private List<Animal> animais = new ArrayList<>();
    private List<Instalacao> instalacoes = new ArrayList();
    private List<Especie> especies = new ArrayList();
    private List<Carateristica> carateristicas = new ArrayList();
    private List<Mutacao> mutacoes = new ArrayList();
    private int ano = 2000;
    private double saldo = 1000000;
    private double rendimento = 0;
    private double saldoUsadoAnimais = 0;
    private double saldoUsadoInstalacoes = 0;
    private int animalId = 0;

    public static void main(String[] args) {

        //criação do Zoo
        Zoo newZoo = new Zoo();

        newZoo.startMenu(); //chamando a função para iniciar a aplicação  

    }

    public void startMenu() {

        int opcao = 0;
        boolean sair = false;
        LoadShit();
        while (!sair) {
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
            /*System.out.println("1.Metodo teste 1                             ");
            System.out.println("2.Metodo teste 2    ");
            System.out.println("3.Metodo teste 3                   ");
            System.out.println("4.Metodo teste 4                               ");*/

            System.out.println("O que deseja fazer:                               ");
            try {
                opcao = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input!");
                scan.nextLine();
            }
            switch (opcao) {
                case 1 -> {
                    AdquirirAnimal();
                    break;
                }
                case 2 -> {
                    AdquirirAnimalComCarateristica();
                    break;
                }
                case 3 -> {
                    ConstruirInstalacao();
                    break;
                }
                case 4 -> {
                    ColocarAnimalEmInstalacao();
                    break;
                }
                case 5 -> {
                    CalendarioChines();
                    break;
                }
                case 6 -> {

                    ListarAnimais();
                    break;
                }
                case 7 -> {
                    ListarAnimaisComCarateristica();
                    break;
                }
                case 8 -> {
                    ListarAnimaisComMutacao();
                    break;
                }
                case 9 -> {
                    ListarInstalacoes();
                    break;
                }
                case 10 -> {
                    FamiliaAnimal();
                    break;
                }
                case 11 -> {
                    ListarObituarios();
                    break;
                }
                case 12 -> {
                    Historico();
                    break;
                }
                case 13 -> {
                    PeriodoContabilistico();
                    break;
                }
                case 14 -> {
                    Jumanji();
                    break;
                }
                case 15 -> {
                    sair = true;
                    break;
                }
                case 20 -> {
                    AdicionarCarateristicaAEspecie();
                    break;
                }
                case 21 -> {
                    PrintEspecie();
                    break;
                }
                case 22 -> {
                    PrintCarateristicas();
                    break;
                }
                case 23 -> {
                    PrintInstalacoes();
                    break;
                }
                case 24 -> {
                    LoadShit();
                    break;
                }
                case 25 -> {
                    SaveShit();
                    break;
                }
                case 30 -> {
                    AdicionarCarateristica();
                    break;
                }
                case 31 -> {
                    AdicionarEspecie();
                    break;
                }
                case 32 -> {
                    AdicionarMutacao();
                    break;
                }
                case 33 -> {
                    AdicionarCarateristicaAEspecie();
                    break;
                }
                case 34 -> {
                    AdicionarMutacaoAAnimal();
                    break;
                }
                case 35 -> {
                    animais.get(0).AdicionarObito(this);
                    break;
                }
                case 36 -> {
                    probMutacoes(animais.get(0), true);
                }

            }
        }

    }
//fazer os métodos aqui

    public void GuardaRegistoHistorico(String tipo, ArrayList<String> dados) {
        try {
            FileWriter fw = new FileWriter("Historico.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            fw.write("\n" + tipo + " ");

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

    public void Metodo1() {

        System.out.println("Metodo 1");
    }

    public void Metodo2() {
        System.out.println("Metodo 2");
    }

//      METODOS MENU PRINCIPAL
    public void AdquirirAnimal() {
        int id;
        Animal animal;
        int raridade;

        List<Animal> animaisOpcoes = new ArrayList();

        for (int i = 1; i <= 3; i++) {
            raridade = (int) (Math.pow(Math.random(), 4) * 9 + 1);

            List<Especie> especieOpcoes = new ArrayList();
            while (especieOpcoes.isEmpty()) {
                for (Especie especie : especies) {
                    if (especie.getRaridade() == raridade) {
                        especieOpcoes.add(especie);
                    }

                }
                raridade--;
            }

            int randomEspecie = (int) (Math.random() * (especieOpcoes.size() - 1));
            int idade = (int) (Math.random() * especieOpcoes.get(randomEspecie).getEsperancaVida());
            try {
                animal = new Animal(this.getAnimalId(), GetRandomNameFromFile(), idade, especieOpcoes.get(randomEspecie));
                animaisOpcoes.add(animal);
                System.out.println("opção nº" + i + ": " + animal.getNome() + ", " + especieOpcoes.get(randomEspecie).getNome() + ", idade: " + animal.getIdade() + " Preço: " + animal.calculaPreco());
            } catch (Exception e) {
                System.out.println("especie invalida");
            }

        }
        System.out.println("Qual animal é que deseja adquirir?");
        int opcao = 0;

        try {
            opcao = scan.nextInt();

            if (saldo >= animaisOpcoes.get(opcao - 1).calculaPreco()) {
                AdicionarListaAnimais(animaisOpcoes.get(opcao - 1));
                incrementaAnimalId();
                probMutacoes(animaisOpcoes.get(opcao-1));
                saldo -= animaisOpcoes.get(opcao - 1).calculaPreco();
                saldoUsadoAnimais += animaisOpcoes.get(opcao - 1).calculaPreco();
                
                ArrayList<String> dados = new ArrayList<>();
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
                GuardaRegistoHistorico("COMPRA", dados);
            }

        } catch (Exception e) {
            System.out.println("Invalid input!");
            scan.nextLine();
        }

    }

    public void AdquirirAnimalComCarateristica() {
        int opcao;
        System.out.println("001");
        List<Especie> possiveisEspecies = new ArrayList<>();
        int i = 0;
        for (Carateristica carateristica : carateristicas) {
            System.out.println(i + ") " + carateristica.getNome());
            i++;
        }
        System.out.println("Selecione o numero carateristica que quer:");
        opcao = scan.nextInt();

        for (Especie especie : especies) {
            for (Carateristica carateristicaProcura : especie.getCarateristicas()) {
                if (carateristicaProcura.equals(carateristicas.get(opcao))) {
                    possiveisEspecies.add(especie);
                }
            }
        }
        if (!possiveisEspecies.isEmpty()) {
            int randomEspecie = (int) (Math.random() * (possiveisEspecies.size() - 1));
            int idade = (int) (Math.random() * possiveisEspecies.get(randomEspecie).getEsperancaVida());
            Animal animal = new Animal(this.getAnimalId(), GetRandomNameFromFile(), idade, possiveisEspecies.get(randomEspecie));
            if (saldo >= animal.calculaPreco()) {
                System.out.println("Animal adquirido: " + animal.getEspecie().getNome() + " custo: " + animal.calculaPreco());
                AdicionarListaAnimais(animal);
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
                GuardaRegistoHistorico("COMPRA", dados);
            }
        } else {
            System.out.println("Não existem especies com estas carateristicas");
        }

    }

    public void ConstruirInstalacao() {
        String opcao = "";
        System.out.println("Tamanho da instalação [Pequena, Media, Grande]: ");
        opcao = scan.next();

        int lotacao[] = new int[3];
        double preco[] = new double[3];
        switch (opcao) {
            case "pequena":
                System.out.println("Resultado do concurso:");
                for (int i = 0; i < 3; i++) {
                    lotacao[i] = (int) ((Math.random() * 4) + 1);
                    preco[i] = (double) (lotacao[i] * ((Math.random() * 250) + 500));
                    System.out.println("Empresa " + (i + 1) + " - Lotação:" + lotacao[i] + " Preço: " + preco[i]);
                }
                break;

            case "media":
                System.out.println("Resultado do concurso:");
                for (int i = 0; i < 3; i++) {
                    lotacao[i] = (int) ((Math.random() * 5) + 5);
                    preco[i] = (double) (lotacao[i] * ((Math.random() * 250) + 500));
                    System.out.println("Empresa " + (i + 1) + " - Lotação:" + lotacao[i] + " Preço: " + preco[i]);
                }
                break;

            case "grande":
                System.out.println("Resultado do concurso:");
                for (int i = 0; i < 3; i++) {
                    lotacao[i] = (int) ((Math.random() * 5) + 10);
                    preco[i] = (double) (lotacao[i] * ((Math.random() * 250) + 500));
                    System.out.println("Empresa " + (i + 1) + " - Lotação:" + lotacao[i] + " Preço: " + preco[i]);
                }
                break;
            default:
                System.out.println("Seleção invalida");
                ConstruirInstalacao();
                return;

        }
        System.out.println("Escolha o numero da empresa ou quaquer outra chave para cancelar:");
        opcao = scan.next();
        int indice = 0;
        try {
            indice = Integer.parseInt(opcao);
        } catch (Exception e) {
            System.out.println("Construção de Instalação cancelada.");
        }
            
        if ((indice == 1 || indice == 2 || indice == 3) && saldo >= preco[indice - 1]) {
            Instalacao instalacao = new Instalacao(instalacoes.size(), lotacao[indice - 1], -1);
            instalacoes.add(instalacao);
            saldo -= preco[indice-1];
            saldoUsadoInstalacoes += preco[indice-1];
            ArrayList<String> dados = new ArrayList<>();
            dados.add("ID:");
            dados.add(instalacao.getIdString());
            dados.add("Lotação:");
            dados.add(instalacao.getLotacaoString());
            GuardaRegistoHistorico("CONTRUÇÃO", dados);
        }
    }

    public void ColocarAnimalEmInstalacao() {
        String opcao = "";
        Animal animalEscolhido = null;
        int idAnimal;
        Instalacao instalacaoEscolhida;
        int idInstalacao;
        for (Animal animal : animais) {
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
            ColocarAnimalEmInstalacao();
            return;
        }
        boolean animalEncontrado = false;
        for (Animal animal : animais) {
            System.out.println("DEBUG: " + idAnimal + " " + animal.getId());
            if (idAnimal == animal.getId()) {

                animalEscolhido = animal;
                break;
            }
        }
        if (animalEscolhido == null) {
            System.out.println("Não existe animal com este ID");
            ColocarAnimalEmInstalacao();
            return;
        }
        idInstalacao = 0;
        instalacaoEscolhida = null;
        while (instalacaoEscolhida == null) {
            System.out.println("Escolha uma das instalações: ");
            int i = 0;
            for (Instalacao instalacao : instalacoes) {
                i++;
                System.out.print(i + ") Lotação: " + instalacao.getLotacao());
                if (instalacao.getAnimal() != null) {
                    System.out.print(" Animal: " + (instalacao.getAnimal()).getNome() + " Especie: " + (instalacao.getAnimal()).getEspecieString());
                }
                System.out.println();
            }
            opcao = scan.next();
            try {
                idInstalacao = Integer.parseInt(opcao);
                instalacaoEscolhida = instalacoes.get(idInstalacao - 1);
            } catch (Exception e) {
                System.out.println("Id invalido");
            }

        }

        ArrayList<String> dados = new ArrayList<>();

        if (instalacaoEscolhida.getAnimal() != null) {
            //Retira animal se já tiver
            dados = new ArrayList<>();

            dados.add("ID_animal:");
            dados.add(instalacaoEscolhida.getAnimal().getIdString());
            GuardaRegistoHistorico("RETIRAR_INSTALAÇÃO", dados);

            instalacaoEscolhida.getAnimal().setInstalacao();

        }
        //Mete animal na instalação
        instalacaoEscolhida.setAnimal(animalEscolhido);
        instalacaoEscolhida.setAnimalID(animalEscolhido.getId());

        dados = new ArrayList<>();
        dados.add("ID_animal:");
        dados.add(animalEscolhido.getIdString());
        dados.add("Nova_Instalação:");
        dados.add(instalacaoEscolhida.getIdString());
        GuardaRegistoHistorico("MOVER", dados);

        if (animalEscolhido.getInstalacao() != null) {
            //Retira animal da instalação se tiver
            animalEscolhido.getInstalacao().setAnimal();

            dados = new ArrayList<>();
            dados.add("ID_animal:");
            dados.add(instalacaoEscolhida.getAnimal().getIdString());
            GuardaRegistoHistorico("RETIRAR_DE_INSTALAÇÃO", dados);

        }
        animalEscolhido.setInstalacao(instalacaoEscolhida);

    }

    public void CalendarioChines() {
        int opcao;
        opcao = (this.getAno() % 12) + 1;
        switch (opcao) {
            case 1 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("macaco")) {
                        animal.getEspecie().AumentaAtratividade();
                        System.out.println("A atratividade do " + animal.getEspecie().getNome() + " aumentou para " + animal.getEspecie().getRaridade());
                            
                    }
                }
            }
            case 2 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("galinha")) {
                        animal.getEspecie().AumentaAtratividade();
                        System.out.println("A atratividade do " + animal.getEspecie().getNome() + " aumentou para " + animal.getEspecie().getRaridade());
                    }
                }
            }
            case 3 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("cao")) {
                        animal.getEspecie().AumentaAtratividade();
                        System.out.println("A atratividade do " + animal.getEspecie().getNome() + " aumentou para " + animal.getEspecie().getRaridade());
                    }
                }
            }
            case 4 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("porco")) {
                        animal.getEspecie().AumentaAtratividade();
                        System.out.println("A atratividade do " + animal.getEspecie().getNome() + " aumentou para " + animal.getEspecie().getRaridade());
                    }
                }
            }
            case 5 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("rato")) {
                        animal.getEspecie().AumentaAtratividade();
                        System.out.println("A atratividade do " + animal.getEspecie().getNome() + " aumentou para " + animal.getEspecie().getRaridade());

                    }
                }
            }
            case 6 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("vaca")) {
                        animal.getEspecie().AumentaAtratividade();
                        System.out.println("A atratividade do " + animal.getEspecie().getNome() + " aumentou para " + animal.getEspecie().getRaridade());
                    }
                }
            }
            case 7 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("tigre")) {
                        animal.getEspecie().AumentaAtratividade();
                        System.out.println("A atratividade do " + animal.getEspecie().getNome() + " aumentou para " + animal.getEspecie().getRaridade());
                    }
                }
            }
            case 8 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("coelho")) {
                        animal.getEspecie().AumentaAtratividade();
                        System.out.println("A atratividade do " + animal.getEspecie().getNome() + " aumentou para " + animal.getEspecie().getRaridade());
                    }
                }
            }
            case 9 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("dragao")) {
                        animal.getEspecie().AumentaAtratividade();
                        System.out.println("A atratividade do " + animal.getEspecie().getNome() + " aumentou para " + animal.getEspecie().getRaridade());
                    }
                }
            }
            case 10 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("serpente")) {
                        animal.getEspecie().AumentaAtratividade();
                        System.out.println("A atratividade do " + animal.getEspecie().getNome() + " aumentou para " + animal.getEspecie().getRaridade());
                    }
                }
            }
            case 11 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("cavalo")) {
                        animal.getEspecie().AumentaAtratividade();
                        System.out.println("A atratividade do " + animal.getEspecie().getNome() + " aumentou para " + animal.getEspecie().getRaridade());
                    }
                }
            }
            case 12 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("cabra")) {
                        animal.getEspecie().AumentaAtratividade();
                        System.out.println("A atratividade do " + animal.getEspecie().getNome() + " aumentou para " + animal.getEspecie().getRaridade());
                    }
                }
            }
            default -> {
                System.out.println("blablabla");
            }
        }
        
    }

    public void ListarAnimais() {
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

    public void ListarAnimaisComCarateristica() {
        int opcao;
        int i = 0;
        for (Carateristica carateristica : carateristicas) {

            System.out.println(i + ") " + carateristica.getNome());
            i++;
        }
        System.out.println("Selecione o numero carateristica que quer:");
        opcao = scan.nextInt();
        for (Animal animal : animais) {
            for (Carateristica carateristicaAnimal : animal.getEspecie().getCarateristicas()) {
                if (carateristicaAnimal.equals(carateristicas.get(opcao))) {
                    System.out.println(animal.getNome() + " id: " + animal.getId() + " Especie: " + animal.getEspecie().getNome() + " Idade: " + animal.getIdade());
                }
            }
        }
    }

    public void ListarAnimaisComMutacao() {
        int opcao;
        boolean encontrado = false;
        int i = 1;
        for (Mutacao mutacao : mutacoes) {
            System.out.println(i + ") " + mutacao.getNome());
            i++;
        }
        System.out.println("Selecione o numero da Mutação que quer:");
        opcao = scan.nextInt();
        for (Animal animal : animais) {
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

    public void ListarInstalacoes() {
        System.out.println("Instalações do zoo: ");

        for (Instalacao instalacao : instalacoes) {
            System.out.print("id: " + instalacao.getId() + " Lotação:" + instalacao.getLotacao());
            if (instalacao.getAnimal() == null) {
                System.out.println(" - Esta instalação não possui nenhum animal ");
            } else {
                System.out.println(" - Nome: " + instalacao.getAnimal().getNome() + " Espécie: " + instalacao.getAnimal().getEspecie().getNome());
            }
        }
    }

    public void FamiliaAnimal() {
        System.out.println("Instalações:");
        for (Instalacao instalacao : instalacoes) {
            System.out.print("id: " + instalacao.getId() + " Lotação: " + instalacao.getLotacao());
            if (instalacao.getAnimal() != null) {
                System.out.print(" - Animal - Nome: " + instalacao.getAnimal().getNome() + " id:" + instalacao.getAnimal().getId());
            } else {
                System.out.println();
            }
        }
        System.out.println("Animais");
        PrintAnimal();

        System.out.println("Especies:");
        PrintEspecie();

        System.out.println("Carateristicas:");
        PrintCarateristicas();

    }

    public void Historico() {
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

    public void PeriodoContabilistico() {
        double custoAnual = 0;
        List<Animal> animaisBebes = new ArrayList();
        List<Animal> animaisMortos = new ArrayList();
        Animal bebe;
        aumentaIdade();
        
        for (Animal animal : animais) {
            if (animal.CheckVida()) {
                animal.Morre(this);
                animaisMortos.add(animal);
            }
            if (animal.CheckNascimento()) {
                bebe = new Animal(this.getAnimalId(), GetRandomNameFromFile(), 0, animal.getEspecie());
                incrementaAnimalId();
                probMutacoes(bebe);
                animaisBebes.add(bebe);
                
                ArrayList<String> dados = new ArrayList<>();
                dados.add("Nome: ");
                dados.add(bebe.getNome());
                dados.add("Id: ");
                dados.add(bebe.getIdString());
                dados.add("Idade: ");
                dados.add(bebe.getIdadeString());
                dados.add("Especie: ");
                dados.add(bebe.getEspecie().getNome());
                dados.add("Mutações: ");
                for(Mutacao mutacao:bebe.getMutacoesLista() ){
                    dados.add(mutacao.getNome() + " ");
                }                
                GuardaRegistoHistorico("NASCEU", dados);
                
            }
        }
        System.out.println("Nascimentos: ");
        for (int i = 0; i < animaisBebes.size(); i++) {
            AdicionarListaAnimais(animaisBebes.get(i));
            System.out.println("Nome: " + animaisBebes.get(i).getNome() + ". Espécie: " + animaisBebes.get(i).getEspecie().getNome());
        }
        System.out.println("Óbitos:");
        for (int i = 0; i < animaisMortos.size(); i++) {
            animais.remove(animaisMortos.get(i));
            if (animaisMortos.get(i).getInstalacao() != null) {
                animaisMortos.get(i).Morre(this);
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
        saldo -= custoAnual;
        saldo += rendimentoAnimais();
        prejuizo();
    }

    public void Jumanji() {
        
        System.out.println("----JUMANJI----");
        List<Animal> animaisEscapados = new ArrayList<>();
        for (Animal animal : animais) {
            if (Math.random() >= .7) {
                animaisEscapados.add(animal);
            }
        }
        for(Animal animalEscapado: animaisEscapados ){
            int numCarateristicas = animalEscapado.getEspecie().getCarateristicas().size();
            int carateristicaEscolhida =(int) (Math.random()*(numCarateristicas-1));
            System.out.println(animalEscapado.getNome()+ " " + animalEscapado.getEspecie().getCarateristicas().get(carateristicaEscolhida).getAbilidade());
            if (Math.random() >= .5) {
                System.out.println("Este animal escapou");
                if(animalEscapado.getInstalacao() != null){
                    animalEscapado.getInstalacao().setAnimal();
                }
                
                animalEscapado.setInstalacao();
                animais.remove(animalEscapado);
                
                ArrayList<String> dados = new ArrayList<>();
                dados.add("Nome: ");
                dados.add(animalEscapado.getNome());
                dados.add("Id: ");
                dados.add(animalEscapado.getIdString());
                dados.add("Idade: ");
                dados.add(animalEscapado.getIdadeString());
                dados.add("Especie: ");
                dados.add(animalEscapado.getEspecie().getNome());
                dados.add("Mutações: ");
                for(Mutacao mutacao:animalEscapado.getMutacoesLista() ){
                    dados.add(mutacao.getNome() + " ");
                }                
                GuardaRegistoHistorico("FUJIU", dados);

            }
        }

    }
    public double rendimentoAnimais() {
        double rendimentosAnimais = 0;
        for (Animal animal : animais) {
            if (animal.getInstalacao() != null) {
                rendimentosAnimais += rendimentosAnimais * animal.getInstalacao().getLotacao();

                if (animal.getMutacoesLista() != null) {
                    for (Mutacao mutacao : animal.getMutacoesLista()) {
                        rendimentosAnimais += ((mutacao.getModAtract() + animal.getEspecie().getAtratividadeBase()) * animal.getEspecie().getRaridade());
                    }
                } else {
                    
                    rendimentosAnimais += animal.getEspecie().getAtratividadeBase() * animal.getEspecie().getRaridade();
                    
                }
            }
        }
        return rendimentosAnimais;
    }
    public void prejuizo() {
        int mutacaoModAttract = 0;
        double vendaAnimal = 0;
        if (saldo < 0) {
            System.out.println("Houve prejuízo este ano");
            while (saldo < 0) {
                for (Animal animal : animais) {
                    if (animal.getMutacoesLista() != null) {
                        for (Mutacao mutacao : animal.getMutacoesLista()) {
                            mutacaoModAttract += mutacao.getModAtract();
                        }
                        System.out.println("Animal vendido devido ao prejuízo: " + animal.getNome() + " especie: " + animal.getEspecie().getNome());
                        saldo += ((100 + mutacaoModAttract + animal.getEspecie().getAtratividadeBase()) * animal.getEspecie().getRaridade());

                    } else {
                        System.out.println("Animal vendido devido ao prejuízo: " + animal.getNome() + " especie: " + animal.getEspecie().getNome());
                        saldo += (25 + animal.getEspecie().getAtratividadeBase()) * animal.getEspecie().getRaridade();

                    }
                    animais.remove(animal);
                    if (animal.getInstalacao() != null) {
                        animal.getInstalacao().setAnimal();
                    }
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
                    GuardaRegistoHistorico("VENDA", dados);

                }

            }
        }
    }
    public double custosManutencao() {
        double custosManutencao = 0;
        for (Instalacao instalacao : instalacoes) {
            custosManutencao += instalacao.getCustoManutencao() * instalacao.getLotacao();
            if (instalacao.getAnimal() != null) {
                custosManutencao += instalacao.getCustoRacao() * (instalacao.getAnimal().getEspecie().getRaridade());
                custosManutencao += instalacao.getCustoCuidadores() * (instalacao.getAnimal().getEspecie().getRaridade());
            }
        }
        return custosManutencao;
    }


    public void probMutacoes(Animal animal) {
        for (Mutacao mutacao : mutacoes) {
            int i = -Objects.hash(animal.getId(), animal.getEspecie(), animal.getIdade(), animal.getMutacoesLista(), mutacao.getNome(), mutacao.getModAtract()) % 20 ;
            if(i == 0){
                animal.addMutacao(mutacao);
            }
        }
    }


    //      METODOS PARA CARREGAR / SALVAR
    public void SaveShit() {
        SalvarEspecies();
        SalvarAnimais();
        SalvarMutacoes();
        SalvarInstalacoes();
        SalvarCarateristicas();
    }

    public void LoadShit() {
        CarregarCarateristicas();
        CarregarEspecies();
        CarregarMutacoes();
        CarregarInstalacoes();
        CarregarAnimais();

    }

    public void CarregarEspecies() {
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

                    especie = new Especie(atratividade, linha[1], raridade, esperancaVida, this, true);
                    if (linha.length > 4) {

                        for (int i = 4; i < linha.length; i++) {

                            for (Carateristica carateristica : carateristicas) {
                                if (carateristica.getNome().equals(linha[i])) {
                                    especie.getCarateristicas().add(carateristica);
                                }
                            }
                        }

                    }

                    System.out.println("Especies ok");

                } catch (Exception e) {
                    System.out.println("Ficheiro corrupto, Cancelado");
                    return;
                }

                especies.add(especie);

            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");

            return;
        }

    }

    public void SalvarEspecies() {
        try {
            FileWriter writer = new FileWriter("Especies.txt");
            for (Especie especie : especies) {
                writer.write(especie.getAtratividadeBase() + " ");
                writer.write(especie.getNome() + " ");
                writer.write(especie.getRaridade() + " ");
                writer.write(especie.getEsperancaVida() + " ");
                for (Carateristica carateristica : especie.getCarateristicas()) {
                    writer.write(carateristica.getNome() + " ");
                }
                writer.write("\n");
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Erro 001");
        }
    }

    public void CarregarAnimais() {
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
                            instalacao.setAnimal(animal);
                        }
                    }

                    if (linha.length > 5) {
                        for (int i = 6; i <= linha.length; i++) {
                            for (Mutacao mutacao : mutacoes) {
                                if (mutacao.getNome().toLowerCase().equals(linha[i].toLowerCase())) {
                                    animal.getMutacoesLista().add(mutacao);
                                }
                            }
                        }
                    }

                    System.out.println("Animais ok");

                } catch (Exception e) {
                    System.out.println("Ficheiro corrupto, Cancelado");
                    return;
                }
                animais.add(animal);

            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            return;
        }
        System.out.println("001");
        atualizarId();
        System.out.println("003");
    }

    public void SalvarAnimais() {
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

    public void CarregarCarateristicas() {
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
                    System.out.println("Carateristicas ok");
                } catch (Exception e) {
                    System.out.println("Ficheiro corrupto, Cancelado");
                    return;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            return;
        }

    }

    public void SalvarCarateristicas() {
        try {
            FileWriter writer = new FileWriter("Carateristicas.txt");
            for (Carateristica carateristica : carateristicas) {
                writer.write(carateristica.getNome() + " ");
                writer.write(carateristica.getCustos() + " ");
                writer.write(carateristica.getAbilidade() + " ");
                writer.write("\n");
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Erro 001");
        }
    }

    public void CarregarMutacoes() {
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
                    System.out.println("Mutacoes ok");

                } catch (Exception e) {
                    System.out.println("Ficheiro corrupto, Cancelado");
                    return;
                }

            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            return;
        }

    }

    public void SalvarMutacoes() {
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

    public void CarregarInstalacoes() {
        String[] linha;
        Instalacao instalacao;

        try {
            File ficheiro = new File("Instalacoes.txt");
            Scanner reader = new Scanner(ficheiro);
            while (reader.hasNextLine()) {
                String dados = reader.nextLine();
                linha = dados.split(" ");
                try {
                    int id = Integer.parseInt(linha[0]);
                    int lotacao = Integer.parseInt(linha[1]);
                    int animalId = Integer.parseInt(linha[2]);

                    instalacao = new Instalacao(id, lotacao, animalId);
                    instalacoes.add(instalacao);
                    System.out.println("Instalacoes ok");
                } catch (Exception e) {
                    System.out.println("Ficheiro corrupto, Cancelado");
                    return;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            return;
        }

    }

    public void SalvarInstalacoes() {
        try {
            FileWriter writer = new FileWriter("Instalacoes.txt");
            for (Instalacao instalacao : instalacoes) {
                writer.write(instalacao.getId() + " ");
                writer.write(instalacao.getLotacao() + " ");
                writer.write(instalacao.getAnimalId() + " ");
                writer.write("\n");
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Erro 001");
        }
    }

    //      METODOS AUXILIARES
    public void atualizarId() {

        int maiorId = 0;
        for (Animal animal : animais) {
            if (animal.getId() > maiorId) {
                maiorId = animal.getId();
            }
        }
        try {
            String[] linha;
            File ficheiro = new File("Obitos.txt");
            Scanner reader = new Scanner(ficheiro);
            while (reader.hasNextLine()) {
                String dados = reader.nextLine();
                linha = dados.split(" ");
                try {

                    if (Integer.parseInt(linha[1]) > maiorId) {

                        maiorId = Integer.parseInt(linha[1]);
                    }
                } catch (Exception e) {

                    System.out.println("Ficheiro corrupto, Cancelado");
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        System.out.println("007");
        animalId = maiorId + 1;
    }

    public void aumentaIdade() {
        for (Animal animais : animais) {
            animais.incrementaIdade();
        }
    }

    public void ListarObituarios() {
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
                    System.out.println("Ficheiro corrupto, Cancelado");
                    return;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            return;
        }

    }

    public String GetRandomNameFromFile() {
        int numNomes = 0;
        String[] nome = new String[10];
        String linha = "";
        Scanner reader;
        int rand = 0;
        try {
            File ficheiro = new File("Nomes.txt");
            reader = new Scanner(ficheiro);
            while (reader.hasNextLine()) {
                reader.nextLine();
                numNomes++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        rand = (int) (Math.random() * numNomes);
        try {
            File ficheiro = new File("Nomes.txt");
            reader = new Scanner(ficheiro);
            for (int i = 0; i < rand; i++) {
                linha = reader.nextLine();
            }
            nome = linha.split(" ", 2)[0].split(",", 2);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return nome[0];
    }

    public void PrintAnimal() {
        for (Animal animal : animais) {
            System.out.println(animal.getNome() + " id: " + animal.getId() + " Especie: " + animal.getEspecie().getNome() + " Idade: " + animal.getIdade());
        }
    }

    public void PrintEspecie() {
        for (Especie especie : especies) {
            System.out.print(especie.getNome());
            for (Carateristica carateristica : especie.getCarateristicas()) {
                System.out.print(" " + carateristica.getNome());
            }
            System.out.println();
        }
    }

    public void PrintCarateristicas() {
        for (Carateristica carateristica : carateristicas) {
            System.out.println(carateristica.getNome());
        }
    }

    public void PrintInstalacoes() {
        for (Instalacao instalacao : instalacoes) {
            System.out.println(instalacao.getId() + " Lotação:" + instalacao.getLotacao());
        }
    }

    public void AdicionarListaAnimais(Animal animal) {
        animais.add(animal);

    }

    public void AdicionarCarateristica() {
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

    public void AdicionarEspecie() {
        int atratividade;
        String nome;
        int raridade;
        int esperancaVida;

        System.out.println("atratividade:");
        atratividade = scan.nextInt();
        System.out.println("nome:");
        nome = scan.next();
        System.out.println("raridade:");
        raridade = scan.nextInt();
        System.out.println("esperancaVida:");
        esperancaVida = scan.nextInt();

        Especie especie = new Especie(atratividade, nome, raridade, esperancaVida, this, true);
        especies.add(especie);
    }

    public void AdicionarMutacao() {
        String nome;
        int modAtract;

        System.out.println("Nome:");
        nome = scan.next();
        System.out.println("modAtract:");
        modAtract = scan.nextInt();

        Mutacao mutacao = new Mutacao(nome, modAtract);
        mutacoes.add(mutacao);
    }

    public void AdicionarCarateristicaAEspecie() {
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

                especies.get(opcao - 1).adicionaCarateristica(carateristicas.get(opcao2));

            }
        }
    }

    public void AdicionarMutacaoAAnimal() {
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
                System.out.println("002");
                animais.get(opcao).addMutacao(mutacoes.get(opcao2));
                System.out.println("003");
            }
        }
    }

    // GETS E SETS
    public List<Carateristica> getCarateristicas() {
        return carateristicas;
    }

    public int getAno() {
        return ano;
    }
    public int getAnimalId(){
        return animalId;
    }
    public void incrementaAnimalId(){
        animalId++;
    }
}
