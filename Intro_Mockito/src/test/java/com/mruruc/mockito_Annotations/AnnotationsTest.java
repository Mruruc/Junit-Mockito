package com.mruruc.mockito_Annotations;

import com.mruruc.LibraryManagementApp.Book;
import com.mruruc.LibraryManagementApp.BookRepo;
import com.mruruc.LibraryManagementApp.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AnnotationsTest {

    @InjectMocks
    private BookService service;
    @Mock
    private BookRepo mock;


    @Test
    void stub_Mockito() {
       // BookRepo mock = mock(BookRepo.class);
      //  this.service = new BookService(mock);

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
}
