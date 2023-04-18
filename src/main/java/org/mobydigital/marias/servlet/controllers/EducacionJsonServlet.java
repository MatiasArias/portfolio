package org.mobydigital.marias.servlet.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mobydigital.marias.portafolio.models.entities.Educacion;
import org.mobydigital.marias.servlet.services.EducacionService;
import org.mobydigital.marias.servlet.services.EducacionServiceImpl;
import org.mobydigital.marias.servlet.util.JpaUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/educacion.json")
public class EducacionJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        EntityManager em = JpaUtil.getEntityManagerFactory();
        EducacionService service = new EducacionServiceImpl(em);
        List<Educacion> estudios = service.getEducaciones();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(estudios);
        resp.getWriter().write(json);
        em.close();
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
        out.println("<li>Institucion: "+educacion.getInstitucion()+"</li>");
        out.println("<li>Titulo: "+educacion.getTitulo()+"</li>");
        out.println("<li>Año Inicio: "+educacion.getAñoIngreso()+"</li>");
        out.println("<li>Año Egreso: "+educacion.getAñoEgreso()+"</li>");
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
        }
    }
}
