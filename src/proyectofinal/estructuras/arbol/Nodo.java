package proyectofinal.estructuras.arbol;

import proyectofinal.objetos.Ticket;

/**
 *
 * @author ulacit
 */
public class Nodo {
    private Ticket dato;
    private Nodo hijoIzq, hijoDer;

    public Nodo(Ticket dato) {
        this.dato = dato;
    }

    public Ticket getDato() {
        return dato;
    }

    public void setDato(Ticket dato) {
        this.dato = dato;
    }

    public Nodo getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public Nodo getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }

    @Override
    public String toString() {
        return " " + dato;
    }
}
