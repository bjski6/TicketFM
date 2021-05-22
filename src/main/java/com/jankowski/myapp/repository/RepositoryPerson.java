package com.jankowski.myapp.repository;

import com.jankowski.myapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPerson extends JpaRepository <Person, Long> {
}
