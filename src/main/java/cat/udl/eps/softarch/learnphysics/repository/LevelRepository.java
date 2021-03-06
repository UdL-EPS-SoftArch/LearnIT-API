package cat.udl.eps.softarch.learnphysics.repository;

import cat.udl.eps.softarch.learnphysics.domain.Level;
import cat.udl.eps.softarch.learnphysics.domain.Topic;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface LevelRepository extends PagingAndSortingRepository<Level, Integer> {
    Optional<Level> findById(@Param("levelId") Integer id);
    //Level findByName(@Param("name") String name);
    //Level findByDescription(@Param("description") String description);
    Level findLevelByName(@Param("name") String name);
    Boolean existsLevelsByName(@Param("name") String name);
}
