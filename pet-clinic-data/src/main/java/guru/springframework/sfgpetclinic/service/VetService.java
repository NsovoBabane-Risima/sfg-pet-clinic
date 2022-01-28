package guru.springframework.sfgpetclinic.service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet findByLastName(String name);
    Set<Vet> findAll();
    Vet save(Vet vet);
}
