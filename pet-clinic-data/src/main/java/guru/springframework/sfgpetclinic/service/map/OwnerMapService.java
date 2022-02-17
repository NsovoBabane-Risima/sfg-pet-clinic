package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService  {
    private Map<Long, Owner> map = super.map;

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner);
    }

    @Override
    public void deleteAll(Map<Long, Owner> map) {
        super.deleteAll(map);
    }

    @Override
    public Owner findByLastName(String name) {
        Optional<AtomicReference<Owner>> owner = Optional.empty();
        map.values().stream().forEach(x -> {
            if (x.getLastName().equals(name)) {
                owner.get().set(x);
            }
        });
        return owner.get().get();
    }

}
