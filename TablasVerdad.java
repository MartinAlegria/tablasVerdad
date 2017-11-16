/*

 */


import javax.swing.*;
import java.util.*;


public class TablasVerdad {

    /**
    null, "\tWelcome to PiggyBank,", "PiggyBank", JOptionPane.INFORMATION_MESSAGE);
    showInputDialog(null, "\tType your name here:", "New User", JOptionPane.INFORMATION_MESSAGE); 
*/
    public static void main(String[] args) {
        
       JOptionPane ventana = new JOptionPane();
       String variables;
       boolean up  = true;
       String tabla = "";
       
       ventana.showMessageDialog(null, " * Bienvendo * \n ", "Tablas de Verdad", JOptionPane.INFORMATION_MESSAGE);
       
       do{
           
        variables = ventana.showInputDialog(null, "Ingresa las variables que quieres usar: \n (Solo minusculas, separadas por comas)", "Tablas de Verdad", JOptionPane.INFORMATION_MESSAGE);        
        boolean tieneMayus = !variables.equals(variables.toLowerCase());
        
            if(tieneMayus){
                ventana.showMessageDialog(null, " Una o más de tus variables tiene mayuscula \n Intentalo de nuevo", "Tablas de Verdad", JOptionPane.ERROR_MESSAGE);
            }
            else{
                up = false;
            }
           
       }while(up);
       
       String[] vars = variables.split(",");
       double numeroVariables = vars.length;
       
       ventana.showMessageDialog(null, " Tienes " + numeroVariables + " variables \n "+ variables, "Tablas de verdad", JOptionPane.INFORMATION_MESSAGE );
       
       
       String[][] tablas;
       double lol = Math.pow(2, numeroVariables);
        int veces = 1;

        tablas = new String[vars.length][(int) lol];
        
        for(int i = (int)numeroVariables; i>0; i--){
        
             int temp = veces;
            int cont = 0;
            for(int j = 0; j<lol; j++){
                
                if(veces == 1){
                
                    if(j<temp){
                        tablas[i-1][j] = "F";
                    }
                    else{
                        tablas[i-1][j] = "T";
                        temp = j+2;
                    }
                
                }else{
                
                    if(temp%(j+1) == 0){
                        tablas[i-1][j] = "F";
                    }
                    else{
                        tablas[i-1][j] = "T";
                        
                    }
                    
                }
                
             
                
            }//for
            
            veces = veces * 2;
            
        }//for
        
        for(int i = vars.length; i>0; i--){
            
            for(int j = 0; j<tablas[0].length; j++){
                
                System.out.print(tablas[i-1][j]);
                
            }//for
            System.out.println();
            
            veces = veces * 2;
            
        }//for
        
       
    }//main
    
}
//class