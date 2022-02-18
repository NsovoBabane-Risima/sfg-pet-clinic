package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetService;
import guru.springframework.sfgpetclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    private Map<Long, Owner> map = super.map;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

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

        if (owner.getPets() != null) {
            owner.getPets().forEach(
                    pet -> {
                        if (pet.getPetType() != null) {
                            if (pet.getPetType().getId() == null) {
                                petTypeService.save(pet.getPetType());
                            }

                        }else {
                            throw new RuntimeException("Pet Type is Required");
                        }
                        if(pet.getId() == null){
                          Pet savedPet =  petService.save(pet);
                          pet.setId(savedPet.getId());
                        }
                    }
            );

        }

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
