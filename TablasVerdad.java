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

        tablas = new String[vars.length][(int) lol];
        
       
    }//main
    
}
//class