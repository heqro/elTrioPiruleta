package p_final;

import java.util.ArrayList;


public class Caballo extends Pieza{
    public Caballo (char color, Tablero t, Posicion pos){
        super(new Color(color), 'C', t, pos);
    }
    @Override
    public void calcularMovimientos(){
        /*Vamos a calcular los movimientos posibles (son en total 8) de la siguiente forma:
            1. Calcularemos todos sin importarnos si son legales o no, y
        los introduciremos en el arraylist de posibles movimientos
            2. Recorreremos con un for el array de posibles movimientos, 
        y excluiremos a aquellos que estén fuera del tablero.
            3. Si no están fuera del tablero, consideraremos si son sobre
        una casilla vacía o no.
            4. Si la casilla no está vacía, consideramos el color de la pieza
        que la ocupa.
            5. Si el color de la pieza es el mismo que el de la pieza, excluiremos
        el movimiento.*/ 
        
        ArrayList<Posicion> aposiciones = new ArrayList<>();
        ArrayList<Posicion> posiblesMovimientos = new ArrayList<>();
        Posicion coordenada = this.getPosicion();
        int x = coordenada.getCoordenadax();
        char y = coordenada.getCoordenaday();
        Tablero t = this.getTablero();
        
        //Primer cuadrante
        aposiciones.add(new Posicion((x+2), (char)(y+1)));
        aposiciones.add(new Posicion((x+1), (char)(y+2)));
        //Segundo cuadrante
        aposiciones.add(new Posicion((x-2), (char)(y+1)));
        aposiciones.add(new Posicion((x-1), (char)(y+2)));
        //Tercer cuadrante
        aposiciones.add(new Posicion((x-2), (char)(y-1)));
        aposiciones.add(new Posicion((x-1), (char)(y-2)));
        //Cuarto cuadrante
        aposiciones.add(new Posicion((x+2), (char)(y-1)));
        aposiciones.add(new Posicion((x+1), (char)(y-2)));
        
        for(Posicion pos: aposiciones){
            if(pos.posicionLegal()){
                /*Solo vamos a introducir aquellas posiciones que sean legales*/
                if(t.PosicionOcupada(pos)){
                    /*Si la posición está ocupada, queremos saber si es
                    por una pieza del contrario o por una nuestra*/
                    Color c = t.GetPiezaPos(pos).getColor();
                    if(!c.equals(this.getColor())){
                        /*Si los colores son distintos, introducimos la posición
                        en el array de posibles movimientos*/
                        posiblesMovimientos.add(pos);
                    }
                }else{
                    /*Si la posición no está ocupada, entonces la añadimos
                    en el array de posibles movimientos automáticamente*/
                    posiblesMovimientos.add(pos);
                }
            }
        }
        this.setPosiblesMovimientos(posiblesMovimientos);
    }
}
