package org.mobydigital.marias.portafolio.models.entities;

import jakarta.persistence.*;
import org.mobydigital.marias.portafolio.exceptions.FechaInvalidaException;

import java.util.Objects;

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

    @ManyToOne()
    @JoinColumn(name = "idCandidato")
    private Candidato candidato;


    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Educacion(Long idEducacion, String institucion, String titulo, Integer añoIngreso, Integer añoEgreso, Candidato candidato) {
        this.idEducacion = idEducacion;
        this.institucion = institucion;
        this.titulo = titulo;
        if(comprobarFecha(añoIngreso,añoEgreso)){
        this.añoIngreso = añoIngreso;
        this.añoEgreso = añoEgreso;

        }
        this.candidato = candidato;
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

    public boolean comprobarFecha(int añoIngreso,int añoEgreso){
        if(añoIngreso>añoEgreso){
            throw new FechaInvalidaException("El año de ingreso no puede ser mayor que el año de egreso");
        }
        return añoIngreso<añoEgreso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Educacion educacion = (Educacion) o;
        return Objects.equals(idEducacion, educacion.idEducacion) && Objects.equals(institucion, educacion.institucion) && Objects.equals(titulo, educacion.titulo) && Objects.equals(añoIngreso, educacion.añoIngreso) && Objects.equals(añoEgreso, educacion.añoEgreso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEducacion, institucion, titulo, añoIngreso, añoEgreso);
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
