package org.mobydigital.marias.portafolio.models.views;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ExperienceDto {
    private String name;
    private String description;
    private Integer yearSince;
    private Integer yearUntil;
}
