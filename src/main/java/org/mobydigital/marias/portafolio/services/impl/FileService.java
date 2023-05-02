package org.mobydigital.marias.portafolio.services.impl;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    public List<String> readFile(String ruta){
        List<String> fileRead = new ArrayList<>();
        File file = new File(ruta);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String linea;
            while((linea = reader.readLine())!=null){
                fileRead.add(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileRead;
    }
}
