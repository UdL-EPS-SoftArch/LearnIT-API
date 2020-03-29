package cat.udl.eps.softarch.learnphysics.repository;

import cat.udl.eps.softarch.learnphysics.domain.Level;
import cat.udl.eps.softarch.learnphysics.domain.Topic;
import lombok.EqualsAndHashCode;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "levels", path = "levels")
public interface LevelRepository extends PagingAndSortingRepository<Level, Integer> {
    Optional<Level> findById(@Param("levelId") Integer id);
    //Level findByName(@Param("name") String name);
    //Level findByDescription(@Param("description") String description);
}
