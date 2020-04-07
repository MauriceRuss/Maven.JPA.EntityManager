package services;

import entities.Movies;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Date;
import java.util.List;

public class MovieServices {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("movies");
    private EntityManager entityManager = emf.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();


    public Movies createMovies(int id, String title, String genre, Date year, String artist, double price){
        Movies movie = new Movies(id, title, genre, year, artist, price);

        entityTransaction.begin();
        entityManager.persist(movie);
        entityTransaction.commit();

        return movie;
    }

    public Movies findMovies(int id){
        return entityManager.find(Movies.class, id);
    }

    public List<Movies> findAllMovies(){
        CriteriaQuery<Movies> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Movies.class);
        criteriaQuery.select(criteriaQuery.from(Movies.class));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public Movies updateMovies(int id, String title, String genre, Date year, String artist, double price){
        Movies movie = findMovies(id);
        entityTransaction.begin();
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setYear(year);
        movie.setArtist(artist);
        movie.setPrice(price);
        entityTransaction.commit();

        return movie;
    }

    public Movies deleteMovies(int id){
        Movies movie = findMovies(id);
        entityTransaction.begin();
        entityManager.remove(movie);
        entityTransaction.commit();

        return movie;
    }
}
