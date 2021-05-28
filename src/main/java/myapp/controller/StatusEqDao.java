package myapp.controller;

import myapp.model.StatusEq;
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


    public void save (StatusEq  statusEq){
        entityManager.persist(statusEq);
    }

    public StatusEq findById (Long id){
        return entityManager.find(StatusEq.class, id);
    }

    public List<StatusEq> findAll(){
        Query query = entityManager.createQuery("select s from StatusEq s");
        return query.getResultList();
    }
}
