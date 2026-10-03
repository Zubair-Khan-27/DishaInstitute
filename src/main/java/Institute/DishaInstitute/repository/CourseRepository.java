package Institute.DishaInstitute.repository;

import Institute.DishaInstitute.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}