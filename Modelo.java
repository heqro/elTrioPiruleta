/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_final;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juans
 */
public class Modelo {
    private Tablero tablero;
    private Solucion jugada_ganadora;
    public Modelo(Tablero t, Solucion s){
        tablero = t;
        jugada_ganadora = s;
    }    
    public Tablero getTablero(){
        return tablero;
    }
    public Solucion getSolucion(){
        return jugada_ganadora;
    }
    public boolean proponerMovimiento(Solucion sol) throws IllegalMovementException{
        if(!tablero.PosicionOcupada(sol.getPosInicial())){
            return false;
        }else{
            tablero.actualizarTablero();
            Pieza piezaMover = tablero.GetPiezaPos(sol.getPosInicial());
            tablero.moverPieza(piezaMover, sol.getPosFinal());/*Si algo va mal, se lanzará la excepción
            IllegalMovementException*/
            return tablero.JaqueMate(new Color ('n'));
        }
    } 
    @Override
    public boolean equals(Object o){
        if (o == null){
            return false;
        }
        
        if (this == o){
            return true;
        }
        
        if (getClass() != o.getClass()){
            return false;
        }
        Modelo pos = (Modelo) o;
        return (tablero.equals(pos.getTablero()) && jugada_ganadora.equals(pos.getSolucion()));
    }
    
    
}
