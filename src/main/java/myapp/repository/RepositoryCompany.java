package myapp.repository;

import myapp.model.Company;
import myapp.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCompany extends JpaRepository <Company, Long> {
}
