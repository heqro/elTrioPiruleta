/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_final;

/**
 *
 * @author Heqro
 */
public class Solucion {
    private Posicion posInicial;
    private Posicion posFinal;
    public Solucion(String cadenaSolucion) throws IllegalFormatException{
        if(cadenaSolucion.length() == 4){
            int posInicialX = Integer.parseInt(cadenaSolucion.substring(0, 0));
            char posInicialY = cadenaSolucion.charAt(1);
            posInicial = new Posicion(posInicialX, posInicialY);
            int posFinalX = Integer.parseInt(cadenaSolucion.substring(3, 3));
            char posFinalY = cadenaSolucion.charAt(4);
            posFinal = new Posicion(posFinalX, posFinalY);
        }else{
            throw new IllegalFormatException("Formato de solución incorrecto: se esperaba"
                    + "fila x inicial, columna y inicial, fila x final, columna y final.");
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
}
