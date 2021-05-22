package com.jankowski.myapp.repository;

import com.jankowski.myapp.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEquipment extends JpaRepository <Equipment, Long> {
}
