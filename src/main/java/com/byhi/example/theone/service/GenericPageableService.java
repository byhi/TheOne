package com.byhi.example.theone.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GenericPageableService<T, R extends CrudRepository<T , Long>> extends GenericService<T,  R >{
    static final int PAGE_MIN = 0;
    static final int LIMIT = 10;

    protected Pageable getPageableByParams(String limit, String page, String offset, String sortType, String sortByFiled, Class<?> entityClass) {
        int pageActual = page!=null && !page.equals("") ? Integer.valueOf(page).intValue() : PAGE_MIN;
        int limitActual = limit!=null && !limit.equals("") ? Integer.valueOf(limit).intValue(): LIMIT;
        Pageable pageable = PageRequest.of(pageActual   ,limitActual);
        boolean isValdiFiledName = getClassFieldNameList(entityClass).contains(sortType);

        if (sortType == null && sortType.equals("") && sortByFiled == null && sortByFiled.equals("") && isValdiFiledName) {
            if (sortType.equals("asc")) {
                pageable = PageRequest.of(Integer.valueOf(page).intValue(), Integer.valueOf(limit).intValue(), Sort.by(sortByFiled).ascending());
            }else if (sortType.equals("desc")){
                pageable = PageRequest.of(Integer.valueOf(page).intValue(), Integer.valueOf(limit).intValue(), Sort.by(sortByFiled).descending());
            }
        }
        return pageable;
    }

    private List<String> getClassFieldNameList(Class<?> entityClass){
        List<String> result = Arrays.asList(entityClass.getClass().getFields()).stream()
                .map(field -> field.getName())
                .collect(Collectors.toList());
        return  result;
    }

    protected boolean isFilterable(String... values) {
        return Arrays.stream(values).anyMatch(s -> (s!= null && !s.equals("")));
    }
}
