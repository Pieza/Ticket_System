package proyectofinal.Lista;

import proyectofinal.Objetos.Usuario;

/**
 *
 * @author ulacit
 */
public class Nodo {
    private Usuario dato;
    private Nodo next, back;

    public Nodo(Usuario dato) {
        this.dato = dato;
    }

    public Usuario getDato() {
        return dato;
    }

    public void setDato(Usuario dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getBack() {
        return back;
    }

    public void setBack(Nodo back) {
        this.back = back;
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + '}';
    }
}
