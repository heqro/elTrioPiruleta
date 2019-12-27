package p_final;

import java.util.ArrayList;


public class Dama extends Pieza{
    public Dama (char color, Tablero t, Posicion pos){
        super(new Color(color), 'D', t, pos);
    }

    @Override
    public void calcularMovimientos(){
        ArrayList<Posicion> aposiciones = new ArrayList();
        ArrayList<Posicion> aposicionesAux = new ArrayList();
        Tablero t = this.getTablero();
        aposiciones = t.lecturaTorre(this.getColor(), this.getPosicion());
        aposicionesAux = t.lecturaAlfil(this.getColor(), this.getPosicion());
        aposiciones.addAll(aposicionesAux);
        this.setPosiblesMovimientos(aposiciones);
    }
    
//    @Override
//    public void calcularMovimientos() {
//        ArrayList<Posicion> aposiciones = new ArrayList();
//        Posicion coordenada = this.getPosicion();
//        int x  = coordenada.getCoordenadax();
//        char y = coordenada.getCoordenaday();
//        int xaux=x;
//        char yaux=y;
//        boolean posnoocupada;
//        aposiciones.add(coordenada);
//        posnoocupada = true;
//        while( (x < 8 ||  y< 'h') && posnoocupada){ //diagonal sup derecha
//            x= x+1;
//            int yn= Character.getNumericValue(y);
//            yn=yn + 1;
//            y = (char)yn;
//           if (not(t.PosicionOcupada(x,y))){
//                aposiciones.add(new Posicion(x,y))}
//            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
//                aposiciones.add(new Posicion(x,y));
//                posnoocupada = false;
//            }
//            else {posnoocupada = false}
//            
//        }
//        x=xaux;
//        y=yaux;
//        posnoocupada = true;
//        while( (x < 8 ||  y> 'a')&& posnoocupada){ //diagonal sup izda
//            x= x+1;
//            int yn= Character.getNumericValue(y);
//            yn=yn - 1;
//            y = (char)yn;
//            if (not(t.PosicionOcupada(x,y))){
//                aposiciones.add(new Posicion(x,y))}
//            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
//                aposiciones.add(new Posicion(x,y));
//                posnoocupada = false;
//            }
//            else {posnoocupada = false}
//            
//        }
//        posnoocupada = true;
//        x=xaux;
//        y=yaux;
//        while( (x > 1 ||  y< 'h') && posnoocupada){ //diagonal inf derecha
//            x= x-1;
//            int yn= Character.getNumericValue(y);
//            yn=yn + 1;
//            y = (char)yn;
//            if (not(t.PosicionOcupada(x,y))){
//                aposiciones.add(new Posicion(x,y))}
//            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
//                aposiciones.add(new Posicion(x,y));
//                posnoocupada = false;
//            }
//            else {posnoocupada = false}
//            
//        }
//        posnoocupada = true;
//        x=xaux;
//        y=yaux;
//        while( (x > 1 ||  y> 'a') && posnoocupada){ //diagonal inf izquierda
//            x= x-1;
//            int yn= Character.getNumericValue(y);
//            yn=yn - 1;
//            y = (char)yn;
//            if (not(t.PosicionOcupada(x,y))){
//                aposiciones.add(new Posicion(x,y))}
//            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
//                aposiciones.add(new Posicion(x,y));
//                posnoocupada = false;
//            }
//            else {posnoocupada = false}
//            
//        } 
//        posnoocupada = true;
//        x=xaux;
//        y=yaux;
//         while (x<8 && posnoocupada){  //vertical sup
//            x= x+1;
//            if (not(t.PosicionOcupada(x,y))){
//                aposiciones.add(new Posicion(x,y))}
//            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
//                aposiciones.add(new Posicion(x,y));
//                posnoocupada = false;
//            }
//            else {posnoocupada = false}            
//        }
//        posnoocupada = true;
//        x=xaux;
//        while (x>1 && posnoocupada) { // vertcal inf
//            x = x-1;
//            if (not(t.PosicionOcupada(x,y))){
//                aposiciones.add(new Posicion(x,y))}
//            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
//                aposiciones.add(new Posicion(x,y));
//                posnoocupada = false;
//            }
//            else {posnoocupada = false}  
//        }
//        posnoocupada = true;
//        x=xaux;
//        while (y < 'h' && posnoocupada){//horizontal derecho
//            int yn= Character.getNumericValue(y);
//            yn=yn + 1;
//            y = (char)yn;
//            if (not(t.PosicionOcupada(x,y))){
//                aposiciones.add(new Posicion(x,y))}
//            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
//                aposiciones.add(new Posicion(x,y));
//                posnoocupada = false;
//            }
//            else {posnoocupada = false}              
//        }
//        posnoocupada = true;
//        y = yaux;
//        while (y > 'a' && posnoocupada){//horizontal izquierdo
//            int yn= Character.getNumericValue(y);
//            yn=yn + 1
//            y = (char)yn;
//            if (not(t.PosicionOcupada(x,y))){
//                aposiciones.add(new Posicion(x,y))}
//            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
//                aposiciones.add(new Posicion(x,y));
//                posnoocupada = false;
//            }
//            else {posnoocupada = false}  
//        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
//    @Override
//    public ArrayList<Posicion> calcularMovimientos(Posicion coordenada) {
//        ArrayList<Posicion> aposiciones = new ArrayList();
//        int x  = coordenada.getCoordenadax();
//        char y = coordenada.getCoordenaday();
//        int xaux=x;
//        char yaux=y;
//        boolean posnoocupada;
//        aposiciones.add(coordenada);
//        posnoocupada = true;
//        while( (x < 8 ||  y< 'h') && posnoocupada){ //diagonal sup derecha
//            x= x+1;
//            int yn= Character.getNumericValue(y);
//            yn=yn + 1;
//            y = (char)yn;
//           if (not(t.PosicionOcupada(x,y))){
//                aposiciones.add(new Posicion(x,y))}
//            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
//                aposiciones.add(new Posicion(x,y));
//                posnoocupada = false;
//            }
//            else {posnoocupada = false}
//            
//        }
//        x=xaux;
//        y=yaux;
//        posnoocupada = true;
//        while( (x < 8 ||  y> 'a')&& posnoocupada){ //diagonal sup izda
//            x= x+1;
//            int yn= Character.getNumericValue(y);
//            yn=yn - 1;
//            y = (char)yn;
//            if (not(t.PosicionOcupada(x,y))){
//                aposiciones.add(new Posicion(x,y))}
//            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
//                aposiciones.add(new Posicion(x,y));
//                posnoocupada = false;
//            }
//            else {posnoocupada = false}
//            
//        }
//        posnoocupada = true;
//        x=xaux;
//        y=yaux;
//        while( (x > 1 ||  y< 'h') && posnoocupada){ //diagonal inf derecha
//            x= x-1;
//            int yn= Character.getNumericValue(y);
//            yn=yn + 1;
//            y = (char)yn;
//            if (not(t.PosicionOcupada(x,y))){
//                aposiciones.add(new Posicion(x,y))}
//            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
//                aposiciones.add(new Posicion(x,y));
//                posnoocupada = false;
//            }
//            else {posnoocupada = false}
//            
//        }
//        posnoocupada = true;
//        x=xaux;
//        y=yaux;
//        while( (x > 1 ||  y> 'a') && posnoocupada){ //diagonal inf izquierda
//            x= x-1;
//            int yn= Character.getNumericValue(y);
//            yn=yn - 1;
//            y = (char)yn;
//            if (not(t.PosicionOcupada(x,y))){
//                aposiciones.add(new Posicion(x,y))}
//            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
//                aposiciones.add(new Posicion(x,y));
//                posnoocupada = false;
//            }
//            else {posnoocupada = false}
//            
//        } 
//        posnoocupada = true;
//        x=xaux;
//        y=yaux;
//         while (x<8 && posnoocupada){  //vertical sup
//            x= x+1;
//            if (not(t.PosicionOcupada(x,y))){
//                aposiciones.add(new Posicion(x,y))}
//            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
//                aposiciones.add(new Posicion(x,y));
//                posnoocupada = false;
//            }
//            else {posnoocupada = false}            
//        }
//        posnoocupada = true;
//        x=xaux;
//        while (x>1 && posnoocupada) { // vertcal inf
//            x = x-1;
//            if (not(t.PosicionOcupada(x,y))){
//                aposiciones.add(new Posicion(x,y))}
//            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
//                aposiciones.add(new Posicion(x,y));
//                posnoocupada = false;
//            }
//            else {posnoocupada = false}  
//        }
//        posnoocupada = true;
//        x=xaux;
//        while (y < 'h' && posnoocupada){//horizontal derecho
//            int yn= Character.getNumericValue(y);
//            yn=yn + 1;
//            y = (char)yn;
//            if (not(t.PosicionOcupada(x,y))){
//                aposiciones.add(new Posicion(x,y))}
//            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
//                aposiciones.add(new Posicion(x,y));
//                posnoocupada = false;
//            }
//            else {posnoocupada = false}              
//        }
//        posnoocupada = true;
//        y = yaux;
//        while (y > 'a' && posnoocupada){//horizontal izquierdo
//            int yn= Character.getNumericValue(y);
//            yn=yn + 1
//            y = (char)yn;
//            if (not(t.PosicionOcupada(x,y))){
//                aposiciones.add(new Posicion(x,y))}
//            else if (GetPiezaPos (x,y).getColor() <> this.getColor()){
//                aposiciones.add(new Posicion(x,y));
//                posnoocupada = false;
//            }
//            else {posnoocupada = false}  
//        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
