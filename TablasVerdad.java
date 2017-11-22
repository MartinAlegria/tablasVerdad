/*
Martín Alegría
A01022216
Tablas de Verdad
 */


import javax.swing.*;
import java.util.*;


public class TablasVerdad  {


    public static void main(String[] args) {


        //Variables
       JOptionPane ventana = new JOptionPane(); //GUI
       String variables; //String donde van a ir las variables que el usuario introduce
       boolean up  = true; // boolean para saber si las variables fueron intruducidas con mayúsculas
       String tabla = ""; // string donde se escribe la tabla
       int salir = 0; // input para saber si el usuario quiere salir
       String[] botones = {"No" , "Si"}; //botones para la decisión del usuario de salir
       
       ventana.showMessageDialog(null, " * Bienvendo * \n ", "Tablas de Verdad", JOptionPane.INFORMATION_MESSAGE);
       
       do { //do while para saber si el usuario quiere salir, si no quiere salir se ejecuta el loop

           do{ // do while para que el usuario introduzca las variables otra vez si las introdujo en mayúsculas

               variables = ventana.showInputDialog(null, "Ingresa las variables que quieres usar: \n (Solo minusculas, separadas por comas)", "Tablas de Verdad", JOptionPane.INFORMATION_MESSAGE);
               boolean tieneMayus = !variables.equals(variables.toLowerCase()); //checa si las variables estan en mayusculas

               if(tieneMayus){ //imprime mensaje si están en mayúsculas.
                   ventana.showMessageDialog(null, " Una o más de tus variables tiene mayuscula \n Intentalo de nuevo", "Tablas de Verdad", JOptionPane.ERROR_MESSAGE);
               }//if
               else{
                   up = false;
               }//else

           }while(up);

           String[] vars = variables.split(","); //Array donde se dividen las variables
           int numeroVariables = vars.length; //int para saber cuantas variables hay

           ventana.showMessageDialog(null, " Tienes " + numeroVariables + " variables \n "+ variables, "Tablas de Verdad", JOptionPane.INFORMATION_MESSAGE );

           tabla = ""; //borra la tabla por si el usuario quiere hacer otra

           for (int i=0 ;i!=(1<<numeroVariables);i++) {

               String binario = Integer.toBinaryString(i); //String que almacena el número booleano en String

               while (binario.length() != numeroVariables) { // while que añade los ceros al numero booleano
                   binario = '0'+ binario;
               }//while

               tabla += binario+ "  | \n"; ///ESTA ES LA TABLA *******************************************************************************
           }//for


           boolean opsCheck = true;
           String funcion = "";

           do { //do while para que el usuario escriba la función bien en caso de que la haya escrito mal

               funcion = ventana.showInputDialog(null, "Escribe tu función utilizando tus variables " + "\n " + variables + "\n Y utilizando operadores binarios y paréntesis \n AND = & \n OR = | \n NOT = ! \n IF-THEN = -> \n IFF = <->", " Tablas de Verdad", JOptionPane.INFORMATION_MESSAGE);

               if(!funcion.matches("[&|!-><->()" + variables + "]+")) //cecha si todas las variables fueron introducidas y si introdujo otra cosa que no fueran los operadores desplegados
               {
                   opsCheck = false;
               }else {
                   opsCheck = true;
               }


               if(!opsCheck){
                   ventana.showMessageDialog(null, "Introdujiste un simbolo no valido o no todas las variables, intenta de nuevo", "Tablas de Verdad", JOptionPane.ERROR_MESSAGE);
               }

           }while(!opsCheck);

           String tablaF = variables + "  | \t " + funcion + "\n"; //Para imprimir la tabla más estética.
           tablaF += "---------------------------------------- \n";
           tablaF += tabla;

           ventana.showMessageDialog(null, "Esta es tu tabla: \n" + tablaF , "Tablas de Verdad", JOptionPane.INFORMATION_MESSAGE);

           salir = ventana.showOptionDialog(null,"Quieres hacer otra tabla ? ","Tablas de Verdad",0,JOptionPane.PLAIN_MESSAGE, null, botones, botones[0]);

       }while(salir == 1);

       System.exit(0);


    }//main


}
//class