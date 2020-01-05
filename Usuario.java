package p_final;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.Serializable;

/**
 *
 * @author juans
 */
public class Usuario implements Serializable{
    private String nombre,password;
    private ArrayList<ModeloUsuario> ModelosUsuario;
    private Sistema sys;
    
    public Usuario(String n,String p, Sistema sys){
        nombre=n;
        password=p;
        ModelosUsuario= new ArrayList<>();
        this.sys = sys;
    }
    
    public ArrayList<ModeloUsuario> getModelosUsuario (){
        return ModelosUsuario;
    }
    public double porcentajeExito(){
        if(this.getNProblemasInt()==0){
        return 0;}
        else{return(this.getNProblemasSol()/this.getNProblemasInt()*100);
        }
    }
   
   public void leerEjemplo(String archivo)throws FileNotFoundException, IOException, 
            IllegalFormatException, IllegalTableroException, 
            IllegalSolutionException, IllegalMovementException, IllegalFileExtension{
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
        Pieza Marcador2[][] = new Pieza[8][8];
        Tablero tablero2 = new Tablero(Marcador2);
        tablero2.limpiarTablero();
        Scanner entrada = new Scanner(new File (archivo)); //el nombre lógico del archivo de texto será entrada
        String solucion;
        int contadorFila = 0; //el contador de filas lo utilizaremos para limitar la lectura del fichero
        while(contadorFila < 8){
            String[] casillas = entrada.nextLine().split(",");//guardamos en un array las piezas de la fila contadorFila
            for(int contadorColumna=0; contadorColumna<=7; contadorColumna++){
                tablero.insertarPieza(casillas[contadorColumna], new Posicion(8 - contadorFila, (char)(contadorColumna+97)));
                tablero2.insertarPieza(casillas[contadorColumna], new Posicion(8 - contadorFila, (char)(contadorColumna+97)));
                //insertamos la pieza en el tablero
            }
            contadorFila++;//incrementamos la fila para poder introducir la siguiente
        }
        solucion = entrada.next();
        Solucion sol = new Solucion(solucion);
        Modelo modeloAux = new Modelo(tablero2, sol);
        /*Si hemos llegado a esta línea, entonces creamos un Modelo
        con un tablero, que no sabemos si será válido, y una solución posible, que no sabemos si será válida*/
        tablero.actualizarTablero();
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
        
        try {
            piezaJugada.Mover(posFinal);//este método lanza IllegalMovementException con un mensaje de error.
        } catch (CoronacionException ex) {
            tablero.coronarPeon(piezaJugada, sol.getLetraCoronacion());
        }
        if(!tablero.JaqueMate(new Color('n'))){
            throw new IllegalSolutionException("La solución dada no es jaque mate. El tablero NO "
                    + "se añadirá.");
         }
        
        /*Llegados a este punto, sabemos que el tablero es legal, que las posiciones dadas son válidas, y
        que la jugada aportada es jaque mate. Por tanto, lo añadimos al arrayList de modelos de usuario
        que tiene el Usuario, y actualizamos el sistema para que todo usuario pueda jugar con ese modelo
        si así lo desea.*/
        tablero2.actualizarTablero();
        this.ModelosUsuario.add(new ModeloUsuario(modeloAux, false, 0, 0)); 
        /*añadimos el Modelo al array de modelos de Usuario*/
        sys.actualizarSistemaModelos();
        /*actualizamos el sistema con el nuevo modelo*/
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
    
    public boolean comprobarContenido(Modelo m){
        for(ModeloUsuario modelo: ModelosUsuario ){
            if(modelo.getModelo().equals(m)) 
                return true;
        }
        return false;
    }
    
    public int recogerIndiceModelo(Modelo m){
        int contador = 0;
        for(ModeloUsuario modelo: ModelosUsuario ){
            if(modelo.getModelo().equals(m)) 
                return contador;
            contador++;
        }
        return -1;
    }
    
    public boolean jugar(Modelo M) {
        if(!comprobarContenido(M)){
            ModelosUsuario.add(new ModeloUsuario(M, false, 0, 0));
            if(comprobarContenido(M)){
                System.out.println("añadido correctamente");//esto sucede
            }
            System.out.println("Su posicion es el "+this.recogerIndiceModelo(M));
            return true;    
        }else{
            System.out.println("Su posicion es el "+this.recogerIndiceModelo(M));
            return !comprobarResuelto(M);
        }
    }
    
}
