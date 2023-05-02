package org.mobydigital.marias.portafolio.models.views;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EducationDto {
    private String institution;
    private String degree;
    private Integer yearSince;
    private Integer graduation;
}
