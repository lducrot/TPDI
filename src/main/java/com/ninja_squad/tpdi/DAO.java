/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ninja_squad.tpdi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 *
 * @author Lauriane
 */
public class DAO {
    
    public DAO () {}
    
    private String FICHIER_SPECTACLE = "spectacle.txt";
    
    public List<String> readSpectacles() throws IOException 
    {
        return Files.readAllLines(new File(FICHIER_SPECTACLE).toPath(), StandardCharsets.UTF_8);
    }
        
    public void write(String name) throws IOException 
    {
        try (BufferedWriter writer = Files.newBufferedWriter(new File(FICHIER_SPECTACLE).toPath(), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            writer.write(name);
            writer.newLine();
        }
    }
    
}
