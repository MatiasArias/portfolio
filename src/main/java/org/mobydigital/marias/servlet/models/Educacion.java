package org.mobydigital.marias.servlet.models;

public class Educacion {
    private Long id;
    private String nombreInstitucion;
    private String nombreTitulo;
    private Integer añoInicio;
    private Integer añoFin;

    public Educacion(Long id, String nombreInstitucion, String nombreTitulo, Integer añoInicio, Integer añoFin) {
        this.id = id;
        this.nombreInstitucion = nombreInstitucion;
        this.nombreTitulo = nombreTitulo;
        this.añoInicio = añoInicio;
        this.añoFin = añoFin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getNombreTitulo() {
        return nombreTitulo;
    }

    public void setNombreTitulo(String nombreTitulo) {
        this.nombreTitulo = nombreTitulo;
    }

    public Integer getAñoInicio() {
        return añoInicio;
    }

    public void setAñoInicio(Integer añoInicio) {
        this.añoInicio = añoInicio;
    }

    public Integer getAñoFin() {
        return añoFin;
    }

    public void setAñoFin(Integer añoFin) {
        this.añoFin = añoFin;
    }
}
