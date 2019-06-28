package com.example.QuoteApi.Controller;
import com.example.QuoteApi.Model.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Random;

@RestController
public class MagicController {

    String[] answerArr = {

            "It is certain",
            "It is decidedly so",
            "Without a doubt",
            "Yes - definitely",
            "You may rely on it",
            "As I see it, yes",
            "Most likely",
            "Outlook good",
            "Signs point to yes",
            "Yes"
                        };

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Answer magicBall(@RequestBody @Valid Answer answer){



        Random r = new Random();
        answer.setAnswer(answerArr[r.nextInt(10)]);


        return answer;
    }

}
