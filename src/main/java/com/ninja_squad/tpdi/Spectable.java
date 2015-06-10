/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ninja_squad.tpdi;

//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

/**
 *
 * @author Lauriane
 */
public class Spectable {
    
    public static final String FICHIER_SPECTACLES = "spectacle.txt";
    
    public static void main(String[] args) throws IOException {
        
        boolean stop = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!stop) {
           System.out.println("Bonjour");
           String command = scanner.next();
           if (command.equals("trouver")) {
               String eol = scanner.nextLine().trim();
               List<String> spectacles = trouver(eol);
               spectacles.forEach(System.out::println);
           }
           else if (command.equals("creer")) {
               String eol = scanner.nextLine();
               creer(eol);
           }
           else if (command.equals("quitter")) {
               stop = true;
           }
            
        }


    }
    
    
    private static List<String> trouver(String nomSpec) throws IOException {
        
        List<String> names = lireSpectacles();
        return names.stream()
                .filter(spectacle -> spectacle.contains(nomSpec))
                .collect(Collectors.toList());
    }
    
    private static List<String> lireSpectacles() throws IOException {
        return Files.readAllLines(new File(FICHIER_SPECTACLES).toPath(), StandardCharsets.UTF_8);
    }
    
    private static void creer(String nomSpec) throws IOException {
        
        if (containsSpectacle(nomSpec)) {
            System.out.println("Ce spectacle est déjà dans la liste");
        } else {
            ecrire(nomSpec);
        }
    }
    
    private static String ecrire(String nomSpec) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(new File(FICHIER_SPECTACLES).toPath(), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) 
        {
            writer.write(nomSpec);
            writer.newLine();
        } 
        return "";
    }
    
    private static boolean containsSpectacle(String nomSpec) throws IOException {
        List<String> names = lireSpectacles();
        return names.stream().anyMatch(spectacle -> spectacle.equals(nomSpec)); 
    } 
    
}
