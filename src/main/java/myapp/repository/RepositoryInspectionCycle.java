package myapp.repository;

import myapp.model.Inspection;
import myapp.model.InspectionCycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RepositoryInspectionCycle extends JpaRepository <InspectionCycle, Long> {

    @Query(value = "select * from InspectionCycle where cycle = ?1", nativeQuery = true)
InspectionCycle findByName (String cycle);
}

