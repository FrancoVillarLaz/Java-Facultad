package Agenda;

public class Contactos {
    private String nombre;
    private int telefono,id;
    private static int cantidad = 0;

    public Contactos() {
    }
    public Contactos(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        cantidad++;
        this.id=cantidad;
        System.out.println(getId());
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public int getTelefono() {
        return telefono;
    }

    public static int getCantidad() { return cantidad;
    }
}
