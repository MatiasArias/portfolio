package org.mobydigital.marias.portafolio.models.views;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CandidateDto {
    Long idCandidate;

    String name;

    String lastname;

    String email;
}
