package Institute.DishaInstitute.service;

import Institute.DishaInstitute.dto.StudentDto;
import Institute.DishaInstitute.entity.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(StudentDto dto);

    Student updateStudent(Long id, StudentDto dto);

    void deleteStudent(Long id);

    Student getStudentById(Long id);

    List<Student> getAllStudents();
}