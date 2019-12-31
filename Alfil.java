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
            método para leer en diagonal del propio tablero
            (3) Asignaremos al mensaje de tipo Tablero el nuevo array de posibles posiciones
        */
        Tablero t = this.getTablero();//(1)
        ArrayList<Posicion> aposiciones = t.lecturaAlfil(this.getColor(), this.getPosicion());//(2)
        this.setPosiblesMovimientos(aposiciones);//
    }
}
