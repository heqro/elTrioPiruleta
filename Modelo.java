/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_final;

/**
 *
 * @author juans
 */
public class Modelo {
    private Tablero tablero;
    private String jugada_ganadora;
    public Modelo(Tablero t, String s){
        tablero = t;
        jugada_ganadora = s;
    }    
    public Tablero getTablero(){
        return tablero;
    }
    public String getSolucion(){
        return jugada_ganadora;
    }
    public boolean proponerMovimiento(String mov){
        return (jugada_ganadora.equals(mov));
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
