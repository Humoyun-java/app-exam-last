package uz.najottalim.appexam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import uz.najottalim.appexam.dto.TeacherDto;
import uz.najottalim.appexam.dto.TeacherUpdateDto;
import uz.najottalim.appexam.entity.Role;
import uz.najottalim.appexam.entity.Teacher;
import uz.najottalim.appexam.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository repository;

    public Teacher create(TeacherDto dto) {
        return repository.save(mapToEntity(dto));
    }

    public List<Teacher> read() {
        return repository.findAll();
    }

    public Optional<Teacher> readById(Long id) {
        return repository.findById(id);
    }

    public String update(TeacherUpdateDto dto) {
        if (repository.existsById(dto.getId())) {
            Optional<Teacher> byId = repository.findById(dto.getId());
            Teacher teacher = byId.get();
            teacher.setName(dto.getName());
            teacher.setName(dto.getName());
            repository.save(teacher);
            return "Teacher Updated";
        } else {
            return "Teacher Not Found";
        }
    }


    public String delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Teacher deleted";
        } else {
            return "Teacher Not Found";
        }
    }


    private Teacher mapToEntity(TeacherDto dto) {
        return Teacher.builder()
                .name(dto.getName())
                .subject(dto.getSubject())
                .role(Role.ADMIN)
                .build();
    }
}
