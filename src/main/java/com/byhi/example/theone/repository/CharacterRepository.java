package com.byhi.example.theone.repository;

import com.byhi.example.theone.modal.CharacterEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CharacterRepository extends CrudRepository<CharacterEntity, Long>, PagingAndSortingRepository<CharacterEntity, Long> {
    Optional<CharacterEntity> findCharacterEntitiesByApiId(String apiId);
    Page<CharacterEntity> findAllByNameContainingAndRaceContaining(String name, String race, Pageable pageable);
    Page<CharacterEntity> findAllByNameContaining(String name, Pageable pageable);
    Page<CharacterEntity> findAllByApiIdContainingAndHeightContainingAndRaceContainingAndGenderContainingAndBirthContainingAndSpouseContainingAndDeathContainingAndRealmContainingAndHairContainingAndNameContainingAndWikiUrlContaining(
            String apiId, String height, String race, String gender, String birth, String spouse, String death, String realm, String hair, String name, String  wikiUrl, Pageable pageable);
    Page<CharacterEntity> findAllByApiIdNotContainingAndHeightNotContainingAndRaceNotContainingAndGenderNotContainingAndBirthNotContainingAndSpouseNotContainingAndDeathNotContainingAndRealmNotContainingAndHairNotContainingAndNameNotContainingAndWikiUrlNotContaining(
            String apiId, String height, String race, String gender, String birth, String spouse, String death, String realm, String hair, String name, String  wikiUrl, Pageable pageable);
}
