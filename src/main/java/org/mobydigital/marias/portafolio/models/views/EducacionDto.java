package org.mobydigital.marias.portafolio.models.views;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EducacionDto {
    private String institucion;
    private String titulo;
    private Integer añoIngreso;
    private Integer añoEgreso;
}
