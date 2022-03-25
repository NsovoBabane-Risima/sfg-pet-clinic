package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "owners")
public class Owner extends Person {
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telphone")
    private String telphone;
    @Column(name = "pets")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<Pet> pets = new HashSet<>();
    
}
