package com.mugalli;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();


    //insert a book;
    public Book createBook(Book book) {
        tx.begin();
        em.persist(book);
        tx.commit();
        return book;
    }

    //find a book
    public Book findBook(Long id) {
        return em.find(Book.class, id);
    }

    // delete a book
    public void removeBook(Long id) {
        Book book = em.find(Book.class, id);
        if (book != null) {
            tx.begin();
            em.remove(book);
            tx.commit();
        }
    }

    // update the price
    public Book updaprice(Long id, float price) {
        Book book = em.find(Book.class, id);
        if (book != null) {
            tx.begin();
           book.setUniCoast(book.getUniCoast() + price);
            tx.commit();
        }
        return book;

    }

}
