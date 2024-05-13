package org.agenda.servicios;

import org.agenda.consultas.Usuario;

public class Register {
        private String user;
        private String pass;
        private String correo;

    public Register(String user, String pass, String correo) {
        this.user = user;
        this.pass = pass;
        this.correo = correo;
    }

    public boolean registrarUsuario(){
        Register usuario = new Register(user,pass,correo);
        Usuario consulta = new Usuario();
        Sesion sesion = new Sesion();

    if (sesion.isValidPassword(usuario.getPass())){

        boolean registrado=consulta.insert(usuario);
        if (registrado== true){
            System.out.println("registrado papá");
        }else {
            System.out.println("no se registro");
        }

    }
    boolean registrado = false;
        return registrado;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getCorreo() {
        return correo;
    }


}

