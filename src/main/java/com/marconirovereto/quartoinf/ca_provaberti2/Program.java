/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconirovereto.quartoinf.ca_provaberti2;

import com.marconirovereto.quartoinf.ca_provaberti2.fantacalcio.*;

import static com.marconirovereto.quartoinf.ca_provaberti2.fantacalcio.Metodi.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.logging.log4j.*;


/**
 *
 * @author Nico
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    
    //Hash map usata come database di persone, usa la squadra come key
    public static Map<String, List<Persona>> dbPersone;
    
    private static final Logger LOG_PRINCIPALE = LogManager.getLogger(Program.class); 
    
    public static String SPAZIATORE = "|||||||||||||||||||||||||||||||||||||||";
    
    
    
    public static void main(String[] args) {
        
        //espressione lambda per aggiornare l'hashmap senza creare un nuovo metodo apposito
        //da chiamare in caso di persone aggiunte, prende le persone inserite nell'arraylist fantacalcio.Metodi.personeList
        //ogni volta che verrà chiamata verrà scritto nei file di log 
        Runnable updateDb = () -> {dbPersone = Metodi.personeList.stream().collect(Collectors.groupingBy(w -> w.squadra)); 
                                   LOG_PRINCIPALE.info("Database updated");};
	
        //aggiungo giocatori tramite metodo(addGiocatore, addAllenatore,
        //prima istanzia oggetti persona e poi li aggiunge ad arraylist
        //poi è necessario aggiornare l'hashmap
        
        //addGiocatore(nomeCognome,squadra);
        addGiocatore("Alessandro del Piero","Juventus");
        addGiocatore("Pavel Nedved","Juventus");
        addGiocatore("Cristiano Ronaldo","Juventus");
        addGiocatore("Giorgio Chiellini","Juventus");
        addGiocatore("Gianluigi Buffon","Juventus");
        addAllenatore("Andrea Pirlo","Juventus");
        
        addGiocatore("Lorenzo Insigne","Napoli");
        addGiocatore("Diego Armando Maradona","Napoli");
        addGiocatore("Dries Mertens","Napoli");
        addGiocatore("Kalidou Koulibaly","Napoli");
        addGiocatore("Pepe Reina","Napoli");
        addAllenatore("Gennaro Gattuso","Napoli");
        
        //aggiorno l'hashmap 
        updateDb.run();
        
    
        
        System.out.println("Giocatori nel database appartenenti alla Juventus");
        System.out.println(dbPersone.get("Juventus"));
        
        
        System.out.println(SPAZIATORE);
        
        System.out.println("Giocatori nel database appartenenti al Napoli");
        System.out.println(dbPersone.get("Napoli"));
        
        System.out.println(SPAZIATORE);
        
        System.out.println("Tutti i giocatori presenti nel database");
        System.out.println(dbPersone.toString());
        
        System.out.println(SPAZIATORE);
        
        System.out.println("Squadre presenti nel database: "+dbPersone.size());        
        
        System.out.println(SPAZIATORE);
        
        //istanzio un Giocatore per provare la serializzazione e deserializzazione
        System.out.println("Provo la serializzazione di un giocatore:");
        
        Giocatore g1 = new Giocatore("AlessandroProva", "SerializProva");
        
        System.out.println("toString del Giocatore da serializzare:\n");
        
        System.out.println("Giocatore: "+g1.toString()+"\nSquadra: "+g1.squadra+"\n");
        
        
        System.out.println(SPAZIATORE);
        
        try {
            FileOutputStream fileOut = new FileOutputStream("giocatore.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(g1);
            out.close();
            System.out.println("Giocatore serializzato correttamente");
            
        } catch (IOException e) {
            System.out.println("Eccezione "+e.getMessage());
            LOG_PRINCIPALE.error("LOG_PRINCIPALE Errore nella serializzazione di un giocatore");
        }
        
        //deserializzazione oggetto
        Giocatore g2 = new Giocatore();
        try {
            FileInputStream fileIn = new FileInputStream("giocatore.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            g2 = (Giocatore) in.readObject();
            System.out.println("Giocatore deserializzato correttamente");
        } catch (IOException | ClassNotFoundException e) {
            
            System.out.println("Eccezione "+e.getMessage());
            LOG_PRINCIPALE.error("LOG_PRINCIPALE Errore nella deserializzazione di un giocatore");
        }
        
        System.out.println(SPAZIATORE);
        
        System.out.println("\nDettagli del giocatore deserializzato:\n");
        System.out.println("Giocatore: "+g2.toString()+"\nSquadra: "+g2.squadra+"\n");
        
        //aggiungo la persona serializzata all'arraylist e aggiorno l'hashmap
        personeList.add(g2);
        updateDb.run();
        
        System.out.println("Giocatori nel database appartenenti alla squadra SerializProva");
        System.out.println(dbPersone.get("SerializProva"));
        
        System.out.println("Squadre presenti nel database: "+dbPersone.size());        
        
        System.out.println(SPAZIATORE);
    }
    
}
