package com.example.MuratSurenlerU1Capstone.Dao;

import com.example.MuratSurenlerU1Capstone.Model.Invoice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static java.math.RoundingMode.HALF_UP;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    InvoiceDao dao;

    @Autowired
    SalesTaxDao salesTaxDao;

    @Before
    public void setUp() throws Exception {
        List<Invoice> invoiceList = dao.getAllInvoices();
            invoiceList.stream()
                    .forEach(invoice -> {
                        dao.deleteInvoice(invoice.getId());
                    });
    }

    @After
    public void tearDown() throws Exception {
        List<Invoice> invoiceList = dao.getAllInvoices();
        invoiceList.stream()
                .forEach(invoice -> {
                    dao.deleteInvoice(invoice.getId());
                });
    }

    @Test
    public void addGetDeleteInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("joe");
        invoice.setStreet("eight");
        invoice.setCity("union");
        invoice.setState("NJ");
        invoice.setZipCode("07087");
        invoice.setItemType("game");
        invoice.setItemId(invoice.getId());
        invoice.setUnitPrice(new BigDecimal(4.55).setScale(2, HALF_UP));
        invoice.setQuantity(33);
        invoice.setSubTotal(new BigDecimal(12.22).setScale(2, HALF_UP));
        invoice.setTax(new BigDecimal(3.44).setScale(2, HALF_UP));
        invoice.setProcessingFee(new BigDecimal(6.78).setScale(2, HALF_UP));
        invoice.setTotal(new BigDecimal(2.55).setScale(2, HALF_UP));

        invoice = dao.addInvoice(invoice);

        Invoice invoice1 = dao.getInvoice(invoice.getId());
        assertEquals(invoice1,invoice);

        dao.deleteInvoice(invoice.getId());
        invoice1 = dao.getInvoice(invoice.getId());

        assertNull(invoice1);
    }



    @Test
    public void getAllInvoices() {
        Invoice invoice = new Invoice();
        invoice.setName("joe");
        invoice.setStreet("eight");
        invoice.setCity("union");
        invoice.setState("NJ");
        invoice.setZipCode("07087");
        invoice.setItemType("game");
        invoice.setItemId(invoice.getId());
        invoice.setUnitPrice(new BigDecimal(4.55).setScale(2, HALF_UP));
        invoice.setQuantity(33);
        invoice.setSubTotal(new BigDecimal(12.22).setScale(2, HALF_UP));
        invoice.setTax(new BigDecimal(3.44).setScale(2, HALF_UP));
        invoice.setProcessingFee(new BigDecimal(6.78).setScale(2, HALF_UP));
        invoice.setTotal(new BigDecimal(2.55).setScale(2, HALF_UP));

        invoice = dao.addInvoice(invoice);

        List<Invoice> invoiceList = dao.getAllInvoices();
        assertEquals(invoiceList.size(),1);


    }

    @Test
    public void updateInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("joe");
        invoice.setStreet("eight");
        invoice.setCity("union");
        invoice.setState("NJ");
        invoice.setZipCode("07087");
        invoice.setItemType("game");
        invoice.setItemId(invoice.getId());
        invoice.setUnitPrice(new BigDecimal(4.55).setScale(2, HALF_UP));
        invoice.setQuantity(33);
        invoice.setSubTotal(new BigDecimal(12.22).setScale(2, HALF_UP));
        invoice.setTax(new BigDecimal(3.44).setScale(2, HALF_UP));
        invoice.setProcessingFee(new BigDecimal(6.78).setScale(2, HALF_UP));
        invoice.setTotal(new BigDecimal(2.55).setScale(2, HALF_UP));

        invoice = dao.addInvoice(invoice);

        invoice.setName("mark");
        invoice.setStreet("fifth");
        dao.updateInvoice(invoice);

        Invoice invoice2 = dao.getInvoice(invoice.getId());
        assertEquals(invoice2,invoice);
    }


}