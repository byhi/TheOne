package com.byhi.example.theone.modal;

import javax.persistence.*;

@Entity
@Table(name = "quoteent")
public class QuoteEntity {
    @Id
    @GeneratedValue
    @Column(name = "sid")
    Long id;
    String apiId;
    @Column(name = "dialog", length = 4000)
    String dialog;
    String movie;
    String character;

    @ManyToOne
    @JoinColumn
    private CharacterEntity character_id;

    public QuoteEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public CharacterEntity getCharacter_id() {
        return character_id;
    }

    public void setCharacter_id(CharacterEntity character_id) {
        this.character_id = character_id;
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
