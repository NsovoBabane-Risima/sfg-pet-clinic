package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.VetService;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class VetMapService extends AbstractMapService<Vet, Long> implements VetService{
    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteAll(Map<Long, Vet> map) {
        super.deleteAll(map);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet, vet.getId());
    }

    @Override
    public Vet findByLastName(String name) {
        AtomicReference<Vet> vet = null;
        map.values().stream().forEach(x -> {
            if (x.getLastName() == name) {
                vet.set(x);
            }
        });
        return vet.get();
    }
}
