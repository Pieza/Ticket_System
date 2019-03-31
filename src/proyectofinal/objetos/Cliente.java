package proyectofinal.objetos;


public class Cliente extends Usuario{
    public int telefono;

    public Cliente(int telefono, String nombre, String apellidos, String correo, String password, int id) {
        super(nombre, apellidos, correo, password, id);
        this.telefono = telefono;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
