package myapp.repository;

import myapp.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryStatusEq extends JpaRepository <Equipment, Long> {
}
