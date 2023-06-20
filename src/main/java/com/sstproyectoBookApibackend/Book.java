package com.sstproyectoBookApibackend;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author Rolando Salinas
 * This is the Model for collection books
 */
@Document(collection = "books")
public class Book {
    @Id
    private int id;
    private String title;
    private String author;
/**
 * Constructor empty
 */
    public Book() {
    }
/**
 * Constructors
 * @param id
 * @param title
 * @param author
 */
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
/**
 *   Getters and setters
 * @return
 */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}