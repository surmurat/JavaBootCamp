package com.example.MuratSurenlerU1M5Summative.dao;



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
public class PublisherDaoTest {


    @Autowired
    PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {


        List<Publisher> pList = publisherDao.getAllPublishers();

        for (Publisher p : pList) {
            publisherDao.deletePublisher(p.getId());
        }
    }

    @Test
    public void addGetAndDeletePublisher() {
        Publisher publisher = new Publisher("Murat","327 eight street","Union","NJ","07087","34755266","murat@publishers.com");
        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getId());

        assertEquals(publisher, publisher1);

        publisherDao.deletePublisher(publisher.getId());

        publisher1 = publisherDao.getPublisher(publisher.getId());

        assertNull(publisher1);

    }

    @Test
    public void getAllPublishers() {
        Publisher publisher = new Publisher("Murat","327 eight street","Union","NJ","07087","34755266","murat@publishers.com");
        publisher = publisherDao.addPublisher(publisher);

        List<Publisher> publisherList = publisherDao.getAllPublishers();

        assertEquals(publisherList.size(), 1);
    }



    @Test
    public void updatePublisher() {
        Publisher publisher = new Publisher("Murat","327 eight street","Union","NJ","07087","34755266","murat@publishers.com");
        publisher = publisherDao.addPublisher(publisher);

        publisher.setCity("Columbia");
        publisher.setState("MO");

        publisherDao.updatePublisher(publisher);

        Publisher publisher1 = publisherDao.getPublisher(publisher.getId());

        assertEquals(publisher1, publisher);
    }


}