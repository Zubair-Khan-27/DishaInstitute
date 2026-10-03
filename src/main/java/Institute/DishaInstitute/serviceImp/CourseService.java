package Institute.DishaInstitute.serviceImp;

import Institute.DishaInstitute.entity.Course;

import java.util.List;

public interface CourseService {

    Course addCourse(Course course);

    Course updateCourse(Long id, Course course);

    void deleteCourse(Long id);

    Course getCourseById(Long id);

    List<Course> getAllCourses();
}