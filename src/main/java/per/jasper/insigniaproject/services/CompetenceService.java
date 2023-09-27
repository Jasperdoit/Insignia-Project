package per.jasper.insigniaproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.jasper.insigniaproject.models.Competence;
import per.jasper.insigniaproject.repositories.CompetenceRepository;

import java.util.List;

@Service
public class CompetenceService
{
    private final CompetenceRepository competenceRepository;

    public CompetenceService(CompetenceRepository competenceRepository)
    {
        this.competenceRepository = competenceRepository;
    }
}
