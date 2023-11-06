package com.mruruc.testDoublesWithAndWithoutMockito.stub;

import com.mruruc.LibraryManagementApp.Book;
import com.mruruc.LibraryManagementApp.BookRepo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class StubBookRepo  implements BookRepo {

    @Override
    public void save(Book book) {

    }

    @Override
    public Collection<Book> findAll() {
        return null;
    }

    @Override
    public List<Book> getDiscountedBooks() {
        var mockito= new Book("1","Mockito In Action",200.0, LocalDate.of(2022,5,25));
        var mockito2= new Book("2","Mockito In Action",200.0, LocalDate.of(2022,5,25));
        var mockito3= new Book("3","Mockito In Action",null, LocalDate.of(2022,5,25));

        return  List.of(mockito,mockito2,mockito3);
    }
}
