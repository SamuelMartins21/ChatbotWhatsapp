package com.whatsappstonksbot.bot.controllers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class MessagingController {
    private final Set<String> repeatCallers = Collections.synchronizedSet(new HashSet<>());

   @PostMapping(path="/messages", produces = "text/plain")
   public String service(@RequestParam("From") String fromNumber,
                        @RequestParam("Body") String symbol) {

      if (repeatCallers.add(fromNumber)){
           return "Welcome to stonksbot \uD83D\uDCC8. Text me a valid ticker symbol and I'll give you quote data.";
       }
       return "We've heard from you.";
   }
}
