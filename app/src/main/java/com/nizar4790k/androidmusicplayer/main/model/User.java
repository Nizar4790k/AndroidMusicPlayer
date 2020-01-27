package com.nizar4790k.androidmusicplayer.main.model;

public class User {

    public String birthDate;
    public String country;
    public String display_name;
    public String email;
    public String id;


    public User(String birthDate, String country, String display_name, String email, String id) {
        this.birthDate = birthDate;
        this.country = country;
        this.display_name = display_name;
        this.email = email;
        this.id = id;
    }


    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }



}
