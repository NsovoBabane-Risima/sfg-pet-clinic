package guru.springframework.sfgpetclinic.service;
import guru.springframework.sfgpetclinic.model.Vet;

public interface VetService extends CRUDService<Vet, Long> {
    Vet findByLastName(String name);
}
