package academy.Quiz;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VastauksetRepository extends PagingAndSortingRepository<Vastaukset, Integer> {


}