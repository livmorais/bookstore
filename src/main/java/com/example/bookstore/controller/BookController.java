package com.example.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.book.Book;
import com.example.bookstore.book.BookRepository;
import com.example.bookstore.book.BookRequestDTO;
import com.example.bookstore.book.BookResponseDTO;

@RestController
@RequestMapping("book")
@PreAuthorize("hasAnyRoles('ADMIN', 'USER')")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {
    
    @Autowired
    private BookRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<BookResponseDTO> getAll(){
        
        List<BookResponseDTO> bookList = repository.findAll().stream().map(BookResponseDTO::new).toList();
        return bookList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable("id") Long id) {
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            BookResponseDTO bookResponseDTO = new BookResponseDTO(book);
            return ResponseEntity.ok(bookResponseDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveBook(@RequestBody BookRequestDTO data){
        Book bookData = new Book(data);
        repository.save(bookData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public void updateBook(@PathVariable("id") Long id, @RequestBody BookRequestDTO data) {
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isPresent()) {
        Book book = optionalBook.get();
        book.setTitle(data.title());
        book.setImage(data.image());
        book.setPrice(data.price());
        repository.save(book);
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}
