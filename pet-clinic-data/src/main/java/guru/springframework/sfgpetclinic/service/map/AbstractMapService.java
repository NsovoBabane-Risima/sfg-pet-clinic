package guru.springframework.sfgpetclinic.service.map;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.*;

public abstract class AbstractMapService<T,ID> {

    protected Map<ID,T> map = new HashMap<>();
    Set<T> findAll(){
        return new HashSet(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object,ID id){
        map.put(id,object);
        return object;
    }

    void delete(T object){
        if (map.containsValue(object)){
            map.entrySet().remove(object);
        }
    }
    void deleteAll(Map<T,ID> map){
        List<ID> list = (List<ID>) map.keySet();
        list.stream().forEach(x ->map.remove(x) );
    }
    void deleteById(ID id){
        T object = map.get(id);
        map.remove(object);
    }
}
