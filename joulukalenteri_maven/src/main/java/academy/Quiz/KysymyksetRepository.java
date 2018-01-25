package academy.Quiz;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface KysymyksetRepository extends PagingAndSortingRepository<Kysymykset, Integer> {


}
