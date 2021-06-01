package myapp.dao;

import myapp.model.EquipmentStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class StatusEqDao {

    @PersistenceContext
    private EntityManager entityManager;


    public void save (EquipmentStatus equipmentStatus){
        entityManager.persist(equipmentStatus);
    }

    public EquipmentStatus findById (Long id){
        return entityManager.find(EquipmentStatus.class, id);
    }

    public List<EquipmentStatus> findAll(){
        Query query = entityManager.createQuery("select s from EquipmentStatus s");
        return query.getResultList();
    }
}
