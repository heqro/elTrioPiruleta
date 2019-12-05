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
    private static int contadorRey = 0;
    private static int contadorAlfil = 0;
    private static int contadorPeon = 0;
    private static int contadorDama = 0;
    private static int contadorTorre = 0;
    private static int contadorCaballo = 0;
    public Tablero(Pieza M[][]){
        Marcador = M;
    }
    private void insertarPieza(String pstring, int x, int y){
        switch(pstring.charAt(0)){
            case 'R':
            {
                contadorRey++;
                Marcador[x][y] = new Rey(pstring.charAt(1));
            }
            case 'A':
            {
                contadorAlfil++;
                Marcador[x][y] = new Alfil(pstring.charAt(1));
            }
            case 'T':
            {
                contadorTorre++;
                Marcador[x][y] = new Torre(pstring.charAt(1));
            }
            
            case 'D':
            {
                contadorDama++;
                Marcador[x][y] = new Dama(pstring.charAt(1));
            }
            case 'P':
            {
                contadorPeon++;
                Marcador[x][y] = new Peon(pstring.charAt(1));
            }
            case 'C':
            {
                contadorCaballo++;
                Marcador[x][y] = new Caballo(pstring.charAt(1));
            }
            default: //caso de 'V'
            {
                Marcador[x][y] = null;
            }
        }
        
    }
}
