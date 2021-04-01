package com.byhi.example.theone.service;

import com.byhi.example.theone.dto.CharacterDTO;
import com.byhi.example.theone.dto.QuoteDTO;
import com.byhi.example.theone.dto.QuotesDTO;
import com.byhi.example.theone.modal.CharacterEntity;
import com.byhi.example.theone.modal.QuoteEntity;
import com.byhi.example.theone.repository.CharacterRepository;
import com.byhi.example.theone.repository.QuoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class QuoteService extends GenericPageableService<QuoteEntity, QuoteRepository>{

    static final int PAGE_MIN = 0;
    static final int PAGE_MAX = 10;

   /* @Autowired
    QuoteRepository quoteRepository;*/

    @Autowired
    CharacterRepository characterRepository;


    @Autowired
    protected QuoteRepository getRepo(QuoteRepository repo){
        return  super.repository = repo;
    }

    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    public List<QuoteEntity> convertAllDtoToEntity(QuotesDTO allQuote) {
        List<QuoteEntity> quoteEntities = new ArrayList<>();
        for (QuoteDTO quoteDTO : allQuote.getDocs()) {
            try {
                quoteEntities.add(this.convertToEntity(quoteDTO)) ;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return quoteEntities;
    }

    private QuoteEntity convertToEntity(QuoteDTO quoteDTO) throws ParseException {
        QuoteEntity quoteEntity = this.modelMapper().map(quoteDTO, QuoteEntity.class);
        Optional<CharacterEntity> characterEntityOptional = this.characterRepository.findCharacterEntitiesByApiId(quoteDTO.get_id());
        if (quoteDTO.get_id() != null) {
            quoteEntity.setApiId(quoteDTO.get_id());
            Optional<QuoteEntity> optionalQuoteEntity = super.repository.findQuoteEntitiesByApiId(quoteDTO.get_id());
            if (optionalQuoteEntity.isPresent()) {
                QuoteEntity oldQuote =  optionalQuoteEntity.get();
                quoteEntity.setApiId(oldQuote.getApiId());
                quoteEntity.setId(oldQuote.getId());
                quoteEntity.setCharacter(oldQuote.getCharacter());
                quoteEntity.setDialog(oldQuote.getDialog());
                quoteEntity.setMovie(oldQuote.getMovie());
                if (characterEntityOptional.isPresent()) quoteEntity.setCharacter_id(characterEntityOptional.get());


            }
        }
        return quoteEntity;
    }

    private QuoteDTO convertToDto(QuoteEntity quoteEntity) {
        QuoteDTO quoteDTO = this.modelMapper().map(quoteEntity, QuoteDTO.class);
        quoteDTO.set_id(quoteEntity.getApiId());
        return quoteDTO;
    }

    public Page<QuoteEntity> getCharactersQuotesById(String characterId) {
        Pageable sortedByPriceDescNameAsc = PageRequest.of(PAGE_MIN, PAGE_MAX);
        Page<QuoteEntity> quoteEntityPage = super.repository.findAllByCharacter(characterId, sortedByPriceDescNameAsc);
        return quoteEntityPage;
    }

    public void saveAll(List<QuoteEntity> convertAllDtoToEntity) {
        super.repository.saveAll(convertAllDtoToEntity);
    }

    @Override
    protected QuoteEntity findById(String id) {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    public List<QuoteDTO> findAll() {
        List<QuoteDTO> quoteDTOS = new ArrayList<>();
        Iterable<QuoteEntity> s = super.repository.findAll();
        Arrays.asList(s);
        s.forEach(quoteEntity -> {
            quoteDTOS.add(convertToDto(quoteEntity));
                }
        );
        return quoteDTOS;
    }

    public Page<QuoteEntity> getAllInPage() {
        Pageable sortedByPriceDescNameAsc = PageRequest.of(PAGE_MIN, PAGE_MAX);
        Page<QuoteEntity> characterEntityPage = super.repository.findAll(sortedByPriceDescNameAsc);
        return characterEntityPage;
    }

    public QuoteDTO getCharacterById(String id) {
        QuoteEntity res = this.findById(id);
        return res != null ? this.convertToDto(res): null;
    }

    public QuoteDTO updateById(QuoteDTO dto) {
        QuoteEntity quoteEntity = this.convertToEntityForUpdate(dto);
        quoteEntity =  super.repository.save(quoteEntity);
        dto = this.convertToDto(quoteEntity);

        return dto;
    }

    private QuoteEntity convertToEntityForUpdate(QuoteDTO dto) {
        QuoteEntity quoteEntity = this.modelMapper().map(dto, QuoteEntity.class);

        if (dto.get_id() != null) {
            quoteEntity.setApiId(dto.get_id());
            Optional<QuoteEntity> optionalQuoteEntity = super.repository.findQuoteEntitiesByApiId(dto.get_id());
            if (optionalQuoteEntity.isPresent()) {
                QuoteEntity oldQuote =  optionalQuoteEntity.get();
                quoteEntity.setId(oldQuote.getId());
               // quoteEntity.setDocs(oldQuote.getDocs());
            }
        }
        return quoteEntity;
    }

    public  Page<QuoteEntity> getAllInPageByParameters(String limit, String page, String offset, String sortType, String sortByFiled, String apiId, String dialog, String movie, String character) {
        Pageable pageable = this.getPageableByParams(limit, page,  offset,  sortType,  sortByFiled, CharacterEntity.class);
        Page<QuoteEntity> entityPage = null;
        if (this.isFilterable(apiId, dialog, movie, character)) {

            entityPage =  super.repository.
                    findAllByApiIdContainsAndDialogContainingAndMovieContainingAndCharacterContaining(
                            apiId, dialog, movie, character,  pageable);


        }else{
            entityPage =  super.repository.findAll(pageable);
        }

        return entityPage;
    }
}
