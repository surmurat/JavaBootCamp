package com.example.MuratSurenlerU1M5Summative.dao;

import com.example.MuratSurenlerU1M5Summative.model.Author;

import java.util.List;

public interface AuthorDao {

    Author getAuthor(int id);

    List<Author> getAllAuthors();

    Author addAuthor(Author author);

    void updateAuthor(Author author);

    void deleteAuthor(int id);


}
