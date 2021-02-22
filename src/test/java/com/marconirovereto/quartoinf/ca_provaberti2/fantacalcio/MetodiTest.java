/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconirovereto.quartoinf.ca_provaberti2.fantacalcio;

import com.sun.net.httpserver.Authenticator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nico
 */
public class MetodiTest {
    
    public MetodiTest() {
    }

    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addAllenatore method, of class Metodi.
     */
    @org.junit.jupiter.api.Test
    public void testAddAllenatore() {
        System.out.println("addAllenatore");
        String nome = "PaoloAllenatore";
        String squadra = "TestNapoli";
        Metodi.addAllenatore(nome, squadra);
        //essendo il secondo test controllo se c'è più di un dato, il primo è il giocatore del primo test
        if (Metodi.personeList.size()<=1){
            fail("Non è stato aggiunto nessun Allenatore");
        }
    }

    /**
     * Test of addGiocatore method, of class Metodi.
     */
    @org.junit.jupiter.api.Test
    public void testAddGiocatore() {
        System.out.println("addGiocatore");
        String nome = "PaoloGiocatore";
        String squadra = "TestJuve";
        Metodi.addGiocatore(nome, squadra);
        //essendo il primo test che fa controllo se l'array è vuoto
        if (Metodi.personeList.isEmpty()){
            fail("Non è stato aggiunto nessun Giocatore");
        }
    }
    
}
