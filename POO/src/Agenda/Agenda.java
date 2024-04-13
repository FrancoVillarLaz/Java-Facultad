package Agenda;
import java.util.ArrayList;

public class Agenda {
    private static ArrayList<Contactos> agenda = new ArrayList();

    public void agregarContacto(String nombre,int telefono){

        agenda.add(new Contactos(nombre,telefono));
    }

    public Contactos buscarContacto(String nombre){
        for (Contactos contacto : agenda) {
            if (nombre.equalsIgnoreCase(contacto.getNombre())){
                Contactos contactoBuscado = new Contactos(contacto.getNombre(),contacto.getTelefono());
                return contactoBuscado;
            }else {
            }
        }

        return null;
    }
    public boolean borrarContacto(String nombre){
        boolean borrado = false;
        for (Contactos contacto : agenda) {
            if (nombre.equalsIgnoreCase(contacto.getNombre())){
                int id=contacto.getId();
                agenda.remove(id-1);
                borrado = true;
                return borrado;
            }else {

            }
        }
        return borrado;
    }

    public static void main(String[] args) {
        Agenda agendaContactos=new Agenda();
        agendaContactos.agregarContacto("Nico",1234);
        agendaContactos.agregarContacto("Franco",2341);
        agendaContactos.agregarContacto("Mati",4321);

        agendaContactos.buscarContacto("nico");
        for (Contactos contacto : agenda) {
            System.out.println("La cantidad de contactos:"+contacto.getId() + ": "+ contacto.getNombre() + ": " + contacto.getTelefono());
            System.out.println(agenda.indexOf(contacto));
        }
    }
}
