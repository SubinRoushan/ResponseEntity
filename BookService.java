package com.book.rest.api.service;

import com.book.rest.api.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {
    static List<Book> list=new ArrayList<>();
    static {
        list.add(new Book(1,"JAVA","BOOK"));
        list.add(new Book(2,"SQL","BOOK"));
        list.add(new Book(3,"PYTHON","BOOK"));
    }

    //Method for All Book
    public List<Book> getAllBook()
    {
        return list;
    }


    //Method for single Book
    public Book getBookById(int id)
    {
        Book book=new Book();
        book=list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }

    //Method for Post
    public Book getbookpost(Book b)
    {
        list.add(b);
        return b;
    }

    //Method for DELETE
    public void delete(int d)
    {
        list.stream().filter(e->e.getId()!=d).collect(Collectors.toList());
    }


    //Methof for PUT
    public void updateBook(Book b,int bookId)
    {
        list= list.stream().map(e->{
            if(e.getId()==bookId)
            {
                e.setFirstname(b.getFirstname());
                e.setSecondname(b.getSecondname());

            }
            return e;
        }).collect(Collectors.toList());
    }
}
