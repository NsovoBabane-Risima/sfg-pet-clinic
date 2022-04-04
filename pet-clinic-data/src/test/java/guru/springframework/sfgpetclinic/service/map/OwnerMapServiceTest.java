package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.*;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {
private OwnerMapService ownerMapService;
private Long ownerId = 7L;

    @BeforeEach
    void setUp() {

        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        Owner owner = new Owner();
        owner.setId(ownerId);
        ownerMapService.save(owner);
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());

    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void save() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void findByLastName() {
    }
}