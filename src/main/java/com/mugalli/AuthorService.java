package com.mugalli;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

public class AuthorService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("name");
    private EntityManager em  = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    //insert an author
    public Author createAuthor(Author author){
        tx.begin();
        em.persist(author);
        tx.commit();
        return author;
    }
    //find an author
    public Author findAuthor(Long id){
        return em.find(Author.class,id);
    }

    // Delete an author
    public void removeAuthor(Long id){
        Author author = em.find(Author.class,id);
        if (author!=null){
            tx.begin();
            em.remove(author);
            tx.commit();
        }
    }

}
