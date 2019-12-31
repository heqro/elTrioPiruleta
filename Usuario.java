package p_final;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author juans
 */
public class Usuario {
    private String nombre,password;
    private ArrayList<ModeloUsuario> ModelosUsuario  = new ArrayList<ModeloUsuario>();
    
    public Usuario(String n,String p, ArrayList<ModeloUsuario> m){
        nombre=n;
        password=p;
        ModelosUsuario=m;
    }
    
    public ArrayList<ModeloUsuario> getModelosUsuario (){
        return ModelosUsuario;
    }
    
    public void leerEjemplo(String archivo)throws FileNotFoundException, IOException{ //esta cadena es la ruta donde esta el txt
      Pieza Marcador[][] = new Pieza[8][8]; 
      Tablero tablero = new Tablero(Marcador);// marcador sera nuestro tablero
      tablero.limpiarTablero();
      Scanner entrada = new Scanner(new File (archivo));
      
      int contadorFila = 0;
      while(entrada.hasNextLine() && contadorFila <= 8){
          String[] casillas = entrada.nextLine().split(",");
          
          for(int contadorColumna=0; contadorColumna<=7; contadorColumna++){
              tablero.insertarPieza(casillas[contadorColumna], new Posicion(8 - contadorFila, (char)(contadorColumna+97)));
          }
          contadorFila++;
      }
      //String solucion = entrada.nextLine();
      String solucion = "";
      Modelo modelo = new Modelo(tablero, solucion);
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
