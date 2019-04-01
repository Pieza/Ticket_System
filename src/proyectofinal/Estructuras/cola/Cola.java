package proyectofinal.estructuras.cola;

import javax.swing.JOptionPane;
import proyectofinal.enums.EstadoTickete;
import proyectofinal.objetos.Ticket;
import proyectofinal.utilidades.InformacionUsuario;

public class Cola {

    private Nodo frente, ultimo;

    //Añade datos a la cola
    public void encola(Ticket t) {
        Nodo n = new Nodo(t);
        if (frente == null) {
            //si es el primer dato que se ingresa frente y ultimo son el mismo dato
            frente = n;
        } else {
            ultimo.setAtras(n);
        }
        ultimo = n;
    }

    //Elimina datos
    public Ticket atiende() {
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
            return aux.getDato();
        }
        return null;
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
     *
     * @param idUsuario
     * @return
     */
    public String[] extraePendientes(int idUsuario) {
        //creamos las variables aix que va a ser el frente de la cola
        Nodo aux = frente;
        String resultado = "";
        while (aux != null) {
            // se excluyen los completados
            if (aux.getDato().getEstado() != EstadoTickete.COMPLETADO) {
                // se compara por id de usuario asignado
                if (aux.getDato().getAsignadolvl1() != null && aux.getDato().getAsignadolvl1().getId() == idUsuario) {
                    resultado += aux.getDato() + ";";
                }

                if (aux.getDato().getAsignadolvl2() != null && aux.getDato().getAsignadolvl2().getId() == idUsuario) {
                    resultado += aux.getDato() + ";";
                }

                if (aux.getDato().getAsignadolvl3() != null && aux.getDato().getAsignadolvl3().getId() == idUsuario) {
                    resultado += aux.getDato() + ";";
                }
            }

            //avanzamos al dato siguiente
            aux = aux.getAtras();
        }

        // retorna null si no encuentra tickets
        return resultado.split(";");
    }

    public String[] extraeSinAsignar() {
        //creamos las variables aix que va a ser el frente de la cola
        Nodo aux = frente;
        String resultado = "";
        while (aux != null) {
            // se excluyen los completados
            if (aux.getDato().getEstado() == EstadoTickete.SIN_ASIGNAR) {
                resultado += aux.getDato() + ";";
            }

            //avanzamos al dato siguiente
            aux = aux.getAtras();
        }

        // retorna null si no encuentra tickets
        return resultado.split(";");
    }

    public boolean actualizarTicket(int id, String nuevaActualizacion, EstadoTickete estado) {
        //aux se convierte en el frente de la cola
        Nodo aux = frente;
        //empezamos a iterar hasta que aux sea nulo
        while (aux != null) {
            if (aux.getDato().getId() == id) {
                aux.getDato().setNuevaActualizacion(nuevaActualizacion);
                String datosActualizacion = "***Actualizado por " + InformacionUsuario.usuario.getNombre() + " " + InformacionUsuario.usuario.getApellidos() + " a las ";
                aux.getDato().setHistorial(datosActualizacion.toUpperCase() + "\n" + nuevaActualizacion + "\n" + aux.getDato().getHistorial());
                aux.getDato().setEstado(estado);
                //retornamos true para indicar que se actualizó correctamente
                return true;
            }
            //si es el ultimo dato aux se iguala a nulo para terminar el ciclo
            aux = aux.getAtras();
        }
        return false;
    }
}
