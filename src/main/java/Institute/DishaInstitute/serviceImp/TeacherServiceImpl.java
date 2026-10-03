package Institute.DishaInstitute.serviceImp;

import Institute.DishaInstitute.entity.Teacher;
import Institute.DishaInstitute.repository.TeacherRepository;
import Institute.DishaInstitute.service.TeacherService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher teacher) {

        Teacher t = teacherRepository.findById(id)
                .orElseThrow();

        t.setName(teacher.getName());
        t.setMobile(teacher.getMobile());
        t.setSubject(teacher.getSubject());

        return teacherRepository.save(t);
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher getTeacherById(Long id) {

        return teacherRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}