/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Gost;
import domen.OpstiDomenskiObjekat;
import domen.Prenociste;

/**
 *
 * @author Stefan
 */
public class SacuvajGosta extends ApstraktnaGenerickaOperacija{
    @Override
    protected void izvrsiValidaciju(OpstiDomenskiObjekat odo) throws Exception {
        if (odo instanceof Gost) {

        } else {
            throw new Exception("Greska u parametru!");
        }
    }
    
    @Override
    protected Object izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        
        Gost gost=(Gost)odo;
        
       

            return dbbr.kreiraj(gost);
        
       
    }
}
