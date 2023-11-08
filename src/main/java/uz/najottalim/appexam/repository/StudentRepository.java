package uz.najottalim.appexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najottalim.appexam.entity.Group;
import uz.najottalim.appexam.entity.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsById(Long id);

    Optional<Student> findById(Long id);
}
