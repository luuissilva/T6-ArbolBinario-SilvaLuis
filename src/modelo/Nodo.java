package modelo;

public class Nodo<T> {

    private T dato;
    private Nodo<T> izquierdo;
    private Nodo<T> derecho;

    // Constructor
    public Nodo(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    // Determina si el nodo es una hoja
    public boolean esHoja() {
        return izquierdo == null && derecho == null;
    }

    // Devuelve el número de hijos
    public int grado() {
        int cantidad = 0;

        if (izquierdo != null) {
            cantidad++;
        }

        if (derecho != null) {
            cantidad++;
        }

        return cantidad;
    }

    // Getters y setters
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo<T> derecho) {
        this.derecho = derecho;
    }
}
