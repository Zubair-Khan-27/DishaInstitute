package Institute.DishaInstitute.service;

import Institute.DishaInstitute.entity.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher addTeacher(Teacher teacher);

    Teacher updateTeacher(Long id, Teacher teacher);

    void deleteTeacher(Long id);

    Teacher getTeacherById(Long id);

    List<Teacher> getAllTeachers();
}