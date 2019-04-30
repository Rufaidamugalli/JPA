package com.mugalli;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Book {

    @Id
    private Long id;
    private String title;
    private String descrptions;
    private float uniCoast;
    private String isbn;

    public Book(Long id) {
        this.id = id;
    }

    public Book(Long id, String title, String descrptions, float uniCoast, String isbn) {
        this.id = id;
        this.title = title;
        this.descrptions = descrptions;
        this.uniCoast = uniCoast;
        this.isbn = isbn;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrptions() {
        return descrptions;
    }

    public void setDescrptions(String descrptions) {
        this.descrptions = descrptions;
    }

    public float getUniCoast() {
        return uniCoast;
    }

    public void setUniCoast(float uniCoast) {
        this.uniCoast = uniCoast;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Float.compare(book.uniCoast, uniCoast) == 0 &&
                id.equals(book.id) &&
                title.equals(book.title) &&
                descrptions.equals(book.descrptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, descrptions, uniCoast);
    }
}


