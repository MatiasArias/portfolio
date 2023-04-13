package org.mobydigital.marias.portafolio.models;

import jakarta.persistence.*;

@Entity
@Table(name="educacion")
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEducacion;
    private String institucion;
    private String titulo;
    private Integer añoIngreso;
    private Integer añoEgreso;

    public Educacion(Long id, String nombreInstitucion, String nombreTitulo, Integer añoInicio, Integer añoFin) {
        this.idEducacion = id;
        this.institucion = nombreInstitucion;
        this.titulo = nombreTitulo;
        this.añoIngreso = añoInicio;
        this.añoEgreso = añoFin;
    }

    public Educacion() {
    }

    public Long getIdEducacion() {
        return idEducacion;
    }

    public void setIdEducacion(Long idEducacion) {
        this.idEducacion = idEducacion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAñoIngreso() {
        return añoIngreso;
    }

    public void setAñoIngreso(Integer añoIngreso) {
        this.añoIngreso = añoIngreso;
    }

    public Integer getAñoEgreso() {
        return añoEgreso;
    }

    public void setAñoEgreso(Integer añoEgreso) {
        this.añoEgreso = añoEgreso;
    }

    @Override
    public String toString() {
        return  idEducacion +" - " + institucion +
                " - " + titulo  +
                " (" + añoIngreso +
                "-" + añoEgreso +
                ')';
    }
}
