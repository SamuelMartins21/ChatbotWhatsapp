package com.whatsappstonksbot.bot.controllers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.whatsappstonksbot.bot.Price;
import com.whatsappstonksbot.bot.services.FinnhubService;

@RestController
public class MessagingController {
    private final Set<String> repeatCallers = Collections.synchronizedSet(new HashSet<>());

    @PostMapping(path = "/messages", produces = "text/plain")
    public String service(@RequestParam("From") String fromNumber,
            @RequestParam("Body") String symbol) {

        if (repeatCallers.add(fromNumber)) {
            return "Bem-vindo ao Stonksbot \uD83D\uDCC8. Envie-me um símbolo de ticker válido e eu lhe fornecerei dados de cotação.";
        }
        
        Optional<Price> price = FinnhubService.getStockDetails(symbol);

        if (price.isPresent()) {
            return messageBuilder(price.get(), symbol);
        } else {
            return "Desculpe não conseguimos encontrar nenhuma informação sobre esse. Tente outro.";
        }
    }

    private String messageBuilder(Price price, String symbol) {
        return String.format("Aqui estão os preços mais atualizados de %s:\n" +
                "\uD83C\uDF05 Preço de abertura do dia: $%s\n" +
                "\uD83D\uDCC8 Preço mais alto do dia: $%s\n" +
                "\uD83D\uDCC9 Preço mais baixo do dia: $%s\n" +
                "\uD83D\uDD14 Preço atual: $%s\n" +
                "\uD83D\uDCC6 Preço de fechamento anterior: $%s\n" +
                "\uD83E\uDD1E Envie outro símbolo.",
                symbol.toUpperCase(), price.open, price.high, price.low, price.current, price.close);
    }
}
