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
    private String nombre;
    private ArrayList<Posicion> posiblesMovimientos = new ArrayList<Posicion>();
    public Color getColor(){
        return color.toString();
    }
    public void setPosiblesMovimientos (ArrayList<Posicion> movimientos){
        posiblesMovimientos = movimientos;
    }
    public ArrayList<Posicion> getPosiblesMovimientos(){
        return posiblesMovimientos;   
    }
    public String toString(){
        return(this.color.toString() + nombre);
    }
    public abstract ArrayList<Posicion> calcularMovimientos();
    @Override
    public abstract String toString();
    public abstract void Mover(Posicion p) throws IllegalMovementException;
}
