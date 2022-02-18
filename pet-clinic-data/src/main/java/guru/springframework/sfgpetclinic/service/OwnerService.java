package guru.springframework.sfgpetclinic.service;

import guru.springframework.sfgpetclinic.model.Owner;
public interface OwnerService extends CRUDService<Owner,Long>{
    Owner findByLastName(String name);

}
