package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.OwnerService;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
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
        return super.save(owner, owner.getId());
    }

    @Override
    public void deleteAll(Map<Long, Owner> map) {
        super.deleteAll(map);
    }

    @Override
    public Owner findByLastName(String name) {
        AtomicReference<Owner> owner = null;
        map.values().stream().forEach(x -> {
            if (x.getLastName() == name) {
                owner.set(x);
            }
        });
        return owner.get();
    }

}
