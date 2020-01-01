/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_final;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j.montes.2018
 */
public class Tablero {
    private Pieza Marcador[][] = new Pieza[8][8];
    private int contReyNegro, contReyBlanco = 0;
    private int contAlfilBlancoCasillasBlancas, contAlfilBlancoCasillasNegras,
            contAlfilNegroCasillasBlancas, contAlfilNegroCasillasNegras= 0;
    private int contPeonNegro, contPeonBlanco = 0;
    private int contDamaBlanca, contDamaNegra = 0;
    private int contTorreBlanca, contTorreNegra = 0;
    private int contCaballoNegro, contCaballoBlanco = 0;
    private boolean tableroIlegal = false;
    public Tablero(Pieza M[][]){
        Marcador = M;
    }

    public Pieza GetPiezaPos (Posicion pos){ //recuperar una pieza en una posición pos
        int x = this.localizarCoordenadaX(pos);
        int y = this.localizarCoordenadaY(pos);
        return(Marcador[x][y]);
    }
    
    public boolean PosicionOcupada(Posicion pos){//comprobar si una casilla está ocupada
        int x = localizarCoordenadaX(pos);
        int y = localizarCoordenadaY(pos);
        return (Marcador[x][y] != null);
    }
    
    void comprobarTableroLegal(){
        boolean legalReyes = contReyNegro == 1 && contReyBlanco == 1;
        //boolean legalPeones = contPeonNegro <= 8 && contPeonBlanco <= 8;
        int piezasExtrasNegra = 0;
        int piezasExtrasBlanca = 0;
        
        if (contDamaBlanca > 1){
            piezasExtrasBlanca += contDamaBlanca -1;
        }
        if (contTorreBlanca > 2){
            piezasExtrasBlanca += contTorreBlanca - 2 ;
        }       
        if (contCaballoBlanco >2){
            piezasExtrasBlanca += contCaballoBlanco -2;
        }
        if (contAlfilBlancoCasillasBlancas > 1){
            piezasExtrasBlanca += contAlfilBlancoCasillasBlancas -1;
        }
        if(contAlfilBlancoCasillasNegras > 1){
            piezasExtrasBlanca += contAlfilBlancoCasillasNegras - 1;
        }
        if (contDamaNegra > 1){
            piezasExtrasNegra +=contDamaNegra-1;
        }
        if(contTorreNegra > 2){
            piezasExtrasNegra += contTorreNegra -2;
        } 
        if (contCaballoNegro >2){
            piezasExtrasNegra += contCaballoNegro -2;
        }
        if (contAlfilNegroCasillasBlancas > 1){
            piezasExtrasNegra += contAlfilNegroCasillasBlancas -1;
        }
        if (contAlfilNegroCasillasNegras > 1){
            piezasExtrasNegra += contAlfilNegroCasillasNegras -1;
            
        }
        tableroIlegal = !( legalReyes && 
                (piezasExtrasNegra + contPeonNegro <= 8) &&
                (piezasExtrasBlanca + contPeonBlanco <= 8) ) && !tableroIlegal;
        
       // boolean legalDamas = contDamaNegra <= 1 && contDamaBlanca <= 1;
       // boolean legalTorres = contTorreNegra <= 2 && contTorreBlanca <= 2;
       //boolean legalCaballos = contCaballoNegro <= 2 && contCaballoBlanco <= 2;
       //boolean legalAlfiles = contAlfilBlancoCasillasBlancas <= 1 && contAlfilBlancoCasillasNegras <= 1
       //       && contAlfilNegroCasillasBlancas <= 1 && contAlfilNegroCasillasNegras <= 1; 
       // tableroIlegal = legalReyes && legalPeones && legalDamas && legalTorres && legalCaballos && legalAlfiles && !tableroIlegal;
    }
    
    public void insertarPieza(String pstring, Posicion pos){/*método para inicializar una casilla del tablero: recibe una cadena,
    que puede ser una casilla vacía ("V") o una pieza P de un color C ("PC"), y una posición*/
        int x = localizarCoordenadaX(pos);
        int y = localizarCoordenadaY(pos);
        char colorPieza;
        if(pstring.charAt(0) != 'V'){
            colorPieza = pstring.charAt(1);
        }else{
            colorPieza = 'x';/*Caracter basura para poder computar las casillas vacías, denotadas
            sencillamente como 'V', sin ningún caracter detrás, evitando así errores*/
        }
        if (PosicionOcupada(pos)){
            tableroIlegal = true; /*Si intentamos introducir la pieza donde ya hay otra,
            el tablero es ilegal*/
        }
        switch(pstring.charAt(0)){
            case 'R'://rey
            {
                switch(colorPieza){
                    case 'B':case 'b':{
                        contReyBlanco++;
                        break;
                    }
                    case 'N':case 'n':{
                        contReyNegro++;
                        break;
                    }
                    default:{//color de pieza ilegal
                        tableroIlegal = true;
                    }
                }
                Marcador[x][y] = new Rey(colorPieza, this, pos);/*introducimos Rey de color
                colorPieza en el tablero this en la posición pos*/
                break;
            }
            case 'A'://alfil
            {
                switch(colorPieza){
                    case 'B': case 'b':{
                        if((x + y) % 2 == 0){
                            contAlfilBlancoCasillasNegras++;
                            /*El alfil blanco de casillas negras se mueve por 
                            coordenadas (x, y) cuya suma da un número par. */
                        }
                        else{
                            contAlfilBlancoCasillasBlancas++;
                            /*El alfil blanco de casillas blancas se mueve por 
                            coordenadas (x, y) cuya suma da un número impar. */
                        }
                        break;
                    }
                    case 'N': case 'n':{
                        if((x + y) % 2 == 0){
                            contAlfilNegroCasillasBlancas++;
                            /*El alfil negro de casillas blancas se mueve por 
                            coordenadas (x, y) cuya suma da un número par. */
                        }
                        else{
                            contAlfilNegroCasillasNegras++;
                            /*El alfil negro de casillas negras se mueve por 
                            coordenadas (x, y) cuya suma da un número impar. */
                        }
                        break;
                    }
                    default:{
                        tableroIlegal = true;
                    }
                }
                Marcador[x][y] = new Alfil(colorPieza, this, pos);/*introducimos Alfil de color
                colorPieza en el tablero this en la posición pos*/
                break;
            }
            case 'T'://torre
            {
                switch(colorPieza){
                    case 'B':case 'b':{
                        contTorreBlanca++;
                        break;
                    }
                    case 'N':case 'n':{
                        contTorreNegra++;
                        break;
                    }
                    default:{//color de pieza ilegal
                        tableroIlegal = true;
                    }
                }
                Marcador[x][y] = new Torre(colorPieza, this, pos);/*introducimos Torre de color
                colorPieza en el tablero this en la posición pos*/
                break;
            }
            
            case 'D'://dama
            {
                switch(colorPieza){
                    case 'B':case 'b':{
                        contDamaBlanca++;
                        break;
                    }
                    case 'N':case 'n':{
                        contDamaNegra++;
                        break;
                    }
                    default:{//color de pieza ilegal
                        tableroIlegal = true;
                    }
                }
                Marcador[x][y] = new Dama(colorPieza, this, pos);/*introducimos Dama de color
                colorPieza en el tablero this en la posición pos*/
                break;
            }
            case 'P'://peón
            {
                switch(colorPieza){
                    case 'B':case 'b':{
                        contPeonBlanco++;
                        break;
                    }
                    case 'N':case 'n':{
                        contPeonNegro++;
                        break;
                    }
                    default:{//color de pieza ilegal
                        tableroIlegal = true;
                    }
                }
                if (x == 7 || x == 0) tableroIlegal = true;
                //Los peones nunca pueden estar en las últimas filas del tablero
                Marcador[x][y] = new Peon(colorPieza, this, pos);/*introducimos Peón de color
                colorPieza en el tablero this en la posición pos*/
                break;
            }
            case 'C'://caballo
            {
                switch(colorPieza){
                    case 'B':case 'b':{
                        contCaballoBlanco++;
                        break;
                    }
                    case 'N':case 'n':{
                        contCaballoNegro++;
                        break;
                    }
                    default:{//color de pieza ilegal
                        tableroIlegal = true;
                    }
                }
                Marcador[x][y] = new Caballo(colorPieza, this, pos);/*introducimos Caballo de color
                colorPieza en el tablero this en la posición pos*/
                break;
            }
            case 'V'://vacío
            {
                Marcador[x][y] = null;
                break;
            }
            default: //nombre de pieza ilegal
            {
                tableroIlegal = true;
            }
        }
        
    }
    
    boolean letraValida(char letra){
        return letra == 'D' || letra == 'T' ||
                letra == 'A' || letra == 'C';
    }
    
    public void coronarPeon(Pieza p, char letra){
        //Si no se introduce un valor válido, se coronará por defecto una dama
        if(letraValida(letra)){
            this.insertarPieza(letra+p.getColor().toString(), p.getPosicion());
        }else{
            this.insertarPieza('D'+p.getColor().toString(), p.getPosicion());
        }
        /*Insertamos una pieza del mismo color de la pieza en la posición de la pieza*/
        p = this.GetPiezaPos(p.getPosicion());//hacemos que p apunte a la nueva pieza
        p.getTablero().actualizarTablero();
    }
    public void descoronarPeon(Pieza p){
        this.insertarPieza("P"+p.getColor().toString(), p.getPosicion());
        p = this.GetPiezaPos(p.getPosicion());
    }
    
    public void peonCoronado(Pieza p) throws CoronacionException{
        if(p.getNombre() == 'P'){
            Posicion pos = p.getPosicion();
            switch(p.getColor().toString()){
                case "N":
                {
                    if(pos.getCoordenadax() == 1){
                        throw new CoronacionException("¡PEÓN NEGRO CORONADO!");
                    }
                    break;
                }
                case "B":{
                    if(pos.getCoordenadax()==8){
                        throw new CoronacionException("¡PEÓN BLANCO CORONADO!");
                    }
                    break;
                }
            }
        }
        
    }
    
    public void moverPieza(Pieza p, Posicion pos) throws IllegalMovementException, CoronacionException {
        /* Apuntes sobre el objeto pos:
            - Sabemos que es una posición a la que puede acceder una pieza
            de forma reglamentaria
            - No sabemos si estará ocupada por otra pieza o no
            - No sabemos si puede ser una jugada ilegal*/
            
            Posicion posicionAntigua = p.getPosicion();
            this.limpiarPosicion(posicionAntigua);/*vaciamos la posición desde la que se movió la pieza*/
            Marcador[localizarCoordenadaX(pos)][localizarCoordenadaY(pos)] = p;/*Insertamos la pieza
            en la posición propuesta*/
            p.setPosicion(pos);/* actualizamos la posición de la pieza p*/
            this.actualizarTablero();/*Actualizamos el tablero.*/
            
        try {
            this.JugadaIlegal(p.getColor());//Si la jugada es ilegal, entonces "retrocedemos" todo.
        } catch (IllegalMovementException ex) {
            String s = ex.getMessage();
            p.setPosicion(posicionAntigua);/*Reasociamos la pieza p a su posición original*/
            Marcador[localizarCoordenadaX(posicionAntigua)][localizarCoordenadaY(posicionAntigua)] = p;
            /*Retrocedemos la pieza a la posición original en el tablero*/
            this.limpiarPosicion(pos);/*Borramos la pieza de la posición del movimiento propuesto*/
            this.actualizarTablero();/*Actualizamos el tablero.*/
            throw new IllegalMovementException(s); /*Lanzamos la excepción que indica que se ha
            producido un movimiento ilegal, para que pueda ser recogida por un método que utilice a moverPieza*/
        }
        /*Si hemos llegado a este punto, entonces no se ha lanzado la excepción
        IllegalMovementException. Por tanto, el movimiento propuesto es legal.
        Queda ver si el movimiento ha producido la coronación de uno de los peones.
        
        Lo haremos con el método peonCoronado, que lanzará una excepción en caso de haber coronado un peón,
        para que la pueda capturar un método que utilice a moverPieza.*/
        peonCoronado(p);
    }
    
    public void actualizarTablero(){
        for(int i = 0; i <= 7; i++){
            for(int j = 0; j <= 7; j++){
                if(Marcador[i][j] != null){
                    Marcador[i][j].calcularMovimientos();
                    /*calculamos los posibles movimientos de todas las piezas*/
                }
            }
        }
    }
    
    public void actualizarTableroColor(Color c){//No me sirve para nada
        for(int i = 0; i <= 7; i++){
            for(int j = 0; j <= 7; j++){
                if(Marcador[i][j] != null){
                    Color colorAux = Marcador[i][j].getColor();
                    if(!colorAux.equals(c)){
                        Marcador[i][j].calcularMovimientos();
                    }
                    /*calculamos los posibles movimientos de las piezas CONTRARIAS a un color*/
                }
            }
        }
    }
    
    Pieza localizarRey(Color colorRey){ /*Este método auxiliar nos permite localizar fácilmente al rey*/
        Pieza piezaAux;
        for(int i = 0; i <= 7; i++){
            for(int j = 0; j <= 7; j++){
                if(Marcador[i][j] != null){
                     piezaAux = Marcador[i][j];
                    if(piezaAux.getColor().equals(colorRey) && piezaAux.getNombre() == 'R'){
                        return piezaAux;
                    }
                }
            }
        }
        return null;//Si el tablero está bien introducido, nunca devolveremos null
    }
    
    public void JugadaIlegal(Color c) throws IllegalMovementException{
        if(Jaque(c)){
            throw new IllegalMovementException("¡Jugada ilegal! El rey "+c.toString()+ " está en jaque.");
        }
    }
    
    public boolean Jaque(Color colorRey){
        Pieza rey = localizarRey(colorRey);
        Posicion pos = rey.getPosicion();
        for(int i = 0; i <= 7; i++){
            for(int j = 0; j <= 7; j++){
                if(Marcador[i][j] != null){//Si hay una pieza en la posición i,j-ésima del array
                    if(Marcador[i][j].getPosiblesMovimientos().contains(pos)){//Si dicha pieza puede comerse al rey
                        return true;//Entonces, el rey esta en jaque
                    }
                }
            }
        }//Si ninguna pieza puede acceder a la posición donde está el rey, entonces el rey no está en jaque
        return false;
    }
    
    private int localizarCoordenadaX(Posicion pos){
        return 8 - pos.getCoordenadax();
        /* Este método nos va a devolver la fila del array Marcador
        en el que se encuentra la coordenada X de la posición */
    }
    
    private int localizarCoordenadaY(Posicion pos){
        return pos.getCoordenaday()-97;
        /* Este método nos va a devolver la columna del array Marcador
        en el que se encuentra la coordenada Y de la posición */
    }
    
    private void limpiarPosicion(Posicion pos){
        int x = localizarCoordenadaX(pos);
        int y = localizarCoordenadaY(pos);
        Marcador[x][y] = null;
        /* Este método hace que una posición del array Marcador pase a ser null 
        (nuestra forma de entender una casilla vacía)*/
    }
    
    ArrayList<Posicion> lecturaAlfil(Color c, Posicion pos){
        /*Vamos a implementar un método lecturaAlfil en Tablero para poder
        reutilizarlo tanto en en el caso del Alfil como en el caso de la Dama */
        
        /*
        Vamos a hacer 4 lecturas: diagonal superior derecha e izquierda, y
        diagonal inferior izquierda y derecha.
        */
        ArrayList<Posicion> arrayAux = new ArrayList<>();
        int i;
        char j;
        //Lectura diagonal superior derecha
        for(i = (pos.getCoordenadax() + 1), j = (char)(pos.getCoordenaday() + 1); i <= 8 && j <= 'h'; i++, j++){
            Posicion posAux = new Posicion(i, (char)(j) );
            if(!this.PosicionOcupada(posAux)){
                arrayAux.add(posAux); 
                /*Si la posición no está ocupada, la añadimos al array.*/
            }else{
                Color colorAux = this.GetPiezaPos(posAux).getColor();
                /*ColorAux será el color de la pieza que haya en la posición
                auxiliar.*/
                if(!c.equals(colorAux)){
                    arrayAux.add(posAux);/*Si no tienen el mismo color,
                    entonces añadimos la pieza (se puede comer)*/
                }
                break;
            }
        }
        
        //Lectura diagonal superior izquierda
        for(i = (pos.getCoordenadax() - 1), j = (char)(pos.getCoordenaday() + 1); i >= 1 && j <= 'h'; i--, j++){
            Posicion posAux = new Posicion(i, (char)(j) );
            if(!this.PosicionOcupada(posAux)){
                arrayAux.add(posAux);
            }else{
                Color colorAux = this.GetPiezaPos(posAux).getColor();
                if(!c.equals(colorAux)){
                    arrayAux.add(posAux);
                }
                break;
            }
        }
        
        //Lectura diagonal inferior izquierda
        for(i = (pos.getCoordenadax() - 1), j = (char)(pos.getCoordenaday() - 1); i >= 1 && j >= 'a'; i--, j--){
            Posicion posAux = new Posicion(i, (char)(j) );
            if(!this.PosicionOcupada(posAux)){
                arrayAux.add(posAux);
            }else{
                Color colorAux = this.GetPiezaPos(posAux).getColor();
                if(!c.equals(colorAux)){
                    arrayAux.add(posAux);
                }
                break;
            }
        }
        
        //Lectura diagonal inferior derecha
        for(i = (pos.getCoordenadax() + 1), j = (char)(pos.getCoordenaday() - 1); i <= 8 && j >= 'a'; i++, j--){
            Posicion posAux = new Posicion(i, (char)(j) );
            if(!this.PosicionOcupada(posAux)){
                arrayAux.add(posAux);
            }else{
                Color colorAux = this.GetPiezaPos(posAux).getColor();
                if(!c.equals(colorAux)){
                    arrayAux.add(posAux);
                }
                break;
            }
        }
        arrayAux.remove(pos);
        return arrayAux;
    }
    
    ArrayList<Posicion> lecturaTorre(Color c, Posicion pos){
        /*Vamos a implementar un método lecturaTorre en Tablero para poder
        reutilizarlo tanto en en el caso de la Torre como en el caso de la Dama */
        
        /*
        Vamos a hacer 4 lecturas: hacia arriba, hacia abajo, a la izquierda
        y a la derecha.
        */
        ArrayList<Posicion> arrayAux = new ArrayList<>();
        //Lectura hacia la derecha
        for(int j = (char)(pos.getCoordenaday() + 1); j <= 'h'; j++){
            Posicion posAux = new Posicion(pos.getCoordenadax(), (char)j);
            if(!this.PosicionOcupada(posAux)){
               arrayAux.add(posAux);
            }else{
                Color colorAux = this.GetPiezaPos(posAux).getColor();
                if(!c.equals(colorAux)){
                    arrayAux.add(posAux);
                }
                break;
            }
        }
        
        //Lectura hacia la izquierda
        for(int j = (char)(pos.getCoordenaday() - 1); j >= 'a'; j--){
            Posicion posAux = new Posicion(pos.getCoordenadax(), (char)j);
            if(!this.PosicionOcupada(posAux)){
               arrayAux.add(posAux);
            }else{
                Color colorAux = this.GetPiezaPos(posAux).getColor();
                if(!c.equals(colorAux)){
                    arrayAux.add(posAux);
                }
                break;
            }
        }
        
        //Lectura hacia arriba
        for(int i = (pos.getCoordenadax() + 1); i <= 8; i++){
            Posicion posAux = new Posicion(i, pos.getCoordenaday());
            if(!this.PosicionOcupada(posAux)){
               arrayAux.add(posAux);
            }else{
                Color colorAux = this.GetPiezaPos(posAux).getColor();
                if(!c.equals(colorAux)){
                    arrayAux.add(posAux);
                }
                break;
            }
        }
        
        //Lectura hacia abajo
        for(int i = (pos.getCoordenadax() - 1); i >= 1; i--){
            Posicion posAux = new Posicion(i, pos.getCoordenaday());
            if(!this.PosicionOcupada(posAux)){
               arrayAux.add(posAux);
            }else{
                Color colorAux = this.GetPiezaPos(posAux).getColor();
                if(!c.equals(colorAux)){
                    arrayAux.add(posAux);
                }
                break;
            }
        }
        arrayAux.remove(pos);
        return arrayAux;
    }
    
    public void limpiarTablero(){
        for(int i=0; i<=7; i++){
            for(int j=0;j<=7; j++){
                Marcador[i][j] = null;
            }
        }
    }
    
    void imprimirTablero(){
        for(int i=0; i<=7; i++){
            for(int j=0; j<=7; j++){
                if(Marcador[i][j] == null){
                    System.out.print("V,");
                }else{
                    Posicion pos = new Posicion(8-i, (char)(97+j));//creamos una posición con i y j
                    Pieza p = this.GetPiezaPos(pos);//recogemos la pieza asociada a la posición pos
                    System.out.print(p.toString());
                    if(j != 7){
                        System.out.print(",");
                    }
                }
            }
            System.out.println(" ");
        }
    }
    
    ArrayList<Pieza> ObtenerPiezasColor (Color c){
        /*Este método nos permite obtener todas las piezas
        de un color c*/
        ArrayList<Pieza> PiezasColor = new ArrayList<>();
        for(int i=0; i<=7; i++){
            for(int j=0; j<=7; j++){
                if(Marcador[i][j] != null){//Si la posición no está ocupada
                    if(Marcador[i][j].getColor().equals(c)){/*Si la pieza que ocupa la posición
                    tiene el mismo color que c*/
                        PiezasColor.add(Marcador[i][j]);/*Entonces añadimos la pieza al arrayList*/
                    }
                }
            }
       }
        return(PiezasColor);
    }
  
    public boolean JaqueMate(Color c){
        ArrayList<Pieza> piezasColorC = this.ObtenerPiezasColor(c);
        ArrayList<Posicion> arrayAux;
        boolean mate = true;
        for(Pieza p: piezasColorC){
            arrayAux = p.getPosiblesMovimientos();
            for(Posicion pos: arrayAux){
                try{
                    this.moverPieza(p, pos);
                    mate = false;/*Si hemos llegado a esta línea, hemos encontrado una jugada
                    que no es ilegal, por tanto no es jaque mate.*/
                }catch(IllegalMovementException | CoronacionException e){
                    /*No queremos hacer nada, porque estamos 
                    probando jugadas por fuerza bruta.
                    Si accedemos a este bloque, es porque
                    la jugada probada era ilegal.*/
                }
            }
        }
        return mate;
    }
    
    public void tableroIlegal() throws IllegalTableroException{
        this.comprobarTableroLegal();
        if(tableroIlegal == true){
            throw new IllegalTableroException("El tablero es ilegal");
        }else{
            if(Jaque(new Color('n'))){
                throw new IllegalTableroException("El tablero es ilegal"
                        + " porque el rey negro está en jaque.");
            }
            if(Jaque(new Color('b'))){
                throw new IllegalTableroException("El tablero es ilegal"
                        + " porque el rey negro está en jaque.");
            }
        }
    }
}

