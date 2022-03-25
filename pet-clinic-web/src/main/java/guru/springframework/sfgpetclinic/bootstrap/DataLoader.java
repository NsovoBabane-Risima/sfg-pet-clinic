package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);


        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Bloubosrand");
        owner1.setCity("Randburg");
        owner1.setTelphone("0824289228");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Bloubosrand");
        owner2.setCity("Randburg");
        owner2.setTelphone("0824289228");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionasCat);
        ownerService.save(owner2);
        System.out.println("Loaded Owners...");

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setPet(fionasCat);
        catVisit.setDescription("Fiona's Cat is sick");
        petService.save(fionasCat);
        visitService.save(catVisit);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);
        System.out.println("Loaded Vets...");
        System.out.println("Vet Specialities : " + vet1.getSpecialities().stream().toList().get(0).getDescription() + ", " + vet2.getSpecialities().stream().toList().get(0).getDescription());
        System.out.println(vetService.findAll().stream().count() + " Number of Vets");
        System.out.println(petTypeService.findAll().stream().count() + " Number of Pet Types");
        System.out.println(" Fiona's Cat Visit : "+ catVisit.getDescription());
        ownerService.findAll().stream().forEach(x ->
                System.out.println("number of pets " + x.getFirstName() + " has : " + x.getPets().stream().count()));

    }
}
