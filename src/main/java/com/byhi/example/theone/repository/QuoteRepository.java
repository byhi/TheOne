package com.byhi.example.theone.repository;

import com.byhi.example.theone.modal.QuoteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface QuoteRepository extends CrudRepository<QuoteEntity, Long>,  PagingAndSortingRepository<QuoteEntity, Long> {
    Optional<QuoteEntity> findQuoteEntitiesByApiId(String apiId);
    Page<QuoteEntity> findAllByCharacter(String character, Pageable pageable);
   // Page<QuoteEntity> findAllBygetApiIdContainingAndgetDialogContainingAndgetMovieContainingAndgetCharacterContainingAnd(String apiId, String dialog, String movie, String character, Pageable pageable);
    Page<QuoteEntity> findAllByApiIdContainsAndDialogContainingAndMovieContainingAndCharacterContaining(String apiId, String dialog, String movie, String character, Pageable pageable);
}
