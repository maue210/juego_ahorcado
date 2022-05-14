/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans_adm;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "ejemplo")
@SessionScoped
public class Ejemplo implements Serializable {
private String texto="Hola a todos";
private String usuario="";
private String password="";
private String mensaje="";
private boolean key=true;
private String intentos ="";

public String getTexto(){
    return texto;
}
public String getMensaje(){
    return mensaje;
}
public String getUsuario(){
    return usuario;
}
public String getPassword(){
    return password;
}

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void actmensaje(){
        if(password.equals("1234")){
        mensaje="Bienvenido";
        key=false;
        }else{
           mensaje="No pudo acceder";
        }
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public boolean getKey() {
        return key;
    }



    public Ejemplo() {
    }
    
}
