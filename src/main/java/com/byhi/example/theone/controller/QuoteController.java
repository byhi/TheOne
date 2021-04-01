package com.byhi.example.theone.controller;

import com.byhi.example.theone.dto.CharacterDTO;
import com.byhi.example.theone.dto.QuoteDTO;
import com.byhi.example.theone.modal.CharacterEntity;
import com.byhi.example.theone.modal.QuoteEntity;
import com.byhi.example.theone.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quote")
public class QuoteController {

    @Autowired
    QuoteService quoteService;

    @GetMapping("/{id}")
    public QuoteDTO getQuote(@PathVariable String id){
        return this.quoteService.getCharacterById(id);
    }

    @PutMapping
    public QuoteDTO updateQuote(@RequestBody QuoteDTO dto ){
        return this.quoteService.updateById(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteQuote(@PathVariable String id ){
        this.quoteService.deleteById(id);
    }



    @GetMapping("/params")
    public Page<QuoteEntity> getQuoteByParameters(
            @RequestParam(name = "limit", defaultValue = "", required = false) String limit,
            @RequestParam(name = "page", defaultValue = "", required = false) String page,
            // @RequestParam(name = "offset", defaultValue = "", required = false) String offset,
            @RequestParam(name = "sortType", defaultValue = "", required = false) String sortType,
            @RequestParam(name = "sortByFiled", defaultValue = "", required = false) String sortByFiled,

            @RequestParam(name = "apiId", defaultValue = "", required = false) String apiId,
            @RequestParam(name = "dialog", defaultValue = "", required = false) String dialog,
            @RequestParam(name = "movie", defaultValue = "", required = false) String movie,
            @RequestParam(name = "character", defaultValue = "", required = false) String  character
    ){

        return this.quoteService.getAllInPageByParameters(limit,page,"",sortType,sortByFiled,apiId, dialog, movie, character);
    }

    @GetMapping("/{characterId}/quote")
    public Page<QuoteEntity> getQuotesByCharacterId(@PathVariable String characterId){
        return this.quoteService.getCharactersQuotesById(characterId);
    }

    @GetMapping("/quote/all")
    public  Page<QuoteEntity> getAllQuotesInPage(){
        return this.quoteService.getAllInPage();
    }

}
