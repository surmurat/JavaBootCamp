package com.example.QuoteApi.Model;

import javax.validation.constraints.NotEmpty;

public class Quote {

    private int id;
    @NotEmpty(message = "Please enter an author name")
    private String author;
    @NotEmpty(message = "Please pick an quote")
    private String quote;





    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }


}
