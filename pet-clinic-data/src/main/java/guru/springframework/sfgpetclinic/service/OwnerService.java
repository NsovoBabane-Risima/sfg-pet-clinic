package guru.springframework.sfgpetclinic.service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Person;

public interface OwnerService extends CRUDService<Owner,Long>{
    Owner findByLastName(String name);

}
