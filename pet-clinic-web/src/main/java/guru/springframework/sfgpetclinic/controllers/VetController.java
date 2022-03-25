package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.service.VetService;
import guru.springframework.sfgpetclinic.service.map.VetMapService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"", "/vets", "/vets.html"})
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/vets";
    }
}
