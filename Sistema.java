/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_final;
import java.io.BufferedInputStream;
import java.io.File;
import java.util.Collections;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileInputStream;
/**
 *
 * @author Juan
 */
public class Sistema implements Serializable{
    
    private ArrayList<Modelo> modelos;
    private ArrayList<Usuario> usuarios;
    
    
    public Sistema () throws IOException, 
            FileNotFoundException, 
            IllegalFormatException, 
            IllegalTableroException, 
            IllegalSolutionException, 
            IllegalMovementException, 
            IllegalFileExtension{
        modelos = new ArrayList<>();
        usuarios = new ArrayList<>();
        añadirAdmin();
        subirProblemas();
    }
    public void añadirAdmin(){
        this.registrarUsuario("admin","admin");
    }
    
    public void subirProblemas() throws IllegalFileExtension, IOException, 
            FileNotFoundException, IllegalFormatException, IllegalTableroException, 
            IllegalSolutionException, IllegalMovementException{
        String rutaArchivo;
        String extension = "";
        Usuario admin = this.buscarUsuario("admin", "admin");
        for(int i = 1; i < 11; i++){
            rutaArchivo = "src/p_final/interfaz_grafica/partidaobligatoria" + i + ".txt";
            int j = rutaArchivo.lastIndexOf('.');
            if (j >= 0) {
                extension = rutaArchivo.substring(j+1);
            }
            if(!extension.equals("txt")){
                throw new IllegalFileExtension("Extensión de archivo no válida. Se esperaba"
                        + " txt, y se obtuvo \""+ extension + "\"" );
            }
            admin.leerEjemplo(rutaArchivo);
        }
    }

    public Sistema(ArrayList<Modelo> m, ArrayList<Usuario> u){
        modelos = m;
        usuarios = u;
    }
    public void registrarUsuario(String nombre, String contraseña){
        if(buscarUsuario(nombre, contraseña)==null){//Usuario no encontrado
            Usuario user = new Usuario(nombre,contraseña, this);
            usuarios.add(user);
        }
    }
    public Usuario buscarUsuario(String nombre, String contraseña){
        for(Usuario u: usuarios){
            if (u.getNombre().equals(nombre)) 
                return u;
        }
        return null; //devolvemos null si no devuelve no
    
    }
    
    public ArrayList<Usuario> getUsuarios(){
        return this.usuarios;
    }
    
    public ArrayList<Modelo> getModelos(){
        return this.modelos;
    }
    
    public void setModelos(ArrayList<Modelo> modelos){
        this.modelos = modelos;
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
            return 100*(resuelto/intentos);
    }
    public ArrayList<Usuario> usuariosNoResolvieron(Modelo p){
        ArrayList<Usuario> auser = new ArrayList<>();
        for(Usuario u: usuarios){
            if(!u.getModelosResueltos().contains(p))
                auser.add(u);
        }
        return auser;
    }
    public void subirProblema(Tablero p, Solucion sol){ //haremos un subprograma en los jframe que permita construir problemas
        /*A este método solo vamos a acceder desde leerEjemplo: así, el problema siempre será válido.*/
        Modelo m = new Modelo(p, sol);
        modelos.add(m);
    }
    
    
    public void actualizarSistemaModelos(){
        ArrayList<Modelo> arrayAuxModelo = new ArrayList<>();
        for(Usuario u: this.getUsuarios()){//Recoger todos los usuarios de la base de datos
            ArrayList<ModeloUsuario> arrayAuxModeloUsuario = u.getModelosUsuario();/*Recoger sus modelos subidos*/
            for(ModeloUsuario m: arrayAuxModeloUsuario){/*Añadir cada modelo encontrado a un array Auxiliar*/
                if(!arrayAuxModelo.contains(m.getModelo())){
                    arrayAuxModelo.add(m.getModelo());
                }
                
            }
        }
        this.setModelos(arrayAuxModelo);
    }
    
    public void LeerBinarioUsuarios(String dir){
        /* funcionara de forma que si el usuario leido esta en el arraylist no lo mete
            pero si no estaba lo añade.
        
            Dos usuarios son iguales syss sus nombres lo son.
        
            */
        
        
        FileInputStream fis = null;
        DataInputStream entrada = null;
        

        try {
           FileInputStream fileInput = new FileInputStream(dir);
           ObjectInputStream oos = new ObjectInputStream(fileInput);
           
           ArrayList<Usuario> auser = (ArrayList<Usuario>) oos.readObject();
           usuarios=auser;
           

            
        } catch (FileNotFoundException e) {                                         //"src/p_final/interfaz_grafica/binmodelos.dat"
            try{System.out.println(e.getMessage());
            FileInputStream fileInput = new FileInputStream("src/p_final/interfaz_grafica/binmodelos.bin");
            ObjectInputStream oos = new ObjectInputStream(fileInput);
           
           ArrayList<Usuario> auser = (ArrayList<Usuario>)oos.readObject();
           
           usuarios=auser;
            } catch(Exception ex){}finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException ex) {
                System.out.println(e.getMessage());
            }
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

public void LeerBinarioModelos(String dir){
        /* funcionara de forma que si el modelo leido esta en el arraylist no lo mete
            pero si no estaba lo añade. 
        
            
            */
        
        
        FileInputStream fis = null;
        DataInputStream entrada = null;
        
 
        try {
           FileInputStream fileInput = new FileInputStream(dir);
           ObjectInputStream oos = new ObjectInputStream(fileInput);
           
           ArrayList<Modelo> am = (ArrayList<Modelo>)oos.readObject();
           
           for(Modelo m : am){
               for(Modelo maux: modelos){
                   if(maux.equals(maux)){}else
                   {
                       modelos.add(m);
                   }
               }
           }
           

            
        } catch (FileNotFoundException e) {
            try{//asignamos direccion por defecto si la direccion que ha metido no sirve
               FileInputStream fileInput = new FileInputStream("src/p_final/interfaz_grafica/binmodelos.bin");
           ObjectInputStream oos = new ObjectInputStream(fileInput);
           
           ArrayList<Modelo> am = (ArrayList<Modelo>)oos.readObject();
           
           for(Modelo m : am){
               for(Modelo maux: modelos){
                   if(maux.equals(maux)){}else
                   {
                       modelos.add(m);
                   }
               }
           }
           }catch(Exception ex){
               
           }finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException ex) {
                System.out.println(e.getMessage());
            }
        }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void EscribirBinarioUsuarios(String dir){
        FileOutputStream fis = null;
        DataOutputStream entrada = null;
        

        try {
           FileOutputStream fileInput = new FileOutputStream(dir);
           ObjectOutputStream oos = new ObjectOutputStream(fileInput);
           //this.LeerBinarioUsuarios(dir); //asi comprobamos que estan actualizados y que no vamos a repetir ningun usuario cuidado serial id
           oos.writeObject(usuarios);
           
          
           

            
        } catch (FileNotFoundException e) {
           try{//asignamos direccion por defecto si la direccion que ha metido no sirve
               FileOutputStream fileInput = new FileOutputStream("src/p_final/interfaz_grafica/binusuarios.bin");
               ObjectOutputStream oos = new ObjectOutputStream(fileInput);
               //this.LeerBinarioUsuarios("src/p_final/interfaz_grafica/binusuarios.bin"); cuidado serial id 
               oos.writeObject(usuarios);
           }catch(Exception ex){
               
           }
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void EscribirBinarioModelo(String dir){
        FileOutputStream fis = null;
        DataOutputStream entrada = null;
        

        try {
           FileOutputStream fileInput = new FileOutputStream(dir);
           ObjectOutputStream oos = new ObjectOutputStream(fileInput);
           //this.LeerBinarioModelos(dir); //asi comprobamos que estan actualizados y que no vamos a repetir ningun usuario¡¡¡¡¡¡¡ cuidado : serializable id
           oos.writeObject(modelos);
           
          
           

            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            try{
            FileOutputStream fileInput = new FileOutputStream("src/p_final/interfaz_grafica/binusuarios.bin");
           ObjectOutputStream oos = new ObjectOutputStream(fileInput);
           //this.LeerBinarioModelos("src/p_final/interfaz_grafica/binusuarios.dat"); //asi comprobamos que estan actualizados y que no vamos a repetir ningun usuario
           oos.writeObject(modelos);
           
            
            }
            catch(Exception ex){
                
            }finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException ex) {
                System.out.println(e.getMessage());
            }
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public Modelo elegirModeloAleatorio (){
        int indiceProblemas = modelos.size()-1;
        double j =  Math.random()*(indiceProblemas) + 1;
        //System.out.println(j);
        indiceProblemas = (int)(j);
        //System.out.println(indiceProblemas);
        return(modelos.get(indiceProblemas));
    }
    public ArrayList<Usuario> ordenarPExito(){
        ArrayList<Usuario> auser = (ArrayList<Usuario>)usuarios.clone();
        Collections.sort(auser, new compararUsuarios());
        /*for(Usuario aux: auser){
            System.out.println(aux.toString());
        }*/
        return auser;
    }
    public ArrayList<Usuario> ordenarProblemasResueltos(){
        ArrayList<Usuario> auser = (ArrayList<Usuario>)usuarios.clone();
        Collections.sort(auser, new compararUsuarios2());
        /* for(Usuario aux: auser){
            System.out.println(aux.toString());
        }*/
        return auser;
    }
    
    public int cardinalidadProblemas(){
        return this.getModelos().size();
    }
    
    /*public void crearBinarioUsuarios(){
        try{ //asignamos esta direccion por defecto
            
            FileInputStream fileInput = new FileInputStream("src/p_final/interfaz_grafica/binusuarios.dat");
        
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    public void crearBinarioModelos(){
        try{ //asignamos esta direccion por defecto
            
            FileInputStream fileInput = new FileInputStream("src/p_final/interfaz_grafica/binmodelos.dat");
        
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    */}
    
    
    
    
    
    
    
    
    
    
    
    
    

        









    



    













