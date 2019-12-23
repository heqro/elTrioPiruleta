package p_final;

import java.util.ArrayList;


public class Peon extends Pieza{
    public Peon (char color, Tablero t){
        super(new Color(color), 'P', t);
    }

    public ArrayList<Posicion> calcularMovimientos(Tablero t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    public ArrayList<Posicion> calcularMovimientos(Posicion coordenada) {
        ArrayList<Posicion> aposiciones = new ArrayList();
        int x  = coordenada.getCoordenadax();
        char y = coordenada.getCoordenaday();
        aposiciones.add(coordenada);
        
        int xaux= x;
        xaux=xaux+1;
        aposiciones.add(new Posicion (xaux,y));
        if (y=='b'){
            aposiciones.add(new Posicion (xaux+1,y));
        }
        
        
        
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
