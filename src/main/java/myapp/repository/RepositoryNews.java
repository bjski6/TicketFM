package myapp.repository;

import myapp.model.News;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryNews extends JpaRepository <News, Long> {
}
