/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Referent;
import domen.StudenskiDom;

/**
 *
 * @author Stefan
 */
public class VratiStudenskiDompoIDu extends ApstraktnaGenerickaOperacija{

    @Override
    protected void izvrsiValidaciju(OpstiDomenskiObjekat odo) throws Exception {
        if(odo instanceof StudenskiDom){
            
        } else {
            throw new Exception("Greska u paramteru!");
        }
    }

    @Override
    protected Object izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        StudenskiDom sdd=(StudenskiDom) odo;
        try {
           sdd.setUslovPretrage("StudenskiDomID="+sdd.getStudenskiDomId());
            StudenskiDom sd= (StudenskiDom) dbbr.vrati(sdd);
            
           
            
            Referent ref=sd.getReferenti();
            ref.setUslovPretrage("BrojRadneKnjizice="+ref.getBrojRadneKnjizice());
            Referent referent1=(Referent)dbbr.vrati(ref);
           
            sd.setReferenti(referent1);
            
            return sd;
                

        } catch (Exception e) {
            rollbackTransakcije();
            throw new Exception("Dogodila se greska prilikom ucitavanja  Studenskog doma sa idjem:" + sdd.getStudenskiDomId() + ". Greska:" + e.getMessage());
        }
    }
    
}
