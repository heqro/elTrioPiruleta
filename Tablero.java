/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_final;

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
//    public Pieza GetPiezaPos (int x , char y){ //recuperar pieza en una posición dada
//        return(Marcador[x-1][Character.getNumericValue(y)-97]);
//    }
    
    public Pieza GetPiezaPos (Posicion p){ //recuperar pieza en una posición dada
        return(Marcador[p.getCoordenadax()-1][Character.getNumericValue(p.getCoordenaday())-97]);
    }
    
    
//    public boolean PosicionOcupada(int x, char y){//comprobamos si la posición está ocupada
//        return (Marcador[x-1][Character.getNumericValue(y)-97] != null);
//    }
    
    public boolean PosicionOcupada(Posicion pos){
        int x = localizarCoordenadaX(pos);
        int y = localizarCoordenadaY(pos);
        return (Marcador[x][y] != null);
    }
    
    public void comprobarTableroLegal(){
        boolean legalReyes = contReyNegro == 1 && contReyBlanco == 1;
        boolean legalPeones = contPeonNegro <= 8 && contPeonBlanco <= 8;
        boolean legalDamas = contDamaNegra <= 1 && contDamaBlanca <= 1;
        boolean legalTorres = contTorreNegra <= 2 && contTorreBlanca <= 2;
        boolean legalCaballos = contCaballoNegro <= 2 && contCaballoBlanco <= 2;
        boolean legalAlfiles = contAlfilBlancoCasillasBlancas <= 1 && contAlfilBlancoCasillasNegras <= 1
                && contAlfilNegroCasillasBlancas <= 1 && contAlfilNegroCasillasNegras <= 1; 
        tableroIlegal = legalReyes && legalPeones && legalDamas && legalTorres && legalCaballos && legalAlfiles && !tableroIlegal;
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
                Marcador[x][y] = new Rey(colorPieza, this);
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
                Marcador[x][y] = new Torre(colorPieza, this);
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
                Marcador[x][y] = new Dama(colorPieza, this);
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
                Marcador[x][y] = new Peon(colorPieza, this);
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
                Marcador[x][y] = new Rey(colorPieza, this);
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
}

