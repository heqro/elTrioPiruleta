package p_final;

import java.util.ArrayList;

public class Torre extends Pieza{
    public Torre (char color){
        super(new Color(color), 'T', tablero);
    }

    @Override
    public ArrayList<Posicion> calcularMovimientos(Tablero t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
