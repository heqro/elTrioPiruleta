/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_final;
import java.io.Serializable;

/**
 *
 * @author Heqro
 */
public class Solucion implements Serializable{
    private Posicion posInicial;
    private Posicion posFinal;
    private char letraCoronacion;
    public Solucion(String cadenaSolucion) throws IllegalFormatException{
        if(cadenaSolucion.length() == 4 || cadenaSolucion.length() == 5){
            int posInicialX = Character.getNumericValue(cadenaSolucion.charAt(0));
            char posInicialY = cadenaSolucion.charAt(1);
            posInicial = new Posicion(posInicialX, posInicialY);
            int posFinalX = Character.getNumericValue(cadenaSolucion.charAt(2));
            char posFinalY = cadenaSolucion.charAt(3);
            posFinal = new Posicion(posFinalX, posFinalY);
            if(cadenaSolucion.length() == 5 ){
                letraCoronacion = cadenaSolucion.charAt(4);
            }else{
                letraCoronacion = 'x';//Caracter basura que no utilizaremos.
            }
        }else{
            throw new IllegalFormatException("Formato de solución incorrecto: se esperaba"
                    + "fila x inicial, columna y inicial, fila x final, columna y final (y, si procede, letra"
                    + "con la que se realice la coronación)");
        }
    }
    @Override
    public String toString(){
        return ("Posición inicial: "+posInicial.toString() +"\n"
                + "Posición final: " + posFinal.toString());
    }
    
    public Posicion getPosInicial(){
        return posInicial;
    }
    public Posicion getPosFinal(){
        return posFinal;
    }
    
    public char getLetraCoronacion(){
        return letraCoronacion;
    }
    public boolean equals(Object o){
        if (o == null){return false;}
        if (o==this){return true;}
        if (getClass()!=o.getClass()){return false;}
        Solucion s = (Solucion) o;
        return(posFinal.equals(s.posFinal)&& posInicial.equals(s.posInicial));
    }
}
