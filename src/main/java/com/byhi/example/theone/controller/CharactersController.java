package com.byhi.example.theone.controller;

import com.byhi.example.theone.dto.CharacterDTO;
import com.byhi.example.theone.dto.CharactersDTO;
import com.byhi.example.theone.dto.QuotesDTO;
import com.byhi.example.theone.handler.TheOneApiHandler;
import com.byhi.example.theone.service.TheOneApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CharactersController {

    @Autowired
    TheOneApiService theOneApiService;

    CharactersDTO defaultTheOneApiCharacter;
    QuotesDTO defaultTheOneApiQuotes;

    @Autowired
    public void setDefaultTheOneApiCharacter(){
        this.defaultTheOneApiCharacter = this.theOneApiService.getAllChartacter();
    }

    @Autowired
    public void setDefaultTheOneApiQuotes(){
        this.defaultTheOneApiQuotes = this.theOneApiService.getAllQuote();
    }

    @GetMapping("/character/all")
    public CharactersDTO getAllCharacter(){
        return this.defaultTheOneApiCharacter;
    }

    @PostMapping("/character/all")
    public  CharactersDTO getSearchInCharacters(@RequestBody CharacterDTO characterDTO){
        TheOneApiHandler theOneApiHandler = new TheOneApiHandler();
        return theOneApiHandler.getNewCharactersDTOByArray(theOneApiHandler.findByCharacter(this.defaultTheOneApiCharacter.getDocs(), characterDTO));
    }

    @GetMapping("/character/{characterId}/quote")
    public QuotesDTO getAllCharacter(@PathVariable String characterId){
        TheOneApiHandler theOneApiHandler = new TheOneApiHandler();
        return theOneApiHandler.getNewQuotesDTOByArray(theOneApiHandler.getQuotesByCharacterId(this.defaultTheOneApiQuotes.getDocs(), characterId));
    }

    @GetMapping("/quote/all")
    public QuotesDTO getAllQuotes(){
        return this.defaultTheOneApiQuotes;
    }

}
