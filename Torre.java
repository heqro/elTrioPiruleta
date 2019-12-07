package p_final;

import java.util.ArrayList;

public class Torre extends Pieza{
    public Torre (char color, Tablero t){
        super(new Color(color), 'T', t);
    }

    public ArrayList<Posicion> calcularMovimientos(Tablero t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Posicion> calcularMovimientos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
