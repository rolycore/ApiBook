package com.sstproyectoBookApibackend;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
/**
 * 
 * @author Rolando Salinas
 *
 */
@Configuration
@EnableMongoRepositories("com.sstproyectoBookApibackend.BookRepository") // Reemplaza por el paquete donde se encuentra tu repositorio
public class MongoConfig {
}