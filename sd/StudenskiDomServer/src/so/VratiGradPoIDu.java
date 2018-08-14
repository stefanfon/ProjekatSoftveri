/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Grad;
import domen.OpstiDomenskiObjekat;
import domen.Referent;

/**
 *
 * @author Stefan
 */
public class VratiGradPoIDu extends ApstraktnaGenerickaOperacija{
    @Override
    protected void izvrsiValidaciju(OpstiDomenskiObjekat odo) throws Exception {
        if (odo instanceof Grad) {

        } else {
            throw new Exception("Greska u paramteru!");
        }
    }

    @Override
    protected Object izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        
         Grad gr=((Grad) odo);
        try {
            gr.setUslovPretrage(gr.vratiUslovZaNadjiSlog());
            
         return dbbr.vrati(gr);
    
        } catch (Exception e) {
            rollbackTransakcije();
            throw new Exception("Dogodila se greska prilikom ucitavanja  grada saa ptt :" + gr.getPttBroj()+ ". Greska:" + e.getMessage());
        }
    }
}
