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
    private double saldoUsado = 0;


public static void main(String[] args ){
        
        //criação do Zoo
        Zoo newZoo = new Zoo();
        
        newZoo.startMenu(); //chamando a função para iniciar a aplicação  
        
        
    }
public void startMenu(){

        int opcao = 0;
        boolean sair = false;
        LoadShit();
        while(!sair){
            System.out.println("==================================================");
            System.out.println("     Bem vindo ao Zoo da UMa Ano: "+ ano +"   Saldo: "+ saldo + ". ");
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
            switch(opcao){
                            case 1 ->{
                                AdquirirAnimal();     
                                break;
                            }
                            case 2 ->{
                                AdquirirAnimalComCarateristica();
                                break;
                            }
                            case 3 ->{
                                ConstruirInstalacao();
                                break;
                            }
                            case 4 ->{
                                ColocarAnimalEmInstalacao();
                                break;
                            }
                            case 5 ->{
                                CalendarioChines();
                                break;
                            }
                            case 6 ->{

                                ListarAnimais();
                                break;
                            }
                            case 7 ->{
                                ListarAnimaisComCarateristica();
                                break;
                            }
                            case 8 ->{
                                ListarAnimaisComMutacao();
                                break;
                            }
                            case 9 ->{
                                ListarInstalacoes();
                                break;
                            }
                            case 10 ->{
                                FamiliaAnimal();
                                break;
                            }
                            case 11 ->{
                                Obituario();
                                break;
                            }
                            case 12 ->{
                                //Historic();
                                break;
                            }
                            case 13 ->{
                                PeriodoContabilistico();
                                break;
                            }
                            case 14 ->{
                                //Jumanji();
                                break;
                            }
                            case 15 ->{
                                sair = true;
                                break;
                            }
                            case 20 ->{
                                 AdicionarCarateristicaAEspecie();
                                break;
                            }
                            case 21 ->{
                                PrintEspecie();
                                break;
                            }
                            case 22 ->{
                                PrintCarateristicas();
                                break;
                            }
                            case 23 ->{
                                PrintInstalacoes();
                                break;
                            }
                            case 24 ->{
                                LoadShit();
                                break;
                            }
                            case 25 ->{
                                SaveShit();
                                break;
                            }
                            case 30 ->{
                                AdicionarCarateristica();
                                break;
                            }
                            case 31 ->{
                                AdicionarEspecie();
                                break;
                            }
                            case 32 ->{
                                AdicionarMutacao();
                                break;
                            }
                            case 33 ->{
                                AdicionarCarateristicaAEspecie();
                                break;
                            }
                            case 34 ->{
                                AdicionarMutacaoAAnimal();
                                break;
                            }
                            case 35 ->{
                                AdicionarObituario(animais.get(0));
                                break;
                            }
                            
                            
                        }
        }
    
}
//fazer os métodos aqui









public void Metodo1(){

    System.out.println("Metodo 1");
}
public void Metodo2(){
    System.out.println("Metodo 2");
}



//      METODOS MENU PRINCIPAL
    public void AdquirirAnimal() {
        int id;
        Animal animal;
        int raridade ;
        
        
        
        List<Animal> animaisOpcoes = new ArrayList();
        
        for (int i = 1; i <= 3; i++) {
            raridade = (int) (Math.pow(Math.random(), 4) * 9 + 1);
            System.out.println(raridade);
            List<Especie> especieOpcoes = new ArrayList();
            while (especieOpcoes.isEmpty()) {
                for (Especie especie : especies) {
                    if (especie.getRaridade() == raridade) {
                        especieOpcoes.add(especie);
                    }
                    
                }
                raridade--;
            }
            
            int randomEspecie = (int) (Math.random() * (especieOpcoes.size()-1));
            int idade = (int) (Math.random() * especieOpcoes.get(randomEspecie).getEsperancaVida());   
            try{
            animal = new Animal(animais.size(),GetRandomNameFromFile(), idade, especieOpcoes.get(randomEspecie));
            animaisOpcoes.add(animal );
            System.out.println("opção nº" + i + ": "+ animal.getNome()+", " + especieOpcoes.get(randomEspecie).getNome() + ", idade: "+ animal.getIdade() + " Preço: " + animal.calculaPreco());
            }
            catch(Exception e){
                System.out.println("especie invalida");
            }       
            
        }
        System.out.println("Qual animal é que deseja adquirir?");
        int opcao = 0;

        try {
            opcao = scan.nextInt();
           
            if(saldo >= animaisOpcoes.get(opcao - 1).calculaPreco()){

                AdicionarListaAnimais(animaisOpcoes.get(opcao - 1));
                saldo -= animaisOpcoes.get(opcao - 1).calculaPreco();
                saldoUsado += animaisOpcoes.get(opcao - 1).calculaPreco();
            }
            
        } catch (Exception e) {
            System.out.println("Invalid input!");
            scan.nextLine();
        }

    }

    public void AdquirirAnimalComCarateristica() {
        int opcao;        
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
            Animal animal = new Animal(animais.size(), GetRandomNameFromFile(), idade, possiveisEspecies.get(randomEspecie));
            if (saldo >= animal.calculaPreco()) {
                System.out.println("Animal adquirido: "+ animal.getEspecie().getNome() + " custo: "+ animal.calculaPreco());
                AdicionarListaAnimais(animal);
                saldo -= animal.calculaPreco();
                saldoUsado += animal.calculaPreco();
            }
        }
        else{
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
                    lotacao[i] = (int) ((Math.random() * 75) + 25);
                    preco[i] = (double) (lotacao[i] * ((Math.random() * 250) + 500));
                    System.out.println("Empresa " + (i + 1) + " - Lotação:" + lotacao[i] + " Preço: " + preco[i]);
                }
                break;

            case "media":
                System.out.println("Resultado do concurso:");
                for (int i = 0; i < 3; i++) {
                    lotacao[i] = (int) ((Math.random() * 150) + 100);
                    preco[i] = (double) (lotacao[i] * ((Math.random() * 250) + 500));
                    System.out.println("Empresa " + (i + 1) + " - Lotação:" + lotacao[i] + " Preço: " + preco[i]);
                }
                break;

            case "grande":
                System.out.println("Resultado do concurso:");
                for (int i = 0; i < 3; i++) {
                    lotacao[i] = (int) ((Math.random() * 250) + 250);
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

        if ((indice == 1 || indice == 2 || indice == 3) && saldo >= preco[indice-1]) {
            Instalacao instalacao = new Instalacao(instalacoes.size(), lotacao[indice - 1], -1);
            instalacoes.add(instalacao);
            saldo -= preco[indice-1];
            saldoUsado += preco[indice-1];
        } else {

        }

    }
    
    public void ColocarAnimalEmInstalacao() {
        String opcao = "";
        Animal animalEscolhido = null;
        int idAnimal;
        Instalacao instalacaoEscolhida;
        int idInstalacao;
        for(Animal animal: animais){
            System.out.print("id: " + animal.getId() + " Nome: " + animal.getNome() + " Especie:" + animal.getEspecieString() );
            if(animal.getInstalacao() != null){
                System.out.println(" Instalação: " + animal.getInstalacao().getId());
            }
            else{
                System.out.println();
            }
            
        } 
        System.out.println("Insira o id do Animal a mover: ");        
        opcao = scan.next();
        try{
            idAnimal = Integer.parseInt(opcao);
        }
        catch (Exception e){
            System.out.println("Id invalido");  
            ColocarAnimalEmInstalacao();
            return;
        }
        boolean animalEncontrado = false;
        for(Animal animal : animais){
            System.out.println("DEBUG: " + idAnimal + " " + animal.getId());
            if (idAnimal ==  animal.getId()){
                
                animalEscolhido = animal;
                break;
            }
        }
        if(animalEscolhido == null){
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
               System.out.print(i + ") Lotação: "+ instalacao.getLotacao());
               if(instalacao.getAnimal() != null){
                   System.out.print(" Animal: "+(instalacao.getAnimal()).getNome()+" Especie: " + (instalacao.getAnimal()).getEspecieString());
               }
               System.out.println();
            }
            opcao = scan.next();
            try {
                idInstalacao = Integer.parseInt(opcao);
                instalacaoEscolhida = instalacoes.get(idInstalacao-1);
            } catch (Exception e) {
                System.out.println("Id invalido");
            }

            
        }
        if(instalacaoEscolhida.getAnimal()!= null){
            instalacaoEscolhida.getAnimal().setInstalacao();
        }        
        instalacaoEscolhida.setAnimal(animalEscolhido);
        
        if(animalEscolhido.getInstalacao()!= null){
            animalEscolhido.getInstalacao().setAnimal();
        } 
        animalEscolhido.setInstalacao(instalacaoEscolhida);       
    }
    

    public void CalendarioChines() {
        int opcao;
        System.out.println("Insira o Ano:");
        opcao = (ano % 12) + 1;
        String animal1 ="";
        int atratividade = 0;
        switch (opcao) {
            case 1 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("macaco")) {
                        animal.getEspecie().AumentaAtratividade();
                        atratividade = animal.getEspecie().getAtratividadeBase();
                        animal1 = animal.getEspecie().getNome();
                                
                    }
                }
                
            }
            case 2 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("galinha")) {
                        animal.getEspecie().AumentaAtratividade();
                        atratividade = animal.getEspecie().getAtratividadeBase();
                        animal1 = animal.getEspecie().getNome();
                    }
                }
                
            }
            case 3 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("cao")) {
                        animal.getEspecie().AumentaAtratividade();
                        atratividade = animal.getEspecie().getAtratividadeBase();
                        animal1 = animal.getEspecie().getNome();
                    }
                }
                
            }
            case 4 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("porco")) {
                        animal.getEspecie().AumentaAtratividade();
                        atratividade = animal.getEspecie().getAtratividadeBase();
                        animal1 = animal.getEspecie().getNome();
                    }
                }
               
            }
            case 5 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("rato")) {
                        animal.getEspecie().AumentaAtratividade();
                        atratividade = animal.getEspecie().getAtratividadeBase();
                        animal1 = animal.getEspecie().getNome();
                        
                    }
                }
                
            }
            case 6 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("vaca")) {
                        animal.getEspecie().AumentaAtratividade();
                        atratividade = animal.getEspecie().getAtratividadeBase();
                        animal1 = animal.getEspecie().getNome();
                    }
                }
                
            }
            case 7 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("tigre")) {
                        animal.getEspecie().AumentaAtratividade();
                        atratividade = animal.getEspecie().getAtratividadeBase();
                        animal1 = animal.getEspecie().getNome();
                    }
                }
                
            }
            case 8 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("coelho")) {
                        animal.getEspecie().AumentaAtratividade();
                        atratividade = animal.getEspecie().getAtratividadeBase();
                        animal1 = animal.getEspecie().getNome();
                    }
                }
                
            }
            case 9 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("dragao")) {
                        animal.getEspecie().AumentaAtratividade();
                        atratividade = animal.getEspecie().getAtratividadeBase();
                        animal1 = animal.getEspecie().getNome();
                    }
                }
                
            }
            case 10 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("serpente")) {
                        animal.getEspecie().AumentaAtratividade();
                        atratividade = animal.getEspecie().getAtratividadeBase();
                        animal1 = animal.getEspecie().getNome();
                    }
                }
                
            }
            case 11 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("cavalo")) {
                        animal.getEspecie().AumentaAtratividade();
                        atratividade = animal.getEspecie().getAtratividadeBase();
                        animal1 = animal.getEspecie().getNome();
                    }
                }
                
            }
            case 12 -> {
                for (Animal animal : animais) {
                    if (animal.getEspecie().getNome().toLowerCase().equals("cabra")) {
                        animal.getEspecie().AumentaAtratividade();
                        atratividade = animal.getEspecie().getAtratividadeBase();
                        animal1 = animal.getEspecie().getNome();
                    }
                }
                
            }
            default ->{
                System.out.println("blablabla");
            }
        }   
        System.out.println("A atratividade dos " + animal1+"s aumentou para " + atratividade);
    }

    
    public void ListarAnimais() {   
        for (Animal animal : animais) {
            System.out.print(animal.getNome() + " id: " + animal.getId() + " Especie: " + animal.getEspecie().getNome() + " Idade: " + animal.getIdade());
            if(!animal.getMutacoesLista().isEmpty()){
                System.out.print(" Mutações: ");
                for(Mutacao mutacao: animal.getMutacoesLista()){
                    System.out.print(mutacao.getNome()+ " ");
                }
            }
            System.out.println();
        }
    }

    public void ListarAnimaisComCarateristica() {
        int opcao;             
        int i =0;
        for(Carateristica carateristica: carateristicas){
            
            System.out.println(i+") " + carateristica.getNome());
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
        int i =1;
        for(Mutacao mutacao: mutacoes){
            System.out.println(i+") " + mutacao.getNome());
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
        if(!encontrado){
            System.out.println("Não Existem animais com esta Mutação");
        }       
    }

    public void ListarInstalacoes() {
        System.out.println("Instalações do zoo: ");
        
        for (Instalacao instalacao : instalacoes) {
            System.out.print("id: " + instalacao.getId() + " Lotação:" + instalacao.getLotacao());
            if(instalacao.getAnimal()== null){
                System.out.println(" - Esta instalação não possui nenhum animal ");
            }
            else{
                System.out.println(" - Nome: " + instalacao.getAnimal().getNome() + " Espécie: " + instalacao.getAnimal().getEspecie().getNome());
            }
        }
    }

    public void FamiliaAnimal() {
        System.out.println("Instalações:");
        for(Instalacao instalacao: instalacoes){
            System.out.print("id: " + instalacao.getId() + " Lotação: "+ instalacao.getLotacao() );
            if(instalacao.getAnimal()!= null){
                System.out.print(" - Animal - Nome: " +instalacao.getAnimal().getNome() + " id:" + instalacao.getAnimal().getId() );
            }
            else{
                System.out.println();
            }
        }
        System.out.println("Animais");
        PrintAnimal() ;
        
        System.out.println("Especies:");
        PrintEspecie();
        
        System.out.println("Carateristicas:");
        PrintCarateristicas();
        
        
        
          
    }

    public void Obituario() {
        
            
            
        

        
    }

    public void Historico() {

    }

    public void PeriodoContabilistico() {
        System.out.println("Este ano foi gasto: "+ saldoUsado + " euros.");
        
        
        probMorrer();
        ano++;
        aumentaIdade();
    }

    public void Jumanji() {

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
    
    
    public void CarregarObituario(){
        
    }

    
    
    
            //      METODOS AUXILIARES
    
    public void aumentaIdade(){
        for(Animal animais: animais){
            animais.incrementaIdade();
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
            for(Carateristica carateristica: especie.getCarateristicas()){
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
    
    public void AdicionarListaAnimais(Animal animal){
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


        Especie especie = new Especie(atratividade, nome, raridade,esperancaVida,this,true);
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
    
    public void AdicionarCarateristicaAEspecie(){
        for(Especie especie: especies){
            System.out.println("1- " + especie.getNome());
        }
        int opcao;
        opcao = scan.nextInt();
        if(opcao <= especies.size()){
            System.out.println(especies.get(opcao-1).getNome());
            int i = 0;
            for (Carateristica carateristica : carateristicas) {
                System.out.println(i + "- " + carateristica.getNome());
                i++;

            }
            System.out.println("001");
            int opcao2;
            opcao2 = scan.nextInt();
            System.out.println("002");
            System.out.println(carateristicas.size());
            System.out.println(opcao2);
            if (opcao2 < carateristicas.size()) {
                System.out.println("002");
                especies.get(opcao - 1).adicionaCarateristica(carateristicas.get(opcao2));
                System.out.println("003");
            }
        }
    }
    
     public void AdicionarMutacaoAAnimal(){
         int i = 0;
        for(Animal animal: animais){
            System.out.println(i+"- " + animal.getNome());
            i++;
        }
        int opcao;
        opcao = scan.nextInt();
        if(opcao <= animais.size()){
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
}
