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
    private int ano;
    


public static void main(String[] args ){
        
        //criação do Zoo
        Zoo newZoo = new Zoo();
        
        newZoo.startMenu(); //chamando a função para iniciar a aplicação  
        
    }
public void startMenu(){
    
    carateristicas.add(new Carateristica("Pequeno"));
    carateristicas.add(new Carateristica("Grande"));
    carateristicas.add(new Carateristica("Preto"));
    carateristicas.add(new Carateristica("Branco"));
    
        int opcao = 0;
        boolean sair = false;

        while(!sair){
            System.out.println("==================================================");
            //System.out.println("                                                  ");
            System.out.println("     Bem vindo ao Zoo da UMa                      ");
            //System.out.println("                                                  ");
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
                                //AdquirirAnimalComCarateristica();
                                //SalvarFicheiro(especies);
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
                                //listMutatedAnimals();
                                break;
                            }
                            case 9 ->{
                                ListarInstalacoes();
                                break;
                            }
                            case 10 ->{
                                //animalFamily();
                                break;
                            }
                            case 11 ->{
                                //obituary();
                                break;
                            }
                            case 12 ->{
                                //Historic();
                                break;
                            }
                            case 13 ->{
                                //accountingPeriod();
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
                                PrintAnimal();
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
                        }
        }
    
}
//fazer os métodos aqui


public void PrintAnimal(){
    for(Animal animal : animais){
        System.out.println(animal.getNome()+" id: "+ animal.getId() + " Especie: " + animal.getEspecie().getEspecieString() + " Idade: " + animal.getIdade());
    }
}
public void PrintEspecie(){
    for(Especie especie : especies){
        System.out.println(especie.getNome());
    }    
}
public void PrintCarateristicas(){
    for(Carateristica carateristica : carateristicas){
        System.out.println(carateristica.getNome());
    }
}

public void AdicionarListaAnimais(Animal animal){
        animais.add(animal);
        
    }


    public void AdquirirAnimal() {
        int id;
        List<Animal> animaisOpcoes = new ArrayList();
        for (int i = 1; i <= 3; i++) {
            int random = (int) (Math.random() * 12);
            Especie especie = CriaEspecieDeRaridade(random);

            int idade = (int) (Math.random() * especie.getEsperancaVida());
            Animal animal = new Animal(animais.size(), GetRandomNameFromFile(), idade, especie);

            System.out.println("opção nº" + i + ": " + animal.getEspecie().getNome()+ ", idade: "+ animal.getIdade());
            animaisOpcoes.add(animal);
        }
        System.out.println("Qual animal é que deseja adquirir?");
        int opcao = 0;
        try {
            opcao = scan.nextInt();
            AdicionarListaAnimais(animaisOpcoes.get(opcao - 1));
        } catch (Exception e) {
            System.out.println("Invalid input!");
            scan.nextLine();
        }
    }

    public void AdquirirAnimalComCarateristica() {
        String opcao = "";
        System.out.println("Carateristicas disponiveis: Rodentia, Artiodactyla, Carnivora, Lagomorpha, Fake, Squamata, Perissodactyla, Artiodactyla, Primates, Galliformes, Carnivora, Artiodactyla");
        System.out.println("Ordem do animal que deseja:                               ");
        opcao = scan.next();
        Especie especie = CriaEspecieDeCarateristica(opcao.toLowerCase());
        if (especie == null) {
            System.out.println("Opção Invalida,");
            AdquirirAnimalComCarateristica();
        } else {
            int idade = (int) (Math.random() * especie.getEsperancaVida());
            Animal animal = new Animal(animais.size(), GetRandomNameFromFile(), idade, especie);
            AdicionarListaAnimais(animal);
        }

    }
    
    public void ConstruirInstalacao() {
        String opcao = "";
        System.out.println("Tamanho da instalação [Pequena, Media, Grande]: ");
        opcao = scan.next();
        
        int lotacao[] = new int[3];
        double preco[] = new double[3];
        switch(opcao){
            case "pequena":
                System.out.println("Resultado do concurso:");
                for (int i=0;i<3;i++){
                    lotacao[i] = (int) ((Math.random() * 75) + 25);
                    preco[i] = (double) (lotacao[i]*((Math.random() * 250)+500));
                    System.out.println("Empresa " + (i+1) + " - Lotação:" + lotacao[i] + " Preço: " + preco[i] );
                }
                break;
                
            case "media":
                System.out.println("Resultado do concurso:");
                for (int i=0;i<3;i++){
                    lotacao[i] = (int) ((Math.random() * 150) + 100);
                    preco[i] = (double) (lotacao[i]*((Math.random() * 250)+500));
                    System.out.println("Empresa " + (i+1) + " - Lotação:" + lotacao[i] + " Preço: " + preco[i] );
                }
                break;
                
            case "grande":
                System.out.println("Resultado do concurso:");
                for (int i=0;i<3;i++){
                    lotacao[i] = (int) ((Math.random() * 250) + 250);
                    preco[i] = (double) (lotacao[i]*((Math.random() * 250)+500));
                    System.out.println("Empresa " + (i+1) + " - Lotação:" + lotacao[i] + " Preço: " + preco[i] );
                }
                break;
            default:
                System.out.println("Seleção invalida" );
                ConstruirInstalacao();
                return;
                
        }
        System.out.println("Escolha o numero da empresa ou quaquer outra chave para cancelar:" );                
                    opcao = scan.next(); 
                    int indice = 0;
                    try{
                        indice = Integer.parseInt(opcao);
                    }
                    catch(Exception e){
                        System.out.println("Construção de Instalação cancelada.");
                    }
                    
                    if(indice == 1 ||indice == 2 || indice == 3){
                        Instalacao instalacao = new Instalacao(instalacoes.size(),lotacao[indice-1]);
                        instalacoes.add(instalacao);
                    }
                    else {
                        
                    }          
           
    }
    
    public void ColocarAnimalEmInstalacao() {
        String opcao = "";
        Animal animalEscolhido = null;
        int idAnimal;
        Instalacao instalacaoEscolhida;
        int idInstalacao;
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
    
    public Especie CriaEspecieDeRaridade(int random) {
        Especie especie = null;
        while (especie == null) {
            switch (random) {
                case 0:
                    especie = new Especie(5, "rato", 1, 4, this);
                    break;
                case 1:
                    especie = new Especie(10, "vaca", 3, 8, this);
                    break;
                case 2:
                    especie = new Especie(75, "tigre", 8, 14, this);
                    break;
                case 3:
                    especie = new Especie(20, "coelho", 2, 6, this);
                    break;
                case 4:
                    especie = new Especie(100, "dragão", 10, 69, this);
                    break;
                case 5:
                    especie = new Especie(80, "serpente", 6, 18, this);
                    break;
                case 6:
                    especie = new Especie(50, "cavalo", 4, 13, this);
                    break;
                case 7:
                    especie = new Especie(25, "cabra", 3, 5, this);
                    break;
                case 8:
                    especie = new Especie(60, "macaco", 5, 8, this);
                    break;
                case 9:
                    especie = new Especie(10, "galinha", 2, 5, this);
                    break;
                case 10:
                    especie = new Especie(40, "cão", 4, 15, this);
                    break;
                case 11:
                    especie = new Especie(25, "porco", 3, 10, this);
                    break;
                default:
                    especie = new Especie(2,"cão", 5,15,this);
                    break;
            }
        }

        return especie;
    }

    public Especie CriaEspecieDeCarateristica(String carateristica) {
        Especie especie = null;
        /*int random = 0;

        switch (carateristica) {
            case "rodentia":
                especie = new Rato();
                break;

            case "artiodactyla":
                random = (int) (Math.random() * 2);
                switch (random) {
                    case 0:
                        especie = new Vaca();
                        break;
                    case 1:
                        especie = new Cabra();
                        break;
                    case 2:
                        especie = new Porco();
                        break;
                }

                break;
            case "carnivora":
                random = (int) (Math.random() * 2);
                switch (random) {
                    case 0:
                        especie = new Tigre();
                        break;
                    case 1:
                        especie = new Cao();
                        break;

                }

                break;
            case "lagomorpha":

                especie = new Coelho();

            case "fake":
                especie = new Dragao();
                break;
            case "squamata":
                especie = new Serpente();
                break;
            case "perissodactyla":
                especie = new Cavalo();
                break;
            case "primates":
                especie = new Macaco();
                break;
            case "galliformes":
                especie = new Galinha();
                break;
            default:
                especie = null;
                break;
        }*/

        return especie;
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

    public void CalendarioChines() {
        int opcao = 1996;
        int atratividade = 0;
        String animal1 = "";
        opcao = (ano % 12) + 1;
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
            System.out.print("Nome: "+animal.getNome() + " id: " + animal.getId() + " Especie: " + animal.getEspecie().getNome() + " Idade: " + animal.getIdade()+ " ");
            if(animal.getInstalacao()!=null){
                System.out.print("Lotação da Instalação: " + animal.getInstalacao().getLotacao());
            }
            System.out.println();
        }
    }

    public void ListarAnimaisComCarateristica() {
        /*String opcao = "";
        System.out.println("Carateristicas disponiveis: Rodentia, Artiodactyla, Carnivora, Lagomorpha, Fake, Squamata, Perissodactyla, Artiodactyla, Primates, Galliformes, Carnivora, Artiodactyla");
        System.out.println("Ordem do animal que deseja:                               ");
        opcao = scan.next().toLowerCase();
        
        Especie especie = CriaEspecieDeCarateristica(opcao.toLowerCase());
        if (especie == null) {
            System.out.println("Opção Invalida,");
            ListarAnimaisComCarateristica();
        } else {
            
            for (Animal animal : animais) {
                
                if (animal.getEspecie().getCarateristicas().toLowerCase().equals(opcao.toLowerCase()) ) {
                    
                    System.out.print(animal.getNome() + " id: " + animal.getId() + " Especie: " + animal.getEspecie().getNome() + " Idade: " + animal.getIdade() + " ");
                    if (animal.getInstalacao() != null) {
                        System.out.print("Lotação da Instalação: " + animal.getInstalacao().getLotacao());
                    }
                    System.out.println();
                }
                
            }
        }*/
    }

    public void ListarAnimaisComMutacao() {

    }

    public void ListarInstalacoes() {
        System.out.println("Instalações do zoo: ");
        for (Instalacao instalacao : instalacoes) {
            
            if(instalacao.getAnimal()== null){
                System.out.println("Id: "+ instalacao.getId()+ ".");
                System.out.println("Lotação: "+instalacao.getLotacao() + ".");
                System.out.println("Esta instalação não possui nenhum animal ");
            }
            else{
                System.out.println("Id: "+ instalacao.getId()+ ".");
                System.out.println("Lotação: "+instalacao.getLotacao() + ".");
                System.out.println("Nome: " + instalacao.getAnimal().getNome() + ".");
                System.out.println("Espécie: " + instalacao.getAnimal().getEspecie().getNome() + ".");
            }
            
        }
    }

    public void FamiliaAnimal() {
          
    }

    public void Obituário() {

    }

    public void Historico() {

    }

    public void PeriodoContabilistico() {

    }

    public void Jumanji() {

    }
    
    public List<Carateristica> getCarateristicas() {
        return carateristicas;
    }

    public void CarregarEspecies() {        
        String[] linha;
        Especie especie;
        
        try {
            File ficheiro = new File("Especies.txt");
            Scanner reader = new Scanner(ficheiro);
            while (reader.hasNextLine()) {
                String dados = reader.nextLine();
                linha  = dados.split(" ");
                try{
                    int atratividade = Integer.parseInt(linha[0]); 
                    int raridade = Integer.parseInt(linha[2]); 
                    int esperancaVida = Integer.parseInt(linha[3]);
                    especie = new Especie(atratividade, linha[1], raridade, esperancaVida, this);
                    if(linha.length > 3){
                        for(int i = 4; i <=linha.length; i++){
                            for(Carateristica carateristica: carateristicas){
                                if(carateristica.getNome().toLowerCase().equals(linha[i].toLowerCase())){
                                    especie.getCarateristicas().add(carateristica);
                                }
                            }
                        }
                    }
                    
                }
                catch(Exception e){
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
    
    public void SalvarEspecies() {
        try {
            FileWriter writer = new FileWriter("Especies.txt");
            for (Especie especie : especies) {
                writer.write(especie.getAtratividadeBase() + " ");
                writer.write(especie.getNome() + " ");
                writer.write(especie.getRaridade() + " ");
                writer.write(especie.getEsperancaVida() + " ");
                for(Carateristica carateristica : especie.getCarateristicas()){
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
        Especie especieFinal;
        
        try {
            File ficheiro = new File("Animais.txt");
            Scanner reader = new Scanner(ficheiro);
            while (reader.hasNextLine()) {
                String dados = reader.nextLine();
                linha  = dados.split(" ");
                try{
                    
                    int id = Integer.parseInt(linha[0]); 
                    int idade = Integer.parseInt(linha[2]); 
                    int instalacaoId = Integer.parseInt(linha[4]); 
                    for(Especie especie: especies){
                        if(especie.getEspecieString().equals(linha[3])){
                            especieFinal = especie;
                        }
                    }                   
                    animal = new Animal(id, linha[1], idade, especieFinal);
                    for(Instalacao instalacao: instalacoes){
                        if(instalacao.getId() == instalacaoId){
                            animal.setInstalacao(instalacao);
                            instalacao.setAnimal(animal);
                        }
                    }
                    
                    
                    if(linha.length > 5){
                        for(int i = 6; i <=linha.length; i++){
                            for(Mutacao mutacao: mutacoes){
                                if(mutacao.getNome().toLowerCase().equals(linha[i].toLowerCase())){
                                    animal.getMutacoesLista().add(mutacao);
                                }
                            }
                        }
                    }
                    
                }
                catch(Exception e){
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
    
    public void SalvarAnimais() {
        try {
            FileWriter writer = new FileWriter("Especies.txt");
            for (Animal animal : animais) {
                writer.write(animal.getId() + " ");
                writer.write(animal.getNome() + " ");
                writer.write(animal.getIdade() + " ");
                writer.write(animal.getEspecieString() + " ");
                writer.write(animal.getInstalacao().getId() + " ");
                for (Mutacao mutacao : animal.getMutacoesLista()) {
                    writer.write(mutacao.getNome() + " ");
                }
                writer.write("\n");
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Erro 001");
        }
    }

    public void CarregarCarateristicas() {
        String[] linha;
        Animal animal;
        Especie especieFinal;

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
                        if (especie.getEspecieString().equals(linha[3])) {
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
            FileWriter writer = new FileWriter("Especies.txt");
            for (Animal animal : animais) {
                writer.write(animal.getId() + " ");
                writer.write(animal.getNome() + " ");
                writer.write(animal.getIdade() + " ");
                writer.write(animal.getEspecieString() + " ");
                writer.write(animal.getInstalacao().getId() + " ");
                for (Mutacao mutacao : animal.getMutacoesLista()) {
                    writer.write(mutacao.getNome() + " ");
                }
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
        Animal animal;
        Especie especieFinal;

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
                        if (especie.getEspecieString().equals(linha[3])) {
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
            FileWriter writer = new FileWriter("Especies.txt");
            for (Animal animal : animais) {
                writer.write(animal.getId() + " ");
                writer.write(animal.getNome() + " ");
                writer.write(animal.getIdade() + " ");
                writer.write(animal.getEspecieString() + " ");
                writer.write(animal.getInstalacao().getId() + " ");
                for (Mutacao mutacao : animal.getMutacoesLista()) {
                    writer.write(mutacao.getNome() + " ");
                }
                writer.write("\n");
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Erro 001");
        }
    }
}
