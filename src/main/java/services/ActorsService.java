package services;

import entities.Actors;
import entities.Movies;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ActorsService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("movies");
    private EntityManager entityManager = emf.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();

    public Actors createActors(int id, String firstName, String lastName, double pay){
        Actors actor = new Actors(id, firstName, lastName, pay);

        entityTransaction.begin();
        entityManager.persist(actor);
        entityTransaction.commit();

        return actor;
    }

    public Actors findActors(int id){
        return entityManager.find(Actors.class, id);
    }

    public List<Actors> findAllActors(){
        CriteriaQuery<Actors> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Actors.class);
        criteriaQuery.select(criteriaQuery.from(Actors.class));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public Actors updateActors(int id, String firstName, String lastName, double pay){
        Actors actor = findActors(id);
        entityTransaction.begin();
        actor.setFirstName(firstName);
        actor.setLastName(lastName);
        actor.setPay(pay);
        entityTransaction.commit();

        return actor;
    }

    public Actors deleteActors(int id){
        Actors actor = findActors(id);
        entityTransaction.begin();
        entityManager.remove(actor);
        entityTransaction.commit();

        return actor;
    }

}
