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
public class Giocatore extends Persona{
    public Giocatore (){
        
    }
    public Giocatore(String nomeCognome, String  squadra, String ruolo){
        this.nomeCognome=nomeCognome;
        this.squadra=squadra;
        this.ruolo=ruolo;
    }

    public String getNomeCognome() {
        return nomeCognome;
    }

    public void setNomeCognome(String nomeCognome) {
        this.nomeCognome = nomeCognome;
    }
    
    public String getRuolo() {
        return ruolo;
    }
    @Override
    public String toString(){
        return nomeCognome;
    }
    
}
