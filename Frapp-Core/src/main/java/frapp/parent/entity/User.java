package frapp.parent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_ıd", nullable = false)
    private UUID userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Timestamp createdTime;
    private boolean isDeleted;
    private String gender;
    private String roles;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_hobby",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id")
    )
    private List<Hobby> hobbies;

}
