package per.jasper.insigniaproject.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import per.jasper.insigniaproject.models.Competence;
import per.jasper.insigniaproject.repositories.CompetenceRepository;
import per.jasper.insigniaproject.repositories.InsigniaRepository;

import java.util.List;

@RestController
public class CompetenceController {
    final
    CompetenceRepository competenceRepository;
    final
    InsigniaRepository insigniaRepository;


    public CompetenceController(CompetenceRepository competenceRepository, InsigniaRepository insigniaRepository) {
        this.competenceRepository = competenceRepository;
        this.insigniaRepository = insigniaRepository;
    }

    @GetMapping("insignias/{id}/competences")
    public ResponseEntity<List<Competence>> getAllCompetencesByInsigniaId(@PathVariable("id") long id) {
        List<Competence> competences = competenceRepository.findByInsigniaId(id);
        if (competences.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(competences, HttpStatus.OK);
    }

    @GetMapping("/competences")
    public ResponseEntity<List<Competence>> getAllCompetences() {
        List<Competence> competences = competenceRepository.findAll();
        if (competences.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(competences, HttpStatus.OK);
    }

    @GetMapping("/competences/{id}")
    public ResponseEntity<Competence> getCompetenceById(@PathVariable("id") long id) {
        Competence competence = competenceRepository.findById(id).orElse(null);
        if (competence == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(competence, HttpStatus.OK);
    }

    @PostMapping("/insignias/{id}/competences")
    public ResponseEntity<Competence> createCompetence(@PathVariable("id") long id, @RequestBody Competence competence) {
        Competence _competence = new Competence();
        _competence.setName(competence.getName());
        _competence.setDescription(competence.getDescription());
        _competence.setInsignia(insigniaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Insignia not found with id: " + id)
        ));
        return new ResponseEntity<>(competenceRepository.save(_competence), HttpStatus.CREATED);
    }

    @PutMapping("/competences/{id}")
    public ResponseEntity<Competence> updateCompetence(@PathVariable("id") long id, @RequestBody Competence competence) {
        Competence competenceData = competenceRepository.findById(id).orElse(null);
        if (competenceData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        competenceData.setName(competence.getName());
        competenceData.setDescription(competence.getDescription());
        return new ResponseEntity<>(competenceRepository.save(competenceData), HttpStatus.OK);
    }

    @DeleteMapping("/competences/{id}")
    public ResponseEntity<HttpStatus> deleteCompetence(@PathVariable("id") long id) {
        if (!competenceRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        competenceRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/insignias/{id}/competences")
    public ResponseEntity<HttpStatus> deleteCompetencesByInsigniaId(@PathVariable("id") long id) {
        List<Competence> competences = competenceRepository.findByInsigniaId(id);
        if (competences.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        competenceRepository.deleteAll(competences);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
