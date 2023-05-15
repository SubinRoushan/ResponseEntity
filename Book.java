package com.book.rest.api.entity;

public class Book {

    private int id;
    private  String firstname;
    private String secondname;
    public Book(){}

    public Book(int id, String firstname, String secondname) {
        this.id = id;
        this.firstname = firstname;
        this.secondname = secondname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", secondname='" + secondname + '\'' +
                '}';
    }
}
