package p_final;

import java.util.ArrayList;

public class Rey extends Pieza{
//    public Rey (char color, Tablero t){
//        super(new Color(color), 'R', t);
//    }
    public Rey (char color, Tablero t, Posicion pos){
        super(new Color(color), 'R', t, pos);
    }
    
    @Override
    public void calcularMovimientos(){
        ArrayList<Posicion> aposiciones = new ArrayList();
        Posicion coordenada = this.getPosicion();
        int x = coordenada.getCoordenadax();
        char y = coordenada.getCoordenaday();
        Tablero t = this.getTablero();
        /* Vamos a:
            - crear todas las posiciones posibles alrededor del rey
            - introducirlas todas, a priori, en el arrayList, y posteriormente:
                - descartar aquellas que nos saquen del tablero
                - descartar aquellas que estén ocupadas por piezas del mismo color
                - descartar aquellas jugadas ilegales (en las que nos puedan
                comer al rey tras hacerlas)
        */
        //Horizontales
        aposiciones.add(new Posicion(x+1, y));
        aposiciones.add(new Posicion(x-1, y));
        //Verticales
        aposiciones.add(new Posicion(x, (char)(y+1) ));
        aposiciones.add(new Posicion(x, (char)(y-1) ));
        //Diagonales
        aposiciones.add(new Posicion(x+1, (char)(y+1) ));
        aposiciones.add(new Posicion(x+1, (char)(y-1) ));
        aposiciones.add(new Posicion(x-1, (char)(y+1) ));
        aposiciones.add(new Posicion(x-1, (char)(y-1) ));
        
        for(Posicion pos: aposiciones){
            if(!pos.posicionLegal()){
                aposiciones.remove(pos);
            }else{
                if(t.PosicionOcupada(pos)){
                    //Recoger el color de la pieza que ocupa la posición
                    Color piezaOcupante = t.GetPiezaPos(pos).getColor();
                    if(piezaOcupante.equals(this.getColor())){
                        //Si tienen el mismo color, este movimiento no se puede
                        aposiciones.remove(pos);
                    }
                }
                /* Llegados a este punto del código, sabemos que la posición que
                estamos estudiando es legal, y que no estará ocupada por una
                pieza del mismo color que el rey.
                
                Por tanto, en este punto lo único que nos queda preguntarnos es
                si, una vez hecho el movimiento, se provoca jaque sobre el rey.
                
                Si lo hay, entonces el movimiento es ilegal y hay que eliminarlo
                de la lista.
                
                Si no lo hay, entonces el movimiento es legal y, además,
                la solución propuesta no era jaque mate.
                
                Lo vamos a comprobar con un método auxiliar de tablero: jugadaIlegalRey.
                */
                if (t.jugadaIlegalRey(this, pos)){
                    aposiciones.remove(pos);
                }
            }
        }
        this.setPosiblesMovimientos(aposiciones);
    }
    
//    @Override
//    public void calcularMovimientos() {
//        ArrayList<Posicion> aposiciones = new ArrayList();
//        
//        int x  = coordenada.getCoordenadax();
//        char y = coordenada.getCoordenaday();
//        aposiciones.add(new Posicion (x,y));
//        char y1 = (char)(Character.getNumericValue(y)+1);
//        char y2 = (char)(Character.getNumericValue(y)+1);
//        if (y<'h')aposiciones.add(new Posicion (x,y1));
//        if (y>'a')aposiciones.add(new Posicion (x,y2));
//        
//        if(y<'h' && x<8)aposiciones.add(new Posicion (x+1,y1));
//        if(y>'a' && x<8)aposiciones.add(new Posicion (x+1,y2));
//        if(x<8)aposiciones.add(new Posicion (x+1,y));
//        if(x>1)aposiciones.add(new Posicion (x-1,y));
//        if(y<'h' && x>1)aposiciones.add(new Posicion (x-1,y1));
//        if(y>'a' && x>1)aposiciones.add(new Posicion (x-1,y2));
//        
//    }
    
    
    
    
//    @Override
//    public ArrayList<Posicion> calcularMovimientos(Posicion coordenada) {
//        ArrayList<Posicion> aposiciones = new ArrayList();
//        
//        int x  = coordenada.getCoordenadax();
//        char y = coordenada.getCoordenaday();
//        aposiciones.add(new Posicion (x,y));
//        char y1 = (char)(Character.getNumericValue(y)+1);
//        char y2 = (char)(Character.getNumericValue(y)+1);
//        if (y<'h')aposiciones.add(new Posicion (x,y1));
//        if (y>'a')aposiciones.add(new Posicion (x,y2));
//        
//        if(y<'h' && x<8)aposiciones.add(new Posicion (x+1,y1));
//        if(y>'a' && x<8)aposiciones.add(new Posicion (x+1,y2));
//        if(x<8)aposiciones.add(new Posicion (x+1,y));
//        if(x>1)aposiciones.add(new Posicion (x-1,y));
//        if(y<'h' && x>1)aposiciones.add(new Posicion (x-1,y1));
//        if(y>'a' && x>1)aposiciones.add(new Posicion (x-1,y2));
//        
//        
//        
//        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
