package proyectofinal.objetos;

import proyectofinal.enums.NivelSoporte;


public class Administrador extends Usuario{
    private NivelSoporte nivel;

    public Administrador() {} 

    public Administrador(NivelSoporte nivel, String nombre, String apellidos, String correo, String password) {
        super(nombre, apellidos, correo, password);
        this.nivel = nivel;
    }

    public NivelSoporte getNivel() {
        return nivel;
    }

    public void setNivel(NivelSoporte nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "[" + getId() + "] " + getNombre() + " " + getApellidos() + " - " + nivel.toString();
    }
    
    
}
