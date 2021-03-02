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
    
    public Allenatore(String nomeCognome, String squadra, String ruolo){
        this.nomeCognome=nomeCognome;
        this.squadra=squadra;
        this.ruolo=ruolo;
    }
    
    @Override
    public String toString(){
        return nomeCognome;
    }

    public String getNomeCognome() {
        return nomeCognome;
    }    
    public String getRuolo() {
        return ruolo;
    }

    public void setNomeCognome(String nomeCognome) {
        this.nomeCognome = nomeCognome;
    }


}
