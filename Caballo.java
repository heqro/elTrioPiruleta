package p_final;

import java.util.ArrayList;


public class Caballo extends Pieza{
    public Caballo (char color, Tablero t, Posicion pos){
        super(new Color(color), 'C', t, pos);
    }
    @Override
    public void calcularMovimientos(){
        /*Vamos a calcular todos los movimientos posibles (8) de la siguiente forma:
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
        
        ArrayList<Posicion> aposiciones = new ArrayList();
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
            if(!pos.posicionLegal()){
                aposiciones.remove(pos);
            }else{
                if(t.PosicionOcupada(pos)){
                    Color c = t.GetPiezaPos(pos).getColor();
                    if(c.equals(this.getColor())){
                        aposiciones.remove(pos);
                    }
                }
            }
        }
    }
//    @Override
//    public void calcularMovimientos() {
//        ArrayList<Posicion> aposiciones = new ArrayList();
//        Posicion coordenada = this.getPosicion();
//        int x  = coordenada.getCoordenadax();
//        char y = coordenada.getCoordenaday();
//        Color c;
//        aposiciones.add(coordenada);
//        
//        int xaux= x;
//        char yaux = y;
//        int yn = Character.getNumericValue(yaux);
//        xaux=xaux+3;
//        yn=yn+1;       
//        char yc = (char) yn;
//        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
//        else{c = null};
//        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& !(this.getColor().equals(c))){
//            aposiciones.add(new Posicion(xaux,yc));
//        }
//        
//        
//        xaux= x;
//        yaux = y;
//        yn = Character.getNumericValue(yaux);
//        xaux=xaux+3;
//        yn=yn-1;
//        yc = (char) yn;
//        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
//        else{c = null};
//        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& !(this.getColor().equals(c))){
//            aposiciones.add(new Posicion(xaux,yc));
//        }
//        
//        xaux= x;
//        yaux = y;
//        yn = Character.getNumericValue(yaux);
//        xaux=xaux-3;
//        yn=yn+1;
//        yc = (char) yn;
//        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
//        else{c = null};
//        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& !(this.getColor.equals(c))){
//            aposiciones.add(new Posicion(xaux,yc));
//        }
//        
//        
//        xaux= x;
//        yaux = y;
//        yn = Character.getNumericValue(yaux);
//        xaux=xaux-3;
//        yn=yn-1;
//        yc = (char) yn;
//        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
//        else{c = null};
//        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& !(this.getColor().equals(c))){
//            aposiciones.add(new Posicion(xaux,yc));
//        }
//        
//        xaux= x;
//        yaux = y;
//        yn = Character.getNumericValue(yaux);
//        xaux=xaux+1;
//        yn=yn+3;
//        yc = (char) yn;
//        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
//        else{c = null};
//        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a') && !(this.getColor().equals(c))){
//            aposiciones.add(new Posicion(xaux,yc));
//        }
//        
//        
//        xaux= x;
//        yaux = y;
//        yn = Character.getNumericValue(yaux);
//        xaux=xaux+1;
//        yn=yn-3;
//        yc = (char) yn;
//        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
//        else{c = null};
//        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& !(this.getColor().equals(c))){
//            aposiciones.add(new Posicion(xaux,yc));
//        }
//        
//        
//        xaux= x;
//        yaux = y;
//        yn = Character.getNumericValue(yaux);
//        xaux=xaux+1;
//        yn=yn-3;
//        yc = (char) yn;
//        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
//        else{c = null};
//        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& !(this.getColor().equals(c))){
//            aposiciones.add(new Posicion(xaux,yc));
//        }
//        
//        
//        xaux= x;
//        yaux = y;
//        yn = Character.getNumericValue(yaux);
//        xaux=xaux-1;
//        yn=yn-3;
//        yc = (char) yn;
//        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
//        else{c = null};
//        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a') && !(this.getColor().equals(c))){
//            aposiciones.add(new Posicion(xaux,yc));
//        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public ArrayList<Posicion> calcularMovimientos(Posicion coordenada) {
//        ArrayList<Posicion> aposiciones = new ArrayList();
//        int x  = coordenada.getCoordenadax();
//        char y = coordenada.getCoordenaday();
//        Color c;
//        aposiciones.add(coordenada);
//        
//        int xaux= x;
//        char yaux = y;
//        int yn = Character.getNumericValue(yaux);
//        xaux=xaux+3;
//        yn=yn+1;       
//        char yc = (char) yn;
//        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
//        else{c = null};
//        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& not(this.getColor().equals(c))){
//            aposiciones.add(new Posicion(xaux,yc));
//        }
//        
//        
//        xaux= x;
//        yaux = y;
//        yn = Character.getNumericValue(yaux);
//        xaux=xaux+3;
//        yn=yn-1;
//        yc = (char) yn;
//        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
//        else{c = null};
//        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& not(this.getColor().equals(c))){
//            aposiciones.add(new Posicion(xaux,yc));
//        }
//        
//        xaux= x;
//        yaux = y;
//        yn = Character.getNumericValue(yaux);
//        xaux=xaux-3;
//        yn=yn+1;
//        yc = (char) yn;
//        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
//        else{c = null};
//        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& not(this.getColor.equals(c))){
//            aposiciones.add(new Posicion(xaux,yc));
//        }
//        
//        
//        xaux= x;
//        yaux = y;
//        yn = Character.getNumericValue(yaux);
//        xaux=xaux-3;
//        yn=yn-1;
//        yc = (char) yn;
//        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
//        else{c = null};
//        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& not (this.getColor().equals(c))){
//            aposiciones.add(new Posicion(xaux,yc));
//        }
//        
//        xaux= x;
//        yaux = y;
//        yn = Character.getNumericValue(yaux);
//        xaux=xaux+1;
//        yn=yn+3;
//        yc = (char) yn;
//        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
//        else{c = null};
//        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a') && not (this.getColor().equals(c))){
//            aposiciones.add(new Posicion(xaux,yc));
//        }
//        
//        
//        xaux= x;
//        yaux = y;
//        yn = Character.getNumericValue(yaux);
//        xaux=xaux+1;
//        yn=yn-3;
//        yc = (char) yn;
//        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
//        else{c = null};
//        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& not(this.getColor().equals(c))){
//            aposiciones.add(new Posicion(xaux,yc));
//        }
//        
//        
//        xaux= x;
//        yaux = y;
//        yn = Character.getNumericValue(yaux);
//        xaux=xaux+1;
//        yn=yn-3;
//        yc = (char) yn;
//        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
//        else{c = null};
//        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& not(this.getColor().equals(c))){
//            aposiciones.add(new Posicion(xaux,yc));
//        }
//        
//        
//        xaux= x;
//        yaux = y;
//        yn = Character.getNumericValue(yaux);
//        xaux=xaux-1;
//        yn=yn-3;
//        yc = (char) yn;
//        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
//        else{c = null};
//        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a') && not(this.getColor().equals(c))){
//            aposiciones.add(new Posicion(xaux,yc));
//        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
