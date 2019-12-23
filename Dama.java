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
    public ArrayList<Posicion> calcularMovimientos(Posicion coordenada) {
        ArrayList<Posicion> aposiciones = new ArrayList();
        int x  = coordenada.getCoordenadax();
        char y = coordenada.getCoordenaday();
        int xaux=x;
        char yaux=y;
        aposiciones.add(coordenada);
        
        while( x < 8 ||  y< 'h'){ //diagonal sup derecha
            x= x+1;
            int yn= Character.getNumericValue(y);
            yn=yn + 1;
            y = (char)yn;
            aposiciones.add(new Posicion(x,y));
            
        }
        x=xaux;
        y=yaux;
        while( x < 8 ||  y> 'a'){ //diagonal sup izda
            x= x+1;
            int yn= Character.getNumericValue(y);
            yn=yn - 1;
            y = (char)yn;
            aposiciones.add(new Posicion(x,y));
            
        }
        x=xaux;
        y=yaux;
        while( x > 1 ||  y< 'h'){ //diagonal inf derecha
            x= x-1;
            int yn= Character.getNumericValue(y);
            yn=yn + 1;
            y = (char)yn;
            aposiciones.add(new Posicion(x,y));
            
        }
        x=xaux;
        y=yaux;
        while( x > 1 ||  y> 'a'){ //diagonal inf izquierda
            x= x-1;
            int yn= Character.getNumericValue(y);
            yn=yn - 1;
            y = (char)yn;
            aposiciones.add(new Posicion(x,y));
            
        }
        x=xaux;
        y=yaux;
         for (int i =0; i<8 ;i++){
            
            aposiciones.add(new Posicion(i,y));
            
        }
        for (int j =0; j<'a' ; j++){
            
            
            int jn= Character.getNumericValue(j);
            jn = jn + 1;
            char jc = (char)(jn);
            
            
            aposiciones.add(new Posicion(x,jc));
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
