package com.example.cursowebjava;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL =
            "jdbc:postgresql://ep-sparkling-boat-apsvfv4y-pooler.c-7.us-east-1.aws.neon.tech/neondb?sslmode=require";

    private static final String USER = "neondb_owner";

    private static final String PASSWORD = "npg_EUJPS7ci1Zwk";

    public static Connection conectar() {
        Connection con = null;

        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Conectado a Neon PostgreSQL");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}