package org.agenda.servicios;

import org.agenda.consultas.Usuario;

public class Login {
    private String user;
    private String pass;
    private String correo;

    // Constructor para traer la contraseña de forma segura
    public Login(String user, char[] pass, String correo) {

        this.user = user;
        this.pass = new String(pass);
        this.correo = correo;
    }
    public Login(String user, String pass, String correo) {
        this.user = user;
        this.pass = pass;
        this.correo = correo;
    }

    public boolean logear(){
        Login usuario = new Login(user,pass,correo);
        Usuario consulta = new Usuario();
        Sesion sesion = new Sesion();
        boolean logeado=consulta.selectLogin(usuario);
        if (logeado== true){
            return logeado;
        }else {
            return logeado;
        }
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
