package myapp.repository;

import myapp.model.Inspection;
import myapp.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RepositoryInspection extends JpaRepository <Inspection, Long> {

    @Query(value = "select * from Inspection where inspectionType_id = ?1", nativeQuery = true)
    List<Inspection> findByInspectionTypeId(int i);


}

