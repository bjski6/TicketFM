package myapp.repository;

import myapp.model.InspectionCycle;
import myapp.model.InspectionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RepositoryInspectionType extends JpaRepository <InspectionType, Long> {


}

