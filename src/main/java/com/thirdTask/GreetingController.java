package com.thirdTask;

import com.thirdTask.domain.Message;
import com.thirdTask.repos.MessageRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.util.resources.cldr.mas.CurrencyNames_mas;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private MessageRep messageRep;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                           Map<String,Object> model)
    {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String,Object > model)
    {
        Iterable<Message>messages = messageRep.findAll();
        model.put("messages",messages);//Input all
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model)
    {
        Message message = new Message(text,tag);
        messageRep.save(message); //save to Db

        Iterable<Message> messages = messageRep.findAll();

        model.put("messages",messages);

        return "redirect:/main";
    }
}