package com.byhi.example.theone.service;

import com.byhi.example.theone.dto.CharacterDTO;
import com.byhi.example.theone.dto.CharactersDTO;
import com.byhi.example.theone.modal.CharacterEntity;;
import com.byhi.example.theone.repository.CharacterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CharacterService extends GenericPageableService<CharacterEntity, CharacterRepository>{

    @Autowired
    protected CharacterRepository getRepo(CharacterRepository repo){
        return  super.repository = repo;
    }


    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public List<CharacterEntity> convertAllDtoToEntity(CharactersDTO allChartacter) {
        List<CharacterEntity> charactersEntity = new ArrayList<>();
        for (CharacterDTO characterDTO : allChartacter.getDocs()) {
                charactersEntity.add(this.convertToEntity(characterDTO)) ;
        }
       return charactersEntity;
    }

    public List<CharacterDTO> findAll() {
        List<CharacterDTO> characterDTOS = new ArrayList<>();
        Iterable<CharacterEntity> s =  super.repository.findAll();
        Arrays.asList(s);
        s.forEach(characterEntity -> {
            characterDTOS.add(convertToDto(characterEntity));
                }
        );
        return characterDTOS;
    }


    private CharacterEntity convertToEntity(CharacterDTO characterDTO) {

        characterDTO = this.exchangeEmpityStringToNaN(characterDTO);
        CharacterEntity charactersEntity = this.modelMapper().map(characterDTO, CharacterEntity.class);

        if (characterDTO.get_id() != null) {
            charactersEntity.setApiId(characterDTO.get_id());
            Optional<CharacterEntity> optionalCharacterEntity =  super.repository.findCharacterEntitiesByApiId(characterDTO.get_id());
            if (optionalCharacterEntity.isPresent()) {
                CharacterEntity oldCharacter =  optionalCharacterEntity.get();
                charactersEntity.setId(oldCharacter.getId());
                charactersEntity.setBirth(oldCharacter.getBirth());
                charactersEntity.setBirth(oldCharacter.getBirth());
                charactersEntity.setDeath(oldCharacter.getDeath());
                charactersEntity.setGender(oldCharacter.getGender());
                charactersEntity.setHair(oldCharacter.getHair());
                charactersEntity.setHeight(oldCharacter.getHeight());
                charactersEntity.setName(oldCharacter.getName());
                charactersEntity.setRace(oldCharacter.getRace());
                charactersEntity.setRealm(oldCharacter.getRealm());
                charactersEntity.setSpouse(oldCharacter.getSpouse());
                charactersEntity.setWikiUrl(oldCharacter.getWikiUrl());
                charactersEntity.setDocs(oldCharacter.getDocs());
            }
        }
        return charactersEntity;
    }

    private CharacterDTO exchangeEmpityStringToNaN(CharacterDTO characterDTO) {
        if (characterDTO.get_id() == null || characterDTO.get_id().equals("")) characterDTO.setBirth("NaN");
        if (characterDTO.getBirth() == null || characterDTO.getBirth().equals("")) characterDTO.setBirth("NaN");
        if (characterDTO.getDeath() == null || characterDTO.getDeath().equals("")) characterDTO.setDeath("NaN");
        if (characterDTO.getGender() == null || characterDTO.getGender().equals("")) characterDTO.setGender("NaN");
        if (characterDTO.getHair() == null || characterDTO.getHair().equals("")) characterDTO.setHair("NaN");
        if (characterDTO.getHeight() == null || characterDTO.getHeight().equals("")) characterDTO.setHeight("NaN");
        if (characterDTO.getName() == null || characterDTO.getName().equals("")) characterDTO.setName("NaN");
        if (characterDTO.getRace() == null || characterDTO.getRace().equals("")) characterDTO.setRace("NaN");
        if (characterDTO.getRealm() == null || characterDTO.getRealm().equals("")) characterDTO.setRealm("NaN");
        if (characterDTO.getSpouse() == null || characterDTO.getSpouse().equals("")) characterDTO.setSpouse("NaN");
        if (characterDTO.getWikiUrl() == null || characterDTO.getWikiUrl().equals("")) characterDTO.setWikiUrl("NaN");

        return characterDTO;
    }

    @Override
    protected CharacterEntity findById(String id) {
        Optional<CharacterEntity> res =  super.repository.findCharacterEntitiesByApiId(id);
        return res.isPresent() ? res.get(): null;
    }

    public CharacterDTO getCharacterById(String id) {
        CharacterEntity res = this.findById(id);
        return res != null ? this.convertToDto(res): null;
    }


    private CharacterDTO convertToDto(CharacterEntity characterEntity) {
        CharacterDTO characterDTO = this.modelMapper().map(characterEntity, CharacterDTO.class);
        characterDTO.set_id(characterEntity.getApiId());
        return characterDTO;
    }

    @Override
    public boolean deleteById(String id) {
        Optional<CharacterEntity> characterEntity =  super.repository.findCharacterEntitiesByApiId(id);
        if (characterEntity.isPresent()) {
            super.repository.deleteById(characterEntity.get().getId());
            return true;
        } 
       return false;
    }


    public CharacterDTO updateById(CharacterDTO characterDTO) {
            CharacterEntity characterEntity = this.convertToEntityForUpdate(characterDTO);
            characterEntity =  super.repository.save(characterEntity);
            characterDTO = this.convertToDto(characterEntity);

        return characterDTO;

    }

    private CharacterEntity convertToEntityForUpdate(CharacterDTO characterDTO) {
        CharacterEntity charactersEntity = this.modelMapper().map(characterDTO, CharacterEntity.class);

        if (characterDTO.get_id() != null) {
            charactersEntity.setApiId(characterDTO.get_id());
            Optional<CharacterEntity> optionalCharacterEntity = super.repository.findCharacterEntitiesByApiId(characterDTO.get_id());
            if (optionalCharacterEntity.isPresent()) {
                CharacterEntity oldCharacter =  optionalCharacterEntity.get();
                charactersEntity.setId(oldCharacter.getId());
                charactersEntity.setDocs(oldCharacter.getDocs());
            }
        }
        return charactersEntity;
    }

    public  Page<CharacterEntity> getAllInPageByParameters(String limit, String page, String offset, String sortType, String sortByFiled, String name, String race, String apiId, String height, String gender, String birth, String spouse, String death, String realm, String hair, String wikiUrl) {
        Pageable pageable = this.getPageableByParams(limit, page,  offset,  sortType,  sortByFiled, CharacterEntity.class);
        Page<CharacterEntity> characterEntityPage = null;
        if (this.isFilterable(apiId,  height,  race,  gender,  birth,  spouse,  death,  realm,  hair,  name,   wikiUrl)) {

            characterEntityPage =  super.repository.
                    findAllByApiIdContainingAndHeightContainingAndRaceContainingAndGenderContainingAndBirthContainingAndSpouseContainingAndDeathContainingAndRealmContainingAndHairContainingAndNameContainingAndWikiUrlContaining(
                            apiId,  height,  race,  gender,  birth,  spouse,  death,  realm,  hair,  name ,   wikiUrl,  pageable);


        }else{
            characterEntityPage =  super.repository.findAll(pageable);
        }

        return characterEntityPage;
    }

    /*private List<Predicate<CharacterEntity>> getCharactersPredicates( CharacterDTO characterDTO ){
        List<Predicate<CharacterEntity>> allPredicates = new ArrayList<Predicate<CharacterEntity>>();
        if(isNuttNullAndNotEmpityString(characterDTO.getBirth()))
            allPredicates.add(str -> str.getBirth().contains(characterDTO.getBirth()));
        if(isNuttNullAndNotEmpityString(characterDTO.getDeath()))
            allPredicates.add(str -> str.getDeath().contains(characterDTO.getDeath()));
        if(isNuttNullAndNotEmpityString(characterDTO.getGender()))
            allPredicates.add(str -> str.getGender().contains(characterDTO.getGender()));
        if(isNuttNullAndNotEmpityString(characterDTO.getHair()))
            allPredicates.add(str -> str.getHair().contains(characterDTO.getHair()));
        if(isNuttNullAndNotEmpityString(characterDTO.getHeight()))
            allPredicates.add(str -> str.getHeight().contains(characterDTO.getHeight()));
        if(isNuttNullAndNotEmpityString(characterDTO.getName()))
            allPredicates.add(str -> str.getName().contains(characterDTO.getName()));
        if(isNuttNullAndNotEmpityString(characterDTO.getRace()))
            allPredicates.add(str -> str.getRace().contains(characterDTO.getRace()));
        if(isNuttNullAndNotEmpityString(characterDTO.getRealm()))
            allPredicates.add(str -> str.getRealm().contains(characterDTO.getRealm()));
        if(isNuttNullAndNotEmpityString(characterDTO.getSpouse()))
            allPredicates.add(str -> str.getSpouse().contains(characterDTO.getSpouse()));
        if(isNuttNullAndNotEmpityString(characterDTO.getWikiUrl()))
            allPredicates.add(str -> str.getWikiUrl().contains(characterDTO.getWikiUrl()));

        return allPredicates;

    }*/

   /* private boolean isNuttNullAndNotEmpityString(String value){
        if ( value!= null ) {
            if ( !value.equals("")) {
                return true;
            }
        }
        return false;
    }*/

}
