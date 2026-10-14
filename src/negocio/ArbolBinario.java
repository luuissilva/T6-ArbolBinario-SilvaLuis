
package negocio;

import modelo.Nodo;

public class ArbolBinario<T> {

    private Nodo<T> raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // Verifica si el arbol esta vacio
    public boolean esVacio() {
        return raiz == null;
    }

    // Crea la raiz
    public Nodo<T> crearRaiz(T dato) {
        if (!esVacio()) {
            throw new IllegalStateException(
                "El arbol ya tiene una raiz."
            );
        }

        raiz = new Nodo<>(dato);
        return raiz;
    }

    // Agrega un hijo izquierdo
    public Nodo<T> agregarIzquierdo(
            Nodo<T> padre, T dato) {

        validarPadre(padre);

        if (padre.getIzquierdo() != null) {
            throw new IllegalStateException(
                "La posicion izquierda esta ocupada."
            );
        }

        Nodo<T> nuevo = new Nodo<>(dato);
        padre.setIzquierdo(nuevo);
        return nuevo;
    }

    // Agrega un hijo derecho
    public Nodo<T> agregarDerecho(
            Nodo<T> padre, T dato) {

        validarPadre(padre);

        if (padre.getDerecho() != null) {
            throw new IllegalStateException(
                "La posicion derecha esta ocupada."
            );
        }

        Nodo<T> nuevo = new Nodo<>(dato);
        padre.setDerecho(nuevo);
        return nuevo;
    }

    // Verifica que el padre pertenezca al arbol
    private void validarPadre(Nodo<T> padre) {
        if (padre == null || !contiene(raiz, padre)) {
            throw new IllegalArgumentException(
                "El nodo padre no pertenece al arbol."
            );
        }
    }

    private boolean contiene(
            Nodo<T> actual, Nodo<T> buscado) {

        if (actual == null) {
            return false;
        }

        if (actual == buscado) {
            return true;
        }

        return contiene(actual.getIzquierdo(), buscado)
            || contiene(actual.getDerecho(), buscado);
    }

    // Cuenta todos los nodos recursivamente
    public int contarNodos() {
        return contarNodos(raiz);
    }

    private int contarNodos(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }

        return 1
            + contarNodos(nodo.getIzquierdo())
            + contarNodos(nodo.getDerecho());
    }

    // Cuenta las hojas recursivamente
    public int contarHojas() {
        return contarHojas(raiz);
    }

    private int contarHojas(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }

        if (nodo.esHoja()) {
            return 1;
        }

        return contarHojas(nodo.getIzquierdo())
            + contarHojas(nodo.getDerecho());
    }

    // Calcula la altura en aristas
    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo<T> nodo) {
        if (nodo == null) {
            return -1;
        }

        int izquierda = altura(nodo.getIzquierdo());
        int derecha = altura(nodo.getDerecho());

        return 1 + Math.max(izquierda, derecha);
    }

    // Muestra el arbol en consola
    public void mostrarArbol() {
        if (esVacio()) {
            System.out.println("El arbol esta vacio.");
            return;
        }

        mostrarArbol(raiz, "", "Raiz: ");
    }

    private void mostrarArbol(
            Nodo<T> nodo, String espacio, String tipo) {

        if (nodo == null) {
            return;
        }

        System.out.println(espacio + tipo + nodo.getDato());

        mostrarArbol(
            nodo.getIzquierdo(),
            espacio + "    ",
            "I-- "
        );

        mostrarArbol(
            nodo.getDerecho(),
            espacio + "    ",
            "D-- "
        );
    }

    // Busca un nodo por su dato
    public Nodo<T> buscar(T dato) {
        return buscar(raiz, dato);
    }

    private Nodo<T> buscar(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            return null;
        }

        if (java.util.Objects.equals(nodo.getDato(), dato)) {
            return nodo;
        }

        Nodo<T> encontrado =
            buscar(nodo.getIzquierdo(), dato);

        if (encontrado != null) {
            return encontrado;
        }

        return buscar(nodo.getDerecho(), dato);
    }
}
