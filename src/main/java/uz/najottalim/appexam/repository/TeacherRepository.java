package uz.najottalim.appexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najottalim.appexam.entity.Student;
import uz.najottalim.appexam.entity.Teacher;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    boolean existsById(Long id);

    Optional<Teacher> findById(Long id);
}
