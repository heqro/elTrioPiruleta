/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_final;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.Serializable;

/**
 *
 * @author juans
 */
public class Modelo implements Serializable{
    private Tablero tablero;
    private Solucion jugada_ganadora;
    public Modelo(Tablero t, Solucion s){
        tablero = t;
        jugada_ganadora = s;
    }
    public Modelo (Modelo M){
        try {
            tablero = new Tablero(M.getTablero());
            jugada_ganadora = new Solucion(M.getSolucion());
        } catch (IllegalTableroException ex) {//nunca saldrá este caso
            System.out.println("fallo al copiar modelo");
        }
    }
    
    public Tablero getTablero(){
        return tablero;
    }
    public Solucion getSolucion(){
        return jugada_ganadora;
    }
    public boolean proponerMovimiento(Solucion sol) throws CoronacionException{
        if(!tablero.PosicionOcupada(sol.getPosInicial())){
            return false;
        }else{
            tablero.actualizarTablero();
            Pieza piezaMover = tablero.GetPiezaPos(sol.getPosInicial());
            try {
                tablero.moverPieza(piezaMover, sol.getPosFinal());
            } catch (IllegalMovementException ex) {
                return false;/*Si la jugada es ilegal, el método termina aquí: no nos interesa
                saber si la jugada provocaba una coronación o no del peón.*/
            } catch (CoronacionException ex){
                throw new CoronacionException(ex.getMessage());/*Si hemos coronado un peón, la
                resolución del problema no termina aquí, sino que necesitamos saber en qué pieza
                quiere coronar el jugador.*/
            }
            return tablero.JaqueMate(new Color ('n'));/*Si hemos llegado a este punto del código,
            solo puede ser debido a una jugada legal de una pieza que no provoque coronación,
            en cuyo caso comprobamos si es jaque mate.*/
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
        Modelo m = (Modelo) o;
        return tablero.equals(m.getTablero());/*dos modelos son iguales
        si sus tableros asociados lo son, (no tienen por qué ser iguales las soluciones, pues
        pueden haber problemas con múltiples soluciones)*/
    }
    
    
}
