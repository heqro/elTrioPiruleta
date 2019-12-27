package p_final;

import java.util.ArrayList;


public class Alfil extends Pieza{
    public Alfil (char color, Tablero t){
        super(new Color(color), 'A', t);
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
        boolean posnoocuppada;
        aposiciones.add(coordenada);
        posnoocupada = true;
        while( (x < 8 ||  y< 'h')&& posnoocupada){ //diagonal sup derecha
            x= x+1;
            int yn= Character.getNumericValue(y);
            yn=yn + 1;
            y = (char)yn;
            if (not(t.PosicionOcupada(x,y))){
                aposiciones.add(new Posicion(x,y))}
            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
                aposiciones.add(new Posicion(x,y));
                posnoocupada = false;
            }
            else {posnoocupada = false};
            
        }
        x=xaux;
        y=yaux;
        posnoocupada = true;
        while( x < 8 ||  y> 'a'){ //diagonal sup izda
            x= x+1;
            int yn= Character.getNumericValue(y);
            yn=yn - 1;
            y = (char)yn;
            if (not(t.PosicionOcupada(x,y))){
                aposiciones.add(new Posicion(x,y))}
            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
                aposiciones.add(new Posicion(x,y));
                posnoocupada = false;
            }
            else {posnoocupada = false}
            
            
        }
        x=xaux;
        y=yaux;
        posnoocupada = true;
        while( x > 1 ||  y< 'h'){ //diagonal inf derecha
            x= x-1;
            int yn= Character.getNumericValue(y);
            yn=yn + 1;
            y = (char)yn;
            if (not(t.PosicionOcupada(x,y))){
                aposiciones.add(new Posicion(x,y))}
            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
                aposiciones.add(new Posicion(x,y));
                posnoocupada = false;
            }
            else {posnoocupada = false}
            
        }
        posnoocupada = true;
        x=xaux;
        y=yaux;
        while( x > 1 ||  y> 'a'){ //diagonal inf izquierda
            x= x-1;
            int yn= Character.getNumericValue(y);
            yn=yn - 1;
            y = (char)yn;
           if (not(t.PosicionOcupada(x,y))){
                aposiciones.add(new Posicion(x,y))}
            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
                aposiciones.add(new Posicion(x,y));
                posnoocupada = false;
            }
            else {posnoocupada = false}
            
        }
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
