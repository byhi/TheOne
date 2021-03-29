package com.byhi.example.theone.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterDTO {

    String _id;

    String height;

    String race;

    String gender;

    String birth;

    String spouse;

    String death;

    String realm;

    String hair;

    String name;

    String  wikiUrl;

    public CharacterDTO() {
        super();
    }

    public CharacterDTO(String _id, String height, String race, String gender, String birth, String spouse, String death, String realm, String hair, String name, String wikiUrl) {
        this();
        this._id = _id;
        this.height = height;
        this.race = race;
        this.gender = gender;
        this.birth = birth;
        this.spouse = spouse;
        this.death = death;
        this.realm = realm;
        this.hair = hair;
        this.name = name;
        this.wikiUrl = wikiUrl;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWikiUrl() {
        return wikiUrl;
    }

    public void setWikiUrl(String wikiUrl) {
        this.wikiUrl = wikiUrl;
    }

    @Override
    public String toString() {
        return "CharacterDTO{" +
                "id='" + _id + '\'' +
                ", height='" + height + '\'' +
                ", race='" + race + '\'' +
                ", gender='" + gender + '\'' +
                ", birth='" + birth + '\'' +
                ", spouse='" + spouse + '\'' +
                ", death='" + death + '\'' +
                ", realm='" + realm + '\'' +
                ", hair='" + hair + '\'' +
                ", name='" + name + '\'' +
                ", wikiUrl='" + wikiUrl + '\'' +
                '}';
    }
}
