package p_final;

import java.util.ArrayList;

public class Alfil extends Pieza{
    public Alfil (char color, Tablero t, Posicion pos){
        super(new Color(color), 'A', t, pos);/*Llamar al constructor de Pieza*/
     }

    @Override
    public void calcularMovimientos(){
        /*
            Etiquetas:
            (1) Recogemos el mensaje de tipo Tablero asociado al objeto de tipo Alfil
            (2) Utilizaremos un array auxiliar sobre el que guardaremos el resultado de un
            método 
        */
        Tablero t = this.getTablero();/*Recogemos el tablero asociado a la pieza*/
        ArrayList<Posicion> aposiciones = t.lecturaAlfil(this.getColor(), this.getPosicion());/**/
        this.setPosiblesMovimientos(aposiciones);
    }
}
