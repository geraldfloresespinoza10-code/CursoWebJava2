package com.example.cursowebjava;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "guardar", value = "/guardar")
public class GuardarUsuarioServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");


        try {

                Connection conexion = ConexionBD.conectar();

            String sql = "INSERT INTO usuarios(nombre, correo) VALUES (?, ?)";

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, correo);

            ps.executeUpdate();

            conexion.close();

            response.setContentType("text/html");

            response.getWriter().println("" +
                    "<html>" +
                    "<head>" +
                    "<title>Registro completado</title>" +

                    "<style>" +

                    "body{" +
                    "background:#0f172a;" +
                    "font-family:Arial;" +
                    "display:flex;" +
                    "justify-content:center;" +
                    "align-items:center;" +
                    "height:100vh;" +
                    "}" +

                    ".caja{" +
                    "background:white;" +
                    "padding:40px;" +
                    "border-radius:15px;" +
                    "text-align:center;" +
                    "width:400px;" +
                    "}" +

                    "h1{" +
                    "color:green;" +
                    "}" +

                    "a{" +
                    "text-decoration:none;" +
                    "padding:12px 20px;" +
                    "margin:10px;" +
                    "display:inline-block;" +
                    "border-radius:10px;" +
                    "font-weight:bold;" +
                    "}" +

                    ".si{" +
                    "background:#4f46e5;" +
                    "color:white;" +
                    "}" +

                    ".no{" +
                    "background:#111827;" +
                    "color:white;" +
                    "}" +

                    "</style>" +

                    "</head>" +

                    "<body>" +

                    "<div class='caja'>" +

                    "<h1>Usuario registrado 😎</h1>" +

                    "<p>¿Deseas registrar otro usuario?</p>" +

                    "<a class='si' href='index.html'>Sí</a>" +

                    "<a class='no' href='gracias.html'>No</a>" +

                    "</div>" +

                    "</body>" +
                    "</html>");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}