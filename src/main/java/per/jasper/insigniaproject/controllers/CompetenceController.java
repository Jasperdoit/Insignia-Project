package per.jasper.insigniaproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import per.jasper.insigniaproject.models.Competence;
import per.jasper.insigniaproject.models.Insignia;
import per.jasper.insigniaproject.services.CompetenceService;
import per.jasper.insigniaproject.services.InsigniaService;

import java.util.List;

@Controller
public class CompetenceController {
    private final CompetenceService competenceService;
    private final InsigniaService insigniaService;

    public CompetenceController(CompetenceService competenceService, InsigniaService insigniaService) {
        this.competenceService = competenceService;
        this.insigniaService = insigniaService;
    }

    @GetMapping("/competences/")
    public String getAllCompetences(Model model)
    {
        List<Competence> competences = competenceService.getAllCompetences();
        model.addAttribute("competences", competences);
        return "Competences";
    }
    @GetMapping("/competences/{id}")
    public String getCompetenceById(Model model, @PathVariable("id") long id)
    {
        Competence competence = competenceService.getCompetenceById(id);
        model.addAttribute("competence", competence);
        return "Competence";
    }

    @GetMapping("/competences/create")
    public String getCompetenceForm(@RequestParam long insigniaId, Model model)
    {
        model.addAttribute("competence", new Competence());
        Insignia insignia = insigniaService.getInsigniaById(insigniaId);
        model.addAttribute("insignia", insignia);
        System.out.println(insignia.toString());
        return "Competence/Create_Competence_Form";
    }
    @PostMapping("/competences/")
    public String createCompetence(@ModelAttribute Competence competence)
    {
        System.out.println(competence.toString());
        Competence returnedCompetence = competenceService.createCompetence(competence.getName(), competence.getDescription(), competence.getInsignia().getId());
        return "redirect:/competences/";
    }

}
