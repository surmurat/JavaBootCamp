package com.example.MuratSurenlerU1Capstone.controller;


import com.example.MuratSurenlerU1Capstone.servicelayer.ServiceLayer;
import com.example.MuratSurenlerU1Capstone.viewmodel.ConsoleViewModel;
import com.example.MuratSurenlerU1Capstone.viewmodel.InvoiceViewModel;
import com.example.MuratSurenlerU1Capstone.viewmodel.PurchasingViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class InvoiceController {

    @Autowired
    ServiceLayer serviceLayer;


    @PostMapping//Another way to set the Rest API Post mapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createInvoices(@RequestBody @Valid PurchasingViewModel invoices) {
        return serviceLayer.saveInvoice(invoices);
    }


}
