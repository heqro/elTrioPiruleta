package p_final;

import java.util.ArrayList;


public class Alfil extends Pieza{
    public Alfil (char color){
        super(new Color(color), 'A');
     }

    @Override
    public ArrayList<Posicion> calcularMovimientos(Tablero t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
