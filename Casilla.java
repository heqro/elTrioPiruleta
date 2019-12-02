package p_final;

/**
 *
 * @author j.montes.2018
 */
public class Posicion {
    private int coordenadax;
    private char coordenaday;
    
    
    public Posicion(int x, char y, boolean l){
        coordenadax=x;
        coordenaday=y;
        
    }
    public void setCoordenadax(int x){
        coordenadax=x;
    }
    public void setCoordenaday(char y){
        coordenaday=y;    
    }
    
    public int getCoordenadax(){
        return coordenadax;
    }
    public char getCoordenaday(){
        return coordenaday;
    }
    
    @Override
    public boolean equals(Object o){
        if (o==null){
            return false;
        }
        if (getClass() != o.getClass()){
            return false;
        }
        final Posicion pos = (Posicion) o;
        if (this.coordenadax != pos.coordenadax){
            return false;
        }else{
            if (this.coordenaday != pos.coordenaday){
                return false;
            } else return true;
        }
        
              
    }
