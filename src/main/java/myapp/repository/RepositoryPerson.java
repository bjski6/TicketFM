package myapp.repository;

import myapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositoryPerson extends JpaRepository <Person, Long> {


    @Query (value = "select * from Person where email = ?1", nativeQuery = true)
    Person findByEmail(String email);
}


// query do szukaj
// @Query (value = "select * from Person where email = %bjsk% ", nativeQuery = true)
//    Person findByEmail(String email);
//}
