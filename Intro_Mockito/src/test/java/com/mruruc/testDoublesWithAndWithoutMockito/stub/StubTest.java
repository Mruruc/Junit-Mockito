package com.mruruc.testDoublesWithAndWithoutMockito.stub;

import com.mruruc.LibraryManagementApp.Book;
import com.mruruc.LibraryManagementApp.BookRepo;
import com.mruruc.LibraryManagementApp.BookService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class StubTest {
    private BookService service;
    private StubBookRepo stubBookRepo;


    @BeforeEach
    void init() {
        this.stubBookRepo = new StubBookRepo();
        this.service = new BookService(stubBookRepo);
    }

    @Test
    void stubTestCase() {
        List<Book> books = service.discountedBooks(0.1);

        Double[] actual = books.stream().filter(book -> book.getPrice() != null)
                .map(Book::getPrice)
                .toArray(Double[]::new);
        assertArrayEquals(new Double[]{180.0, 180.0}, actual);
    }

    @Test
    void stub_Mockito() {
        BookRepo mock = mock(BookRepo.class);
        this.service = new BookService(mock);

        when(mock.getDiscountedBooks()).thenReturn(List.of(
                new Book("1", "Mockito In Action", 200.0, LocalDate.of(2022, 5, 25)),
                new Book("2", "Mockito In Action", 200.0, LocalDate.of(2022, 5, 25)),
                new Book("3", "Mockito In Action", null, LocalDate.of(2022, 5, 25)))
        );
        double sum = service.discountedBooks(0.1)
                .stream()
                .filter(book -> book.getPrice() != null)
                .mapToDouble(book -> book.getPrice())
                .sum();

        assertEquals(360.0, sum);
    }

    @AfterEach
    void destroy() {
        this.stubBookRepo = null;
        this.service = null;
    }
}
