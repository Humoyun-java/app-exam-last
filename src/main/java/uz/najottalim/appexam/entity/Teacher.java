package uz.najottalim.appexam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.cfg.beanvalidation.GroupsPerOperation;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String subject;

    Role role = Role.ADMIN;

    public Teacher(Long id) {
        this.id = id;
    }
}
