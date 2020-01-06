package p_final;

import java.util.ArrayList;
import java.io.Serializable;

public class Torre extends Pieza implements Serializable{
    public Torre (char color, Tablero t, Posicion pos){
        super(new Color(color), 'T', t, pos);
    }
     
    @Override 
    public void calcularMovimientos(){
         /*
            Etiquetas:
            (1) Recogemos el mensaje de tipo Tablero asociado al objeto de tipo Torre
            (2) Utilizaremos un array auxiliar sobre el que guardaremos el resultado de un
            método para leer en horizontal y vertical del propio tablero
            (3) Asignaremos al mensaje de tipo Tablero el nuevo array de posibles posiciones
        */
        Tablero t = this.getTablero();//(1)
        ArrayList<Posicion> aposiciones = t.lecturaTorre(this.getColor(), this.getPosicion());//(2)
        this.setPosiblesMovimientos(aposiciones);//(3)
    }
}
