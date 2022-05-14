/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log_neg;

import acceso_datos.JuegosUsuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.JuegosUsuario;

/**
 *
 * @author OEM
 */
@Stateless
@LocalBean
public class JuegosUsuario_ln {

    @EJB
    private JuegosUsuarioFacade juegosUsuarioFacade;

    public void guardar_Ju(JuegosUsuario Jusu){
        juegosUsuarioFacade.create(Jusu);
    }
    
    public List<JuegosUsuario> lista_JU(){
        return juegosUsuarioFacade.findAll();
    }
}
