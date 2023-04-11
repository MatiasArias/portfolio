package org.mobydigital.marias.servlet.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mobydigital.marias.servlet.models.Educacion;
import org.mobydigital.marias.servlet.services.EducacionService;
import org.mobydigital.marias.servlet.services.EducacionServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/educacion.json")
public class EducacionJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        EducacionService service = new EducacionServiceImpl();
        List<Educacion> estudios = service.listar();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(estudios);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream jsonStream = req.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Educacion educacion = mapper.readValue(jsonStream,Educacion.class);
        resp.setContentType("text/html");
        try(PrintWriter out = resp.getWriter()){
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Detalle JSON</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Detalle de educacion desde JSON</h1>");
        out.println("<ul>");
        out.println("<li>Institucion: "+educacion.getNombreInstitucion()+"</li>");
        out.println("<li>Titulo: "+educacion.getNombreTitulo()+"</li>");
        out.println("<li>Año Inicio: "+educacion.getAñoInicio()+"</li>");
        out.println("<li>Año Egreso: "+educacion.getAñoFin()+"</li>");
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
        }
    }
}
