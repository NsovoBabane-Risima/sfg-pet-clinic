package guru.springframework.sfgpetclinic.service.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.service.OwnerService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @Mock
    PetRepository petRepository;
    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;
    Owner retunOwner;
    @BeforeEach
    void setUp() {

         Owner.builder().id(7L).lastName(LAST_NAME);
        retunOwner = new Owner();
        retunOwner.setId(7L);
        retunOwner.setLastName(LAST_NAME);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void save() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void findByLastName() {


        Mockito.when(ownerRepository.findByLastName(any())).thenReturn(retunOwner);
        Owner smith = ownerSDJpaService.findByLastName(LAST_NAME);
        assertEquals(retunOwner.getLastName(),smith.getLastName());

    }
}