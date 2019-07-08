package com.example.MuratSurenlerU1M5Summative.dao;

import com.example.MuratSurenlerU1M5Summative.model.Author;
import com.example.MuratSurenlerU1M5Summative.model.Book;
import com.example.MuratSurenlerU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoTest {

    @Autowired
    AuthorDao authorDao;



    @Before
    public void setUp() throws Exception {
        List<Author> authorList = authorDao.getAllAuthors();
        for (Author a : authorList) {
            authorDao.deleteAuthor(a.getId());
        }


    }

    @Test
    public void addGetAndDeleteAuthor() {
        Author author = new Author("Jack", "London", "327 eight street", "Union", "NJ", "06067", "6462800500", "jack@gmail.com");
        author = authorDao.addAuthor(author);

        Author author1 = authorDao.getAuthor(author.getId());

        assertEquals(author, author1);

        authorDao.deleteAuthor(author.getId());
        author1 = authorDao.getAuthor(author.getId());
        assertNull(author1);

    }

    @Test
    public void getAllAuthors() {
        Author author = new Author("Jack", "London", "327 eight street", "Union", "NJ", "06067", "6462800500", "jack@gmail.com");
        author = authorDao.addAuthor(author);

        List<Author> authorList = authorDao.getAllAuthors();

        assertEquals(authorList.size(), 1);

    }

    @Test
    public void updateAuthor() {
        Author author = new Author("Jack", "London", "327 eight street", "Union", "NJ", "06067", "6462800500", "jack@gmail.com");
        author = authorDao.addAuthor(author);
        author.setFirstName("James");
        author.setLastName("Dean");

        authorDao.updateAuthor(author);

        Author author1 = authorDao.getAuthor(author.getId());

        assertEquals(author, author1);

    }
}