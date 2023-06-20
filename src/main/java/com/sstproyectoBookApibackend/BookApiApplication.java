package com.sstproyectoBookApibackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Rolando Salinas
 *This is API RESTful provides basic functionality for managing a collection of books.
 */
@SpringBootApplication
@RestController
@RequestMapping("/books")
public class BookApiApplication {


    private List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(BookApiApplication.class, args);
    }
/**
 * 
 * @return
 */
    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(books);
    }
/**
 * 
 * @param bookId
 * @return
 */
    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable int bookId) {
        Book book = findBookById(bookId);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
/**
 * 
 * @param newBook
 * @return
 */
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book newBook) {
        newBook.setId(books.size() + 1);
        books.add(newBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }
/**
 * 
 * @param bookId
 * @param updatedBook
 * @return
 */
    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable int bookId, @RequestBody Book updatedBook) {
        Book book = findBookById(bookId);
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
/**
 * 
 * @param bookId
 * @return
 */
    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable int bookId) {
        Book book = findBookById(bookId);
        if (book != null) {
            books.remove(book);
            return ResponseEntity.ok("Book deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
/**
 * FindBookByID
 * @param bookId
 * @return
 */
    private Book findBookById(int bookId) {
        return books.stream()
                .filter(book -> book.getId() == bookId)
                .findFirst()
                .orElse(null);
    }

}
