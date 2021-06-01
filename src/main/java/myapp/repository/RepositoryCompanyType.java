package myapp.repository;


import myapp.model.CompanyType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCompanyType extends JpaRepository <CompanyType, Long> {
}
