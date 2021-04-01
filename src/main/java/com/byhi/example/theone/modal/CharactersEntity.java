package com.byhi.example.theone.modal;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "charpages")
public class CharactersEntity{


    @Id
    @Column(name = "charpages_id")
    @GeneratedValue
    String cid;

    String total;
    String offset;
    String limit;
    String page;
    String pages;

    public CharactersEntity() {

    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }


    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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
}
