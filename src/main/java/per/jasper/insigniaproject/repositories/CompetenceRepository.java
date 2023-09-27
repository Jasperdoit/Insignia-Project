package per.jasper.insigniaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import per.jasper.insigniaproject.models.Competence;

import java.util.List;

public interface CompetenceRepository extends JpaRepository<Competence, Long>
{
    List<Competence> findByInsigniaId(Long id);
}
