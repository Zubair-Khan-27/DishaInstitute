package Institute.DishaInstitute.serviceImp;

import Institute.DishaInstitute.dto.StudentDto;
import Institute.DishaInstitute.entity.Batch;
import Institute.DishaInstitute.entity.Course;
import Institute.DishaInstitute.entity.Student;
import Institute.DishaInstitute.repository.BatchRepository;
import Institute.DishaInstitute.repository.CourseRepository;
import Institute.DishaInstitute.repository.StudentRepository;
import Institute.DishaInstitute.service.StudentService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final BatchRepository batchRepository;

    public StudentServiceImpl(
            StudentRepository studentRepository,
            CourseRepository courseRepository,
            BatchRepository batchRepository) {

        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.batchRepository = batchRepository;
    }

    @Override
    public Student addStudent(StudentDto dto) {

        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Course not found with id: "
                                        + dto.getCourseId()
                        )
                );

        Batch batch = batchRepository.findById(dto.getBatchId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Batch not found with id: "
                                        + dto.getBatchId()
                        )
                );

        Student student = new Student();

        student.setName(dto.getName());
        student.setMobile(dto.getMobile());
        student.setAge(dto.getAge());
        student.setAddress(dto.getAddress());

        student.setCourse(course);
        student.setBatch(batch);

        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, StudentDto dto) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->new RuntimeException(  "Student not found with id: " + id ));

        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException(  "Course not found with id: " + dto.getCourseId() ) );

        Batch batch = batchRepository.findById(dto.getBatchId())
                .orElseThrow(() ->new RuntimeException("Batch not found with id: "  + dto.getBatchId()  ));

        student.setName(dto.getName());
        student.setMobile(dto.getMobile());
        student.setAge(dto.getAge());
        student.setAddress(dto.getAddress());

        student.setCourse(course);
        student.setBatch(batch);

        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentById(Long id) {

        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(  "Student not found with id: " + id ));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}