package myapp.repository;

import myapp.model.News;
import myapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryNews extends JpaRepository <News, Long> {
}
