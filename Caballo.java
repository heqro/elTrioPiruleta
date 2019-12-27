package p_final;

import java.util.ArrayList;


public class Caballo extends Pieza{
    public Caballo (char color, Tablero t, Posicion pos){
        super(new Color(color), 'C', t, pos);
    }

    
    @Override
    public void calcularMovimientos() {
        ArrayList<Posicion> aposiciones = new ArrayList();
        Posicion coordenada = this.getPosicion();
        int x  = coordenada.getCoordenadax();
        char y = coordenada.getCoordenaday();
        Color c;
        aposiciones.add(coordenada);
        
        int xaux= x;
        char yaux = y;
        int yn = Character.getNumericValue(yaux);
        xaux=xaux+3;
        yn=yn+1;       
        char yc = (char) yn;
        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
        else{c = null};
        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& !(this.getColor().equals(c))){
            aposiciones.add(new Posicion(xaux,yc));
        }
        
        
        xaux= x;
        yaux = y;
        yn = Character.getNumericValue(yaux);
        xaux=xaux+3;
        yn=yn-1;
        yc = (char) yn;
        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
        else{c = null};
        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& !(this.getColor().equals(c))){
            aposiciones.add(new Posicion(xaux,yc));
        }
        
        xaux= x;
        yaux = y;
        yn = Character.getNumericValue(yaux);
        xaux=xaux-3;
        yn=yn+1;
        yc = (char) yn;
        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
        else{c = null};
        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& !(this.getColor.equals(c))){
            aposiciones.add(new Posicion(xaux,yc));
        }
        
        
        xaux= x;
        yaux = y;
        yn = Character.getNumericValue(yaux);
        xaux=xaux-3;
        yn=yn-1;
        yc = (char) yn;
        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
        else{c = null};
        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& !(this.getColor().equals(c))){
            aposiciones.add(new Posicion(xaux,yc));
        }
        
        xaux= x;
        yaux = y;
        yn = Character.getNumericValue(yaux);
        xaux=xaux+1;
        yn=yn+3;
        yc = (char) yn;
        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
        else{c = null};
        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a') && !(this.getColor().equals(c))){
            aposiciones.add(new Posicion(xaux,yc));
        }
        
        
        xaux= x;
        yaux = y;
        yn = Character.getNumericValue(yaux);
        xaux=xaux+1;
        yn=yn-3;
        yc = (char) yn;
        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
        else{c = null};
        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& !(this.getColor().equals(c))){
            aposiciones.add(new Posicion(xaux,yc));
        }
        
        
        xaux= x;
        yaux = y;
        yn = Character.getNumericValue(yaux);
        xaux=xaux+1;
        yn=yn-3;
        yc = (char) yn;
        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
        else{c = null};
        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a')&& !(this.getColor().equals(c))){
            aposiciones.add(new Posicion(xaux,yc));
        }
        
        
        xaux= x;
        yaux = y;
        yn = Character.getNumericValue(yaux);
        xaux=xaux-1;
        yn=yn-3;
        yc = (char) yn;
        if (t.PosicionOcupada(xaux,yn)){c=t.GetPiezaPos(xaux,yaux).getColor()}
        else{c = null};
        if ((xaux<9 && xaux>0 && yc<='h' && yc >='a') && !(this.getColor().equals(c))){
            aposiciones.add(new Posicion(xaux,yc));
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
