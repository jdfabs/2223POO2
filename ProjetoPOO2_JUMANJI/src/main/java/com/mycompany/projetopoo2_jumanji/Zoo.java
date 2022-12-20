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
    


public static void main(String[] args ){
        
        //criação do Zoo
        Zoo newZoo = new Zoo();
        
        newZoo.startMenu(); //chamando a função para iniciar a aplicação  
        
    }
public void startMenu(){
    
        AdquirirAnimal();
        AdquirirAnimal();
        AdquirirAnimal();
        AdquirirAnimal();
        AdquirirAnimal();
        AdquirirAnimal();
        AdquirirAnimal();
        AdquirirAnimal();
        AdquirirAnimal();
        
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
                                //chineseCallender();
                                sair = true;
                                break;
                            }
                            case 6 ->{
                                //listAnimals();
                                Metodo2();
                                break;
                            }
                            case 7 ->{
                                //listGeneticAnimals();
                                break;
                            }
                            case 8 ->{
                                //listMutatedAnimals();
                                break;
                            }
                            case 9 ->{
                                //ListInstalations();
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
                        }
        }
    
}
//fazer os métodos aqui

/*public void ficheiro(){
    File tiposAnimais = new File("C:\\Users\\vigab\\OneDrive\\Documents\\GitHub\\2223POO2\\Animais.txt");
        if (tiposAnimais.exists()){
            System.out.println("Nome: " + tiposAnimais.getName());
            System.out.println("Tamanho: "+ tiposAnimais.length());
        }
        else{
            System.out.println("O ficheiro não existe");
        }
}*/
public void Metodo2(){
    for(Animal animal : animais){
        System.out.println(animal.getNome()+" id: "+ animal.getId() + " Especie: " + animal.getEspecie().getEspecieString() + " Idade: " + animal.getIdade());
    }

    
}
public void Metodo3(){
    System.out.println("Metodo 3");
}
public void Metodo4(){
    System.out.println("Metodo 4");
}


public void AdicionarListaAnimais(Animal animal){
        animais.add(animal);
        
    }


    public void AdquirirAnimal() {

        int raridade = (int) ((Math.pow(Math.random(), 4) * 10) + 1);
        System.out.println(raridade);
        Especie especie = CriaEspecieDeRaridade(raridade);

        int idade = (int) (Math.random() * especie.getEsperancaVida());
        Animal animal = new Animal(animais.size(), GetRandomNameFromFile(), idade, especie);
        AdicionarListaAnimais(animal);
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
                        Instalacao instalacao = new Instalacao(lotacao[indice-1]);
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
    
    
   

    public Especie CriaEspecieDeRaridade(int raridade) {
        Especie especie = null;
        int random = 0;
        while (especie == null) {
            switch (raridade) {
                case 1:
                    random = (int) (Math.random() * 4);
                    switch (random) {
                        case 0:
                            especie = new Cao();
                            break;
                        case 1:
                            especie = new Cabra();
                            break;
                        case 2:
                            especie = new Galinha();
                            break;
                        case 3:
                            especie = new Porco();
                            break;

                    }
                    break;
                case 2:
                    random = (int) (Math.random() * 2);
                    switch (random) {
                        case 0:
                            especie = new Coelho();
                            break;
                        case 1:
                            especie = new Rato();
                            break;
                    }

                    break;
                case 3:
                    raridade--;

                    break;
                case 4:
                    random = (int) (Math.random() * 2);
                    switch (random) {
                        case 0:
                            especie = new Cavalo();
                            break;
                        case 1:
                            especie = new Vaca();
                            break;
                    }
                    break;
                case 5:
                    raridade--;
                    break;
                case 6:
                    raridade--;
                    break;
                case 7:
                    especie = new Macaco();

                    break;
                case 8:
                    especie = new Serpente();
                    break;
                case 9:
                    especie = new Tigre();
                    break;
                case 10:
                    especie = new Dragao();

                    break;
                default:
                    especie = new Porco();
                    break;
            }
        }

        return especie;
    }

    public Especie CriaEspecieDeCarateristica(String carateristica) {
        Especie especie = null;
        int random = 0;

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
        }

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

    }

    public void ListarAnimais() {

    }

    public void ListarAnimaisComCarateristica() {

    }

    public void ListarAnimaisComMutacao() {

    }

    public void ListarInstalações() {

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

}
