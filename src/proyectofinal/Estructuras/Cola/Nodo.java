package proyectofinal.Estructuras.Cola;

import proyectofinal.Objetos.Ticket;

public class Nodo {
    private Ticket dato;
    private Nodo atras;

    public Nodo(Ticket dato) {
        this.dato = dato;
    }

    public Ticket getDato() {
        return dato;
    }

    public void setDato(Ticket dato) {
        this.dato = dato;
    }

    public Nodo getAtras() {
        return atras;
    }

    public void setAtras(Nodo atras) {
        this.atras = atras;
    }

    @Override
    public String toString() {
        return "dato= " + dato;
    }
}
