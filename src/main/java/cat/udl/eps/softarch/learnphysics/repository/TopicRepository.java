package cat.udl.eps.softarch.learnphysics.repository;

import cat.udl.eps.softarch.learnphysics.domain.Topic;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TopicRepository extends PagingAndSortingRepository<Topic, Integer> {
}
