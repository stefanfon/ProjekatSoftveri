/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Grad;
import domen.OpstiDomenskiObjekat;

/**
 *
 * @author Stefan
 */
public class VratiSveGradove extends ApstraktnaGenerickaOperacija{
@Override
    protected void izvrsiValidaciju(OpstiDomenskiObjekat odo) throws Exception {
        if (odo instanceof Grad) {

        } else {
            throw new Exception("Greska u paramteru!");
        }
    }

    @Override
    protected Object izvrsi(OpstiDomenskiObjekat odo) throws Exception {
       
        return dbbr.vrati(odo);
    }
    
}
