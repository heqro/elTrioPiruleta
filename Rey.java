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
        /* Vamos a:
            - crear todas las posiciones posibles alrededor del rey
            - introducirlas todas, a priori, en el arrayList, y posteriormente:
                - descartar aquellas que nos saquen del tablero
                - descartar aquellas que estén ocupadas por piezas del mismo color
        */
        ArrayList<Posicion> aposiciones = new ArrayList();      //arrayList de posiciones 'a priori'
        ArrayList<Posicion> arrayPosiblesMovimientos = new ArrayList();//arrayList final
        Posicion coordenada = this.getPosicion();
        int x = coordenada.getCoordenadax();
        char y = coordenada.getCoordenaday();
        Tablero t = this.getTablero();
        
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
            if(pos.posicionLegal()){
                if(t.PosicionOcupada(pos)){
                    //Recoger el color de la pieza que ocupa la posición
                    Color piezaOcupante = t.GetPiezaPos(pos).getColor();
                    if(!piezaOcupante.equals(this.getColor())){
                        /*Si tienen el color distinto, puede ser que el rey
                        pueda comer la pieza.*/
                        arrayPosiblesMovimientos.add(pos);
                    }
                }else{
                    arrayPosiblesMovimientos.add(pos);
                }
            }
        }
        this.setPosiblesMovimientos(arrayPosiblesMovimientos);
    }
}
