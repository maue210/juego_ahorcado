/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso_datos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.JuegosUsuario;

/**
 *
 * @author OEM
 */
@Stateless
public class JuegosUsuarioFacade extends AbstractFacade<JuegosUsuario> {

    @PersistenceContext(unitName = "juego_ahorcado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JuegosUsuarioFacade() {
        super(JuegosUsuario.class);
    }
    
}
