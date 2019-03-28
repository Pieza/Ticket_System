package proyectofinal.Objetos;

import proyectofinal.Enums.EstadoTickete;

public class Ticket {
    private int id;
    private Usuario creadoPor;
    private Administrador asignadolvl1, asignadolvl2, asignadolvl3;
    private String descripcion, historial, nuevaActualizacion;
    private EstadoTickete estado;

    public Ticket(){}
    
    public Ticket(int id, Usuario creadoPor, Administrador asignadolvl1, Administrador asignadolvl2, Administrador asignadolvl3, String descripcion, String historial, String nuevaActualizacion, EstadoTickete estado) {
        this.id = id;
        this.creadoPor = creadoPor;
        this.asignadolvl1 = asignadolvl1;
        this.asignadolvl2 = asignadolvl2;
        this.asignadolvl3 = asignadolvl3;
        this.descripcion = descripcion;
        this.historial = historial;
        this.nuevaActualizacion = nuevaActualizacion;
        this.estado = estado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Usuario creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Administrador getAsignadolvl1() {
        return asignadolvl1;
    }

    public void setAsignadolvl1(Administrador asignadolvl1) {
        this.asignadolvl1 = asignadolvl1;
    }

    public Administrador getAsignadolvl2() {
        return asignadolvl2;
    }

    public void setAsignadolvl2(Administrador asignadolvl2) {
        this.asignadolvl2 = asignadolvl2;
    }

    public Administrador getAsignadolvl3() {
        return asignadolvl3;
    }

    public void setAsignadolvl3(Administrador asignadolvl3) {
        this.asignadolvl3 = asignadolvl3;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }

    public String getNuevaActualizacion() {
        return nuevaActualizacion;
    }

    public void setNuevaActualizacion(String nuevaActualizacion) {
        this.nuevaActualizacion = nuevaActualizacion;
    }

    public EstadoTickete getEstado() {
        return estado;
    }

    public void setEstado(EstadoTickete estado) {
        this.estado = estado;
    }
    
    
}
