package com.example.MuratSurenlerU1M5Summative.dao;

import com.example.MuratSurenlerU1M5Summative.model.Author;
import com.example.MuratSurenlerU1M5Summative.model.Book;
import com.example.MuratSurenlerU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTest {
    @Autowired
    AuthorDao authorDao;

    @Autowired
    BookDao bookDao;

    @Autowired
    PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {

        List<Book> bookList = bookDao.getAllBooks();
        for(Book b : bookList){
            bookDao.deleteBook(b.getId());
        }

        List<Author> authorList = authorDao.getAllAuthors();
        for (Author a : authorList) {
            authorDao.deleteAuthor(a.getId());
        }
        List<Publisher> publisherList = publisherDao.getAllPublishers();
        for(Publisher p : publisherList){
            publisherDao.deletePublisher(p.getId());
        }
    }

    @Test
    public void addGetAndDeleteBook() {
        Author author = new Author("Jack","London","327 eight street","Union", "NJ","06067","6462800500","jacklondon@gmail.com");
        author = authorDao.addAuthor(author);

        Publisher publisher = new Publisher("Murat","327 eight street","Union","NJ","07087","34755266","murat@publishers.com");
        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book("45328383", LocalDate.of(2014, 02, 02),author.getId(),"Bloomdale", publisher.getId(), 2.0);
        book = bookDao.addBook(book);

        Book book1 = bookDao.getBook(book.getId());

        assertEquals(book, book1);

        bookDao.deleteBook(book.getId());

        book1 = bookDao.getBook(book.getId());

        assertNull(book1);

    }

    @Test(expected = DataIntegrityViolationException.class)
    public void addWithRefIntegrityException(){
        Book book = new Book("7477399",LocalDate.of(2012, 04, 20),45,"Hello", 345, 2.0);
        book = bookDao.addBook(book);
    }

    @Test
    public void getAllBooks() {
        Author author = new Author("Jack","London","327 eight street","Union", "NJ","06067","6462800500","jacklondon@gmail.com");
        author = authorDao.addAuthor(author);

        Publisher publisher = new Publisher("Murat","327 eight street","Union","NJ","07087","34755266","murat@publishers.com");
        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book("45328383", LocalDate.of(2014, 02, 02),author.getId(),"Bloomdale", publisher.getId(), 2.0);
        book = bookDao.addBook(book);

        List<Book> bookList = bookDao.getAllBooks();

        assertEquals(bookList.size(), 1);

    }

    @Test
    public void updateBook() {
        Author author = new Author("Jack","London","327 eight street","Union", "NJ","06067","6462800500","jacklondon@gmail.com");
        author = authorDao.addAuthor(author);

        Publisher publisher = new Publisher("Murat","327 eight street","Union","NJ","07087","34755266","murat@publishers.com");
        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book("45328383", LocalDate.of(2014, 02, 02),author.getId(),"Bloomdale", publisher.getId(), 2.0);
        book = bookDao.addBook(book);
        book.setIsbn("5939494");
        book.setPrice(3.45);
        bookDao.updateBook(book);

        Book book1 = bookDao.getBook(book.getId());

        assertEquals(book, book1);

    }

    @Test
    public void findBookByAuthor() {
        Author author = new Author("Jack","London","327 eight street","Union", "NJ","06067","6462800500","jacklondon@gmail.com");
        author = authorDao.addAuthor(author);

        Publisher publisher = new Publisher("Murat","327 eight street","Union","NJ","07087","34755266","murat@publishers.com");
        publisher = publisherDao.addPublisher(publisher);

        Book book = new Book("45328383", LocalDate.of(2014, 02, 02),author.getId(),"Bloomdale", publisher.getId(), 2.0);
        book = bookDao.addBook(book);

        List<Book> bookList = bookDao.getBooksByAuthor(author.getId());

        assertEquals(bookList.get(0), book);
    }
}