/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ninja_squad.tpdi;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import com.ninja_squad.tpdi.Service;


/**
 *
 * @author Lauriane
 */
public class Main {
    private static DAO dao = new DAO();
    private static Service service = new Service(dao);
    
    public static void main(String[] args) throws IOException {
        boolean stop = false;

        
        Scanner sc = new Scanner(System.in);
        // List<String> file = Files.readAllLines(fichier, StandardCharsets.UTF_8);
        while (!stop) {
            System.out.println("Bonjour");
            String chaineUtilisateur = sc.next();
            if (chaineUtilisateur.equals("trouver")) {
                String finDeLigne = sc.nextLine();
                List<String> spectacles = service.trouver(finDeLigne);
                spectacles.forEach(System.out::println);
            } else if (chaineUtilisateur.equals("creer")) {
                String nom = sc.nextLine();
                service.creer(nom);
            } else if (chaineUtilisateur.equals("quitter")) {
                stop = true;
            } else {
                System.out.println("Vous n'avez pas tapé la bonne commande !");
            }
        }
    }




}

