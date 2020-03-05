package cat.udl.eps.softarch.learnphysics.repository;

import cat.udl.eps.softarch.learnphysics.domain.Question;
import cat.udl.eps.softarch.learnphysics.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface QuestionRepository extends PagingAndSortingRepository<Question, Integer> {
    Boolean existsQuestionByStatement(@Param("statement") String statement);
}
