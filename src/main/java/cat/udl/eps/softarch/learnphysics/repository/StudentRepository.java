package cat.udl.eps.softarch.learnphysics.repository;

import cat.udl.eps.softarch.learnphysics.domain.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentRepository extends PagingAndSortingRepository<Student, String> {
}
