package per.jasper.insigniaproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import per.jasper.insigniaproject.models.Competence;
import per.jasper.insigniaproject.models.Insignia;
import per.jasper.insigniaproject.repositories.CompetenceRepository;
import per.jasper.insigniaproject.repositories.InsigniaRepository;
import per.jasper.insigniaproject.services.CompetenceService;
import per.jasper.insigniaproject.services.InsigniaService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/insignias")
public class InsigniaController {
    private final InsigniaRepository insigniaRepository;
    private final CompetenceRepository competenceRepository;

    public InsigniaController(InsigniaRepository insigniaRepository, CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
        this.insigniaRepository = insigniaRepository;
    }
    @GetMapping("/")
    public ResponseEntity<List<Insignia>> getAllInsignias() {
        List<Insignia> insignias = insigniaRepository.findAll();
        if (insignias.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(insignias, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Insignia> getInsigniaById(@PathVariable("id") long id) {
        Insignia insignia = insigniaRepository.findById(id).orElse(null);
        if (insignia == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(insignia, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Insignia> createInsignia(@RequestBody Insignia insignia) {
        Insignia _insignia = new Insignia();
        _insignia.setName(insignia.getName());
        _insignia.setDescription(insignia.getDescription());
        return new ResponseEntity<>(insigniaRepository.save(_insignia), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Insignia> updateInsignia(@PathVariable("id") long id, @RequestBody Insignia insignia) {
        Insignia insigniaData = insigniaRepository.findById(id).orElse(null);
        if (insigniaData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        insigniaData.setName(insignia.getName());
        insigniaData.setDescription(insignia.getDescription());
        return new ResponseEntity<>(insigniaRepository.save(insigniaData), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteInsignia(@PathVariable("id") long id) {
        insigniaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
