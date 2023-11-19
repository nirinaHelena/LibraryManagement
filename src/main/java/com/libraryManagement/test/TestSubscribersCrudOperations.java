package com.libraryManagement.test;

import com.libraryManagement.model.Author;
import com.libraryManagement.model.Subscribers;
import com.libraryManagement.repository.AuthorCrudOperations;
import com.libraryManagement.repository.SubscribersCrudOperations;

import java.util.List;

public class TestSubscribersCrudOperations {
    public static void main(String[] args) {
        SubscribersCrudOperations subscribersCrudOperations= new SubscribersCrudOperations();
        try {
            // test method findAll()
            System.out.println("test find all method:");
            List<Subscribers> allSubscribers= subscribersCrudOperations.findAll();
            System.out.println("all subscribers:");
            for (Subscribers subscribers: allSubscribers){
                System.out.println(subscribers);
            }
            /*
            // test method save()
            Author newAuthor= new Author("Grimm", 'F');
            System.out.println("test method save a author: ");
            authorCrudOperations.save(newAuthor);
            System.out.println("New book added: "+ newAuthor);

            //test method findAll() after adding
            System.out.println("test method find all after adding: ");
            allAuthors= authorCrudOperations.findAll();
            System.out.println("all Books:");
            for (Author author: allAuthors){
                System.out.println(author);
            }
            // Test method delete()
            System.out.println("test method delete: ");
            if (!allAuthors.isEmpty()) {
                Author authoToDelete = allAuthors.get(0);
                authorCrudOperations.delete(authoToDelete);
                System.out.println("Deleted Book: " + authoToDelete);
            }

            // Test method findAll() après la suppression
            System.out.println("test method findAll after delte: ");
            allAuthors = authorCrudOperations.findAll();
            System.out.println("All Books after deletion:");
            for (Author author : allAuthors) {
                System.out.println(author);
            }


             */
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("An error occurred: "+ e.getMessage());
        }
    }
}
