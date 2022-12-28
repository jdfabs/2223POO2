/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo2_jumanji;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jdfab
 */
public class MenuManager {
    
    private final Scanner scan = new Scanner(System.in);
    
    
    public void printMainMenu(int ano, double saldo) {
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
    }
    
    

    public void listarAnimais(ArrayList<Animal> animais) {
        try {
            if (animais.isEmpty()) {
                System.out.println("Não existem animais");
                return;
            }
            for (Animal animal : animais) {
                System.out.print(animal.getNome() + " ID: " + animal.getId() + " Especie: " + animal.getEspecie().getNome() + " Idade: " + animal.getIdade() + " Atratividade: " + animal.calculaAtratividade());
                if (!animal.getMutacoesLista().isEmpty()) {
                    System.out.print(" Mutações: ");
                    for (Mutacao mutacao : animal.getMutacoesLista()) {
                        System.out.print(mutacao.getNome() + " ");
                    }
                }
                System.out.println();
            }
        } catch (NullPointerException e) {
            System.out.println("Ocorreu um erro ao listar os animais");
        }
    }

    public void listarAnimaisComCarateristica(ArrayList<Animal> animais, ArrayList<Carateristica> carateristicas) {
        if (animais.isEmpty()) {
            System.out.println("Não existem animais no zoo");
            return;
        }
        if (carateristicas.isEmpty()) {
            System.out.println("Não existem carateristicas no zoo");
            return;
        }
        int opcao;
        int i = 0;
        for (Carateristica carateristica : carateristicas) {
            System.out.println(i + ") " + carateristica.getNome());
            i++;
        }
        System.out.println("Selecione o número da característica que quer ou -1 para cancelar:");

        while (true) {
            try {
                opcao = scan.nextInt();
                if (opcao == -1) {
                    System.out.println("Cancelado");
                    return;
                } else if (opcao < 0 || opcao >= carateristicas.size()) { //se id é maior ou menos do que o das carateristicas existentes
                    throw new IndexOutOfBoundsException();
                }
                for (Animal animal : animais) {
                    for (Carateristica carateristicaAnimal : animal.getEspecie().getCarateristicas()) {
                        if (carateristicaAnimal.equals(carateristicas.get(opcao))) {
                            System.out.println(animal.getNome() + " id: " + animal.getId() + " Especie: " + animal.getEspecie().getNome() + " Idade: " + animal.getIdade());
                        }
                    }
                }
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Opção inválida. Por favor, selecione um número válido:");
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Por favor, insira um número inteiro:");
                scan.next();
            }
        }
    }

    public void listarAnimaisComMutacao(ArrayList<Animal> animais, ArrayList<Mutacao> mutacoes) {
        if (animais.isEmpty()) {
            System.out.println("Não existem animais no zoo");
            return;
        }
        if (mutacoes.isEmpty()) {
            System.out.println("Não existem mutacoes no zoo");
            return;
        }
        int opcao;
        boolean encontrado = false;
        int i = 1;
        for (Mutacao mutacao : mutacoes) { //lista todas as mutações para poder escolher
            System.out.println(i + ") " + mutacao.getNome());
            i++;
        }
        System.out.println("Selecione o numero da Mutação que quer ou qualquer outra opção para cancelar:");
        try {
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
        } catch (Exception e) {
            System.out.println("Cancelado");
            return;
        }
        if (!encontrado) {
            System.out.println("Não Existem animais com esta Mutação");
        }
    }

    public void listarInstalacoes(ArrayList<Instalacao> instalacoes) {
        if (instalacoes.isEmpty()) {
            System.out.println("Não existem instalações");
            return;
        }

        for (Instalacao instalacao : instalacoes) {
            System.out.print("id: " + instalacao.getId() + " Lotação:" + instalacao.getLotacao());
            if(!instalacao.getAnimais().isEmpty()){
                System.out.print(" - ID dos Animais na instalação: ");
            }
            for (Animal animal : instalacao.getAnimais()) {
                System.out.print( animal.getId()+ " ");
            }
            System.out.println(" ");
            
        }
        System.out.println( " ");
    }
    
    public void listarEspecies(ArrayList<Especie> especies) {
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

    public void familiaAnimal(ArrayList<Animal> animais, ArrayList<Instalacao> instalacoes, ArrayList<Especie> especies, ArrayList<Carateristica> carateristicas) {
        if (!instalacoes.isEmpty()) {
            System.out.println("Instalações:");
            for (Instalacao instalacao : instalacoes) { //imprime cada instalação e seus animais
                System.out.print("id: " + instalacao.getId() + " Lotação: " + instalacao.getLotacao());
                if (!instalacao.getAnimais().isEmpty()) {
                    System.out.print(" - Animais: ");
                    for (Animal animal : instalacao.getAnimais()) {
                        System.out.print("Id: " + animal.getId() + " Nome: " + animal.getNome());
                    }

                }
                System.out.println();

            }

        }
        if (!animais.isEmpty()) {
            System.out.println("Animais");
            listarAnimais(animais);

        }
        if (!especies.isEmpty()) {
            System.out.println("Especies:");
            printEspecies(especies);

        }
        if (!carateristicas.isEmpty()) {
            System.out.println("Carateristicas:");
            printCarateristicas(carateristicas);

        }

    }

    
    
    
    
    public void printAnimal(Animal animal) {
        System.out.print("ID: " + animal.getId() + " Nome: "+animal.getNome() + " Especie: " + animal.getEspecie().getNome() + " Idade: " + animal.getIdade());
        if(animal.getInstalacao() != null){
            System.out.print(" Instalação: " + animal.getInstalacao().getId());
        }
        
        
    } 

    public void printEspecie(Especie especie) {
        System.out.print("Nome: " + especie.getNome() + " Atratididade Base: " + especie.getAtratividadeBase() + " Raridade: " + especie.getRaridade() + " Esperança de Vida: " + especie.getEsperancaVida() + " Apetite Reprodutivo: " + especie.getApetiteReprodutivo());

    } 

    public void printCarateristica(Carateristica carateristica) {
        System.out.print(carateristica.getNome() + " Abilidade: " + carateristica.getAbilidade());
    }

    public void printInstalacao(Instalacao instalacao) {
        System.out.print(instalacao.getId() + " Lotação:" + instalacao.getLotacao());
    }
    
    

    public void printAnimais(ArrayList<Animal> animais) {
        for (Animal animal : animais) {
            printAnimal(animal);
            System.out.println();
        }
    }

    public void printEspecies(ArrayList<Especie> especies) {
        for (Especie especie : especies) {
            printEspecie(especie);
            System.out.println();
        }
    }

    public void printCarateristicas(ArrayList<Carateristica> carateristicas) {
        for (Carateristica carateristica : carateristicas) {
            printCarateristica(carateristica);
            System.out.println();
        }
    }

    public void printInstalacoes(ArrayList<Instalacao> instalacoes) {
        for (Instalacao instalacao : instalacoes) {
            printInstalacao(instalacao);
            System.out.println();
        }
    }
    
    
    public void printSemDinheiroCancelar(){
        System.out.println("Dinheiro insufeciente seu pobre, cancelando");
    }
    public void printCancelado(){
        System.out.println("Cancelado");
    }
    
    public void printInputForaDoIntervalo(){
        System.out.println("Input invalido, opção fora do intervalo");
    }
    
    public void printInputDoTipoErrado(){
        System.out.println("Input invalido, input do tipo errado!");
    }
    

}
