package per.jasper.insigniaproject.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Insignia
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String description;
    String imageUri;
    @OneToMany(mappedBy = "insignia")
    List<Competence> competences;
    int requiredCompetences;
}
