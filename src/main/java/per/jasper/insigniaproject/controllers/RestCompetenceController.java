//package per.jasper.insigniaproject.controllers;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import per.jasper.insigniaproject.models.Competence;
//import per.jasper.insigniaproject.services.CompetenceService;
//
//import java.util.List;
//
//@RestController
//public class RestCompetenceController {
//    private final CompetenceService competenceService;
//
//    public RestCompetenceController(CompetenceService competenceService) {
//        this.competenceService = competenceService;
//    }
//
//    @GetMapping("insignias/{id}/competences")
//    public ResponseEntity<List<Competence>> getAllCompetencesByInsigniaId(@PathVariable("id") long id) {
//        List<Competence> competences = competenceService.getAllCompetencesByInsigniaId(id);
//        return new ResponseEntity<>(competences, HttpStatus.OK);
//    }
//    @GetMapping("/competences")
//    public ResponseEntity<List<Competence>> getAllCompetences() {
//        List<Competence> competences = competenceService.getAllCompetences();
//        return new ResponseEntity<>(competences, HttpStatus.OK);
//    }
//    @GetMapping("/competences/{id}")
//    public ResponseEntity<Competence> getCompetenceById(@PathVariable("id") long id) {
//        Competence competence = competenceService.getCompetenceById(id);
//        return competence == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(competence, HttpStatus.OK);
//    }
//
//    @PostMapping("/insignias/{id}/competences")
//    public ResponseEntity<Competence> createCompetence(@PathVariable("id") long id, @RequestBody Competence competence) {
//        return new ResponseEntity<>(
//                competenceService.createCompetence(competence.getName(), competence.getDescription(), id),
//                HttpStatus.OK
//        );
//    }
//
//    @PutMapping("/competences/{id}")
//    public ResponseEntity<Competence> updateCompetence(@PathVariable("id") long id, @RequestBody Competence competence) {
//        return new ResponseEntity<>(
//                competenceService.updateCompetence(id, competence.getName(), competence.getDescription()),
//                HttpStatus.OK
//        );
//    }
//
//    @DeleteMapping("/competences/{id}")
//    public ResponseEntity<HttpStatus> deleteCompetence(@PathVariable("id") long id) {
//        competenceService.deleteCompetence(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @DeleteMapping("/insignias/{id}/competences")
//    public ResponseEntity<HttpStatus> deleteCompetencesByInsigniaId(@PathVariable("id") long id) {
//        competenceService.deleteCompetencesByInsigniaId(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}
