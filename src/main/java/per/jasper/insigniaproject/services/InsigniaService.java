package per.jasper.insigniaproject.services;

import org.springframework.stereotype.Service;
import per.jasper.insigniaproject.models.Competence;
import per.jasper.insigniaproject.models.Insignia;
import per.jasper.insigniaproject.repositories.InsigniaRepository;

import java.util.List;
import java.util.Set;

@Service
public class InsigniaService
{
//    Implement Repository
    final
InsigniaRepository insigniaRepository;

    public InsigniaService(InsigniaRepository insigniaRepository)
    {
        this.insigniaRepository = insigniaRepository;
    }

}
