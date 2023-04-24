package org.mobydigital.marias.portafolio.repositories;

import org.mobydigital.marias.portafolio.models.entities.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long> {

}
