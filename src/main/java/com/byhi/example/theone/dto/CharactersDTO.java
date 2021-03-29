package com.byhi.example.theone.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

public class CharactersDTO {

   CharacterDTO[] docs;

    String total;

    String limit;

    String offset;

    String page;

    String pages;

    public CharactersDTO() {
        super();
    }

    public CharactersDTO(CharacterDTO[] docs, String total, String limit, String offset, String page, String pages) {
        this();
        this.docs = docs;
        this.total = total;
        this.limit = limit;
        this.offset = offset;
        this.page = page;
        this.pages = pages;
    }

    public CharacterDTO[] getDocs() {
        return docs;
    }

    public void setDocs(CharacterDTO[] docs) {
        this.docs = docs;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "CharactersDTO{" +
                "characters=" + Arrays.toString(docs) +
                ", total='" + total + '\'' +
                ", limit='" + limit + '\'' +
                ", offset='" + offset + '\'' +
                ", page='" + page + '\'' +
                ", pages='" + pages + '\'' +
                '}';
    }
}
