package p_final;

import java.util.ArrayList;


public class Dama extends Pieza{
    public Dama (char color, Tablero t){
        super(new Color(color), 'D', t);
    }

    public ArrayList<Posicion> calcularMovimientos(Tablero t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Posicion> calcularMovimientos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
