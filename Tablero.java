/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_final;

import java.util.ArrayList;

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
    public Pieza GetPiezaPos (int x , char y){ //recuperar pieza en una posición dada
        return(Marcador[x-1][Character.getNumericValue(y)-97]);
    }
    
    public Pieza GetPiezaPos (Posicion p){ //recuperar pieza en una posición dada
        return(Marcador[p.getCoordenadax()-1][Character.getNumericValue(p.getCoordenaday())-97]);
    }
    
    
    public boolean PosicionOcupada(int x, char y){//comprobamos si la posición está ocupada
        return (Marcador[x-1][Character.getNumericValue(y)-97] != null);
    }
    
    public boolean PosicionOcupada(Posicion pos){
        int x = localizarCoordenadaX(pos);
        int y = localizarCoordenadaY(pos);
        return (Marcador[x][y] != null);
    }
    
    public void comprobarTableroLegal(){
        boolean legalReyes = contReyNegro == 1 && contReyBlanco == 1;
        //boolean legalPeones = contPeonNegro <= 8 && contPeonBlanco <= 8;
        int piezasExtrasNegra =0;
        int piezasExtrasBlancas = 0;
        
        if (contDamaBlanca > 1){
            piezasExtrasBlanca += contDamaBlanca -1;
        }
        if (contTorreBlanca > 2){
            piezasExtrasBlanca +=contTorreBlanca - 2 ;
        }       
        if (contCaballoBlanco >2){
            piezasExtrasBlanca += contCaballoBlanco -2;
        }
        if (contAlfilBlancoCasillasBlancas > 1)
            piezasExtrasblanco +=contAlfilBlancoCasillasBlancas -1;
        }
        if(contAlfilBlancoCasillasNegas > 1){
            piezasExtrasBlanco += contAlfilBlancoCasillasNegas - 1;
            
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
        return(legalReyes && ((piezasExtrasNegra + contPeonNegro) <= 8) && ((piezasExtrasBlanca + contPeonBlanco)<= 8)
        
       // boolean legalDamas = contDamaNegra <= 1 && contDamaBlanca <= 1;
       // boolean legalTorres = contTorreNegra <= 2 && contTorreBlanca <= 2;
       //boolean legalCaballos = contCaballoNegro <= 2 && contCaballoBlanco <= 2;
       //boolean legalAlfiles = contAlfilBlancoCasillasBlancas <= 1 && contAlfilBlancoCasillasNegras <= 1
       //       && contAlfilNegroCasillasBlancas <= 1 && contAlfilNegroCasillasNegras <= 1; 
       // tableroIlegal = legalReyes && legalPeones && legalDamas && legalTorres && legalCaballos && legalAlfiles && !tableroIlegal;
    }
    
    public void insertarPieza(String pstring, Posicion pos){/*método para inicializar el tablero*/
        int x = localizarCoordenadaX(pos);
        int y = localizarCoordenadaY(pos);
        char colorPieza = pstring.charAt(1);
        if (PosicionOcupada(pos)){
            tableroIlegal = true; /*Si intentamos introducir la pieza donde ya hay otra,
            el tablero es ilegal*/
        }
        switch(pstring.charAt(0)){
            case 'R':
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
                Marcador[x][y] = new Rey(colorPieza, this, pos);
                break;
            }
            case 'A':
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
            }
            case 'T':
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
                Marcador[x][y] = new Torre(colorPieza, this, pos);
                break;
            }
            
            case 'D':
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
                Marcador[x][y] = new Dama(colorPieza, this, pos);
                break;
            }
            case 'P':
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
                Marcador[x][y] = new Peon(colorPieza, this, pos);
                break;
            }
            case 'C':
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
                Marcador[x][y] = new Caballo(colorPieza, this, pos);
                break;
            }
            case 'V':
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
    
    public void moverPieza(Pieza p, Posicion pos){
        /* Apuntes sobre el objeto pos:
            - Sabemos que es una posición reglamentaria
            - No sabemos si está ocupada*/
        Posicion posicionAntigua = p.getPosicion();
        this.limpiarPosicion(posicionAntigua);/*vaciamos la posición desde la que se movió la pieza*/
        
        Marcador[localizarCoordenadaX(pos)][localizarCoordenadaY(pos)] = p;
        /* actualizamos el tablero con la pieza movida*/
        
        p.setPosicion(pos);
        /* actualizamos la pieza con la nueva posición */
        
        for(int i = 0; i <= 7; i++){
            for(int j = 0; j <= 7; j++){
                if(Marcador[i][j] != null){
                    Marcador[i][j].calcularMovimientos();
                    /*calculamos los posibles movimientos de todas las piezas*/
                }
            }
        }
    }
    
    public boolean jugadaIlegalRey(Pieza p, Posicion pos){
        /*En este método vamos a comprobar si la posición introducida 
        forma parte de las posiciones posibles de una pieza contraria,
        para saber si la posición posible a la que se puede mover el rey es
        legal o no, de la siguiente forma:
        
            1. Guardamos la posición en la que se encuentra el rey
            2. Movemos el rey
            3. Tras mover el rey, se actualiza el array de posibles movimientos
        de todas las piezas
            4. Si alguna pieza del color contrario se puede comer al rey,
        entonces la jugada era ilegal. En ese caso, movemos el rey a la 
        posición original y devolvemos true.
            5. Si ninguna pieza del color contrario se puede comer al rey,
        entonces la jugada era legal. En ese caso, movemos el rey a la 
        posición original y devolvemos false.
        */
        Posicion posAntigua = p.getPosicion();
        moverPieza(p,pos);
        for(int i = 0; i <= 7; i++){
            for(int j = 0; j <= 7; j++){
                if(Marcador[i][j] != null){
                    ArrayList<Posicion> arrayAuxiliar = 
                            Marcador[i][j].getPosiblesMovimientos();
                    if(arrayAuxiliar.contains(pos)){
                        moverPieza(p, posAntigua);
                        return true;
                    }
                }
            }
        }
        moverPieza(p, posAntigua);
        return false; /*Si se devuelve false, entonces el rey puede moverse
        a la posición introducida*/
    }
    
    private int localizarCoordenadaX(Posicion pos){
        return pos.getCoordenadax()-1;
        /* Este método nos va a devolver la fila del array Marcador
        en el que se encuentra la coordenada X de la posición */
    }
    
    private int localizarCoordenadaY(Posicion pos){
        return Character.getNumericValue(pos.getCoordenaday())-97;
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
        ArrayList<Posicion> arrayAux = null;
        int i;
        char j;
        //Lectura diagonal superior derecha
        for(i = pos.getCoordenadax(), j = pos.getCoordenaday(); i <= 8 && j <= 'h'; i++, j++){
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
        
        //Lectura diagonal superior izquierda
        for(i = pos.getCoordenadax(), j = pos.getCoordenaday(); i >= 1 && j <= 'h'; i--, j++){
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
        for(i = pos.getCoordenadax(), j = pos.getCoordenaday(); i >= 1 && j >= 'a'; i--, j--){
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
        for(i = pos.getCoordenadax(), j = pos.getCoordenaday(); i <= 8 && j >= 'a'; i++, j--){
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
        ArrayList<Posicion> arrayAux = null;
        //Lectura hacia la derecha
        for(int j = pos.getCoordenaday(); j <= 'h'; j++){
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
        for(int j = pos.getCoordenaday(); j >= 'a'; j--){
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
        for(int i = pos.getCoordenadax(); i <= 8; i++){
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
        for(int i = pos.getCoordenadax(); i >= 1; i--){
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
}

