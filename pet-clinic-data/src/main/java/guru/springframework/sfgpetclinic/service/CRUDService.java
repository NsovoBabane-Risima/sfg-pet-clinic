package guru.springframework.sfgpetclinic.service;

import java.util.Set;

public interface CRUDService <T, ID>{
    T findById(ID id);
    Set<T> findAll();
    T save(T t);
    void deleteById(ID id);
    void delete(T t);
    void deleteAll();

}
