package p_final;

import java.util.ArrayList;


public class Dama extends Pieza{
    public Dama (char color){
        super(new Color(color), 'D');
    }

    @Override
    public ArrayList<Posicion> calcularMovimientos(Tablero t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Mover(Posicion p) throws IllegalMovementException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
