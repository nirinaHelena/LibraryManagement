package com.libraryManagement.repository;

import com.libraryManagement.model.Book;
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
                String topic= resultSet.getString("topic");
                Boolean available= resultSet.getBoolean("available");

                Book book= new Book(id, bookName, author,
                        pageNumbers,topic, releaseDate, available);
                allBook.add(book);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return allBook;
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) {
        return null;
    }

    @Override
    public Book save(Book toSave) {
        String sql= "insert into book (bookName, author, pageNumbers," +
                "releaseDate, topic, available) values (?, ?, ?, ?, ?, ?) ;";

        try (Connection connection= databaseConfig.createConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ){
            preparedStatement.setString(1, toSave.getBookName());
            preparedStatement.setInt(2, toSave.getAuthor());
            preparedStatement.setInt(3, toSave.getPageNumbers());
            preparedStatement.setDate(4, Date.valueOf(toSave.getReleaseDate()));
            preparedStatement.setString(5, toSave.getTopic());
            preparedStatement.setBoolean(6, toSave.getAvailable());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public void delete(Book toDelete) {

    }
}
