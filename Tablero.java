/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_final;

/**
 *
 * @author j.montes.2018
 */
public class Tablero {
    private Pieza Marcador[][] = new Pieza[8][8];
    public Tablaro(){
        int i;
        int j;
        for (i=0;i==7;i++){
            for(j=0;j==7;j++){
                Marcador[i][j] = null;
            }
        };
    }
    public Tablero(Pieza M[][]){
        Marcador= M;
        
    }
    private ArrayList<Posicion> BuscarPiezas(Char s){
        ArrayList<Posicion>  p = new ArrayList<Posicion>;
        int i;
        int j;
        for (i = 0; i==7; i++){
            for (j=0;j==7;j++){
                if (Marcador[i][j].getNombre == s){
                    p.add(new Posicion(i,j));
                }
            }
        };
        return(p);
        
    }
    public Pieza MovimientoValido(String s){
      char a =  s.charAt(1);
      this.BuscarPiezas(a)
    }
    public void MoverPieza (Posicion posM, Pieza p ){
        try{
        }catch()
    }
    
    private void insertarPieza(String pstring, int x, int y){
        switch(pstring.charAt(0)){
            case 'R':
                if (pstring.charAt(1)=='B'){
                    
                    
                    
                }
        }
        
    }
}
