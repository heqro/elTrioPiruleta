package p_final;

import java.util.ArrayList;


public class Peon extends Pieza{
    public Peon (char color, Tablero t, Posicion pos){
        super(new Color(color), 'P', t, pos);
    }

    @Override
    public void calcularMovimientos() {
        Posicion coordenada = this.getPosicion();
        ArrayList<Posicion> aposiciones = new ArrayList();
        int x  = coordenada.getCoordenadax();
        char y = coordenada.getCoordenaday();
        Tablero t = this.getTablero();
        switch(this.getColor().toString()){
            case "B":{
                //Crear posición siguiente
                Posicion posSiguiente1 = new Posicion(x+1, y);
                //Crear posición siguiente siguiente
                Posicion posSiguiente2 = new Posicion(x+2, y);
                //Crear posiciones diagonales
                char yDiagonalIzq = (char)(y-1);
                Posicion posDiagonalIzq = new Posicion(x+1, yDiagonalIzq);
                char yDiagonalDcha = (char)(y+1);
                Posicion posDiagonalDcha = new Posicion(x+1, yDiagonalDcha);
                
                if((x==2)&&
                        (!t.PosicionOcupada(posSiguiente2))&&
                        (!t.PosicionOcupada(posSiguiente1))){
                    /*Se puede mover dos casillas hacia adelante una pieza blanca
                    si se encuentra en la fila 2 y no se bloquean ni la casilla
                    de adelante ni la siguiente*/
                    aposiciones.add(posSiguiente2);
                }
                if(posSiguiente1.posicionLegal()){
                    if(!t.PosicionOcupada(posSiguiente1)){
                    /*Se puede mover una casilla hacia adelante una pieza blanca
                    si no se encuentra la casilla bloqueada*/
                    aposiciones.add(posSiguiente1);
                    }
                }
                
                
                /*Se puede mover una casilla en diagonal si se encuentra
                la casilla bloqueada por una pieza del COLOR CONTRARIO*/
                if(posDiagonalIzq.posicionLegal()){/*comprobación
                    de haber creado una posición legal*/
                    if(t.PosicionOcupada(posDiagonalIzq)){/*comprobación
                        de que la casilla está ocupada*/
                        Color colorPiezaOcupante = t.GetPiezaPos(posDiagonalIzq).getColor();
                        if(!this.getColor().equals(colorPiezaOcupante)){
                            /*comprobación de que la casilla la ocupa una pieza
                            del color contrario*/
                            aposiciones.add(posDiagonalIzq);
                        }
                    }
                }
                
                if(posDiagonalDcha.posicionLegal()){/*comprobación
                    de haber creado una posición legal*/
                    if(t.PosicionOcupada(posDiagonalDcha)){/*comprobación
                        de que la casilla está ocupada*/
                        Color colorPiezaOcupante = t.GetPiezaPos(posDiagonalDcha).getColor();
                        if(!this.getColor().equals(colorPiezaOcupante)){
                            /*comprobación de que la casilla la ocupa una pieza
                            del color contrario*/
                            aposiciones.add(posDiagonalDcha);
                        }
                    }
                }
                
                break;
            }
            case "N":{
                //Crear posición siguiente
                Posicion posSiguiente1 = new Posicion(x-1, y);
                //Crear posición siguiente siguiente
                Posicion posSiguiente2 = new Posicion(x-2, y);
                //Crear posiciones diagonales
                char yDiagonalIzq = (char)(y-1);
                Posicion posDiagonalIzq = new Posicion(x-1, yDiagonalIzq);
                
                char yDiagonalDcha = (char)(y+1);
                Posicion posDiagonalDcha = new Posicion(x-1, yDiagonalDcha);
                
                if((x==7)&&
                        (!t.PosicionOcupada(posSiguiente2))&&
                        (!t.PosicionOcupada(posSiguiente1))){
                    /*Se puede mover dos casillas hacia adelante una pieza blanca
                    si se encuentra en la fila 2 y no se bloquean ni la casilla
                    de adelante ni la siguiente*/
                    aposiciones.add(posSiguiente2);
                }
                if(posSiguiente1.posicionLegal()){
                    if(!t.PosicionOcupada(posSiguiente1)){
                    /*Se puede mover una casilla hacia adelante una pieza blanca
                    si no se encuentra la casilla bloqueada*/
                    aposiciones.add(posSiguiente1);
                    }
                }
                /*Se puede mover una casilla en diagonal si se encuentra
                la casilla bloqueada por una pieza del COLOR CONTRARIO*/
                if(posDiagonalIzq.posicionLegal()){/*comprobación
                    de haber creado una posición legal*/
                    if(t.PosicionOcupada(posDiagonalIzq)){/*comprobación
                        de que la casilla está ocupada*/
                        Color colorPiezaOcupante = t.GetPiezaPos(posDiagonalIzq).getColor();
                        if(!this.getColor().equals(colorPiezaOcupante)){
                            /*comprobación de que la casilla la ocupa una pieza
                            del color contrario*/
                            aposiciones.add(posDiagonalIzq);
                        }
                    }
                }
                
                if(posDiagonalDcha.posicionLegal()){/*comprobación
                    de haber creado una posición legal*/
                    if(t.PosicionOcupada(posDiagonalDcha)){/*comprobación
                        de que la casilla está ocupada*/
                        Color colorPiezaOcupante = t.GetPiezaPos(posDiagonalDcha).getColor();
                        if(!this.getColor().equals(colorPiezaOcupante)){
                            /*comprobación de que la casilla la ocupa una pieza
                            del color contrario*/
                            aposiciones.add(posDiagonalDcha);
                        }
                    }
                }
                break;
            }
        }
        this.setPosiblesMovimientos(aposiciones);
    }
}
