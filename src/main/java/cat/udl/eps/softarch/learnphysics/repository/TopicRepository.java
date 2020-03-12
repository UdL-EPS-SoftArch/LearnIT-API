package cat.udl.eps.softarch.learnphysics.repository;

import cat.udl.eps.softarch.learnphysics.domain.Question;
import cat.udl.eps.softarch.learnphysics.domain.Topic;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.expression.spel.ast.BooleanLiteral;

@RepositoryRestResource
public interface TopicRepository extends PagingAndSortingRepository<Topic, Integer> {
    Topic findTopicByName(@Param("name") String name);
    Boolean existsTopicByName(@Param("name") String name);
}
