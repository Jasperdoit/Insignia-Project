package per.jasper.insigniaproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import per.jasper.insigniaproject.models.Competence;
import per.jasper.insigniaproject.models.Insignia;
import per.jasper.insigniaproject.repositories.CompetenceRepository;
import per.jasper.insigniaproject.repositories.InsigniaRepository;

import java.util.List;
import java.util.Set;

@Service
public class InsigniaService
{
    private final InsigniaRepository insigniaRepository;
    private final CompetenceRepository competenceRepository;

    public InsigniaService(InsigniaRepository insigniaRepository, CompetenceRepository competenceRepository) {
        this.insigniaRepository = insigniaRepository;
        this.competenceRepository = competenceRepository;
    }
    public List<Insignia> getAllInsignias()
    {
        return insigniaRepository.findAll();
    }
    public Insignia getInsigniaById(long id)
    {
        return insigniaRepository.findById(id).orElse(null);
    }
    public Insignia getInsigniaByCompetenceId(long id)
    {
        return insigniaRepository.findByCompetencesId(id);
    }
    public Insignia createInsignia(String name, String description, String imageUri)
    {
        Insignia insignia = new Insignia();
        insignia.setName(name);
        insignia.setDescription(description);
        insignia.setImageUri(imageUri);
        return insigniaRepository.save(insignia);
    }
    public Insignia updateInsignia(long id, String name, String description, String imageUri)
    {
        Insignia insignia = insigniaRepository.findById(id).orElse(null);
        if (insignia == null)
        {
            return null;
        }
        insignia.setName(name);
        insignia.setDescription(description);
        insignia.setImageUri(imageUri);
        return insigniaRepository.save(insignia);
    }
    public void deleteInsignia(long id)
    {
        insigniaRepository.deleteById(id);
    }
}
