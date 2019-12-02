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
public enum Color {
    BLANCO, NEGRO;
    @Override
    public String toString(){
        String color;
        switch(this){
            case BLANCO:
            {
                color = "BLANCO";
                break;
            }
            case NEGRO:
            {
                color = "NEGRO";
                break;
            }
            default:{
                color = null;
            }
        }
        return color;
    }
}
