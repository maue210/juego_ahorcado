/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log_neg;

import acceso_datos.UsuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Usuario;

/**
 *
 * @author OEM
 */
@Stateless
@LocalBean
public class Usuario_ln {

    @EJB
    private UsuarioFacade usuarioFacade;

    public void guardarU(Usuario usuario){
        usuarioFacade.create(usuario);
    }
    
    public List<Usuario> lista_U(){
        return usuarioFacade.findAll();
    }
}
