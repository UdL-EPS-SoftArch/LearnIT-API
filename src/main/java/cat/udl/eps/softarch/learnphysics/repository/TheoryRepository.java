package cat.udl.eps.softarch.learnphysics.repository;

import cat.udl.eps.softarch.learnphysics.domain.Question;
import cat.udl.eps.softarch.learnphysics.domain.Theory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TheoryRepository extends PagingAndSortingRepository<Theory, Integer> {
    Boolean existsTheoriesByName(@Param("name") String name);
    Theory findTheoriesByName(@Param("name") String name);
}
