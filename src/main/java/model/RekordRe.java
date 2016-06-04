package model;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RekordRe extends CrudRepository<Rekord,Integer>{
    @Query("select count(r) from Rekord r where r.value = ?1")
    Long findNumberOfMatchingValues(String value);
}
