package it.aulab.springprogetto.service;

import java.util.List;
import java.util.Map;

public interface CrudService<Read, Create, Update, ID> {
    
    List<Read> readAll();

    Read readOne(ID id) throws Exception;

    //Mappare tutti i parametri inseriti -> non solo select ma anche where
    List<Read> read(Map<String, String> params );

    Read create(Create createDTO);

    Read update(Long id, Update updateDTO) throws Exception;

    Read delete(ID id) throws Exception ;

}
