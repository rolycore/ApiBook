package com.sstproyectoBookApibackend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 
 * @author Rolando Salinas
 *
 */
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
/**
 * root
 * @return
 */
    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
/**
 * 
 * @param book
 * @return
 */
    @PostMapping("/")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookRepository.save(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }
/**
 * Get id Book
 * @param id
 * @return
 */
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Book not found with id: " + id));
        return ResponseEntity.ok(book);
    }
/**
 * 
 * @param id
 * @param bookDetails
 * @return
 */
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Book not found with id: " + id));

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());

        Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }
/**
 * Delete book
 * @param id
 * @return
 */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Book not found with id: " + id));

        bookRepository.delete(book);
        return ResponseEntity.noContent().build();
    }
}