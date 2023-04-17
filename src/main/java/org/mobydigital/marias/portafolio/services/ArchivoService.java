package org.mobydigital.marias.portafolio.services;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArchivoService {
    public List<String> leerArchivo(String ruta){
        List<String> lecturaArchivo = new ArrayList<>();
        File archivo = new File(ruta);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea;
            while((linea = reader.readLine())!=null){
                lecturaArchivo.add(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lecturaArchivo;
    }
}
