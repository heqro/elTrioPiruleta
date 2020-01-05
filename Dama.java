package p_final;

import java.util.ArrayList;
import java.io.Serializable;

public class Dama extends Pieza implements Serializable{
    public Dama (char color, Tablero t, Posicion pos){
        super(new Color(color), 'D', t, pos);
    }

    @Override
    public void calcularMovimientos(){
        /*
            Etiquetas:
            (1) Recogemos el mensaje de tipo Tablero asociado al objeto de tipo Dama
            (2) Utilizaremos un arrayList auxiliar sobre el que guardaremos el resultado de un
            método para leer en diagonal y en horizontal y vertical del propio tablero
            (3) Guardamos el resultado de las lecturas en un arrayList
            (4) Asignaremos al mensaje de tipo Tablero el nuevo arrayList de posibles posiciones
        */
        ArrayList<Posicion> aposiciones = new ArrayList();
        ArrayList<Posicion> aposicionesAux = new ArrayList();
        Tablero t = this.getTablero();//(1)
        aposiciones = t.lecturaTorre(this.getColor(), this.getPosicion());//(2)
        aposicionesAux = t.lecturaAlfil(this.getColor(), this.getPosicion());//(2)
        aposiciones.addAll(aposicionesAux);//(3)
        this.setPosiblesMovimientos(aposiciones);//(4)
    }
}
