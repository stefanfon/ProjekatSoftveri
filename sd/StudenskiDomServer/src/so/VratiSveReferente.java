/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Referent;
import domen.Student;

/**
 *
 * @author Stefan
 */
public class VratiSveReferente extends ApstraktnaGenerickaOperacija{

    @Override
    protected void izvrsiValidaciju(OpstiDomenskiObjekat odo) throws Exception {
        if (odo instanceof Referent) {

        } else {
            throw new Exception("Greska u parametru!");
        }
    }

    @Override
    protected Object izvrsi(OpstiDomenskiObjekat odo) throws Exception {
            
           
            return dbbr.vrati(odo);
    }
    
}
