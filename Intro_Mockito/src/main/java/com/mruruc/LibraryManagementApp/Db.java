package com.mruruc.LibraryManagementApp;

import java.util.Collection;
import java.util.List;

public class Db implements BookRepo {
    private List<Book> list;

    public Db(List<Book> list){
        this.list=list;
    }


    @Override
    public void save(Book book) {
        list.add(book);
    }

    @Override
    public Collection<Book> findAll() {
        return list;
    }
}
