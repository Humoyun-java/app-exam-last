package uz.najottalim.appexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najottalim.appexam.entity.Group;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    boolean existsById(Long id);

    Optional<Group> findById(Long id);
}
