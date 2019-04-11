package proyectofinal.objetos;

/*Clase cliente hereda de la clase Usuario*/

public class Cliente extends Usuario{
    public int telefono;

    public Cliente(int telefono, String nombre, String apellidos, String correo, String password) {
        super(nombre, apellidos, correo, password);
        this.telefono = telefono;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
