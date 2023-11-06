package com.mruruc.testDoublesWithAndWithoutMockito.fake;

import com.mruruc.LibraryManagementApp.Book;
import com.mruruc.LibraryManagementApp.BookRepo;
import com.mruruc.LibraryManagementApp.BookService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class FakeTest {
    private Book book;
    private BookService bookService;
    private FakeBookRepo fakeRepo;

    @BeforeEach
    void init(){
        this.book=
                new Book("1","Mockito In Action",200.0, LocalDate.of(2022,5,25));

    }

    @Test
    @DisplayName("Testing Classes Instance")
    void fakeRepo(){
        this.fakeRepo=new FakeBookRepo();
        this.bookService=new BookService(fakeRepo);
        assertInstanceOf(FakeBookRepo.class,fakeRepo);
        assertInstanceOf(BookService.class,bookService);
        assertInstanceOf(Book.class,book);
    }

    @Test
    @DisplayName("Testing addBook() ")
    void test_add(){
        bookService.addBook(book);
        assertEquals(1,bookService.findNumberOfBooks());
    }

    @Test
    @DisplayName("Testing Fake Double With Mockito")
    void testFakeDouble_Mockito(){
        BookRepo mockRepo = Mockito.mock(BookRepo.class);
        this.bookService = new BookService(mockRepo);
        bookService.addBook(book);

        Collection<Book> books=new ArrayList<>();
        books.add(book);

        Mockito.when(mockRepo.findAll()).thenReturn(books);

        assertEquals(1,bookService.findNumberOfBooks());

    }


    @AfterEach
    void destroy(){
        book=null;
        bookService=null;
        fakeRepo=null;
    }
}
