package com.example.QuoteApi.Controller;


import com.example.QuoteApi.Model.Quote;
import com.example.QuoteApi.Model.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class QuoteController {

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Quote quoteList(){

        String[] authorArr = {
                "Mark Twain",
                "Pablo Picasso",
                "Buddha",
                "Leonardo da Vinci",
                "Shakespeare",
                "Thomas Edison",
                "Albert Einstein",
                "Confucius",
                "Benjamin Franklin",
                "Francis Bacon"
        };

        String[] quoteArr = {
                "Never regret anything that made you smile.",
                "Everything you can imagine is real.",
                "What we think, we become.",
                "Simplicity is the ultimate sophistication.",
                "When words fail, music speaks.",
                "There is no substitute for hard work.",
                "Only a life lived for others is a life worthwhile.",
                "Life is really simple, but we insist on making it complicated.",
                "Well done is better than well said.",
                "Knowledge is power."
        };

        Quote quote = new Quote();
        Random rnd = new Random();
        int random = rnd.nextInt(10);
        quote.setAuthor(authorArr[random]);

        quote.setQuote(quoteArr[random]);


        return quote;

    }
}
