/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Referent;

/**
 *
 * @author Stefan
 */
public class VratiReferentaPoBrojuRk extends ApstraktnaGenerickaOperacija{

    @Override
    protected void izvrsiValidaciju(OpstiDomenskiObjekat odo) throws Exception {
        if (odo instanceof Referent) {

        } else {
            throw new Exception("Greska u paramteru!");
        }
    }

    @Override
    protected Object izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        
         Referent ref=((Referent) odo);
        try {
            
            ref.setUslovPretrage("BrojRadneKnjizice="+ref.getBrojRadneKnjizice());
      
    return dbbr.vrati(ref);


        } catch (Exception e) {
            rollbackTransakcije();
            throw new Exception("Dogodila se greska prilikom ucitavanja  referenta sa Brojem rk:" + ref.getBrojRadneKnjizice() + ". Greska:" + e.getMessage());
        }
    }
    
}
