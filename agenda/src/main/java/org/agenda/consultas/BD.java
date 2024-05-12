package org.agenda.consultas;

import java.sql.Connection;
import java.sql.DriverManager;

public class BD {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                String url = "jdbc:mysql://localhost:3306/agenda";
                String username = "root";
                String password = "";
                connection = DriverManager.getConnection(url, username, password);
                return connection;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
