package com.byhi.example.theone.controller;

import com.byhi.example.theone.dto.CharacterDTO;
import com.byhi.example.theone.dto.CharactersDTO;
import com.byhi.example.theone.dto.QuotesDTO;
import com.byhi.example.theone.dto.SortingDTO;
import com.byhi.example.theone.handler.TheOneApiHandlerService;
import com.byhi.example.theone.modal.CharacterEntity;
import com.byhi.example.theone.modal.QuoteEntity;
import com.byhi.example.theone.service.CharacterService;
import com.byhi.example.theone.service.QuoteService;
import com.byhi.example.theone.service.TheOneApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/character")
public class CharactersController {

    @Autowired
    TheOneApiService theOneApiService;

    @Autowired
    TheOneApiHandlerService theOneApiHandlerService;

    @Autowired
    CharacterService characterService;

    @Autowired
    QuoteService quoteService;

    CharactersDTO defaultTheOneApiCharacter;
    QuotesDTO defaultTheOneApiQuotes;


    @Autowired
    public void initDefaultTheOneApi(){
        this.characterService.saveAll(
                this.characterService.convertAllDtoToEntity(this.theOneApiService.getAllChartacter()));
        this.quoteService.saveAll(
                this.quoteService.convertAllDtoToEntity(this.theOneApiService.getAllQuote()));

        this.defaultTheOneApiCharacter =
                this.theOneApiHandlerService.getNewCharactersDTOByArray(
                        this.theOneApiHandlerService.convertCharacterListToArray(this.characterService.findAll()));

        this.defaultTheOneApiQuotes =
                this.theOneApiHandlerService.getNewQuotesDTOByArray(
                        this.theOneApiHandlerService.convertQuoteListToArray(this.quoteService.findAll()));
    }

    @GetMapping("/{id}")
    public CharacterDTO getCharacter( @PathVariable String id){
        return this.characterService.getCharacterById(id);
    }

    @PutMapping
    public CharacterDTO updateCharacter(@RequestBody CharacterDTO characterDTO ){
        return this.characterService.updateById(characterDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable String id ){
         this.characterService.deleteById(id);
    }



    @GetMapping("/params")
    public Page<CharacterEntity> getCharacterByParameters(
            @RequestParam(name = "limit", defaultValue = "", required = false) String limit,
            @RequestParam(name = "page", defaultValue = "", required = false) String page,
           // @RequestParam(name = "offset", defaultValue = "", required = false) String offset,
            @RequestParam(name = "sortType", defaultValue = "", required = false) String sortType,
            @RequestParam(name = "sortByFiled", defaultValue = "", required = false) String sortByFiled,

            @RequestParam(name = "name", defaultValue = "", required = false) String name,
            @RequestParam(name = "race", defaultValue = "", required = false) String race,

            @RequestParam(name = "id", defaultValue = "", required = false) String  apiId,
            @RequestParam(name = "height", defaultValue = "", required = false) String  height,
            @RequestParam(name = "gender", defaultValue = "", required = false) String  gender,
            @RequestParam(name = "birth", defaultValue = "", required = false) String  birth,
            @RequestParam(name = "spouse", defaultValue = "", required = false) String  spouse,
            @RequestParam(name = "death", defaultValue = "", required = false) String  death,
            @RequestParam(name = "realm", defaultValue = "", required = false) String  realm,
            @RequestParam(name = "hair", defaultValue = "", required = false) String  hair,
            @RequestParam(name = "wikiUrl", defaultValue = "", required = false) String   wikiUrl


            ){

        return this.characterService.getAllInPageByParameters(limit,page,"",sortType,sortByFiled,name,race,
                apiId,height,gender,birth,spouse,death,realm,hair,wikiUrl);
    }

    @GetMapping("/{characterId}/quote")
    public Page<QuoteEntity> getCharactersQuotes(@PathVariable String characterId){
        return this.quoteService.getCharactersQuotesById(characterId);
    }

    @GetMapping("/quote/all")
    public  Page<QuoteEntity> getAllQuotesInPage(){
        return this.quoteService.getAllInPage();
    }

}
