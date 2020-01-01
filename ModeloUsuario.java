/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_final;

/**
 *
 * @author juans
 */
public class ModeloUsuario {
    private Modelo Modelo;
    private boolean Resuelto;
    private int contadorIntentos,contadorErrores;
    
    public ModeloUsuario(Modelo m, boolean res, int conint, int conerr){
    Modelo=m;
    Resuelto=res;
    contadorIntentos=conint;
    contadorErrores=conerr;
}
    public Modelo getModelo(){
        return Modelo;
    }
    public boolean getResuelto(){
        return Resuelto;
    }
    public int getIntentos(){
        return contadorIntentos;
    }
    public int getErrores(){
        return contadorErrores;
    }
    public void setIntentos(int i){
        contadorIntentos=i;
    }
    public void setErrores(int i){
        contadorErrores=i;
    }
    public void setResuelto(boolean i){
        Resuelto=i;
    }
    
    
}
