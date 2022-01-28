package guru.springframework.sfgpetclinic.service;

import com.sun.source.doctree.SeeTree;
import guru.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findById(Long id);
    Owner findByLastName(String name);
    Set<Owner> findAll();
    Owner save(Owner owner);
}
