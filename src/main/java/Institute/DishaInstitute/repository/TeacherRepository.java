package Institute.DishaInstitute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Institute.DishaInstitute.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}