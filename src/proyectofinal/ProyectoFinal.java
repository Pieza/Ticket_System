/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import proyectofinal.enums.EstadoTickete;
import proyectofinal.enums.NivelSoporte;
import proyectofinal.estructuras.cola.Nodo;
import proyectofinal.objetos.Administrador;
import proyectofinal.objetos.Cliente;
import proyectofinal.objetos.Ticket;
import proyectofinal.utilidades.Data;
import proyectofinal.vistas.Login;

/**
 *
 * @author ulacit
 */
public class ProyectoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Data.LISTA_USUARIOS.inserta(new Administrador(NivelSoporte.LVL_3, "Jose", "Ulloa", "jose@mail.com", "123", 1));
        Data.LISTA_USUARIOS.inserta(new Administrador(NivelSoporte.LVL_3, "Alejandro", "Salguero", "alejandro@mail.com", "123", 2));
        Data.LISTA_USUARIOS.inserta(new Administrador(NivelSoporte.LVL_2, "Carlos", "Espinosa", "carlos@mail.com", "123", 3));
        Data.LISTA_USUARIOS.inserta(new Administrador(NivelSoporte.LVL_1, "Martir", "Canales", "martir@mail.com", "123", 4));
        Data.LISTA_USUARIOS.inserta(new Cliente(88888888, "Mario", "Torres", "mario@mail.com", "123", 5));
        Data.LISTA_USUARIOS.inserta(new Cliente(88888888, "Luis", "Marin", "luis@mail.com", "123", 6));
        // new Cliente(88888888, "Mario", "Torres", "mario@mail.com", "123", 5)
        Data.TICKETES.encola(new Ticket(0, (Cliente) Data.LISTA_USUARIOS.extrae(5), null, null, (Administrador) Data.LISTA_USUARIOS.extrae(1),
            "Ayuda", null, null, EstadoTickete.PENDIENTE));
        Login login = new Login();
        login.show();
    }
    
}
