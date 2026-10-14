
package app;

import java.util.Scanner;
import modelo.Nodo;
import negocio.ArbolBinario;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArbolBinario<String> arbol = new ArbolBinario<>();

    public static void main(String[] args) {
        int opcion = 0;

        do {
            System.out.println("\n===== MENU ARBOL BINARIO =====");
            System.out.println("1. Crear arbol inicial");
            System.out.println("2. Visualizar arbol");
            System.out.println("3. Consultar numero de nodos");
            System.out.println("4. Consultar numero de hojas");
            System.out.println("5. Consultar altura");
            System.out.println("6. Consultar grado de un nodo");
            System.out.println("7. Verificar si un nodo es hoja");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(
                    scanner.nextLine().trim()
                );

                switch (opcion) {
                    case 1:
                        crearArbolInicial();
                        break;

                    case 2:
                        arbol.mostrarArbol();
                        break;

                    case 3:
                        System.out.println(
                            "Numero de nodos: " +
                            arbol.contarNodos()
                        );
                        break;

                    case 4:
                        System.out.println(
                            "Numero de hojas: " +
                            arbol.contarHojas()
                        );
                        break;

                    case 5:
                        System.out.println(
                            "Altura en aristas: " +
                            arbol.altura()
                        );
                        break;

                    case 6:
                        consultarGrado();
                        break;

                    case 7:
                        verificarHoja();
                        break;

                    case 8:
                        System.out.println(
                            "Gracias por utilizar el programa."
                        );
                        break;

                    default:
                        System.out.println(
                            "Opcion no valida."
                        );
                }

            } catch (NumberFormatException e) {
                System.out.println(
                    "Error: ingrese un numero valido."
                );
            } catch (IllegalStateException |
                     IllegalArgumentException e) {
                System.out.println(
                    "Error: " + e.getMessage()
                );
            }

        } while (opcion != 8);

        scanner.close();
    }

    // Construye las dependencias universitarias
    public static void crearArbolInicial() {

        if (!arbol.esVacio()) {
            System.out.println(
                "El arbol ya existe. No se puede crear otra raiz."
            );
            return;
        }

        Nodo<String> universidad =
            arbol.crearRaiz("UNIVERSIDAD");

        Nodo<String> fisei =
            arbol.agregarIzquierdo(universidad, "FISEI");

        Nodo<String> dide =
            arbol.agregarDerecho(universidad, "DIDE");

        Nodo<String> software =
            arbol.agregarIzquierdo(fisei, "SOFTWARE");

        arbol.agregarDerecho(fisei, "TI");

        arbol.agregarIzquierdo(dide, "INVEST.");

        arbol.agregarDerecho(dide, "VINCULACION");

        arbol.agregarIzquierdo(software, "NIVEL1");

        arbol.agregarDerecho(software, "NIVEL3");

        System.out.println(
            "Arbol universitario creado correctamente."
        );
    }

    // Consulta el grado de un nodo
    public static void consultarGrado() {

        System.out.print("Ingrese el nombre del nodo: ");
        String nombre = scanner.nextLine().trim();

        Nodo<String> nodo = arbol.buscar(nombre);

        if (nodo == null) {
            System.out.println("Nodo no encontrado.");
        } else {
            System.out.println(
                "El grado de " + nombre +
                " es: " + nodo.grado()
            );
        }
    }

    // Verifica si un nodo es hoja
    public static void verificarHoja() {

        System.out.print("Ingrese el nombre del nodo: ");
        String nombre = scanner.nextLine().trim();

        Nodo<String> nodo = arbol.buscar(nombre);

        if (nodo == null) {
            System.out.println("Nodo no encontrado.");
        } else if (nodo.esHoja()) {
            System.out.println(
                nombre + " SI es una hoja."
            );
        } else {
            System.out.println(
                nombre + " NO es una hoja."
            );
        }
    }
}
