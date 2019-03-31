package proyectofinal.objetos;

import proyectofinal.enums.NivelSoporte;


public class Administrador extends Usuario{
    private NivelSoporte nivel;

    public Administrador() {} 

    public Administrador(NivelSoporte nivel, String nombre, String apellidos, String correo, String password, int id) {
        super(nombre, apellidos, correo, password, id);
        this.nivel = nivel;
    }

    public NivelSoporte getNivel() {
        return nivel;
    }

    public void setNivel(NivelSoporte nivel) {
        this.nivel = nivel;
    }
    
    
    
    
}
