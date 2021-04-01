package com.byhi.example.theone.service;

import com.byhi.example.theone.dto.CharacterDTO;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public abstract class GenericService<T , R extends CrudRepository<T , Long> > {

    R repository;

    protected abstract R getRepo(R repo);

    public void saveAll(List<T> all){
        repository.saveAll(all);
    }

    protected abstract T findById(String id);

    public abstract boolean deleteById(String id);

}
