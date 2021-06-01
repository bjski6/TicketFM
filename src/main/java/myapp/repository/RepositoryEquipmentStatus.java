package myapp.repository;

import myapp.model.Equipment;
import myapp.model.EquipmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Query;
import java.util.List;

public interface RepositoryEquipmentStatus extends JpaRepository <EquipmentStatus, Long> {



}
