package uz.najottalim.appexam.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.appexam.dto.*;
import uz.najottalim.appexam.entity.Group;
import uz.najottalim.appexam.entity.Student;
import uz.najottalim.appexam.entity.Teacher;
import uz.najottalim.appexam.service.GroupService;
import uz.najottalim.appexam.service.StudentService;
import uz.najottalim.appexam.service.TeacherService;

import java.util.List;

@RestController
public class Controller {
    GroupService groupService;
    StudentService studentService;
    TeacherService teacherService;

    @PostMapping("/create/group")
    @PreAuthorize("hasRole('ADMIN')")
    public Group createGroup(@RequestBody GroupDto dto) {
        return groupService.create(dto);
    }
    @PostMapping("/create/student")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public Student createStudent(@RequestBody StudentDto dto) {
        return studentService.create(dto);
    }
    @PostMapping("/create/teacher")
    @PreAuthorize("hasRole('ADMIN')")
    public Teacher createTeacher(@RequestBody TeacherDto dto) {
        return teacherService.create(dto);
    }

    @GetMapping("/get/group")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Group> readGroups() {
        return groupService.read();
    }
    @GetMapping("/get/student")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public List<Student> readStudent() {
        return studentService.read();
    }
    @GetMapping("/get/teacher")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Teacher> readTeacher() {
        return teacherService.read();
    }

    @PostMapping("/update/group")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateGroup(@RequestBody GroupUpdateDto dto){
        return groupService.update(dto);
    }
    @PostMapping("/update/student")
    @PreAuthorize("hasAnyRole('ADMIN', 'Student')")
    public String updateStudent(@RequestBody StudentUpdateDto dto){
        return studentService.update(dto);
    }
    @PostMapping("/update/teacher")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public String updateTeacher(@RequestBody TeacherUpdateDto dto){
        return teacherService.update(dto);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/delete/{id}")
    public String deleteGroup(@RequestParam Long id){
        return groupService.delete(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/delete/{id}")
    public String deleteStudent(@RequestParam Long id){
        return studentService.delete(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/delete/{id}")
    public String deleteTeacher(@RequestParam Long id){
        return teacherService.delete(id);
    }
}
