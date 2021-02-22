/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marconirovereto.quartoinf.ca_provaberti2.fantacalcio;

/**
 *
 * @author Nico
 */
public class Allenatore extends Persona{
    
    public Allenatore(String nomeCognome, String squadra){
        this.nomeCognome=nomeCognome;
        this.squadra=squadra;
    }
    
    @Override
    public String toString(){
        return nomeCognome;
    }


}
