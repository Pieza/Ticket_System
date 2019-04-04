/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import proyectofinal.enums.EstadoTickete;
import proyectofinal.enums.NivelSoporte;
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
        
        Cliente mario = new Cliente(88888888, "Mario", "Torres", "mario@mail.com", "123", 5);
        Cliente romeo = new Cliente(88888888, "Romeo", "Santos", "santosromeo@mail.com", "123", 8);
        Cliente marta = new Cliente(88888888, "Marta", "Ureña", "marurena@mail.com", "123", 9);
        
        Data.LISTA_USUARIOS.inserta(mario);
        Data.LISTA_USUARIOS.inserta(romeo);
        Data.LISTA_USUARIOS.inserta(marta);
        
        Data.TICKETES.encola(new Ticket(mario, "Errores varios en el sistema X"));
        Data.TICKETES.encola(new Ticket(romeo, "Errores varios en el sistema Y"));
        Data.TICKETES.encola(new Ticket(marta, "Errores varios en el sistema Z"));
        
        Login login = new Login();
        login.show();
    }
    
}
