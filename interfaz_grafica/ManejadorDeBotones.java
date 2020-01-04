/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_final.interfaz_grafica;


import java.awt.event.*;
import javax.swing.*;
import p_final.*;

/**
 *
 * @author Heqro
 */
public class ManejadorDeBotones implements ActionListener {
    JButton btn;
    jframeprincipal interfazGrafica;
    boolean pintado = false;
    public ManejadorDeBotones(JButton btn, jframeprincipal interfazGrafica){
        this.btn = btn;
        this.interfazGrafica = interfazGrafica;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        interfazGrafica.desopacarBotones();
        if(!pintado){
            String nombreBoton = ((JButton) ae.getSource()).getName();
            int x = Character.getNumericValue(nombreBoton.charAt(0));
            char y = nombreBoton.charAt(1);
            Posicion pos = new Posicion(x, y);
            Tablero t = interfazGrafica.getTablero();
            Pieza piezaAux = t.GetPiezaPos(pos);
            btn.setContentAreaFilled(true);
            pintado = true;
        }else{
            btn.setContentAreaFilled(false);
            pintado = false;
        }
        
        //System.out.println("¡Hola! Soy un "+ piezaAux.toString()+" y estoy en " +pos.toString());
    }
    
    public void habilitarBotones(){
        
    }
}
