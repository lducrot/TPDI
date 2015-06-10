/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ninja_squad.tpdi;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import com.ninja_squad.tpdi.DAO;

/**
 *
 * @author Lauriane
 */
public class Service {
    
    private DAO dao;
        
    public Service(DAO dao) {
        this.dao = dao;
    }
    
    public void creer(String name) throws IOException 
    {
        if (containsSpectacle(name)) {
            System.out.println("Ce spectacle est déjà dans la liste.");
        } else {
            
            dao.write(name);
        }
    }

    public List<String> trouver(String name) throws IOException {
        List<String> names = dao.readSpectacles();
        return names.stream().filter(spectacle -> spectacle.contains(name)).collect(Collectors.toList());
    }

    public boolean containsSpectacle(String name) throws IOException {
        List<String> names = dao.readSpectacles();
        return names.stream().anyMatch(spectacle -> spectacle.equals(name));
    }
    
}
