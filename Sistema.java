/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_final;
import java.util.ArrayList;
/**
 *
 * @author Juan
 */
public class Sistema {
    
    private ArrayList<Modelo> modelos;
    private ArrayList<Usuario> usuarios;
    
    
    public Sistema (){
        modelos = new ArrayList<>();
        usuarios = new ArrayList<>();
    }
    public Sistema(ArrayList<Modelo> m, ArrayList<Usuario> u){
        
        modelos = m;
        usuarios = u;
    }
    public void registrarUsuario(String nombre, String contraseña){
        boolean control=true;
        for(Usuario u: usuarios){
            if (control) control = !u.getNombre().equals(nombre); // cuando control sea falso es porque hay un nombre igual, luego no podemos registarlo
            
        }
        if (control){
            ArrayList<ModeloUsuario> Auser = new ArrayList<>();
            Usuario user = new Usuario(nombre,contraseña,Auser);
        }else {
            System.out.println("El usuario ya esta registrado.");
        }
        
    }
    public Usuario buscarUsuario(String nombre, String contraseña){
        
        for(Usuario u: usuarios){
            if (u.getNombre().equals(nombre)) return u;
        
    }
        return null; //devolvemos null si no devuelve no
    
    }
    public int usuariosQueHanResuelto(Modelo p){
        int sum=0;
        for(Usuario u: usuarios){
            boolean control = u.getModelosResueltos().contains(p);
            if(control)
                sum=+1;
    }
            return sum;
    }
     public double porcentajeExito(Modelo p){
         int resuelto=0;
         int intentos=0;
         for(Usuario u: usuarios){
            ArrayList<ModeloUsuario> amu = u.getModelosUsuario();
            for(int i=0; i<amu.size();i++){
                Modelo m = amu.get(i).getModelo();
                if(m.equals(p)){
                   intentos =+ amu.get(i).getIntentos();
                    if(amu.get(i).getResuelto()) resuelto=+1;
                }
        }
    } 
            return (resuelto/intentos*100);
     }
    public ArrayList<Usuario> usuariosNoResolvieron(Modelo p){
        
        ArrayList<Usuario> auser = new ArrayList<>();
        
        for(Usuario u: usuarios){
            if(!u.getModelosResueltos().contains(p))
                auser.add(u);
    }
        return auser;
    
    
    
    }
    public void subirProblema(Tablero p,String str){ //haremos un subprograma en los jframe que permita construir problemas
        Modelo m = new Modelo(p,str);
        modelos.add(m);
    }
    




}
    













