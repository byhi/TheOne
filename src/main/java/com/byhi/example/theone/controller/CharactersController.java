package com.byhi.example.theone.controller;

import com.byhi.example.theone.dto.CharacterDTO;
import com.byhi.example.theone.dto.CharactersDTO;
import com.byhi.example.theone.dto.QuotesDTO;
import com.byhi.example.theone.dto.SortingDTO;
import com.byhi.example.theone.handler.TheOneApiHandlerService;
import com.byhi.example.theone.service.TheOneApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CharactersController {

    @Autowired
    TheOneApiService theOneApiService;

    @Autowired
    TheOneApiHandlerService theOneApiHandlerService;

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

    @PostMapping("/character/search")
    public  CharactersDTO getSearchInCharacters(@RequestBody CharacterDTO characterDTO){
        return  this.theOneApiHandlerService.getNewCharactersDTOByArray(
                this.theOneApiHandlerService.findByCharacter(this.defaultTheOneApiCharacter.getDocs(), characterDTO));
    }

    @PostMapping("/character/sort")
    public  CharactersDTO geSortCharacters(@RequestBody SortingDTO<CharactersDTO> sortingData){
        return this.theOneApiHandlerService.sortCharacter(sortingData.getDtoData(), sortingData.getSortType(), sortingData.getFieldName());
    }

    @GetMapping("/character/sort={fieldName}:{sortType}")
    public  CharactersDTO geSortCharacters(@PathVariable String sortType, @PathVariable String fieldName){

        return this.theOneApiHandlerService.sortCharacter(this.defaultTheOneApiCharacter, sortType, fieldName);
    }

    @GetMapping("/character/{characterId}/quote")
    public QuotesDTO getAllCharacter(@PathVariable String characterId){
        return  this.theOneApiHandlerService.getNewQuotesDTOByArray(
                this.theOneApiHandlerService.getQuotesByCharacterId(this.defaultTheOneApiQuotes.getDocs(), characterId));
    }

    @GetMapping("/quote/all")
    public QuotesDTO getAllQuotes(){
        return this.defaultTheOneApiQuotes;
    }

}
