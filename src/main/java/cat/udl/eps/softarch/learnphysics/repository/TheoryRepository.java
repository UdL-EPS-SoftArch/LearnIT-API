package cat.udl.eps.softarch.learnphysics.repository;

import cat.udl.eps.softarch.learnphysics.domain.Level;
import cat.udl.eps.softarch.learnphysics.domain.Question;
import cat.udl.eps.softarch.learnphysics.domain.Theory;
import cat.udl.eps.softarch.learnphysics.domain.Topic;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TheoryRepository extends PagingAndSortingRepository<Theory, Integer> {

    Boolean existsTheoriesByName(@Param("name") String name);
    Theory findTheoriesByName(@Param("name") String name);

    List<Theory> findByLevelAndTopic(Level level, Topic topic);
    List<Theory> findByLevel(Level level);
    List<Theory> findByTopic(Topic topic);
}
