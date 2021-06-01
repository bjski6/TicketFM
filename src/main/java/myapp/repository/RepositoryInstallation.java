package myapp.repository;

import myapp.model.CompanyType;
import myapp.model.Equipment;
import myapp.model.Installation;
import myapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositoryInstallation extends JpaRepository <Installation, Long> {

}
