package p_final;
import java.io.Serializable;

/**
 *
 * @author j.montes.2018
 */
public class Posicion implements Serializable{
    private int coordenadax;
    private char coordenaday;
    
    
    public Posicion(int x, char y){
        coordenadax = x;
        coordenaday = y;
    }
    
    public Posicion(Posicion pos){
        coordenadax = pos.getCoordenadax();
        coordenaday = pos.getCoordenaday();
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
    public boolean equals(Object o){/*dos posiciones son iguales si tienen la misma coordenada
    x y la misma coordenada y*/
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
    
    public boolean posicionLegal(){/*una posición es legal si su coordenada x está entre 0 y 8, y si su coordenada y
    está entre 0 y 7 (es decir, si está entre "a" y "h" en el alfabeto.*/
        boolean xCorrecta = (coordenadax <= 8) && (coordenadax > 0);
        int yNumerico = coordenaday - 97;
        boolean yCorrecta = (yNumerico >= 0) && (yNumerico <=7);
        return xCorrecta && yCorrecta;
    }
    
    @Override
    public String toString(){
        return "("+coordenadax+", "+coordenaday+")";
    }
}
