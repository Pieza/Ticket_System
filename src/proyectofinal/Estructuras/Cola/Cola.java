/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Estructuras.Cola;

import javax.swing.JOptionPane;

/**
 *
 * @author ulacit
 */
public class Cola {

    private Nodo frente, ultimo;

    //Añade datos a la cola
    public void encola(Nodo n) {
        if (frente == null) {
            //si es el primer dato que se ingresa frente y ultimo son el mismo dato
            frente = n;
        } else {
            ultimo.setAtras(n);
        }
        ultimo = n;
    }

    //Elimina datos
    public Nodo atiende() {
        //cremos un auxiliar para guardar el dato
        Nodo aux = frente;
        //validamos que frente tenga datos
        if (aux != null) {
            //decimo que el dato de atras es el frente
            frente = frente.getAtras();
            //borramos las conexciones de aux
            aux.setAtras(null);
            //preguntamos de nuevo que frente sea nulo
            if (frente == null) {
                //si es nulo significa que era el ultimo dato, por lo que la lista esta vacia y borramos ultimo
                ultimo = null;
            }
        }
        return aux;
    }

    //imprime
    public String toString() {
        String msj = "";
        //aux se convierte en el frente de la cola
        Nodo aux = frente;

        //empezamos a iterar hasta que aux sea nulo
        while (aux != null) {
            //concatenamos los datos a la variable final
            msj = msj + aux.getDato().toString();
            //si es el ultimo dato aux se iguala a nulo para terminar el ciclo
            aux = aux.getAtras();
        }
        return msj;
    }

    public Boolean encuentra(int year) {
        //aux se convierte en el frente de la cola
        Nodo aux = frente;
        int yearDato = aux.getDato().getYear();
        //empezamos a iterar hasta que aux sea nulo
        while (aux != null) {
            if (year == yearDato) {
                //retornamos true con la informacion que estamos buscando
                JOptionPane.showMessageDialog(null, "Se encontro el registro " + aux.getDato().toString());
                return true;
            }
            //si es el ultimo dato aux se iguala a nulo para terminar el ciclo
            aux = aux.getAtras();
        }

        JOptionPane.showMessageDialog(null, "No se encontraron datos del año: " + year);
        return false;
    }

    public void extrae(String modelo) {
        //creamos las variables aix y auxAnterior que van a ser el frente de la cola
        Nodo aux = frente;
        Nodo auxAnterior = frente;
        //la variable eliminado nos va a controlar las iteraciones
        boolean eliminado = false;
        while (eliminado == false) {
            String modeloEncontrado = aux.getDato().getModelo().toUpperCase().trim();
            if (modelo.toUpperCase().trim().contains(modeloEncontrado)) {
                //cuando encontramos la coincidencia del modelo le asignamos a auxAnterior que el dato de atras va a ser el dato que le sigue a aux
                auxAnterior.setAtras(aux.getAtras());
                //borramos aux
                aux.setAtras(null);
                eliminado = true;
            } else {
                //cuando no encuentra el dato guardamos aux en auxanterior para asi iterar y no olvidar la posicion de donde venimos
                auxAnterior = aux;
            }
            //avanzamos al dato siguiente
            aux = aux.getAtras();
        }
    }

    public String ordenaAscendente() {
        String msj = "";
        Nodo aux = frente;
        Nodo auxSiguiente = frente.getAtras();

        boolean cambio = false;
        while (auxSiguiente != null) {
            int auxPasajeros = aux.getDato().getPasajeros();
            int auxSiguientePasajeros = auxSiguiente.getDato().getPasajeros();
            //while(cambio == false){

            if (auxPasajeros < auxSiguientePasajeros) {
                msj = msj + auxSiguiente.getDato().toString();
                auxSiguiente = auxSiguiente.getAtras();

            } else {
                msj = msj + aux.getDato().toString();
                auxSiguiente = auxSiguiente.getAtras();
                //aux = aux.getAtras();
            }

            //}
        }

        return msj;
    }
}
