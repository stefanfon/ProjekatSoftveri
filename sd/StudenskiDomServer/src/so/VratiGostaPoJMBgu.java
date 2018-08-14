/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Gost;
import domen.OpstiDomenskiObjekat;

/**
 *
 * @author Stefan
 */
public class VratiGostaPoJMBgu extends ApstraktnaGenerickaOperacija{
    @Override
    protected void izvrsiValidaciju(OpstiDomenskiObjekat odo) throws Exception {
        if (odo instanceof Gost) {

        } else {
            throw new Exception("Greska u paramteru!");
        }
    }

    @Override
    protected Object izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        Gost sdd = (Gost) odo;
        try {
            
            sdd.setUslovPretrage("JMBGGosta='"+sdd.getJmbg()+"'");
            return dbbr.vrati(sdd);
        } catch (Exception e) {
            rollbackTransakcije();
            throw new Exception("Dogodila se greska prilikom ucitavanja  studenta sa idjem:" + sdd.getJmbg() + ". Greska:" + e.getMessage());
        }
    }
}
