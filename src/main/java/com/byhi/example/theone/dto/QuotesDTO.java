package com.byhi.example.theone.dto;

public class QuotesDTO {
    QuoteDTO[] docs;

    String total;

    String limit;

    String offset;

    String page;

    String pages;

    public QuotesDTO() {
        super();
    }

    public QuotesDTO(QuoteDTO[] docs, String total, String limit, String offset, String page, String pages) {
        this();
        this.docs = docs;
        this.total = total;
        this.limit = limit;
        this.offset = offset;
        this.page = page;
        this.pages = pages;
    }

    public QuoteDTO[] getDocs() {
        return docs;
    }

    public void setDocs(QuoteDTO[] docs) {
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
}
