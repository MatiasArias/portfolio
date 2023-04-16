package org.mobydigital.marias.portafolio.models;

import java.util.Date;

public class Proyecto {
    private Long idProyecto;
    private String titulo;
    private String descripcion;
    private String urlImagen;
    private String urlProyecto;
    private Date fecha;
    private String active;

    public Proyecto() {
    }

    public Proyecto(Long idProyecto, String titulo, String descripcion, String urlImagen, String urlProyecto, Date fecha) {
        this.idProyecto = idProyecto;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.urlProyecto = urlProyecto;
        this.fecha = fecha;
    }

    public Proyecto(Long idProyecto, String titulo, String descripcion, String urlImagen, String urlProyecto, Date fecha, String active) {
        this.idProyecto = idProyecto;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.urlProyecto = urlProyecto;
        this.fecha = fecha;
        this.active = active;
    }

    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getUrlProyecto() {
        return urlProyecto;
    }

    public void setUrlProyecto(String urlProyecto) {
        this.urlProyecto = urlProyecto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
