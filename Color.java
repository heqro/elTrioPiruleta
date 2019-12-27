package p_final;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hr.iglesias.2018
 */
public class Color {
    public enum ColorPieza {BLANCO, NEGRO};
    private final ColorPieza color; 
    public Color(char colorDePieza) {
        switch(colorDePieza){
            case 'B':case 'b':{
                color = ColorPieza.BLANCO;
                break;
            }
            case 'N': case'n':{
                color = ColorPieza.NEGRO;
                break;
            }
            default:{
                color = null;
            }
        }
    }
    
    
@Override
public String toString(){
    switch(this.color){
            case BLANCO:
            {
                return "BLANCO";
            }
            case NEGRO:
            {
                return "NEGRO";
            }
            default:
            {
                return null;
            }
        }
    }

@Override
public boolean equals(Object o){
    if(o == null){ return false; }
    if(this == o){ return true; }
    if(this.getClass() != o.getClass()){ return false; }
    Color c = (Color)o;
    return c.toString() == this.toString();
}

}
