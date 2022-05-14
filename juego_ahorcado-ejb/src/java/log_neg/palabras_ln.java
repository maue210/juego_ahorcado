/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log_neg;

import acceso_datos.PalabrasFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Palabras;
import java.util.List;
/**
 *
 * @author OEM
 */
@Stateless
@LocalBean
public class palabras_ln {

    @EJB
    private PalabrasFacade palabrasFacade;

    public void guardar(Palabras palabra){
        palabrasFacade.create(palabra);
    }
    
    public List<Palabras> lispa_p(){
        return palabrasFacade.findAll();
    }
}
