/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_final;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author juans
 */
public class Usuario {
    private String nombre,password;
    private ArrayList<ModeloUsuario> ModelosUsuario  = new ArrayList<ModeloUsuario>();
    
    public ArrayList<ModeloUsuario> getModelosUsuario (){
        return ModelosUsuario;
    }
    public Usuario(String n,String p, ArrayList<ModeloUsuario> m){
        nombre=n;
        password=p;
        ModelosUsuario=m;
    }
    public void leerEjemplo(String archivo)throws FileNotFoundException, IOException{ //esta cadena es la ruta donde esta el txt
      String cadena;
      int cfila=1; //contador fila
      char c;
      int ccolumna=0;// contador columna
      
      
      Pieza Marcador[][] = new Pieza[8][8]; 
      Tablero tablero = new Tablero(Marcador);// marcador sera nuestro tablero
      FileReader f = new FileReader(archivo);
      BufferedReader b = new BufferedReader(f);
      while((cadena = b.readLine())!=null) {
          
          // b es la cadena que tiene la primera linea del tablero empezando por arriba
          for(int i=0; i<cadena.length();i++){
              if(cadena.charAt(i) != ','){
                  
                  
                  
                  Posicion pos = new Posicion(cfila, (char)(ccolumna+97));
                  switch(cadena.charAt(i)){
                      case 'V': String cadenauso = cadena.charAt(i)+" ";//añadimos espacio para solucionar un error que daba en inserpieza que luego arreglaremos
                                tablero.insertarPieza(cadenauso, pos);
                                break;
                      case 'R': cadenauso = cadena.charAt(i) + cadena.charAt(i+1)+"";
                                tablero.insertarPieza(cadenauso, pos);
                                i=i+1; //sabemos que el siguiente caracter a leer es el tipo de pieza asi que lo adelantamos intencionadamente para tener un buen control del contador de columnas
                                break;
                      case 'P': cadenauso = cadena.charAt(i) + cadena.charAt(i+1)+"";
                                tablero.insertarPieza(cadenauso, pos);
                                i=i+1;
                                break;
                      case 'C': cadenauso = cadena.charAt(i) + cadena.charAt(i+1)+"";
                                tablero.insertarPieza(cadenauso, pos);
                                i=i+1;
                                break;
                      case 'T': cadenauso = cadena.charAt(i) + cadena.charAt(i+1)+"";
                                tablero.insertarPieza(cadenauso, pos);
                                i=i+1;
                                break;    
                      case 'A': cadenauso = cadena.charAt(i) + cadena.charAt(i+1)+"";
                                tablero.insertarPieza(cadenauso, pos);
                                i=i+1;
                                break;
                      case 'D': cadenauso = cadena.charAt(i) + cadena.charAt(i+1)+"";
                                tablero.insertarPieza(cadenauso, pos);
                                i=i+1;
                                break;
                                
                  } 
                  ccolumna=ccolumna+1;
              }
          
          }
          cfila=cfila+1;
          ccolumna=0;
      }
      b.close();
      //Ahora crearemos el modelo correspondiente teniendo ya el tablero
      //La jugada ganadora sera siempre el ultimo string que sacamos de b
      Modelo modelo = new Modelo(tablero, cadena); //nuestro modelo
      
      this.ModelosUsuario.add(new ModeloUsuario(modelo,false,0,0)); //ya lo hemos añadido al almacen incializado
      
      
    }
    public String getNombre(){
        return nombre;
    }
    public String getPassword(){
        return password;
    }
    public int getNProblemasInt(){
        int cont=0;
        for(ModeloUsuario m : ModelosUsuario ){
            cont+= cont + m.getIntentos();
        }
        return cont;
    }
    public int getNProblemasSol(){
        int cont=0;
        for(ModeloUsuario m : ModelosUsuario ){
            if(m.getResuelto()) cont+= cont + 1;
        }
        return cont;
    }
    public int getNErrores(){
        int cont=0;
        for(ModeloUsuario m : ModelosUsuario ){
            cont+= cont + m.getErrores();
        }
        return cont;
    }
    public ArrayList<Modelo> getModelosResueltos(){
        ArrayList<Modelo> aux = new ArrayList<>();
        for(ModeloUsuario m : ModelosUsuario ){
            if(m.getResuelto()) aux.add(m.getModelo());
        }
        return aux;
    }
    public boolean comprobarResuelto(Modelo p){
        for(ModeloUsuario m : ModelosUsuario ){
            if(m.getModelo().equals(p)) return m.getResuelto();
        }
        return false;
    }
    public void jugar(Modelo M, String j_propuesta){
        for(ModeloUsuario m : ModelosUsuario ){
            if(m.getModelo().equals(M)){
                m.setIntentos(m.getIntentos()+1);
                
                if(m.getModelo().proponerMovimiento(j_propuesta)){
                    m.setResuelto(true);
                }else {
                    m.setErrores(m.getErrores() + 1);
                }
                
            }
        }
    }
    
    
    
}
