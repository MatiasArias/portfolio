package org.mobydigital.marias.portafolio.models.entities;

import java.util.Objects;

public class Perfil {
    Long id;
    String nombre;
    Candidato candidato;

    public Perfil(Long id, String nombre, Candidato candidato) {
        this.id = id;
        this.nombre = nombre;
        this.candidato = candidato;
    }

    public Perfil() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    @Override
    public String toString() {
        return id +" - " + nombre + " - " + candidato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfil perfil = (Perfil) o;
        return Objects.equals(id, perfil.id) && Objects.equals(nombre, perfil.nombre) && Objects.equals(candidato, perfil.candidato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, candidato);
    }
}
