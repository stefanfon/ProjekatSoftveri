/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Prenociste;
import domen.Student;

/**
 *
 * @author Stefan
 */
public class SacuvajPrenociste extends ApstraktnaGenerickaOperacija{
    @Override
    protected void izvrsiValidaciju(OpstiDomenskiObjekat odo) throws Exception {
        if (odo instanceof Prenociste) {

        } else {
            throw new Exception("Greska u parametru!");
        }
    }
    
    @Override
    protected Object izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        
        Prenociste prenociste=(Prenociste)odo;
        
       

            return dbbr.kreiraj(prenociste);
        
       
    }
}
