package org.mobydigital.marias.portafolio.services.impl;

import org.mobydigital.marias.portafolio.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ProjectServiceImpl {
    @Autowired
    private FileService fileService;

    public List<Project> findAll() {
        List<Project> projects = new ArrayList<>();
        List<String> projectFile = fileService.readFile("src\\main\\java\\org\\mobydigital\\marias\\portafolio\\files\\Proyectos.csv");
        for(String project : projectFile){
            System.out.println(project);
            projects.add(new Project(Long.parseLong(project.split(";")[0]),project.split(";")[1],project.split(";")[2],project.split(";")[3],project.split(";")[4],new Date(),project.split(";")[6]));
        }
        return projects;
    }

    public Project getProjectById(Long id) {
        return findAll().stream().filter(p->p.getIdProject().equals(id)).findAny()
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Project not found"));
    }
}
