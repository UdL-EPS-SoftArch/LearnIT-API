package cat.udl.eps.softarch.learnphysics.repository;


import cat.udl.eps.softarch.learnphysics.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "students_exams", path = "students_exams")
public interface StudentExamRepository extends PagingAndSortingRepository<StudentExam, Integer> {

    List<StudentExam> findByExam(Exam exam);
    List<StudentExam> findByStudent(Student student);
    List<StudentExam> findByStudentAndExam(Student student, Exam exam);
}
