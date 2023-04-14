package org.mobydigital.marias.portafolio.services;

import java.util.List;

public interface EntityService<T> {
    void init();
    List<T> getListEntidades(String startWith);
    T porId(Long id);
    T guardar(T t);
    void eliminar(Long id);

}
