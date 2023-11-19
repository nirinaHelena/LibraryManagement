package com.libraryManagement.repository;

import com.libraryManagement.model.Book;
import com.libraryManagement.model.Topic;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookCrudOperations implements CrudOperations<Book> {
    DatabaseConfig databaseConfig= new DatabaseConfig();
    @Override
    public List<Book> findAll() {
        List<Book> allBook= new ArrayList<>();
        String sql= "select * from book ;";

        try (PreparedStatement preparedStatement= databaseConfig.createConnection().prepareStatement(sql)){
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                String id= String.valueOf(resultSet.getInt("id"));
                String bookName= resultSet.getString("bookName");
                int author= resultSet.getInt("author");
                int pageNumbers= resultSet.getInt("pageNumbers");
                LocalDate releaseDate= resultSet.getDate("releaseDate").toLocalDate();
                Topic topic= Topic.toTopic(resultSet.getString("topic"));
                Boolean available= resultSet.getBoolean("available");

                Book book= new Book(id, bookName, author,
                        pageNumbers,Topic.valueOf(String.valueOf(topic)), releaseDate, available);
                allBook.add(book);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return allBook;
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) {
        List<Book> savedBooks= new ArrayList<>();
        for (Book book: toSave){
            save(book);
            savedBooks.add(book);
        }
        return savedBooks;
    }

    @Override
    public Book save(Book toSave) {
        String sql= "insert into book (bookName, author, pageNumbers," +
                "releaseDate, topic, available) values (?, ?, ?, ?, ?::topic, ?) ;";

        try (Connection connection= databaseConfig.createConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(sql)
        ){
            preparedStatement.setString(1, toSave.getBookName());
            preparedStatement.setInt(2, toSave.getAuthor());
            preparedStatement.setInt(3, toSave.getPageNumbers());
            preparedStatement.setDate(4, Date.valueOf(toSave.getReleaseDate()));
            preparedStatement.setString(5, toSave.getTopic().name());
            preparedStatement.setBoolean(6, toSave.getAvailable());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public void delete(Book toDelete) {
        String sql= "delete from book where id= ? ;";

        try (Connection connection= databaseConfig.createConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(sql)
        ){
          preparedStatement.setInt(1, Integer.parseInt(toDelete.getId()));
          preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
