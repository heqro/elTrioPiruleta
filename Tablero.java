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
    
    public Tablero(Pieza M[][]){
        Marcador= M;
        
    }
    private void insertarPieza(String pstring, int x, int y){
        switch(pstring.charAt(0)){
            case 'R':
                if (pstring.charAt(1)=='B'){
                    
                    
                    
                }
        }
        
    }
}
