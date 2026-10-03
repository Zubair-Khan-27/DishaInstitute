package Institute.DishaInstitute.service;

import Institute.DishaInstitute.entity.Course;
import Institute.DishaInstitute.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // CREATE
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    // READ ALL
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // READ BY ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Course not found"));
    }

    // UPDATE
    public Course updateCourse(Long id, Course course) {

        Course existing = getCourseById(id);

        existing.setName(course.getName());
        existing.setDuration(course.getDuration());
        existing.setFees(course.getFees());

        return courseRepository.save(existing);
    }

    // DELETE
    public void deleteCourse(Long id) {

        Course existing = getCourseById(id);

        courseRepository.delete(existing);
    }
}