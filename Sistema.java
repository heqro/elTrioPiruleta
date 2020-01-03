/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_final;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.ObjectOutputStream;

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
public class Sistema {
    
    private ArrayList<Modelo> modelos;
    private ArrayList<Usuario> usuarios;
    
    
    public Sistema (){
        modelos = new ArrayList<>();
        usuarios = new ArrayList<>();
        
        
    }
    public void añadirAdmin(){
        this.registrarUsuario("admin","admin");
    }
    public void añadir10Problemas()throws FileNotFoundException, IOException, 
            IllegalFormatException, IllegalTableroException, 
            IllegalSolutionException, IllegalMovementException, IllegalFileExtension{
        
        for(int j=1; j<10; j++){
            
            String archivo = "src/p_final/1interfaz_grafica/partidaobligatoria/" + j + ".txt";
        // archivo es el nombre físico del archivo de texto que vamos a leer
        String extension = "";
        int i = archivo.lastIndexOf('.');
        if (i >= 0) {
            extension = archivo.substring(i+1);
        }
        if(!extension.equals("txt")){
            throw new IllegalFileExtension("Extensión de archivo no válida. Se esperaba"
                    + " txt, y se obtuvo \""+ extension + "\"" );
        }
        Pieza Marcador[][] = new Pieza[8][8]; 
        Tablero tablero = new Tablero(Marcador);// tablero será el objeto donde guardemos el problema
        tablero.limpiarTablero();// inicializamos el tablero con valores nulos
        Scanner entrada = new Scanner(new File (archivo)); //el nombre lógico del archivo de texto será entrada
        String solucion;
        int contadorFila = 0; //el contador de filas lo utilizaremos para limitar la lectura del fichero
        while(contadorFila < 8){
            String[] casillas = entrada.nextLine().split(",");//guardamos en un array las piezas de la fila contadorFila
            for(int contadorColumna=0; contadorColumna<=7; contadorColumna++){
                tablero.insertarPieza(casillas[contadorColumna], new Posicion(8 - contadorFila, (char)(contadorColumna+97)));
                //insertamos la pieza en el tablero
            }
            contadorFila++;//incrementamos la fila para poder introducir la siguiente
        }
        solucion = entrada.next();
        Solucion sol = new Solucion(solucion);
        Modelo modelo = new Modelo(tablero, sol); /*Si hemos llegado a esta línea, entonces creamos un Modelo
        con un tablero, que no sabemos si será válido, y una solución posible, que no sabemos si será válida*/
        tablero.tableroIlegal();/*Queremos saber si el tablero es legal*/
        /*Si hemos llegado a esta línea, entonces hemos creado un modelo con un tablero que es legal,
        y ahora queremos ver si la solución lo es.*/
        Posicion posInicial = sol.getPosInicial();
        if(!tablero.PosicionOcupada(posInicial)){
            throw new IllegalSolutionException("La posición inicial dada está vacía.");
        }
        /*Ya sabemos que en posInicial hay una pieza. Queremos saber si es del color que nos interesa (BLANCO)*/
        if(tablero.GetPiezaPos(posInicial).getColor().equals(new Color('n'))){
            throw new IllegalSolutionException("La posición inicial dada está ocupada"
                    + "por una pieza negra.");
        }
        /*Si hemos llegado hasta aquí, queremos saber si el movimiento se puede hacer.
        Para ello, actualizaremos el tablero para obtener los posibles movimientos de todas las piezas
        y moveremos la pieza de posInicial a la posición posFinal.*/
        Pieza piezaJugada = tablero.GetPiezaPos(posInicial);// Ya sabemos que es no nulo
        Posicion posFinal = sol.getPosFinal();/*No sabemos su situación, pero el método mover de la pieza
        se encargará de saber su situación.*/
        tablero.actualizarTablero();
        try {
            piezaJugada.Mover(posFinal);//este método lanza IllegalMovementException con un mensaje de error.
        } catch (CoronacionException ex) {
            tablero.coronarPeon(piezaJugada, sol.getLetraCoronacion());
        }
        if(!tablero.JaqueMate(new Color('n'))){
            throw new IllegalSolutionException("La solución dada no es jaque mate. El tablero NO "
                    + "se añadirá.");
            }
        if (modelos.contains(modelo)){
            
        }else{
        modelos.add(modelo);
        }
         }
    }
    public Sistema(ArrayList<Modelo> m, ArrayList<Usuario> u){
        
        modelos = m;
        usuarios = u;
    }
    public void registrarUsuario(String nombre, String contraseña){
        if(buscarUsuario(nombre, contraseña)==null){//Usuario no encontrado
            ArrayList<ModeloUsuario> Auser = new ArrayList<>();
            Usuario user = new Usuario(nombre,contraseña, this);
            usuarios.add(user);
        }
    }
    public Usuario buscarUsuario(String nombre, String contraseña){
        
        for(Usuario u: usuarios){
            if (u.getNombre().equals(nombre)) return u;
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
                if(arrayAuxModelo.contains(m.getModelo())){}else{
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
           
           for(Usuario u : auser){
               for(int i =0 ; i<usuarios.size();i++){
                   if(usuarios.get(i).getNombre().equals(u.getNombre())){}else
                   {
                       usuarios.add(u);
                   }
               }
           }
           

            
        } catch (FileNotFoundException e) {                                         //"src/p_final/interfaz_grafica/binmodelos.dat"
            try{System.out.println(e.getMessage());
            FileInputStream fileInput = new FileInputStream("src/p_final/interfaz_grafica/binmodelos.bin");
            ObjectInputStream oos = new ObjectInputStream(fileInput);
           
           ArrayList<Usuario> auser = (ArrayList<Usuario>)oos.readObject();
           
           for(Usuario u : auser){
               for(int i =0 ; i<usuarios.size();i++){
                   if(usuarios.get(i).getNombre().equals(u.getNombre())){}else
                   {
                       usuarios.add(u);
                   }
               }
           }
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
           this.LeerBinarioUsuarios(dir); //asi comprobamos que estan actualizados y que no vamos a repetir ningun usuario
           oos.writeObject(usuarios);
           
          
           

            
        } catch (FileNotFoundException e) {
           try{//asignamos direccion por defecto si la direccion que ha metido no sirve
               FileOutputStream fileInput = new FileOutputStream("src/p_final/interfaz_grafica/binusuarios.bin");
               ObjectOutputStream oos = new ObjectOutputStream(fileInput);
               this.LeerBinarioUsuarios("src/p_final/interfaz_grafica/binmodelos.dat"); 
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
           this.LeerBinarioModelos(dir); //asi comprobamos que estan actualizados y que no vamos a repetir ningun usuario
           oos.writeObject(modelos);
           
          
           

            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            try{
            FileOutputStream fileInput = new FileOutputStream("src/p_final/interfaz_grafica/binusuarios.bin");
           ObjectOutputStream oos = new ObjectOutputStream(fileInput);
           this.LeerBinarioModelos("src/p_final/interfaz_grafica/binusuarios.dat"); //asi comprobamos que estan actualizados y que no vamos a repetir ningun usuario
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
    
    
    
    
    
    
    
    
    
    
    
    
    

        









    



    













