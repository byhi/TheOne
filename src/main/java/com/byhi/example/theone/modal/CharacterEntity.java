package com.byhi.example.theone.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "charactent")
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sid")
    @JsonIgnore
    private Long id;

    private String apiId;
    private  String height;
    private  String race;
    private  String gender;
    private  String birth;
    private  String spouse;
    private  String death;
    private String realm;
    private String hair;
    private String name;
    private String  wikiUrl;

    @JsonIgnore
    @OneToMany(mappedBy="character_id", cascade = CascadeType.ALL)
    Set<QuoteEntity> docs;

    public CharacterEntity() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
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

    public Set<QuoteEntity> getDocs() {
        return docs;
    }

    public void setDocs(Set<QuoteEntity> docs) {
        this.docs = docs;
    }

    @Override
    public String toString() {
        return "CharacterEntity{" +
                "id=" + id +
                ", apiId='" + apiId + '\'' +
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
