package Agenda;
import javax.swing.*;
import java.util.ArrayList;

public class Agenda {
    private static ArrayList<Contactos> agenda = new ArrayList();


    public void agregarContacto(String nombre,int telefono){

        agenda.add(new Contactos(nombre,telefono));
    }

    public String buscarContacto(String nombre){
        StringBuilder contactoBuscado = new StringBuilder();

        for (Contactos contacto : agenda) {
            if (nombre.equalsIgnoreCase(contacto.getNombre())){
                int id = contacto.getId();
                String buscado = contacto.getNombre();
                int telefono = contacto.getTelefono();
                System.out.println(contacto.getCantidad());
                contactoBuscado.append("id: ").append(id).append(" Nombre: ").append(buscado).append(" Telefono: ").append(telefono).append("\n");
                String contactoBuscadoStr = contactoBuscado.toString();

                return contactoBuscadoStr;
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
            }
        }
        return borrado;
    }
    public String cantidadContactos(){
        Contactos contacto = new Contactos();
        int cantidad = contacto.getCantidad();
        String cantidadStr= Integer.toString(cantidad);
        return cantidadStr;
    }
    public String listaCompleta(){
        StringBuilder lista = new StringBuilder();
        for (Contactos contacto : agenda) {
            int id = contacto.getId();
            String nombre = contacto.getNombre();
            int telefono = contacto.getTelefono();
            
            lista.append("id: ").append(id).append(" Nombre: ").append(nombre).append(" Telefono: ").append(telefono).append("\n");
        }
        String listaCompleta = lista.toString();
        return listaCompleta;
    }

//    public static void main(String[] args) {
//        Agenda agendaContactos=new Agenda();
//        agendaContactos.agregarContacto("Nico",1234);
//        agendaContactos.agregarContacto("Franco",2341);
//        agendaContactos.agregarContacto("Mati",4321);
//
//        agendaContactos.buscarContacto("nico");
//        for (Contactos contacto : agenda) {
//            System.out.println("La cantidad de contactos:"+contacto.getId() + ": "+ contacto.getNombre() + ": " + contacto.getTelefono());
//            System.out.println(agenda.indexOf(contacto));
//        }
//    }
}
