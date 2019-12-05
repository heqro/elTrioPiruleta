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
    private Color color;
    private char nombre;
    private ArrayList<Posicion> posiblesMovimientos = new ArrayList<Posicion>();
    private Tablero tablero;
    
    public Pieza(Color c, char nombre,Tablero tablero){
        this.color = c;
        this.nombre = nombre;
        this.tablero = tablero;
    }
    
    public Color getColor(){
        return color;
    }
    
    public char getNombre(){
        return nombre;
    }
    public void setTablero(Tablero t){
        tablero=t;
    }
    public Tablero getTablero(){
        return tablero;
    }
    
    @Override
    public String toString(){
        return (getNombre() + getColor().toString());   
    }
    
    public abstract ArrayList<Posicion> calcularMovimientos();
    public void Mover(Posicion p) throws IllegalMovementException{
        if (!posiblesMovimientos.contains(p))
        {
            throw (new IllegalMovementException());
        }
        else
        {
            this.getTablero().moverPieza(this.toString(), p);
        }  
    }
}
