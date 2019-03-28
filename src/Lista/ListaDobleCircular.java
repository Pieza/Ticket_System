/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import javax.swing.JOptionPane;

/**
 *
 * @author ulacit
 */
public class ListaDobleCircular {

    private Nodo cabeza, ultimo;

    public void inserta(Juego j) {
        //preguntamos si cabeza es null para saber si esta vacio o no
        if (cabeza == null) {
            //Creamos el objeto y le asignamos a cabeza
            cabeza = new Nodo(j);
            ultimo = cabeza;
        } else {
            if (j.getYear() < cabeza.getDato().getYear()) {
                //como el dato se va a guardar a la izquierda entonces lo creamos como la izquierda de cabeza
                //por lo que decimos que es el back de cabeza
                cabeza.setBack(new Nodo(j));
                //a la vez decimos que el siguiente de cabeza.getBack va a ser cabeza
                cabeza.getBack().setNext(cabeza);
                //cambiamos el puntero de cabeza
                cabeza = cabeza.getBack();
            } else {
                //preguntamos si el nuevo juego es mayor a ultimo para agregarlo al final
                if (j.getYear() > ultimo.getDato().getYear()) {
                    ultimo.setNext(new Nodo(j));
                    ultimo.getNext().setBack(ultimo);
                    ultimo = ultimo.getNext();
                } else {
                    //si el dato es menor que ultimo
                    Nodo aux = cabeza;
                    //iteramos hasta esta en el dato que es mayor al que vamos a ingresar
                    while (j.getYear() > aux.getDato().getYear()) {
                        aux = aux.getNext();
                    }
                    Nodo temp = new Nodo(j);
                    temp.setNext(aux);
                    temp.setBack(aux.getBack());

                    aux.setBack(temp);
                    temp.getBack().setNext(temp);
                }
            }
        }
        //decimos que el siguiente de ultimo es cabeza para que sea circular
        //lo ponemos antes de que se acabe del metodo para asi asegurar que se cumpla en todas las decisiones
        ultimo.setNext(cabeza);
        cabeza.setBack(ultimo);
    }

    public String toString() {
        String msj = "";
        Nodo aux = cabeza;

        if (cabeza != null) {
            msj += cabeza.getDato().toString();
            aux = aux.getNext();
            while (aux != cabeza) {
                msj += aux.getDato().toString();
                aux = aux.getNext();
            }
        } else {
            //lista vacia
        }
        return msj;
    }

    public boolean existe(String nombre) {
        Nodo aux = cabeza;

        if (cabeza != null) {
            //comparamos que el dato este en la cabeza
            if (cabeza.getDato().getNombre().trim().equalsIgnoreCase(nombre.trim())) {
                JOptionPane.showMessageDialog(null, "El juego existe");
                return true;
            } else {
                //si no es cabeza iteramos el siguiente para entrar al metodo
                aux = aux.getNext();
                while (aux != cabeza) {
                    //en el ciclo comparamos igual
                    if (aux.getDato().getNombre().trim().equalsIgnoreCase(nombre.trim())) {
                        JOptionPane.showMessageDialog(null, "El juego existe");
                        return true;
                    }
                    aux = aux.getNext();
                }
            }
        } else {
            //vacia
        }

        JOptionPane.showMessageDialog(null, "El juego NO existe");
        return false;
    }

    public void modifica(String nombre, int year) {
        Nodo aux = cabeza;

        if (cabeza != null) {
            //verificamos que el dato no este en la cabeza
            if (cabeza.getDato().getNombre().trim().equalsIgnoreCase(nombre.trim()) && cabeza.getDato().getYear() == year) {
                //pedimos nuevo dato
                String nuevaPlataforma = JOptionPane.showInputDialog("Ingrese la nueva plataforma para el dato:\n " + aux.getDato().toString());
                //asignamos y mostramos
                cabeza.getDato().setPlataforma(nuevaPlataforma);
                JOptionPane.showMessageDialog(null, "Se modficó el dato por el siguiente:\n " + aux.getDato().toString());
            } else {
                //si no es la cabeza, iteramos y hacemos el mismo procesos
                aux = aux.getNext();
                while (aux != cabeza) {
                    if (aux.getDato().getNombre().trim().equalsIgnoreCase(nombre.trim()) && aux.getDato().getYear() == year) {
                        String nuevaPlataforma = JOptionPane.showInputDialog("Ingrese la nueva plataforma para el dato:\n " + aux.getDato().toString());
                        aux.getDato().setPlataforma(nuevaPlataforma);
                        JOptionPane.showMessageDialog(null, "Se modficó el dato por el siguiente:\n " + aux.getDato().toString());
                    }
                    aux = aux.getNext();
                }
            }
        } else {
            //vaica
        }

    }

    public void elimina(String nombre, int year) {
        Nodo aux = cabeza;

        if (cabeza != null) {
            //verificamos que el dato sea la cabeza
            if (cabeza.getDato().getNombre().trim().equalsIgnoreCase(nombre.trim()) && cabeza.getDato().getYear() == year) {
                cabeza = cabeza.getNext();//decimos que cabeza es el siguiente
                //hacemos la lista circular
                ultimo.setNext(cabeza);
                cabeza.setBack(ultimo);
            } else {
                //si no es cabeza iteramos al sigueinte dato
                aux = aux.getNext();
                while (aux != cabeza) {
                    //comparamos
                    if (aux.getDato().getNombre().trim().equalsIgnoreCase(nombre.trim()) && aux.getDato().getYear() == year) {
                        //le asignamos el dato anterior que estamos al siguiente de nosotros
                        aux.getNext().setBack(aux.getBack());
                        //le asignamos al dato anterios de nosotros el siguiente de nosotros
                        aux.getBack().setNext(aux.getNext());
                    }
                    aux = aux.getNext();
                }
            }
        } else {

        }
    }

    public String imprimeDescendente() {
        //hacemos un toString y aprovechamos el getback para iterat alreves
        Nodo aux = ultimo;
        String msj = "";

        if (cabeza != null) {
            msj += ultimo.getDato().toString();
            aux = aux.getBack();
            while (aux != ultimo) {
                msj += aux.getDato().toString();
                aux = aux.getBack();
            }
        } else {

        }
        return msj;
    }

    public void cuentaNombres(String nombre) {
        Nodo aux = cabeza;
        int cantidad = 0;

        //cada vez que se encuente en match sumamos el contador y al final mostramos el resultado
        if (cabeza != null) {
            if (cabeza.getDato().getNombre().trim().equalsIgnoreCase(nombre.trim())) {
                cantidad++;
            }
            aux = aux.getNext();
            while (aux != cabeza) {
                if (aux.getDato().getNombre().trim().equalsIgnoreCase(nombre)) {
                    cantidad++;
                }
                aux = aux.getNext();
            }
        } else {
            //vacia
        }

        JOptionPane.showMessageDialog(null, "El nombre " + nombre + " aparece un total de " + cantidad + " veces.");
    }
}
