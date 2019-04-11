package proyectofinal.utilidades;

import proyectofinal.estructuras.arbol.Arbol;
import proyectofinal.estructuras.cola.Cola;
import proyectofinal.estructuras.lista.ListaDobleCircular;
//aqui se guarda la informacion de los estructuras de manera que tenemos facil acceso a ellos en cualquier momento
public class Data {
    public static final ListaDobleCircular LISTA_USUARIOS = new ListaDobleCircular();
    public static final Cola TICKETES = new Cola();
    public static final Arbol HISTORIAL_TICKETES = new Arbol();
}
