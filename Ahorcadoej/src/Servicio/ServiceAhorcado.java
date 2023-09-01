/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Ahorcado;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 *  Metodo crearJuego(): le pide la palabra al usuario y cantidad de jugadas
 * máxima. Con la palabra del usuario, pone la longitud de la palabra, como la
 * longitud del vector. Después ingresa la palabra en el vector, letra por
 * letra, quedando cada letra de la palabra en un índice del vector. Y también,
 * guarda en cantidad de jugadas máximas, el valor que ingresó el usuario y
 * encontradas en 0.  Método longitud(): muestra la longitud de la palabra que
 * se debe encontrar. Nota: buscar como se usa el vector.length.  Método
 * buscar(letra): este método recibe una letra dada por el usuario y busca sila
 * letra ingresada es parte de la palabra o no. También informará si la letra
 * estaba o no.  Método encontradas(letra): que reciba una letra ingresada por
 * el usuario y muestre cuantas letras han sido encontradas y cuantas le faltan.
 * Este método además deberá devolver true si la letra estaba y false si la
 * letra no estaba, ya que, cada vez que se busque una letra que no esté, se le
 * restará uno a sus oportunidades.  Método intentos(): para mostrar cuantas
 * oportunidades le queda al jugador.  Método juego(): el método juego se
 * encargará de llamar todos los métodos previamente mencionados e informará
 * cuando el usuario descubra toda la palabra o se quede sin intentos. Este
 * método se llamará en el main.
 */
public class ServiceAhorcado {

    Ahorcado juego = new Ahorcado();
    Scanner read = new Scanner(System.in);

    public void crearJuego() {
        String palabra;
        System.out.println("Ingrese la palabra: ");
        palabra = read.next().toLowerCase();
        System.out.println("Ingresar la cantidad de jugadas maximas:");
        juego.setJugadasMax(read.nextInt());
        juego.setPalabraBuscar(new String[palabra.length()]);
        for (int i = 0; i < palabra.length(); i++) {
            juego.getPalabraBuscar()[i] = palabra.substring(i, i + 1);
 
        }

        juego.setCantidadLetras(0);

    }

    public void longitud() {
        System.out.println("La longitud de la palabra es: " + juego.getPalabraBuscar().length);
    }

    public void buscar(String letra) {
        String[] guion = new String[juego.getPalabraBuscar().length];
        for (int i = 0; i < juego.getPalabraBuscar().length; i++) {
            guion[i] = "_";

        }
        do {
            System.out.println("Ingrese una letra: ");
            letra = read.nextLine().toLowerCase();
            int cont = 0;
            for (int i = 0; i < juego.getPalabraBuscar().length; i++) {
                if (juego.getPalabraBuscar()[i].equals(letra)) {
                    cont++;
                    if (letra.equals(guion[i])) {
                        break;
                    }
                    guion[i] = letra;
                    // int cl = juego.getCantidadLetras();
                    //cl++;
                    juego.setCantidadLetras(juego.getCantidadLetras()+1);

                }

            }
            encontradas();
            if (cont > 0) {
                System.out.println("La letra pertenece a  la palabra ");
            } else {
                System.out.println("la letra no pertenece a la palabra ");
                 juego.setJugadasMax(juego.getJugadasMax()-1);
            }
            System.out.println("la palabra es: ");
            for (int i = 0; i < juego.getPalabraBuscar().length; i++) {
                System.out.print(" " + guion[i] + " ");  
              
            }
              System.out.println(" ");
             // Arrays.equals(guion, juego.getPalabraBuscar());
              intentos();
              
        } while (juego.getJugadasMax()>0 && Arrays.equals(guion, juego.getPalabraBuscar())==false);
        if (Arrays.equals(guion, juego.getPalabraBuscar())==true) {
            System.out.println("Encontraste la palabra ");
            
        }
    }

    public void encontradas() {
        System.out.println("Número de letras (encontradas, faltantes) " + "(" + juego.getCantidadLetras() + ")" + "(" + (juego.getPalabraBuscar().length - juego.getCantidadLetras()) + ")");

       
    }

    public void intentos() {
        System.out.println("Le quedan: " + juego.getJugadasMax() + "intentos");
    }

    public void juego() {
        String letra = " ";
        crearJuego();
        longitud();
        buscar(letra);
        if (juego.getJugadasMax() == 0) {
            System.out.println("Se terminaron los intentos ");
            System.out.println("La palabra era: ");
            for (int i = 0; i < juego.getPalabraBuscar().length; i++) {
                System.out.print(" " + juego.getPalabraBuscar()[i] + " ");

            }
            System.out.println(" ");
        }

    }
}
