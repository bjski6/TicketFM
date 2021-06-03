package myapp.repository;

import myapp.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryStatus extends JpaRepository <Status, Long> {
}
