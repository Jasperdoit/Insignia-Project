package per.jasper.insigniaproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.jasper.insigniaproject.models.Competence;
import per.jasper.insigniaproject.models.Insignia;
import per.jasper.insigniaproject.repositories.CompetenceRepository;
import per.jasper.insigniaproject.repositories.InsigniaRepository;

import java.util.List;

@Service
public class CompetenceService
{
    private final CompetenceRepository competenceRepository;
    private final InsigniaRepository insigniaRepository;

    public CompetenceService(CompetenceRepository competenceRepository, InsigniaRepository insigniaRepository) {
        this.competenceRepository = competenceRepository;
        this.insigniaRepository = insigniaRepository;
    }

    public List<Competence> getAllCompetencesByInsigniaId(long id)
    {
        return competenceRepository.findByInsigniaId(id);
    }
    public List<Competence> getAllCompetences()
    {
        return competenceRepository.findAll();
    }
    public Competence getCompetenceById(long id)
    {
        return competenceRepository.findById(id).orElse(null);
    }

    public Competence createCompetence(String name, String description, long insigniaId)
    {
        Insignia insignia = insigniaRepository.findById(insigniaId).orElseThrow(
                () -> new RuntimeException("Insignia not found with id: " + insigniaId)
        );
        Competence competence = new Competence();
        competence.setName(name);
        competence.setDescription(description);
        competence.setInsignia(insignia);
        return competenceRepository.save(competence);
    }

    public Competence updateCompetence(long id, String name, String description)
    {
        Competence competence = competenceRepository.findById(id).orElse(null);
        if(competence == null)
        {
            return null;
        }
        competence.setName(name);
        competence.setDescription(description);
        return competence;
    }

    public void deleteCompetence(long id)
    {
        competenceRepository.deleteById(id);
    }
    public void deleteCompetencesByInsigniaId(long insigniaId)
    {
        List<Competence> competences = competenceRepository.findByInsigniaId(insigniaId);
        if(competences.isEmpty())
        {
            throw new RuntimeException("Insignia not found with id: " + insigniaId);
        }
        competenceRepository.deleteAll(competences);
    }
}
