package org.mobydigital.marias.portafolio.models.entities;

import jakarta.persistence.*;

import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "candidato")
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCandidato;
    String nombre;
    String apellido;
    String email;

    @OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Educacion> educacionList = new ArrayList<>();

    public Candidato() {
    }

    public Candidato(Long idCandidato, String nombre, String apellido, String email) {
        this.idCandidato = idCandidato;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public Long getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(Long idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Educacion> getEducacionList() {
        return educacionList;
    }

    public void setEducacionList(List<Educacion> educacionList) {
        this.educacionList = educacionList;
    }

    public void addEducacion(Educacion educacion) {
        educacionList.add(educacion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidato candidato = (Candidato) o;
        return Objects.equals(idCandidato, candidato.idCandidato) && Objects.equals(nombre, candidato.nombre) && Objects.equals(apellido, candidato.apellido) && Objects.equals(email, candidato.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCandidato, nombre, apellido, email);
    }

    @Override
    public String toString() {
        return idCandidato + " - " + nombre + ", " + apellido + " - " + email;
    }
}
