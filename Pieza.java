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
    private ArrayList<Posicion> posiblesMovimientos = new ArrayList<Posicion>();
    public abstract void Mover(Posicion p) throws IllegalMovementException;
    
    
    @Override
    public abstract String toString();
    
    public Posicion getPosicion(){
        return pos;
    }
    
    public void setPosicion(Posicion p){
        pos = p;//
    }
    
    public abstract String getColor(){
        return color.toString();
    }
    
    public ArrayList<Posicion> getPosiblesMovimientos(){
        return posiblesMovimientos;   
    }
    
    public abstract ArrayList<Posicion> calcularMovimientos();
}
