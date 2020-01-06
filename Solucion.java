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
        if(cadenaSolucion.length() == 4 || cadenaSolucion.length() == 5){/*solo aceptaremos como válidas
        aquellas soluciones de longitud de caracteres = 4 (soluciones sin coronación) o igual a 5 (soluciones
        con coronación, o con un caracter basura al final).*/
            int posInicialX = Character.getNumericValue(cadenaSolucion.charAt(0));/*recoger el número asociado
            al primer caracter del String*/
            char posInicialY = cadenaSolucion.charAt(1);/*recoger la letra asociada al segundo caracter
            del string*/
            posInicial = new Posicion(posInicialX, posInicialY);/*creamos posición inicial con los datos recogidos*/
            int posFinalX = Character.getNumericValue(cadenaSolucion.charAt(2));/*recoger número asociado al tercer
            caracter del String*/
            char posFinalY = cadenaSolucion.charAt(3);/*recoger letra asociada al cuarto caracter del String*/
            posFinal = new Posicion(posFinalX, posFinalY);/*crear posición final con los datos recogidos*/
            if(cadenaSolucion.length() == 5 ){//si hay un caracter más en la cadena,
                letraCoronacion = cadenaSolucion.charAt(4);/*lo recogemos en letraCoronacion*/
            }else{
                letraCoronacion = 'x';//Caracter basura que no utilizaremos.
            }
        }else{
            throw new IllegalFormatException("Formato de solución incorrecto: se esperaba"
                    + "fila x inicial, columna y inicial, fila x final, columna y final (y, si procede, letra"
                    + "con la que se realice la coronación)");
        }
    }
    
    public Solucion(Solucion s){//crear solución como copia de otra dada
        posInicial = new Posicion(s.getPosInicial());
        posFinal = new Posicion(s.getPosFinal());
        letraCoronacion = s.getLetraCoronacion();
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
    public boolean equals(Object o){/*dos piezas son iguales si coinciden las posiciones finales y las iniciales.*/
        if (o == null){return false;}
        if (o==this){return true;}
        if (getClass()!=o.getClass()){return false;}
        Solucion s = (Solucion) o;
        return(posFinal.equals(s.posFinal)&& posInicial.equals(s.posInicial));
    }
}
