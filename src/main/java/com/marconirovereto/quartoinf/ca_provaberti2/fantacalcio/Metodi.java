/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconirovereto.quartoinf.ca_provaberti2.fantacalcio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Nico
 */

public class Metodi implements Serializable{
    //Hash map usata come database di persone, usa la squadra come key
    public static Map<String, List<Persona>> dbPersone;
    
    //personeList viene usata come tramite tra gli oggetti e l'hashmap
    public static List<Persona> personeList = new ArrayList<>();
    
    //lista delle squadre presenti nell'hashmap
    //viene aggiornata assieme alla map nel metodo updateDb()
    public static String squadre[];
    
    //metodi per istanziare giocatori
    //appena istanziati vengono aggiunti a personeList
    
    public static void addAllenatore(String nome, String squadra, String ruolo){
        
        Allenatore a1 = new Allenatore(nome, squadra,ruolo);
        
        personeList.add(a1);
        
    }    
    
    public static void addGiocatore(String nome, String squadra,String ruolo){
        
        Giocatore g1 = new Giocatore(nome, squadra,ruolo);
        
        personeList.add(g1);
    }
    
    
    //updateDb() gestisce completamente l'aggiornamento di hashmap e lista squadre presenti in hashmap
    //da chiamare ad ogni modifica del database
    
    public static void updateDb(){
        //creo un array di stringhe grande il numero di squadre presenti
        //lo popolo con le key usate nell'hashmap per avere una lista di squadre presenti
        
        dbPersone = Metodi.personeList.stream().collect(Collectors.groupingBy(w -> w.squadra)); 
        squadre= new String[dbPersone.size()];
        int i=0;
        for (String str : dbPersone.keySet()){
            squadre[i]=str;
            i++;
        }          
        //popolo l'hashmap usando come key la squadra con lo stream delle persone presenti nell'array personeList
        
        
             
      
    }
   


}
