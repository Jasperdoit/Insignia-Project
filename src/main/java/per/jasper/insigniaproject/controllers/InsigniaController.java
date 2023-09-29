package per.jasper.insigniaproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import per.jasper.insigniaproject.models.Insignia;
import per.jasper.insigniaproject.services.InsigniaService;

import java.util.List;

@Controller
public class InsigniaController {
    private final InsigniaService insigniaService;

    public InsigniaController(InsigniaService insigniaService) {
        this.insigniaService = insigniaService;
    }

    @GetMapping("/insignias/")
    public String getAllInsignias(Model model)
    {
        List<Insignia> insignias = insigniaService.getAllInsignias();
        model.addAttribute("insignias", insignias);
        return "Insignia/Insignias";
    }
    @GetMapping("/insignias/{id}")
    public String getInsigniaById(Model model, @PathVariable("id") long id)
    {
        Insignia insignia = insigniaService.getInsigniaById(id);
        model.addAttribute("insignia", insignia);
        return "Insignia/Insignia";
    }

    @GetMapping("/insignias/create")
    public String getInsigniaForm(Model model)
    {
        model.addAttribute("insignia", new Insignia());
        return "Insignia/Create_Insignia_Form";
    }
    @PostMapping("/insignias/")
    public String createInsignia(@ModelAttribute Insignia insignia)
    {
        Insignia returnedInsignia = insigniaService.createInsignia(insignia.getName(), insignia.getDescription(), insignia.getImageUri());
        return "redirect:/insignias/";
    }

    @GetMapping("/insignias/{id}/update")
    public String getUpdateInsigniaForm(Model model, @PathVariable("id") long id)
    {
        Insignia insignia = insigniaService.getInsigniaById(id);
        model.addAttribute("insignia", insignia);
        return "Insignia/Update_Insignia_Form";
    }
    @PostMapping("/insignias/{id}/update")
    public String updateInsignia(@PathVariable("id") long id, @ModelAttribute Insignia insignia)
    {
        Insignia returnedInsignia = insigniaService.updateInsignia(id, insignia.getName(), insignia.getDescription(), insignia.getImageUri());
        return "redirect:/insignias/" + returnedInsignia.getId();
    }

    @PostMapping("/insignias/{id}/delete")
    public String deleteInsignia(@PathVariable("id") long id)
    {
        insigniaService.deleteInsignia(id);
        return "redirect:/insignias/";
    }
}
