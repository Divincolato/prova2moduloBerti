/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconirovereto.quartoinf.ca_provaberti2;

import com.marconirovereto.quartoinf.ca_provaberti2.fantacalcio.*;

import static com.marconirovereto.quartoinf.ca_provaberti2.fantacalcio.Metodi.*;
import com.marconirovereto.quartoinf.ca_provaberti2.gui.FormSquadre;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Nico
 */
public class Program {

    /**
     */
    

    public static void main(String[] args){

        
        //espressione lambda per aggiornare l'hashmap senza creare un nuovo metodo apposito
        //da chiamare in caso di persone aggiunte, prende le persone inserite nell'arraylist fantacalcio.Metodi.personeList
        //ogni volta che verrà chiamata verrà scritto nei file di log 
        
	
        //aggiungo giocatori tramite metodo(addGiocatore, addAllenatore,
        //prima istanzia oggetti persona e poi li aggiunge ad arraylist
        //poi è necessario aggiornare l'hashmap
        
//        addGiocatore(nomeCognome,squadra);
//        addGiocatore("Alessandro del Piero","Juventus","ATT");
//        addGiocatore("Pavel Nedved","Juventus","CC");
//        addGiocatore("Cristiano Ronaldo","Juventus","ATT");
//        addGiocatore("Giorgio Chiellini","Juventus","DIF");
//        addGiocatore("Gianluigi Buffon","Juventus","POR");
//        addAllenatore("Andrea Pirlo","Juventus","Allenatore");
//        
//        addGiocatore("Lorenzo Insigne","Napoli","ATT");
//        addGiocatore("Diego Armando Maradona","Napoli","ATT");
//        addGiocatore("Dries Mertens","Napoli","ATT");
//        addGiocatore("Kalidou Koulibaly","Napoli","DIF");
//        addGiocatore("Pepe Reina","Napoli","POR");
//        addAllenatore("Gennaro Gattuso","Napoli","Allenatore");
////        
        //aggiorno l'hashmap 
        updateDb();
        try {
            FileOutputStream fileOut = new FileOutputStream("giocatore.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(personeList);
            out.close();
            
        } catch (IOException e) {
            System.out.println("Eccezione "+e.getMessage());
        }
        
        //deserializzazione oggetto
        Giocatore g2 = new Giocatore();

       
        new FormSquadre().setVisible(true);
    }
    
}
