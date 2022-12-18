/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo2_jumanji;
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
/**
 *
 * @author vigab
 */
public class Zoo {
    private Scanner scan = new Scanner(System.in);
    private Random rand = new Random();
    private List<Animal> animais = new ArrayList<>();
    private List<Instalacao> instalacoes = new ArrayList();
    
    


public static void main(String[] args){
        
        //criação do Zoo
        Zoo newZoo = new Zoo();
        
        //chamando a função para iniciar a aplicação
        newZoo.startMenu();        
    }
public void startMenu(){
        
        int opcao = 0;
        boolean sair = false;

        while(!sair){
            System.out.println("==================================================");
            //System.out.println("                                                  ");
            System.out.println("     Bem vindo ao Zoo da UMa                      ");
            //System.out.println("                                                  ");
            System.out.println("==================================================");
            /*System.out.println("1.Adquirir animal aleatório                       ");
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
            System.out.println("                                                  ");*/            
            System.out.println("1.Metodo teste 1                             ");
            System.out.println("2.Metodo teste 2    ");
            System.out.println("3.Metodo teste 3                   ");
            System.out.println("4.Metodo teste 4                               ");
            
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
                                Metodo2();
                                break;
                            }
                            case 3 ->{
                                Metodo3();
                                break;
                            }
                            case 4 ->{
                                Metodo4();
                                break;
                            }
                            case 5 ->{
                                //chineseCallender();
                                sair = true;
                                break;
                            }
                            case 6 ->{
                                //listAnimals();
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


public void Metodo2(){
    for(Animal animal : animais){
        System.out.println(animal.getNome());
    }
    System.out.println("Metodo 2");
}
public void Metodo3(){
    System.out.println("Metodo 3");
}
public void Metodo4(){
    System.out.println("Metodo 4");
}

public void AdicionarEspecies(){
    
    
    
}

public void AdicionaAnimais(){
        
        
    }


public void AdquirirAnimal(){
    //Animal animal = new Animal(1,"Jonny",1,1,"1");
    //AdicionarListaAnimais(animal);
}
public void AdquirirAnimalComCarateristica(){
    
}
public void ConstruirInstalacao(){
    
}
public void ColocarAnimalEmInstalacao(){
    
}
public void CalendarioChines(){
    
}
public void ListarAnimais(){
    
}
public void ListarAnimaisComCarateristica(){
    
}
public void ListarAnimaisComMutacao(){
    
}
public void ListarInstalações(){
    
    
}
public void FamiliaAnimal(){
    
}
public void Obituário(){
    
}
public void Historico(){
    
}
public void PeriodoContabilistico(){
    
}
public void Jumanji(){
    
}













}