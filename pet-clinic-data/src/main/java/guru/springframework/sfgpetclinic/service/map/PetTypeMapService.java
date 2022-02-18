package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public PetType findById(Long id) {
        return null;
    }

    @Override
    public Set<PetType> findAll() {
        return null;
    }

    @Override
    public void deleteAll(Map<Long, PetType> map) {

    }

    @Override
    public void delete(PetType t) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public PetType save(PetType t) {
        return null;
    }
}
