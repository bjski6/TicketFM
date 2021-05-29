package myapp.controller;

import myapp.model.Installation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public class InstallationDao {

    @PersistenceContext
    EntityManager entityManager;

    private void save (Installation installation){
        entityManager.persist(installation);
    }

    public Installation findById (Long id){
        return entityManager.find(Installation.class, id);
    }


    public List<Installation> findAll (){
        Query query = entityManager.createQuery("select x from Installation x");
        return query.getResultList();
    }
}
