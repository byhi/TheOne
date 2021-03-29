package com.byhi.example.theone.dto;

public class QuoteDTO {
    String _id;
    String dialog;
    String movie;
    String character;

    public QuoteDTO() {
        super();
    }

    public QuoteDTO(String _id, String dialog, String movie, String character) {
        this();
        this._id = _id;
        this.dialog = dialog;
        this.movie = movie;
        this.character = character;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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
