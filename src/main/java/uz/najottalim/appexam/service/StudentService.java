package uz.najottalim.appexam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import uz.najottalim.appexam.dto.StudentDto;

import uz.najottalim.appexam.dto.StudentUpdateDto;
import uz.najottalim.appexam.entity.Role;
import uz.najottalim.appexam.entity.Student;
import uz.najottalim.appexam.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public Student create(StudentDto dto) {
        return repository.save(mapToEntity(dto));
    }

    public List<Student> read() {
        return repository.findAll();
    }

    public Optional<Student> readById(Long id) {
        return repository.findById(id);
    }

    public String update(StudentUpdateDto dto) {
        if (repository.existsById(dto.getId())) {
            Optional<Student> byId = repository.findById(dto.getId());
            Student student = byId.get();
            student.setName(dto.getName());
            student.setSurname(dto.getSurname());
            student.setAge(dto.getAge());
            repository.save(student);
            return "Student Updated";
        } else {
            return "Student Not Found";
        }
    }


    public String delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Student deleted";
        } else {
            return "Student Not Found";
        }
    }


    private Student mapToEntity(StudentDto dto) {
        return Student.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .age(dto.getAge())
                .role(Role.STUDENT)
                .build();
    }
}
