package org.mobydigital.marias.portafolio.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "educations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEducation;
    private String institution;
    private String degree;
    private Integer yearEntry;
    private Integer graduation;

    @ManyToOne()
    @JoinColumn(name = "idCandidate")
    private Candidate candidate;


}
