/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans_adm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import log_neg.JuegosUsuario_ln;
import log_neg.Usuario_ln;
import log_neg.palabras_ln;
import log_neg.tipos_p;
import modelo.JuegosUsuario;
import modelo.Palabras;
import modelo.Tipos;
import modelo.Usuario;

/**
 *
 * @author oem
 */
@Named(value ="ahorcado")
@ApplicationScoped
public class ahorcado2 implements Serializable {

    @EJB
    private JuegosUsuario_ln juegosUsuario_ln;

    @EJB
    private Usuario_ln usuario_ln;

    @EJB
    private tipos_p tipos_p;

    @EJB
    private palabras_ln palabras_ln;
    
    private Usuario usuario;
    private JuegosUsuario Jusu;
    private Palabras palabras;
    private Tipos tipos;
    private ArrayList<Character> letras;
    private ArrayList<Character> adivinar;
    private String palabra;
    private String ida;
    private String ab ="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    private ArrayList <Character> abecedario;
    private String idletra;
    private int intentos;
    private boolean desactivar;
    private int nivel;
    private ArrayList niveles;
    private ArrayList tipopersona;
    private ArrayList<Palabras> ARpalabras;
    private String user;
    private String mensaje;
    private int intentost;
    private Palabras pal;
    private List<JuegosUsuario> listaG = new ArrayList<JuegosUsuario>();
    private String niv;
    private List<Palabras> lista_p;
    private List<Tipos> lista_t;
    private List<JuegosUsuario> lista_ju;
    public ahorcado2(){
        
        palabra= "";
        user= "";
        niveles= new ArrayList();
        tipopersona= new ArrayList();
        tipopersona.add('H');
        tipopersona.add('M');
        tipopersona.add('I');
        intentos=4;
        pal = new Palabras();
        usuario = new Usuario();
        Jusu = new JuegosUsuario();
        palabras = new Palabras();
        tipos = new Tipos();
        ida= new String("");
        idletra="";
        letras = new ArrayList();
        adivinar = new ArrayList();
        abecedario = new ArrayList();
        ARpalabras = new ArrayList();
        lista_p = null;
        lista_t=null;
        lista_ju=null;
       
        
        for(int i=0; i<palabra.length();i++){
            letras.add(palabra.charAt(i));
            adivinar.add('_');
        }
        for(int x=0;x<ab.length();x++)
        abecedario.add(ab.charAt(x));
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public JuegosUsuario getJusu() {
        return Jusu;
    }

    public void setJusu(JuegosUsuario Jusu) {
        this.Jusu = Jusu;
    }
    
    public Palabras getPalabras() {
        return palabras;
    }

    public void setPalabras(Palabras palabras) {
        this.palabras = palabras;
    }
   /* public List<Palabras> lista_p(){
        return palabras_ln.lispa_p();
    }*/

    public List<Palabras> getLista_p() {
        return palabras_ln.lispa_p();
    }

    public void setLista_p(List<Palabras> lista_p) {
        this.lista_p = lista_p;
    }
    
    public Tipos getTipos() {
        return tipos;
    }

    public void setTipos(Tipos tipos) {
        this.tipos = tipos;
    }

    
    public List<Tipos> getLista_t(){
        return tipos_p.lispa_t();
    }

    /* public List<Tipos> lista_t(){
    return tipos_p.lispa_t();
    }*/
    public void setLista_t(List<Tipos> lista_t) {
        this.lista_t = lista_t;
    }

    public List<JuegosUsuario> lista_ju() {
        for(int x=0;x<juegosUsuario_ln.lista_JU().size();x++){
            if(juegosUsuario_ln.lista_JU().get(x).getIntentosr()>0 && !listaG.contains(juegosUsuario_ln.lista_JU().get(x))){
                listaG.add(juegosUsuario_ln.lista_JU().get(x));
            }
        }
        return listaG;
    }

    /*public List<JuegosUsuario> getListaG() {
        for(int x=0;x<juegosUsuario_ln.lista_JU().size();x++){
            if(juegosUsuario_ln.lista_JU().get(x).getIntentosr()>0 && !listaG.contains(juegosUsuario_ln.lista_JU().get(x))){
                listaG.add(juegosUsuario_ln.lista_JU().get(x));
            }
        }
        return listaG;
    }

    public void setListaG(List<JuegosUsuario> listaG) {
        this.listaG = listaG;
    }*/

    public void guarda_p(ActionEvent e){
        palabras.setTipo(tipos);
        palabras_ln.guardar(palabras);
        palabras= new Palabras();
    }
    
    public void guarda_u (){
        Date d = new Date();
        usuario.setFechaRegistro(d);
        usuario.setNombre(user);
        usuario_ln.guardarU(usuario);
        //usuario= new Usuario();
    }
    public void guarda_ju(){
       Date d = new Date();
       Jusu.setFechaHora(d);
       Jusu.setIdusuario(usuario);
       Jusu.setIntentosr(intentos);
       Jusu.setIntentost(intentost);
       
       Jusu.setPalabra(pal);
       juegosUsuario_ln.guardar_Ju(Jusu);
       Jusu= new JuegosUsuario();
    }
    public List<Usuario> lista_u(){
        return usuario_ln.lista_U();
    }
    public void comprobar_u(ActionEvent e){
        for(int x=0;x<lista_u().size();x++){
            if(lista_u().get(x).getNombre().equals(user)){
                break;
                
            }else{
                guarda_u();
                break;
            }
        }
    }
    
    public void actualizar(ActionEvent e){
       
        ida = e.getComponent().getId();
        idletra= e.getComponent().getId().substring(1);
        Character ka = ida.charAt(0);
        
        for(int i=0; i<palabra.length();i++){
            if(ka.equals(palabra.charAt(i))){
                adivinar.set(i,ka);
            }
                if(abecedario.contains(ka)){
                abecedario.remove(ka);
                 
            }
        }
        intentos=intentos-1;
            if(intentos<=0){
                desactivar=true;
                mensaje="Has perdido "+user;
                guarda_ju();
            }
            if(!adivinar.contains('_')){
              desactivar=true;
                mensaje="Has ganado "+user;  
                guarda_ju();
            }
           
    }


    public String getIdletra() {
        return idletra;
    }

    public void setIdletra(String idletra) {
        this.idletra = idletra;
    }

    public ArrayList<Character> getLetras() {
        return letras;
    }

    public void setLetras(ArrayList<Character> letras) {
        this.letras = letras;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getIda() {
        return ida;
    }

    public void setIda(String ida) {
        this.ida = ida;
    }

    public String getAb() {
        return ab;
    }

    public void setAb(String ab) {
        this.ab = ab;
    }

    public ArrayList<Character> getAbecedario() {
        return abecedario;
    }

    public void setAbecedario(ArrayList<Character> abecedario) {
        this.abecedario = abecedario;
    }

    public ArrayList<Character> getAdivinar() {
        return adivinar;
    }

    public void setAdivinar(ArrayList<Character> adivinar) {
        this.adivinar = adivinar;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
        intentost=intentos;
    }

    public boolean isDesactivar() {
        return desactivar;
    }

    public void setDesactivar(boolean desactivar) {
        this.desactivar = desactivar;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public ArrayList<Character> getNiveles() {
        return niveles;
    }

    public void setNiveles(ArrayList<Character> niveles) {
        this.niveles = niveles;
    }

    public ArrayList getTipopersona() {
        return tipopersona;
    }

    public void setTipopersona(ArrayList tipopersona) {
        this.tipopersona = tipopersona;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    public void obtenerPalabra(){
    niveles.clear();
     for(int x=0; x<palabras_ln.lispa_p().size();x++){
            if(palabras_ln.lispa_p().get(x).getTipo().getIdtipos().equals(tipos.getIdtipos())){
                
                if(!niveles.contains((palabras_ln.lispa_p().get(x).getNivel()))){
                    niveles.add(palabras_ln.lispa_p().get(x).getNivel());    
                }  
            }
        }
   
    }  
    public void azar(ActionEvent e){
        
        for(int x=0; x<palabras_ln.lispa_p().size();x++){
            if(palabras_ln.lispa_p().get(x).getTipo().getIdtipos().equals(tipos.getIdtipos())){
               if(palabras.getNivel().equals(palabras_ln.lispa_p().get(x).getNivel())){
                   ARpalabras.add(palabras_ln.lispa_p().get(x));
                   
               }
                
            }
        }
        pal=ARpalabras.get((int) (Math.random() * ARpalabras.size()));
        palabra=pal.getPalabra();
         
            adivinar = new ArrayList();
        for(int i=0; i<palabra.length();i++){
            letras.add(palabra.charAt(i));
            adivinar.add('_');
       
        
            }
    }
    public String ncomp(int n){
        if(n==1){
            niv="Facil";
        }
        if(n==2){
            niv="Medio";
        }
        if(n==3){
            niv="Dificil";
        }
        return niv;
    }

    public String getNiv() {
        return niv;
    }

    public void setNiv(String niv) {
        this.niv = niv;
    }
    
}
