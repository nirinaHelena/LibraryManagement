package com.libraryManagement.test;

import com.libraryManagement.model.Book;
import com.libraryManagement.repository.BookCrudOperations;

import java.time.LocalDate;
import java.util.List;

public class TestBookCrudOperations {
    public static void main(String[] args) {
        BookCrudOperations bookCrudOperations= new BookCrudOperations();
        try {
            // test method findAll()
            List<Book> allBooks= bookCrudOperations.findAll();
            System.out.println("all Books:");
            for (Book book: allBooks){
                System.out.println(book);
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("An error occurred: "+ e.getMessage());
        }
    }
}
