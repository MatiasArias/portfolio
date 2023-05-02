package org.mobydigital.marias.portafolio.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "experiences")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExperience;
    private String name;
    private String description;
    private Integer yearSince;
    private Integer yearUntil;
}
