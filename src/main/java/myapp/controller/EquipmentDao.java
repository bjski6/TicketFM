package myapp.controller;

import myapp.model.Equipment;
import myapp.model.Installation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Repository
@Transactional
public class EquipmentDao {

    @PersistenceContext
    private EntityManager entityManager;


    public void save (Equipment equipment){
        entityManager.persist(equipment);
    }

    public Equipment findById (Long id){
        return entityManager.find(Equipment.class, id);
    }
}
