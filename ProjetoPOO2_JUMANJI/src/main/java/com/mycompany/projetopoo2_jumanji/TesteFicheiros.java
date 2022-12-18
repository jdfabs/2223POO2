/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo2_jumanji;
import java.util.*;
import java.io.*;

/**
 *
 * @author vigab
 */
public class TesteFicheiros {
    private ArrayList<String> animais = new ArrayList<>();
    
    public void main(String[] args )throws IOException{
        
        FileReader inStream = new FileReader("C:\\Users\\vigab\\OneDrive\\Documents\\GitHub\\2223POO2\\Animais.txt");
        BufferedReader bR = new BufferedReader(inStream);
        
        String linha = bR.readLine();
        while (linha != null){
            
            System.out.println(linha);
            animais.add(linha);
            linha = bR.readLine();
            
        }
        System.out.println(animais.size());
        //bR.close;
        
    }
    
}
