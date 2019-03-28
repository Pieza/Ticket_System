/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Lista;

/**
 *
 * @author ulacit
 */
public class Nodo {
    private Juego dato;
    private Nodo next, back;

    public Nodo(Juego dato) {
        this.dato = dato;
    }

    public Juego getDato() {
        return dato;
    }

    public void setDato(Juego dato) {
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
