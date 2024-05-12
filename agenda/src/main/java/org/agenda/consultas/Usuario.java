package org.agenda.consultas;

import org.agenda.servicios.Login;
import org.agenda.servicios.Register;
import org.agenda.servicios.RegistrosBd;

import java.sql.Connection;

//Usuarios
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Usuario {
    Boolean logeado = null;
    Connection conexion = null;
    PreparedStatement instruccion = null;
    ResultSet resultado = null;
    public boolean insert(Register user) {
        try {
            //conexion a base de datos
            conexion = BD.getConnection();
            //defino la consulta
            String consulta ="INSERT INTO user (username, correo, password) VALUES (?, ?, ?)";
            //preaparo la instruccion con su consulta y le paso los parametros
            instruccion=conexion.prepareStatement(consulta);
            instruccion.setString(1, user.getUser());
            instruccion.setString(2, user.getCorreo());
            instruccion.setString(3, user.getPass());
            //ejecuto la instruccion
            instruccion.executeUpdate();
            //devuelvo si se completo correctamente o si fallo la instruccion
            Boolean registrado=true;
            return registrado;
        } catch (SQLException e) {
            e.printStackTrace();
            Boolean registrado=false;
            return registrado;
        }finally {
            // Cerrar los recursos
            try {
                if (instruccion != null) instruccion.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean selectLogin(Login user) {
        try {
            conexion = BD.getConnection();
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            instruccion = conexion.prepareStatement(query);
            instruccion.setString(1, user.getUser());
            instruccion.setString(2, user.getPass());
            //guardamos el resultado de la busqueda
            resultado = instruccion.executeQuery();
            if (resultado.next()) {
                System.out.println("Se inicio sesion correctamente paaa");
                this.logeado = true;
                return logeado;
            }else {
                System.out.println("Contraseña o correo incorrectos");
                this.logeado = false;
                return logeado;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerramos los recursos
            try {
                if (resultado != null) resultado.close();
                if (instruccion != null) instruccion.close();
                if (conexion != null) conexion.close();

                return logeado;
            } catch (SQLException e) {
                e.printStackTrace();

                return logeado;
            }
        }
    }
    public List<RegistrosBd> select(String campo, String valor){

        return null;
    }
    public List<RegistrosBd> select(String campo, int valor){
        return null;
    }
    public List<RegistrosBd> select(String campo, boolean valor){
        return null;
    }
}