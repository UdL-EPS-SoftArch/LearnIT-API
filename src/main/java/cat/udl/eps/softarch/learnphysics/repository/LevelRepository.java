package cat.udl.eps.softarch.learnphysics.repository;

import cat.udl.eps.softarch.learnphysics.domain.Level;
import cat.udl.eps.softarch.learnphysics.domain.Topic;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LevelRepository extends PagingAndSortingRepository<Level, Integer> {
    Optional<Level> findById(@Param("levelId") String id);
    Level findByName(@Param("name") String name);
    Level findByDescription(@Param("description") String description);
    Level findByTopic(@Param("topics") Topic topic);

    <Level> Level  findAllById(@Param("listOfLevelsId") String id);
}
