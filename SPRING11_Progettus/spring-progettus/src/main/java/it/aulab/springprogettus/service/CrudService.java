package it.aulab.springprogettus.service;

import java.util.List;
import java.util.Map;

public interface CrudService<Read, Create, Update, ID> {
    
    List<Read> readAll();

    List<Read> readOne(ID id);

    //Mappare tutti i parametri inseriti -> non solo select ma anche where
    List<Read> read(Map<String, String> params );

    Read create(Create createDTO);

    Read update(Update updateDTO);

    Read delete(ID id);

}
