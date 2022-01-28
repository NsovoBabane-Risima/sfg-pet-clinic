package guru.springframework.sfgpetclinic.service;

import com.sun.source.doctree.SeeTree;
import guru.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CRUDService<Owner,Long>{
    Owner findByLastName(String name);

}
