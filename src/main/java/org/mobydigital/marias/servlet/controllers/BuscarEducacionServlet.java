package org.mobydigital.marias.servlet.controllers;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mobydigital.marias.portafolio.models.Educacion;
import org.mobydigital.marias.servlet.services.EducacionService;
import org.mobydigital.marias.servlet.services.EducacionServiceImpl;
import org.mobydigital.marias.servlet.util.JpaUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/buscar-educacion")
public class BuscarEducacionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = JpaUtil.getEntityManagerFactory();
        EducacionService service = new EducacionServiceImpl(em);
        String nombre = req.getParameter("educacion");

        Optional<Educacion> educacionEncontrada = service.getEducaciones().stream().filter(p->{
            if (nombre.isBlank() || nombre==null){
                return false;
            }
            return p.getTitulo().contains(nombre);
        }).findFirst();
        if (educacionEncontrada.isPresent()){
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Matias Jesús Arias</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Titulo encontrado</h1>");
            out.println("<h2> Educacion encontrada: </h2>");
            out.println("<p>"+ educacionEncontrada.get() +"</p>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"No se encontró ese titulo: "+nombre);
        }
        em.close();
    }
}
