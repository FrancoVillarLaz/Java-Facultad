import java.time.LocalDate;

public class Empleado {
    private String dni,nombre,apellido,domicilio,fechaNac;
    private double sueldoBruto;

    public Empleado(String dni, String nombre, String apellido, String domicilio, String fechaNac, double sueldoBruto) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.fechaNac = fechaNac;
        this.sueldoBruto = sueldoBruto;
    }
//    public static int calcular_edad(String fechaNac){
//        LocalDate fechaNacimiento =LocalDate.parse(fechaNac);
//
//        LocalDate fechaAct = LocalDate.now();
//        return fechaAct.minusYears(LocalDate fechaNac, LocalDate fechaAct);
//
//
//    }
//    public void mostrar_datos(){
//        System.out.println("Los datos del empleado son /n" +
//                "dni: "+this.dni+"/n" +
//                "nombre: "+this.nombre +"/n" +
//                "apellido: "+this.apellido +"/n" +
//                "domicilio: "+this.domicilio +"/n"+
//                "fehca de nacimiento: "+this.fechaNac +"/n"+
//                "edad: "+"progmara xd"+"/n" +
//                "Sueldo bruto: "+this.sueldoBruto +"/n");
//    }

}
