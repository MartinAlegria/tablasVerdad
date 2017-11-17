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

            tabla += binario+ "\n"; ///ESTA ES LA TABLA *******************************************************************************
        }//for

        String[] comp = new String[vars.length + 6];
        String[] ops = {"&","|","!","->","<->","(",")"};

        for(int i = 0; i<comp.length; i++){

            if(i<vars.length){
                comp[i] = vars[i];
            }//if
            else{
                comp[i] = ops[i-vars.length];
            }

        }//for

        String funcion = ventana.showInputDialog(null, "Escribe tu función utilizando tus variables " + "\n " + variables + "\n Y utilizando operadores binarios y paréntesis \n AND = & \n OR = | \n NOT = ! \n IF-THEN = -> \n IFF = <->" , " Tablas de Verdad", JOptionPane.INFORMATION_MESSAGE);

        boolean[] check = new boolean[vars.length];
        boolean  varCheck = true;

        for(int i = 0; i<vars.length; i++){
            if(funcion.contains(vars[i])){
                check[i] = true;
            }else{
                check[i] = false;
            }

        }//ofr

        for(int i=0; i<check.length; i++){

            if(check[i]){
                varCheck = true;
            }else{
                varCheck = false;
                break;
            }

        }//for

        if(varCheck){
            System.out.println("YUP");} else { System.out.println("NAH");}


    }//main


}
//class