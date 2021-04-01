package com.byhi.example.theone.handler;

import com.byhi.example.theone.dto.CharacterDTO;
import com.byhi.example.theone.dto.CharactersDTO;
import com.byhi.example.theone.dto.QuoteDTO;
import com.byhi.example.theone.dto.QuotesDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TheOneApiHandlerService {

    public QuoteDTO[] convertQuoteListToArray( List<QuoteDTO> dtoList) {
        return dtoList.toArray(new QuoteDTO[dtoList.size()]);
    }

    public CharacterDTO[] convertCharacterListToArray( List<CharacterDTO> dtoList) {
        return dtoList.toArray(new CharacterDTO[dtoList.size()]);
    }

    public QuotesDTO getNewQuotesDTOByArray(QuoteDTO[] quoteDTO) {
        QuotesDTO quotesDTO = new QuotesDTO();
        quotesDTO.setDocs(quoteDTO);
        quotesDTO.setTotal( String.valueOf(quoteDTO.length));
        quotesDTO.setLimit("1000");
        quotesDTO.setOffset("0");
        quotesDTO.setPage("1");
        quotesDTO.setPages("1");
        return quotesDTO;
    }

    public CharactersDTO getNewCharactersDTOByArray(CharacterDTO[] characterDTO) {
        CharactersDTO charactersDTO = new CharactersDTO();
        charactersDTO.setDocs(characterDTO);
        charactersDTO.setTotal( String.valueOf(characterDTO.length));
        charactersDTO.setLimit("1000");
        charactersDTO.setOffset("0");
        charactersDTO.setPage("1");
        charactersDTO.setPages("1");
        return charactersDTO;
    }

}
