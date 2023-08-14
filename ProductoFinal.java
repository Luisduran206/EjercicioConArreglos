// Jesus Eduardo Nava Castan y Luis Durán
// Estructuras de Datos

import java.util.Scanner;

public class ProductoFinal {

    // función para pedir un dato int
    public static int getInt() {
        int thevalue;
        Scanner keyboard;
        //
        keyboard = new Scanner(System.in);
        thevalue = keyboard.nextInt();
        return thevalue;
    }//end getInt


    //funcón para obtener suma del subconjunto contiguo
   public static int maxSubArraySum(int[] datosSuma)
   {

        int maxEndingHere = datosSuma[0];
        int maxSoFar = datosSuma[0];

        for (int i = 1; i < datosSuma.length; i++) {
            maxEndingHere = Math.max(datosSuma[i], maxEndingHere + datosSuma[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }//end maxSubArraySum

    static int[] printSubconjunto(int[] datos)
    {

        int maxEndingHere = datos[0];
        int maxSoFar = datos[0];
        int start = 0;
        int tempStart = 0;
        int end = 0;

        //Encontramos el subconjunto contiguo
        for (int i = 1; i < datos.length; i++)
        {
           //Usamos algoritmo de Kadane
            if (datos[i] > maxEndingHere + datos[i])
            {
                maxEndingHere = datos[i];  // Si el número actual es mayor que la suma acumulada, comenzamos un nuevo subconjunto
                tempStart = i;            // Actualizamos tempStart para seguir la posición del nuevo subconjunto
            }//end if
            else
            {
                maxEndingHere += datos[i]; // Si el número actual no rompe el subconjunto, lo agregamos a la suma
            }//end else

            // Comparamos la suma máxima actual con la suma máxima global
            if (maxEndingHere > maxSoFar)
            {
                maxSoFar = maxEndingHere;  // Si encontramos una nueva suma máxima, actualizamos maxSoFar
                start = tempStart;         // Guardamos el inicio del nuevo subconjunto contiguo
                end = i;                   // Guardamos el final del nuevo subconjunto contiguo
            }//end if
        } // end For

        // Imprimimos el subconjunto contiguo
        System.out.print("Subconjunto contiguo: {");
        for (int i = start; i <= end; i++)
        {
            System.out.print(datos[i]);
            if (i < end)
            {
                System.out.print(", ");
            }//end if
        }//end for

        System.out.println("}");
        return datos;
    } // end printSubconjunto


    public static void main(String[] args) {

        int start = 0;
        int end = 0;
        System.out.print("Ingrese la cantidad de datos que va a tener el subconjunto: ");
        int cantidadDatos = getInt();

        int[] arreglo = new int[cantidadDatos];
        System.out.println("Ingrese los elementos del subconjunto:");
        for (int i = 0; i < cantidadDatos; i++) {
            arreglo[i] = getInt();
        }// end for

        System.out.print("Los elementos ingresados son: {");
        for (int i = 0; i < cantidadDatos; i++)
        {
            System.out.print(arreglo[i]);
            if (i < cantidadDatos - 1)
            {
                System.out.print(", ");
            }//end if
        }//end for
        System.out.println("}");

        //Imprimimos el subconjunto contiguo
        int[] subconjuntoContiguo = printSubconjunto(arreglo);


        //llamamos a la función del algoritmo de Kadane para la suma máxima
        int sumaContigua = maxSubArraySum(arreglo);
        System.out.println("La suma del subconjunto contiguo es: " + sumaContigua);

    }//end main

}//end EjercicioConArreglos