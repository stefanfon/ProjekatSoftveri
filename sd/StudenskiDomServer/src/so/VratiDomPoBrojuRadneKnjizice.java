/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Referent;
import domen.StudenskiDom;
import java.util.List;

/**
 *
 * @author Stefan
 */
public class VratiDomPoBrojuRadneKnjizice extends ApstraktnaGenerickaOperacija{

    @Override
    protected void izvrsiValidaciju(OpstiDomenskiObjekat odo) throws Exception {
        if(odo instanceof StudenskiDom){
            
        }else {
            throw new Exception("Greska u paramteru!");
        }
    }

    @Override
    protected Object izvrsi(OpstiDomenskiObjekat odo) throws Exception {
            StudenskiDom sd=(StudenskiDom)odo;
            
            sd.setUslovPretrage("BrojRadneKnjizice='"+sd.getReferenti().getBrojRadneKnjizice()+"'");
         
            return dbbr.vrati(sd);
            
            
            
    }
    
}
