package com.byhi.example.theone.handler;

import com.byhi.example.theone.dto.CharacterDTO;
import com.byhi.example.theone.dto.CharactersDTO;
import com.byhi.example.theone.dto.QuoteDTO;
import com.byhi.example.theone.dto.QuotesDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TheOneApiHandlerService {
    public QuoteDTO[] getQuotesByCharacterId(QuoteDTO[] quoteDTOS, String id) {
        List<QuoteDTO> resultList = Arrays.asList(quoteDTOS).stream()
                .filter(quote -> id.equals(quote.getCharacter())).collect(Collectors.toList());

        return resultList.toArray(new QuoteDTO[resultList.size()]);
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

    public CharacterDTO[] findByCharacter(CharacterDTO[] quoteDTOS, CharacterDTO characterDTO) {
        List<Predicate<CharacterDTO>> predicateList = this.getCharactersPredicates( characterDTO );
        List<CharacterDTO> resultList = new ArrayList<>();
        resultList =  Arrays.asList(quoteDTOS).stream()
                .filter(predicateList.stream().reduce(x->true, Predicate::and))
                .collect(Collectors.toList());

        return resultList.toArray(new CharacterDTO[resultList.size()]);
    }

    public CharactersDTO sortCharacter(CharactersDTO charactersDTO, String sortType, String fieldName) {
        List<CharacterDTO> resultList =  Arrays.asList(charactersDTO.getDocs());

        Comparator<CharacterDTO> characterDTOComparator =  this.getComparator(CharacterDTO.class, fieldName);
        if (characterDTOComparator != null) {
            if (sortType.equals("desc")) {
                Collections.sort( resultList,characterDTOComparator.reversed());
            }else{
                Collections.sort( resultList,characterDTOComparator);
            }
            charactersDTO.setDocs(resultList.toArray(new CharacterDTO[resultList.size()]));
        }

        return charactersDTO;
    }

    private Comparator<CharacterDTO> getComparator(Class<CharacterDTO> characterDTOClass, String fieldName) {
        if (fieldName.equals("_id"))return Comparator.comparing(CharacterDTO::get_id);
        if (fieldName.equals("height"))return Comparator.comparing(CharacterDTO::getHeight);
        if (fieldName.equals("race")) return  Comparator.comparing(CharacterDTO::getRace);
        if (fieldName.equals("gender")) return   Comparator.comparing(CharacterDTO::getGender);
        if (fieldName.equals("birth")) return   Comparator.comparing(CharacterDTO::getBirth);
        if (fieldName.equals("spouse")) return   Comparator.comparing(CharacterDTO::getSpouse);
        if (fieldName.equals("death")) return   Comparator.comparing(CharacterDTO::getDeath);
        if (fieldName.equals("realm")) return   Comparator.comparing(CharacterDTO::getRealm);
        if (fieldName.equals("hair")) return   Comparator.comparing(CharacterDTO::getHair);
        if (fieldName.equals("name")) return   Comparator.comparing(CharacterDTO::getName);
        if (fieldName.equals("wikiUrl")) return   Comparator.comparing(CharacterDTO::getWikiUrl);


        return null;
    }

    private List<Predicate<CharacterDTO>> getCharactersPredicates( CharacterDTO characterDTO ){
        List<Predicate<CharacterDTO>> allPredicates = new ArrayList<Predicate<CharacterDTO>>();
        if(isValid(characterDTO.getBirth()))
        allPredicates.add(str -> str.getBirth().contains(characterDTO.getBirth()));
        if(isValid(characterDTO.getDeath()))
        allPredicates.add(str -> str.getDeath().contains(characterDTO.getDeath()));
        if(isValid(characterDTO.getGender()))
        allPredicates.add(str -> str.getGender().contains(characterDTO.getGender()));
        if(isValid(characterDTO.getHair()))
        allPredicates.add(str -> str.getHair().contains(characterDTO.getHair()));
        if(isValid(characterDTO.getHeight()))
        allPredicates.add(str -> str.getHeight().contains(characterDTO.getHeight()));
        if(isValid(characterDTO.getName()))
        allPredicates.add(str -> str.getName().contains(characterDTO.getName()));
        if(isValid(characterDTO.getRace()))
        allPredicates.add(str -> str.getRace().contains(characterDTO.getRace()));
        if(isValid(characterDTO.getRealm()))
        allPredicates.add(str -> str.getRealm().contains(characterDTO.getRealm()));
        if(isValid(characterDTO.getSpouse()))
        allPredicates.add(str -> str.getSpouse().contains(characterDTO.getSpouse()));
        if(isValid(characterDTO.getWikiUrl()))
        allPredicates.add(str -> str.getWikiUrl().contains(characterDTO.getWikiUrl()));

        return allPredicates;

    }
    private boolean isValid(String value){
        if ( value!= null ) {
            if ( !value.equals("")) {
                return true;
            }
        }
        return false;
    }
}
