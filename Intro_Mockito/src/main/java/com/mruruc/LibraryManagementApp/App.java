package com.mruruc.LibraryManagementApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        // Book Object That we want to save in DB.
        var mockito= new Book("1","Mockito In Action",200.0, LocalDate.of(2022,5,25));
        var mockito2= new Book("2","Mockito In Action",200.0, LocalDate.of(2022,5,25));
        var mockito3= new Book("3","Mockito In Action",null, LocalDate.of(2022,5,25));

        // Representation Of DB
//        BookRepo repo=new Db(new ArrayList<>());
//
//        // Service For Business Logic.
//        var service=new BookService(repo);
//
//        service.addBook(mockito);
//        service.addBook(mockito2);
//        service.addBook(mockito3);
//        int numberOfBooks = service.findNumberOfBooks();
//        System.out.println("Number Of Total Book: " + numberOfBooks);
//        service.listOfBook().forEach(System.out::println);

        List<Book> list=new ArrayList<>();
        list.add(mockito);
        list.add(mockito2);
        list.add(mockito3);

        list.forEach(System.out::println);

        list.stream().filter(book -> book.getPrice() != null)
                .forEach(book->book.setPrice(book.getPrice() - book.getPrice()*0.1));

        System.out.println("==========================");

        list.forEach(System.out::println);


    }
}
