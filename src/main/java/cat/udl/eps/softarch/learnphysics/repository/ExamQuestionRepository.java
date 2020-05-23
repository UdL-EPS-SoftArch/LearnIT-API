package cat.udl.eps.softarch.learnphysics.repository;

import cat.udl.eps.softarch.learnphysics.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "exams_questions", path = "exams_questions")
public interface ExamQuestionRepository extends PagingAndSortingRepository<ExamQuestion, Integer> {

    List<ExamQuestion> findByExam(Exam exam);
    List<ExamQuestion> findByQuestion(Question question);
    List<ExamQuestion> findByExamAndQuestion(Exam exam, Question question);
}
