package frapp.parent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "t_hobby")
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hobby_ıd", nullable = false)
    private UUID hobbyId;
    @Column(name = "hobby_name")
    private String hobbyName;
    @Column(name = "hobby_description")
    private String hobbyDescription;

    @ManyToMany
    @JoinTable(
            name = "user_hobby",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id")
    )
    private List<Hobby> hobbies;
}
