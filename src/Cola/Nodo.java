/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cola;

/**
 *
 * @author ulacit
 */
public class Nodo {
    private Auto dato;
    private Nodo atras;

    public Nodo(Auto dato) {
        this.dato = dato;
    }

    public Auto getDato() {
        return dato;
    }

    public void setDato(Auto dato) {
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
