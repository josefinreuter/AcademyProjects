//Written by Hennileena Calonius 2017
package academy.Translator;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface SanakirjaRepository extends PagingAndSortingRepository<Sanakirja, Integer> {
    @Query("SELECT suomi FROM Sanakirja WHERE lauseid = :lauseid")
    String findBySentenceIdAndSuomi(@Param("lauseid") int lauseid);

    Sanakirja findSanakirjaByLauseid(Integer lauseid);
}