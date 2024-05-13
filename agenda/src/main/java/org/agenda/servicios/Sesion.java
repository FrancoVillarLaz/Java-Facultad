package org.agenda.servicios;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import javax.swing.JOptionPane;
public class Sesion {
    private int userId;
    private String user;
    private boolean logeado;

    public Sesion(){

    }
    public boolean isValidPassword(String password) {
        // Expresión regular para verificar la contraseña
        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).{12,}$";

        // Compila la expresión regular en un patrón
        Pattern pattern = Pattern.compile(regex);

        // Crea un matcher para la contraseña dada
        Matcher matcher = pattern.matcher(password);
        // Devuelve verdadero si la contraseña cumple con la expresión regular
        return matcher.matches();
    }
    public String passwordHash(String password) {
        // Creamos una instancia de cifrado AES
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException e) {
            // Manejamos una excepción si no se encuentra el algoritmo de cifrado
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            // Manejamos una excepción si no se encuentra el padding especificado
            throw new RuntimeException(e);
        }

        // Creamos una clave secreta basada en la clave definida
        SecretKeySpec secretKey = new SecretKeySpec(password.getBytes(), "AES");

        // Ciframos el texto original
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        } catch (InvalidKeyException e) {
            // Manejamos una excepción si la clave es inválida para la operación de cifrado
            throw new RuntimeException(e);
        }
        byte[] textoCifrado = new byte[0];
        try {
            textoCifrado = cipher.doFinal(password.getBytes());
        } catch (IllegalBlockSizeException e) {
            // Manejamos una excepción si el tamaño del bloque de datos es incorrecto
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            // Manejamos una excepción si el relleno es incorrecto
            throw new RuntimeException(e);
        }

        // Convertimos los resultados a una representación legible
        String paswordHashed = Base64.getEncoder().encodeToString(textoCifrado);

        // Mostramos el resultado cifrado
        JOptionPane.showMessageDialog(null, "Texto original: " + password);
        JOptionPane.showMessageDialog(null, "Texto cifrado: " + paswordHashed);
        return paswordHashed;
    }

    public String passwordDecrypt(String passwordHashed) {
        // Creamos una instancia de cifrado AES
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException e) {
            // Manejamos una excepción si no se encuentra el algoritmo de cifrado
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            // Manejamos una excepción si no se encuentra el padding especificado
            throw new RuntimeException(e);
        }

        // Creamos una clave secreta basada en el hash de la contraseña cifrada
        SecretKeySpec secretKey = new SecretKeySpec(passwordHashed.getBytes(), "AES");

        // Desciframos el texto cifrado
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
        } catch (InvalidKeyException e) {
            // Manejamos una excepción si la clave es inválida para la operación de descifrado
            throw new RuntimeException(e);
        }
        byte[] passwordUnHash = new byte[0];
        try {
            passwordUnHash = cipher.doFinal(Base64.getDecoder().decode(passwordHashed));
        } catch (IllegalBlockSizeException e) {
            // Manejamos una excepción si el tamaño del bloque de datos es incorrecto
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            // Manejamos una excepción si el relleno es incorrecto
            throw new RuntimeException(e);
        }

        // Convertimos el resultado descifrado a una representación legible
        String passwordUnHashStr = new String(passwordUnHash);

        // Mostramos el resultado descifrado
        JOptionPane.showMessageDialog(null, "Texto descifrado: " + passwordUnHashStr);
        return passwordUnHashStr;
    }


}

