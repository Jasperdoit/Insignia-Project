package per.jasper.insigniaproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
public class Competence
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String description;
    @ManyToOne
    @JoinColumn(name = "insignia_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Insignia insignia;
}
