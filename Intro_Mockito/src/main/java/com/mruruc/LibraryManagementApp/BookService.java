package com.mruruc.LibraryManagementApp;

import java.util.Collection;
import java.util.List;

public class BookService {
    private BookRepo repo;


    public BookService(BookRepo repo) {
        this.repo = repo;
    }


    public void addBook(Book book){
        repo.save(book);
    }

    public int findNumberOfBooks(){
        return repo.findAll().size();
    }
    public Collection<Book> listOfBook(){
        return repo.findAll();
    }

    public List<Book> discountedBooks(double discountRate){
        List<Book> list=repo.getDiscountedBooks();
        list.stream().filter(book -> book.getPrice() != null)
                .forEach(book -> book.setPrice(book.getPrice() -(book.getPrice() * discountRate)));
        return list;
    }









}
