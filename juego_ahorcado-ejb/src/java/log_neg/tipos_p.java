/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log_neg;

import acceso_datos.TiposFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Tipos;

/**
 *
 * @author OEM
 */
@Stateless
@LocalBean
public class tipos_p {

    @EJB
    private TiposFacade tiposFacade;
    public List<Tipos> lispa_t(){
        return tiposFacade.findAll();
    }
    
}
