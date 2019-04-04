package proyectofinal.objetos;

import proyectofinal.enums.EstadoTickete;

public class Ticket {
    private int id;
    private Cliente creadoPor;
    private Administrador asignadolvl1, asignadolvl2, asignadolvl3;
    private String descripcion, historial, nuevaActualizacion;
    private EstadoTickete estado;

    @Override
    public String toString() {
        return id + "," + descripcion + "," + estado + "," + creadoPor.getNombre() + " " + creadoPor.getApellidos();
    }

    public Ticket(){}
    
    public Ticket(Cliente creadoPor, String descripcion) {
        this.id = id;
        this.creadoPor = creadoPor;
        this.asignadolvl1 = null;
        this.asignadolvl2 = null;
        this.asignadolvl3 = null;
        this.descripcion = descripcion;
        this.historial = "";
        this.nuevaActualizacion = "";
        this.estado = EstadoTickete.SIN_ASIGNAR; // por defecto
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Cliente creadoPor) {
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
