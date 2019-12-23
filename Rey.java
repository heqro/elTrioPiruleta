package p_final;

import java.util.ArrayList;

public class Rey extends Pieza{
    public Rey (char color, Tablero t){
        super(new Color(color), 'R', t);
    }

    public ArrayList<Posicion> calcularMovimientos(Tablero t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Posicion> calcularMovimientos(Posicion coordenada) {
        ArrayList<Posicion> aposiciones = new ArrayList();
        int x  = coordenada.getCoordenadax();
        char y = coordenada.getCoordenaday();
        char y1 = (char)(Character.getNumericValue(y)+1);
        char y2 = (char)(Character.getNumericValue(y)+1);
        if (y<'h')aposiciones.add(new Posicion (x,y1));
        if (y>'a')aposiciones.add(new Posicion (x,y2));
        aposiciones.add(new Posicion (x,y));
        if(y<'h' && x<8)aposiciones.add(new Posicion (x+1,y1));
        if(y>'a' && x<8)aposiciones.add(new Posicion (x+1,y2));
        if(x<8)aposiciones.add(new Posicion (x+1,y));
        if(x>1)aposiciones.add(new Posicion (x-1,y));
        if(y<'h' && x>1)aposiciones.add(new Posicion (x-1,y1));
        if(y>'a' && x>1)aposiciones.add(new Posicion (x-1,y2));
        
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
