package org.mobydigital.marias.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cabeceras-request")
public class CabecerasHttpRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String metodoHttp = req.getMethod();
        String requestUri = req.getRequestURI();
        String requestUrl = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ip = req.getLocalAddr();
        String ipCliente = req.getRemoteAddr();
        String servidorName = req.getServerName();
        int port = req.getLocalPort();
        String scheme = req.getScheme();
        String host = req.getHeader("host");
        String url = scheme+"//"+host+contextPath+servletPath;
        String urlIp = scheme+"://"+ip+contextPath+servletPath;


        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Cabeceras HTTP</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Cabeceras HTTP</h1>");
        out.println("<ul>");
        out.println("<li>Metodo http: "+metodoHttp+"</li>");
        out.println("<li>Request URI: "+requestUri+"</li>");
        out.println("<li>Request URL: "+requestUrl+"</li>");
        out.println("<li>Context Path: "+contextPath+"</li>");
        out.println("<li>Servlet Path: "+servletPath+"</li>");
        out.println("<li>IP: "+ip+"</li>");
        out.println("<li>IP Cliente: "+ipCliente+"</li>");
        out.println("<li>Port: "+port+"</li>");
        out.println("<li>Scheme: "+scheme+"</li>");
        out.println("<li>Host: "+host+"</li>");
        out.println("<li>URL: "+url+"</li>");
        out.println("<li>URL: "+urlIp+"</li>");
        out.println("<li>Server: "+servidorName+"</li>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
