package org.mobydigital.marias.portafolio.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Project {
    private Long idProject;
    private String name;
    private String description;
    private String urlImage;
    private String urlProject;
    private Date date;
    public String active;

}
