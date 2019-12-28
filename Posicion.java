package p_final;

/**
 *
 * @author j.montes.2018
 */
public class Posicion {
    private int coordenadax;
    private char coordenaday;
    
    
    public Posicion(int x, char y){
        coordenadax = x;
        coordenaday = y;
        
    }
    public void setCoordenadax(int x){
        coordenadax = x;
    }
    public void setCoordenaday(char y){
        coordenaday = y;    
    }
    
    public int getCoordenadax(){
        return coordenadax;
    }
    public char getCoordenaday(){
        return coordenaday;
    }
    
    @Override
    public boolean equals(Object o){
        if (o == null){
            return false;
        }
        
        if (this == o){
            return true;
        }
        
        if (getClass() != o.getClass()){
            return false;
        }
        Posicion pos = (Posicion) o;
        return (this.coordenadax == pos.coordenadax && this.coordenaday == pos.coordenaday);
    }
    
    public boolean posicionLegal(){
        boolean xCorrecta = (coordenadax < 8) && (coordenadax > 0);
        int yNumerico = coordenaday - 97;
        boolean yCorrecta = (yNumerico >= 0) && (yNumerico <=7);
        return xCorrecta && yCorrecta;
    }
}
