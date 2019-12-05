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
    
    public Pieza(Color c, char nombre){
        this.color = c;
        this.nombre = nombre;
    }
    
    public Color getColor(){
        return color;
    }
    
    public char getNombre(){
        return nombre;
    }
    
    @Override
    public String toString(){
        return (getNombre() + getColor().toString());   
    }
    
    public abstract ArrayList<Posicion> calcularMovimientos();
    public abstract void Mover(Posicion p) throws IllegalMovementException;
}
