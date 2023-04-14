package org.mobydigital.marias.portafolio.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="experiencia")
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExperiencia;
    private String titulo;
    private String descripcion;
    private Integer añoDesde;
    private Integer añoHasta;

    public Experiencia(Long idExperiencia, String titulo, String descripcion, Integer añoDesde, Integer añoHasta) {
        this.idExperiencia = idExperiencia;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.añoDesde = añoDesde;
        this.añoHasta = añoHasta;
    }

    public Experiencia() {
    }

    public Long getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(Long idExperiencia) {
        this.idExperiencia = idExperiencia;
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

    public Integer getAñoDesde() {
        return añoDesde;
    }

    public void setAñoDesde(Integer añoDesde) {
        this.añoDesde = añoDesde;
    }

    public Integer getAñoHasta() {
        return añoHasta;
    }

    public void setAñoHasta(Integer añoHasta) {
        this.añoHasta = añoHasta;
    }

    @Override
    public String toString() {
        return  idExperiencia +" - " + titulo  +
                "\n" + añoDesde +
                "-" + añoHasta +
                "\n\t" + descripcion + '\'' ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experiencia that = (Experiencia) o;
        return Objects.equals(idExperiencia, that.idExperiencia) && Objects.equals(titulo, that.titulo) && Objects.equals(descripcion, that.descripcion) && Objects.equals(añoDesde, that.añoDesde) && Objects.equals(añoHasta, that.añoHasta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idExperiencia, titulo, descripcion, añoDesde, añoHasta);
    }
}
