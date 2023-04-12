package org.mobydigital.marias.servlet.services;

import org.mobydigital.marias.servlet.entity.Educacion;

import java.util.Arrays;
import java.util.List;

public class EducacionServiceImpl implements EducacionService{

    @Override
    public List<Educacion> listar() {
        return Arrays.asList(new Educacion(1L,"Instituo Gral. Manuel Belgrano","Bachiller en Informatica",2013,2018),
                new Educacion(2L,"Universidad Tecnologica Nacional FRVM","Ingenieria en Sistemas de información",2019,2024));
    }
}
