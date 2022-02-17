package guru.springframework.sfgpetclinic.service.map;
import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected final Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object){

        if(object != null) {
            if(object.getId() == null){
                object.setId(getNextId());
            }

            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }

        return object;
    }

    void delete(T object) {
        if (map.containsValue(object)) {
            map.entrySet().remove(object);
        }
    }

    void deleteAll(Map<ID, T> map) {
        List<ID> list = (List<ID>) map.keySet();
        list.stream().forEach(map::remove);
    }

    void deleteById(ID id) {
        T object = map.get(id);
        map.remove(object);
    }

    private Long getNextId() {
        return Collections.max(map.keySet()) + 1;
    }
}
