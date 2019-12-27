package p_final;

import java.util.ArrayList;

public class Torre extends Pieza{
//    public Torre (char color, Tablero t){
//        super(new Color(color), 'T', t);
//    }
    public Torre (char color, Tablero t, Posicion pos){
        super(new Color(color), 'T', t, pos);
    }
     
    @Override 
    public void calcularMovimientos(){
        ArrayList<Posicion> aposiciones = new ArrayList();
        Tablero t = this.getTablero();
        aposiciones = t.lecturaTorre(this.getColor(), this.getPosicion());
        this.setPosiblesMovimientos(aposiciones);
    }

//    @Override
//    public void calcularMovimientos(Posicion coordenada) {
//         ArrayList<Posicion> aposiciones = new ArrayList();
//        int x  = coordenada.getCoordenadax();
//        char y = coordenada.getCoordenaday();
//        
//        aposiciones.add(coordenada);
//        for (int i =0; i<8 ;i++){
//            
//            aposiciones.add(new Posicion(i,y));
//            
//        }
//        for (int j =0; j<'a' ; j++){
//            
//            
//            int jn= Character.getNumericValue(j);
//            jn = jn + 1;
//            char jc = (char)(jn);
//            
//            
//            aposiciones.add(new Posicion(x,jc));
//        }
//        
//        
//        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
