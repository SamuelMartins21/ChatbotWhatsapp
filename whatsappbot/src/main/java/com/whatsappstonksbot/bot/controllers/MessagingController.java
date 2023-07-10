package com.whatsappstonksbot.bot.controllers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagingController {
    private final Set<String> repeatCallers = Collections.synchronizedSet(new HashSet<>());

   @PostMapping(path="/messages", produces = "text/plain")
   public String service(@RequestParam("From") String fromNumber,
                        @RequestParam("Body") String symbol) {

      if (repeatCallers.add(fromNumber)){
           return "Bem-vindo ao Stonksbot \uD83D\uDCC8. Envie-me um símbolo de ticker válido e eu lhe fornecerei dados de cotação.";
       }
       return "Nós ouvimos você";
   }
}
