package p_final;

import java.util.ArrayList;


public class Caballo extends Pieza{
    public Caballo (char color, Tablero t){
        super(new Color(color), 'C', t);
    }

    public ArrayList<Posicion> calcularMovimientos(Tablero t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Posicion> calcularMovimientos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
