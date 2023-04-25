package org.mobydigital.marias.portafolio.repositories;

import java.util.List;

public interface CrudRepository<T> {
    List<T> listar();
    T porId(Long id);
    T guardar(T t);
    void eliminar(Long id);


}
