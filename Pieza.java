package p_final;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author hr.iglesias.2018
 */
public abstract class Pieza {
    private final Color color;
    private char nombre;
    private ArrayList<Posicion> posiblesMovimientos;
    private Tablero tablero;
    private Posicion posPieza;

    public Pieza(Color c, char nombre, Tablero tablero, Posicion posPieza){
        this.color = c;
        this.nombre = nombre;
        this.tablero = tablero;
        this.posPieza = posPieza;
    }
    
    public Color getColor(){
        return color;
    }
    
    public char getNombre(){
        return nombre;
    }
    
    public Posicion getPosicion(){
        return posPieza;
    }
    
    public void setTablero(Tablero t){
        tablero=t;
    }
    public Tablero getTablero(){
        return tablero;
    }
    
    public void setPosicion(Posicion p){
        this.posPieza = p;
    }
    
    public ArrayList<Posicion> getPosiblesMovimientos(){
        return posiblesMovimientos;
    }
    
    public void setPosiblesMovimientos(ArrayList<Posicion> posiblesMovimientos){
        this.posiblesMovimientos = posiblesMovimientos;
    }
    
    @Override
    public String toString(){
        return getNombre() + getColor().toString();   
    }
    

    
    public void Mover(Posicion p) throws IllegalMovementException, CoronacionException{
        if (!posiblesMovimientos.contains(p)){
            throw (new IllegalMovementException("El movimiento propuesto no"
                    + " se corresponde con un movimiento que pueda realizar la pieza."));
        }else{
            this.getTablero().moverPieza(this, p);
        }
    }
    @Override
    public boolean equals(Object o){
        if(o == null){ return false; }
        if(this == o){ return true; }
        if(this.getClass() != o.getClass()){ return false; }
        Pieza p = (Pieza) o;
        return (this.nombre == p.nombre) && this.getPosicion().equals(p.getPosicion()) 
                && this.getColor().equals(p.getColor()) && this.tablero == p.tablero;
    }
    public abstract void calcularMovimientos();
}

