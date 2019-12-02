package p_final;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hr.iglesias.2018
 */
public abstract class Pieza {
    private Posicion pos;
    private Color color;
    private String nombre;
    public abstract void Mover(Posicion p) throws IllegalMovementException;
    public abstract String getColor();
    @Override
    public abstract String toString();
        public Posicion getPosicion(){
        return pos;
    }
}
