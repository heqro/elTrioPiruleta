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
    public ArrayList<Posicion> calcularMovimientos(Posicion coordenada) {
        ArrayList<Posicion> aposiciones = new ArrayList();
        int x  = coordenada.getCoordenadax();
        char y = coordenada.getCoordenaday();
        aposiciones.add(coordenada);
        
        int xaux= x;
        char yaux = y;
        int yn = Character.getNumericValue(yaux);
        xaux=xaux+3;
        yn=yn+1;
        char yc = (char) yn;
        if (xaux<9 && xaux>0 && yc<='h' && yc >='a'){
            aposiciones.add(new Posicion(xaux,yc));
        }
        
        
        xaux= x;
        yaux = y;
        yn = Character.getNumericValue(yaux);
        xaux=xaux+3;
        yn=yn-1;
        yc = (char) yn;
        if (xaux<9 && xaux>0 && yc<='h' && yc >='a'){
            aposiciones.add(new Posicion(xaux,yc));
        }
        
        xaux= x;
        yaux = y;
        yn = Character.getNumericValue(yaux);
        xaux=xaux-3;
        yn=yn+1;
        yc = (char) yn;
        if (xaux<9 && xaux>0 && yc<='h' && yc >='a'){
            aposiciones.add(new Posicion(xaux,yc));
        }
        
        
        xaux= x;
        yaux = y;
        yn = Character.getNumericValue(yaux);
        xaux=xaux-3;
        yn=yn-1;
        yc = (char) yn;
        if (xaux<9 && xaux>0 && yc<='h' && yc >='a'){
            aposiciones.add(new Posicion(xaux,yc));
        }
        
        xaux= x;
        yaux = y;
        yn = Character.getNumericValue(yaux);
        xaux=xaux+1;
        yn=yn+3;
        yc = (char) yn;
        if (xaux<9 && xaux>0 && yc<='h' && yc >='a'){
            aposiciones.add(new Posicion(xaux,yc));
        }
        
        
        xaux= x;
        yaux = y;
        yn = Character.getNumericValue(yaux);
        xaux=xaux+1;
        yn=yn-3;
        yc = (char) yn;
        if (xaux<9 && xaux>0 && yc<='h' && yc >='a'){
            aposiciones.add(new Posicion(xaux,yc));
        }
        
        
        xaux= x;
        yaux = y;
        yn = Character.getNumericValue(yaux);
        xaux=xaux+1;
        yn=yn-3;
        yc = (char) yn;
        if (xaux<9 && xaux>0 && yc<='h' && yc >='a'){
            aposiciones.add(new Posicion(xaux,yc));
        }
        
        
        xaux= x;
        yaux = y;
        yn = Character.getNumericValue(yaux);
        xaux=xaux-1;
        yn=yn-3;
        yc = (char) yn;
        if (xaux<9 && xaux>0 && yc<='h' && yc >='a'){
            aposiciones.add(new Posicion(xaux,yc));
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
