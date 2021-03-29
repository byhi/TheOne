package com.byhi.example.theone.service;

import com.byhi.example.theone.dto.CharactersDTO;
import com.byhi.example.theone.dto.QuotesDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@PropertySource("classpath:application.properties")
@Service
public class TheOneApiService {
    Logger logger = LoggerFactory.getLogger(TheOneApiService.class);

    @Autowired
    private Environment env;

    @Value( "${the-one-token}" )
    private String TOKEN;

    static final String BASE_URL= "https://the-one-api.dev/v2";
    static final String CHAR_URL= "/character";
    static final String QUOTE_URL= "/quote";

    WebClient client;

    public CharactersDTO getAllChartacter(){
        this.client = WebClient.create();
        Mono<CharactersDTO> charactersDTOMono = client.get()
                .uri(BASE_URL + CHAR_URL)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer "+ TOKEN)
                .retrieve()
                .bodyToMono(CharactersDTO.class);
        CharactersDTO readers = charactersDTOMono.block();
        return  readers;
    }

    public QuotesDTO getAllQuote(){
        this.client = WebClient.create();
        Mono<QuotesDTO> charactersDTOMono = client.get()
                .uri(BASE_URL + QUOTE_URL)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer "+ TOKEN)
                .retrieve()
                .bodyToMono(QuotesDTO.class);
        QuotesDTO readers = charactersDTOMono.block();
        return  readers;
    }


}
