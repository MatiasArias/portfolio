package org.mobydigital.marias.portafolio.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profile {
    Long idProfile;
    String name;
    Candidate candidate;

}
