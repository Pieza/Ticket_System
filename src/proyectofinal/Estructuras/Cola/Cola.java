package proyectofinal.Estructuras.Cola;

import javax.swing.JOptionPane;
import proyectofinal.Objetos.Ticket;

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

    public Ticket busquedaTicketPorID(int id) {
        //aux se convierte en el frente de la cola
        Nodo aux = frente;
        //empezamos a iterar hasta que aux sea nulo
        while (aux != null) {
            if (aux.getDato().getId() == id) {
                //retornamos true con la informacion que estamos buscando
                return aux.getDato();
            }
            //si es el ultimo dato aux se iguala a nulo para terminar el ciclo
            aux = aux.getAtras();
        }
        JOptionPane.showMessageDialog(null, "No se encontraron datos del ticket: " + id);
        return null;
    }

    /**
     * Se extrae el tickete por id de usuario
     * @param idUsuario
     * @return 
     */
    public String[] extrae(int idUsuario) {
        //creamos las variables aix que va a ser el frente de la cola
        Nodo aux = frente;
        String resultado = "";
        while (aux != null) {
            if(aux.getDato().getAsignadolvl3().getId() == idUsuario){
                resultado += aux.getDato() + ";";
            }
            //avanzamos al dato siguiente
            aux = aux.getAtras();
        }
        
        // retorna null si no encuentra tickets
        return resultado.split(";");
    }
}
