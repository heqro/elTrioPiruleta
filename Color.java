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
    public Color(String colorDePieza) {
        switch(colorDePieza.charAt(0)){
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
}
