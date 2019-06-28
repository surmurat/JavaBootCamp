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
public class WordController {

    String[] wordArr = {
            "Articulate",
            "Bandwidth",
            "Interface",
            "Server",
            "Byte",
            "Data",
            "Output",
            "Application",
            "Computer",
            "Keyboard"
    };

    String[] defArr = {
            "Expressing oneself readily, clearly, and effectively.",
            "A range within a band of wavelengths, frequencies, or energies.",
            "The place at which independent and often unrelated systems meet and act on or communicate with each other.",
            "A computer in a network that is used to provide services to other computers in the network.",
            "A unit of computer information or data-storage capacity that consists of a group of eight bits and that is used especially to represent an alphanumeric character.",
            "Information in digital form that can be transmitted or processed.",
            "The information produced by a computer.",
            "A program that performs a particular task or set of tasks.",
            "A programmable usually electronic device that can store, retrieve, and process data.",
            "A group of systematically arranged keys by which a machine or device is operated."
    };

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Word generateAWord(){


        Word word = new Word();
        Random rnd = new Random();
        int random = rnd.nextInt(10);
        word.setDefinition(defArr[random]);

        word.setWord(wordArr[random]);


        return word;
    }
}

