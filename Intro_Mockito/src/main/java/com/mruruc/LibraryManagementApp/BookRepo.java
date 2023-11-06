package com.mruruc.LibraryManagementApp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface BookRepo {
    void save(Book book);
    Collection<Book> findAll();

    default List<Book> getDiscountedBooks(){
        return new ArrayList<>();
    }
}
