package org.mobydigital.marias.servlet.controllers;

import jakarta.servlet.ServletException;
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

@WebServlet({"/educacion.xls","/educacion"})
public class EducacionXlsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EducacionService service = new EducacionServiceImpl();
        List<Educacion> estudios = service.listar();
        String servletPath = req.getServletPath();
        boolean esXls = servletPath.endsWith(".xls");
        if(esXls){
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition","attachment;filename=educacion.xls");
        }
        resp.setContentType("text/html");
        try(PrintWriter out = resp.getWriter()){
            if(!esXls) {
                out.println("<!DOCTYPE html>");
                out.println("<html lang=\"en\">");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Estudios</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Estudios</h1>");
                out.println("<p><a href=\"" + req.getContextPath() + "/educacion.xls\">Exportar a Excel</a></p>");
            }
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Institucion</th>");
            out.println("<th>Titulo</th>");
            out.println("<th>Año inicio</th>");
            out.println("<th>Año Egreso</th>");
            out.println("</tr>");
            estudios.forEach(e->{
                out.println("<tr>");
                out.println("<td>"+e.getNombreInstitucion()+"</td>");
                out.println("<td>"+e.getNombreTitulo()+"</td>");
                out.println("<td>"+e.getAñoInicio()+"</td>");
                out.println("<td>"+e.getAñoFin()+"</td>");
                out.println("</tr>");
            });
            out.println("</table>");
            if(!esXls) {
            out.println("</body>");
            out.println("</html>");
            }
        }
    }
}
