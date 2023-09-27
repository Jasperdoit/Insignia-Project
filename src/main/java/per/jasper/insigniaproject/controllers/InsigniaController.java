package per.jasper.insigniaproject.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import per.jasper.insigniaproject.models.Insignia;
import per.jasper.insigniaproject.services.InsigniaService;

import java.util.List;

@RestController
@RequestMapping("/insignias")
public class InsigniaController {
    private final InsigniaService insigniaService;

    public InsigniaController(InsigniaService insigniaService) {
        this.insigniaService = insigniaService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Insignia>> getAllInsignias() {
        List<Insignia> insignias = insigniaService.getAllInsignias();
        if(insignias == null)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(insignias, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Insignia> getInsigniaById(@PathVariable("id") long id) {
        Insignia insignia = insigniaService.getInsigniaById(id);
        if (insignia == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(insignia, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Insignia> createInsignia(@RequestBody Insignia insignia) {
        Insignia _insignia = insigniaService.createInsignia(insignia.getName(), insignia.getDescription(), insignia.getImageUri());
        return new ResponseEntity<>(_insignia, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Insignia> updateInsignia(@PathVariable("id") long id, @RequestBody Insignia insignia) {
        Insignia _insignia = insigniaService.updateInsignia(insignia.getId(), insignia.getName(), insignia.getDescription(), insignia.getImageUri());
        if(_insignia == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(_insignia, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteInsignia(@PathVariable("id") long id) {
        insigniaService.deleteInsignia(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
