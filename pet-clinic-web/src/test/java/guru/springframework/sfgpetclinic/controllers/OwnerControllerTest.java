package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.OwnerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class OwnerControllerTest {
    @Mock
    OwnerService ownerService;
    @Mock
    Model model;
    @InjectMocks
    OwnerController controller;

    MockMvc mockMvc;
    Set<Owner> owners;

    @BeforeEach
    void setUp() {
        Owner owner1 = new Owner();
        owner1.setId(2L);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owners = new HashSet<>();
        owners.add(owner1);
        owners.add(owner2);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test
    void listOwners() throws Exception {

        Mockito.when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.view().name("owners/indexp"))
                .andExpect(MockMvcResultMatchers.model().attribute("owners", Matchers.hasSize(2)));

    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/find"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("notimplemented"));
        Mockito.verifyNoInteractions(ownerService);
    }
}