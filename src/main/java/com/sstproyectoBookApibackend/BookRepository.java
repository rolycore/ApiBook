package com.sstproyectoBookApibackend;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
	// Aquí puedes agregar métodos personalizados si lo deseas
	Optional<Book> findById(int id);
    
}