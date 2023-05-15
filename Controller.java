package com.book.rest.api.controller;

import com.book.rest.api.entity.Book;
import com.book.rest.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private BookService bookService;
    @GetMapping("/book")

    //For All Book(GET)
    public ResponseEntity<List<Book>> getbook()
    {
        List<Book> list=bookService.getAllBook();
        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.of(Optional.of(list));
        }
    }

    //For Single Book(GET)

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getbookbyeid(@PathVariable("id") int id)
    {
        Book book=bookService.getBookById(id);
        if(book==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.of(Optional.of(book));
        }
    }



    //Post Mapping
    @PostMapping("/book")
    public ResponseEntity<Book> getBook(@RequestBody Book book)
    {
        Book b=null;
        try {
            b=this.bookService.getbookpost(book);
            return ResponseEntity.of(Optional.of(b));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    //DELETE Mapping
    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<?> getdelete(@PathVariable("bookId") int bookId)
    {
        try {
            this.bookService.delete(bookId);
            return ResponseEntity.ok().build();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }


    //PUT Mapping
    @PutMapping("/book/{bookId}")
    public ResponseEntity<Book> getupdate(@RequestBody Book book,@PathVariable("bookId") int bookId)
    {
        try {
            this.bookService.updateBook(book, bookId);
            return ResponseEntity.ok().body(book);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
