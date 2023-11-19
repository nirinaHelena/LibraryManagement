package com.libraryManagement.test;

import com.libraryManagement.model.Book;
import com.libraryManagement.model.Topic;
import com.libraryManagement.repository.BookCrudOperations;

import java.time.LocalDate;
import java.util.List;

public class TestBookCrudOperations {
    public static void main(String[] args) {
        BookCrudOperations bookCrudOperations= new BookCrudOperations();
        try {
            // test method findAll()
            System.out.println("test find all method:");
            List<Book> allBooks= bookCrudOperations.findAll();
            System.out.println("all Books:");
            for (Book book: allBooks){
                System.out.println(book);
            }

            // test method save()
            Book newBook=  new Book("New book", 5, 200, Topic.OTHER, LocalDate.of(2023,01,01),
                    true);
            System.out.println("test method save a book: ");
            bookCrudOperations.save(newBook);
            System.out.println("New book added: "+ newBook);

            /**
             * // test method findAll() after adding
             *             System.out.println("test method find all after adding: ");
             *             allBooks= bookCrudOperations.findAll();
             *             System.out.println("all Books:");
             *             for (Book book: allBooks){
             *                 System.out.println(book);
             *             }
             *             // Test method delete()
             *             System.out.println("test method delete: ");
             *             if (!allBooks.isEmpty()) {
             *                 Book bookToDelete = allBooks.get(0);
             *                 bookCrudOperations.delete(bookToDelete);
             *                 System.out.println("Deleted Book: " + bookToDelete);
             *             }
             *
             *             // Test method findAll() après la suppression
             *             System.out.println("test method findAll after delte: ");
             *             allBooks = bookCrudOperations.findAll();
             *             System.out.println("All Books after deletion:");
             *             for (Book book : allBooks) {
             *                 System.out.println(book);
             *             }
             */
            /
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("An error occurred: "+ e.getMessage());
        }
    }
}
