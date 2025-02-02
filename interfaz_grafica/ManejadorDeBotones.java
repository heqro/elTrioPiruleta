/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_final.interfaz_grafica;


import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public void actionPerformed(ActionEvent ae) {/*Este es un botón habilitado: es, o bien 
        perteneciente a una pieza blance, o bien perteneciente a una casilla vacía o a una pieza
        negra una vez se haya seleccionado una pieza blanca.*/
        interfazGrafica.desopacarBotones();
        String nombreBoton = ((JButton) ae.getSource()).getName();
        interfazGrafica.deshabilitarBotonesVaciosONegros();
        ModeloUsuario modelo = interfazGrafica.getModeloUsuario();
        int x = Character.getNumericValue(nombreBoton.charAt(0));
        char y = nombreBoton.charAt(1);
        Posicion pos = new Posicion(x, y);
        Tablero t = interfazGrafica.getTablero();
        if(posicionVaciaONegra(pos)){
            /*Si no está ocupada la posición, o está ocupada por una pieza negra, la única razón
            por la que este botón ha podido estar habilitado es porque esté dentro
            del array de posibles posiciones de una pieza BLANCA seleccionada PREVIAMENTE.*/
            Pieza pAux = interfazGrafica.getPieza();
            try {
                pAux.Mover(pos);/*Movemos la pieza seleccionada previamente a la posición
                indicada por el botón pulsado en este caso*/
                if(t.JaqueMate(new Color ('n'))){
                        interfazGrafica.sacarVictoria();
                        modelo.setResuelto(true);
                }else{
                    interfazGrafica.sacarError("La jugada introducida no es jaque mate.\n"
                                + "Pulsa \"Aceptar\" para ver el movimiento que evita el jaque mate.");
                    modelo.setErrores(modelo.getErrores() + 1);
                }
                interfazGrafica.actualizarFotoTablero(t);
                interfazGrafica.setEstadoBotonesClasificacion(true);
            } catch (IllegalMovementException ex) {
                interfazGrafica.sacarError(ex.getMessage());/*Si la jugada es ilegal, lanzaremos
                un mensaje de error*/
                if(!modelo.getResuelto()){
                    modelo.setErrores(modelo.getErrores() + 1);
                }
            } catch (CoronacionException ex) {/*Si se produce una coronación, lanzaremos un mensaje
                con opciones de coronación.*/
                String[] opciones = {"Dama", "Caballo", "Torre", "Alfil"};
                int respuesta = JOptionPane.showOptionDialog(
                interfazGrafica, //Ventana padre
                "Elige en qué pieza deseas coronar.",//Mensaje del cuerpo
                ex.getMessage(),//Texto de encabezado
                JOptionPane.DEFAULT_OPTION, //Tipo de opciones a mostrar
                JOptionPane.INFORMATION_MESSAGE, //Tipo del mensaje a mostrar
                null,//Icono a mostrar
                opciones,//array con las elecciones posibles
                opciones[0]);//Coronar en dama
                char letra = 'x';//valor basura que reescribiremos
                switch(respuesta){
                    case 0:{
                        letra = 'D';
                        break;
                    }
                    case 1:{
                        letra = 'C';
                        break;
                    }
                    case 2:{
                        letra = 'T';
                        break;
                    }
                    case 3:{
                        letra = 'A';
                        break;
                    }
                }
                try {
                    t.coronarPeon(pAux, letra);/*lanzamos sobre el tablero el método de coronar*/
                    if(t.JaqueMate(new Color ('n'))){/*si se produce jaque mate sobre el rey negro*/
                        interfazGrafica.sacarVictoria();//sacar mensaje de victoria
                        modelo.setResuelto(true);//seleccionar el modelo como resuelto
                    }else{//si no hay jaque mate
                        interfazGrafica.sacarError("La jugada introducida no es jaque mate.\n"
                                + "Pulsa \"Aceptar\" para ver el movimiento que evita el jaque mate.");
                        if(!modelo.getResuelto()){//si no está resuelto
                            modelo.setErrores(modelo.getErrores() + 1);/*aumentar contador de errores*/
                        }
                    }
                    interfazGrafica.actualizarFotoTablero(t);/*actualizamos el tablero para ver la jugada*/
                    interfazGrafica.setEstadoBotonesClasificacion(true);/*recuperamos la posibilidad del usuario
                    para seguir realizando cualquier otra operación sobre la interfaz gráfica*/
                } catch (IllegalTableroException ex1) {/*Nunca llegamos a este caso, ya que solo se pueden subir
                    tablero legales*/
                    interfazGrafica.sacarError(ex1.getMessage());
                }
            }finally{
                /*en cualquier caso, desactivamos los botones del
                tablero para evitar posibles errores*/
                interfazGrafica.desactivarBotones();
            }
        }else{
            btn.setContentAreaFilled(true);
            Pieza piezaBlancaSeleccionada = t.GetPiezaPos(pos);
            interfazGrafica.setPieza(piezaBlancaSeleccionada);
            habilitarBotones(piezaBlancaSeleccionada);
            //pintado = false;
        }
        //System.out.println("¡Hola! Soy un "+ piezaAux.toString()+" y estoy en " +pos.toString());
    }
    
    public boolean posicionVaciaONegra(Posicion pos){
        Tablero t = interfazGrafica.getTablero();
        if(t.PosicionOcupada(pos)){
            Pieza pAux = t.GetPiezaPos(pos);
            return pAux.getColor().equals(new Color ('n'));
        }else{
            return true;
        }
    }
    
    public void habilitarBotones(Pieza p){/*Vamos a habilitar los botones
        a los que podamos acceder desde un botón que ya de por sí estuviera
        habilitado*/
        ArrayList<Posicion> posicionesPosibles = p.getPosiblesMovimientos();
        Tablero t = interfazGrafica.getTablero();
        int i, j;
        JButton btnAux;
        ArrayList<JButton> listaBotonesAux = interfazGrafica.getListaBotones();
        for(Posicion pos: posicionesPosibles){
            i = t.localizarCoordenadaX(pos);
            j = t.localizarCoordenadaY(pos);
            int indiceBoton = 8 * i + j;
            btnAux = listaBotonesAux.get(indiceBoton);
            btnAux.setContentAreaFilled(true);
            btnAux.setEnabled(true);
        }
    }
}
