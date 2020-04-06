package cat.udl.eps.softarch.learnphysics.repository;

import cat.udl.eps.softarch.learnphysics.domain.Level;
import cat.udl.eps.softarch.learnphysics.domain.Topic;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "topics", path = "topics")
public interface TopicRepository extends PagingAndSortingRepository<Topic, Integer> {
    Optional<Topic> findById(@Param("topicId") Integer id);
    //Topic findByName(@Param("name") String name);
    //Topic findByDescription(@Param("description") String description);
    Topic findTopicByName(@Param("name") String name);
    Boolean existsTopicByName(@Param("name") String name);
    List<Topic> findByLevel(Level level);
}
