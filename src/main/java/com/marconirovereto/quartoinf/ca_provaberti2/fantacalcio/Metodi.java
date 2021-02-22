/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconirovereto.quartoinf.ca_provaberti2.fantacalcio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nico
 */
public class Metodi {
    
    public static List<Persona> personeList = new ArrayList<>();
    
    public static void addAllenatore(String nome, String squadra){
        
        Allenatore a1 = new Allenatore(nome, squadra);
        
        personeList.add(a1);
        
    }    
    
    public static void addGiocatore(String nome, String squadra){
        
        Giocatore g1 = new Giocatore(nome, squadra);
        
        personeList.add(g1);
        
    }


}
