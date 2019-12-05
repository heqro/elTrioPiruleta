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
    public Pieza (Color c, String n){
        color = c;
        nombre =n;
    }
    public Color getColor(){
        return color;
    }
    public void setPosiblesMovimientos (ArrayList<Posicion> movimientos){
        posiblesMovimientos = movimientos;
    }
    public ArrayList<Posicion> getPosiblesMovimientos(){
        return posiblesMovimientos;   
    }
    public String toString(){
        return( nombre + this.color.toString() );
    }
    public String getNombre(){
        return (nombre);
    }
    @Override

}
