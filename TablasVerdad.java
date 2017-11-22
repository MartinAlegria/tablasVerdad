/*

 */


import javax.swing.*;
import java.util.*;


public class TablasVerdad {


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
            }//if
            else{
                up = false;
            }//else
           
       }while(up);
       
       String[] vars = variables.split(",");
       int numeroVariables = vars.length;
       
       ventana.showMessageDialog(null, " Tienes " + numeroVariables + " variables \n "+ variables, "Tablas de Verdad", JOptionPane.INFORMATION_MESSAGE );


        for (int i=0 ;i!=(1<<numeroVariables);i++) {

            String binario = Integer.toBinaryString(i);

            while (binario.length() != numeroVariables) {
                binario = '0'+ binario;
            }//while

            tabla += binario+ "  | \n"; ///ESTA ES LA TABLA *******************************************************************************
        }//for


        boolean opsCheck = true;
        String funcion = "";

        do {

            funcion = ventana.showInputDialog(null, "Escribe tu función utilizando tus variables " + "\n " + variables + "\n Y utilizando operadores binarios y paréntesis \n AND = & \n OR = | \n NOT = ! \n IF-THEN = -> \n IFF = <->", " Tablas de Verdad", JOptionPane.INFORMATION_MESSAGE);

            if(!funcion.matches("[&|!-><->()" + variables + "]+"))
            {
                opsCheck = false;
            }else {
                opsCheck = true;
            }


            if(!opsCheck){
                ventana.showMessageDialog(null, "Introdujiste un simbolo no valido o no todas las variables, intenta de nuevo", "Tablas de Verdad", JOptionPane.ERROR_MESSAGE);
            }

        }while(!opsCheck);

        String tablaF = variables + "  | \t " + funcion + "\n";
        tablaF += "---------------------------------------- \n";
        tablaF += tabla;

        ventana.showMessageDialog(null, "Esta es tu tabla: \n" + tablaF , "Tablas de Verdad", JOptionPane.INFORMATION_MESSAGE);


    }//main


}
//class