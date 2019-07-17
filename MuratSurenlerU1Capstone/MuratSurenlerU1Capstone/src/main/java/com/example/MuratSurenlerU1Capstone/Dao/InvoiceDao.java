package com.example.MuratSurenlerU1Capstone.Dao;

import com.example.MuratSurenlerU1Capstone.Model.Invoice;
import java.util.List;

public interface InvoiceDao {


    Invoice addInvoice(Invoice invoice);

    Invoice getInvoice(int id);

    List<Invoice> getAllInvoices();

    void updateInvoice(Invoice invoice);

    void deleteInvoice(int id);

}
