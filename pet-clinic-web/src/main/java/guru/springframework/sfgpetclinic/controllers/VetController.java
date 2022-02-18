package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.service.map.VetMapService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetMapService vetMapService;

    public VetController(VetMapService vetMapService) {
        this.vetMapService = vetMapService;
    }

    @GetMapping({"", "/indexp", "/indexp.html"})
    public String listVets(Model model) {
        model.addAttribute("vets", vetMapService.findAll());
        return "vets/indexp";
    }
}
