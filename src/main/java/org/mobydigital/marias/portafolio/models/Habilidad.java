package org.mobydigital.marias.portafolio.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="habilidad")
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabilidad;
    private String titulo;
    private String descripcion;

    public Habilidad(Long idHabilidad, String titulo, String descripcion) {
        this.idHabilidad = idHabilidad;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Habilidad() {
    }

    public Long getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(Long idHabilidad) {
        this.idHabilidad = idHabilidad;
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

    @Override
    public String toString() {
        return titulo +" ( " + descripcion + " )";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habilidad habilidad = (Habilidad) o;
        return Objects.equals(idHabilidad, habilidad.idHabilidad) && Objects.equals(titulo, habilidad.titulo) && Objects.equals(descripcion, habilidad.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHabilidad, titulo, descripcion);
    }
}
