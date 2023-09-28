package per.jasper.insigniaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import per.jasper.insigniaproject.models.Competence;
import per.jasper.insigniaproject.models.Insignia;

import java.util.List;

public interface InsigniaRepository extends JpaRepository<Insignia, Long>
{
    public Insignia findByCompetencesId(long id);
}
