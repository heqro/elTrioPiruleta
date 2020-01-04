/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_final;
import java.util.Comparator;
/**
 *
 * @author Juan
 */
public class compararUsuarios implements Comparator<Usuario>{
    
    @Override //no return 0 porque son doubles, a la hora de usarlo no tendremos en cuenta
    public int compare(Usuario e1, Usuario e2){
        if(e1.porcentajeExito()<e2.porcentajeExito()){
            return -1;
        }else{
            if(e1.porcentajeExito()==e2.porcentajeExito()){ //solo se dara cuando ambos sean 0
                return 0;
            }else{
                return 1;
            }
        }
    }
    
}
