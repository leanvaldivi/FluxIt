package com.fluxit.desafioandroidmobile.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Persona implements Serializable {

    private String email;
    private Name name = new Name();
    private Picture picture = new Picture();
    @SerializedName("dob")
    private Dob edad;
    @SerializedName("login")
    private Login nombreUsuario;

    public Persona() {
    }

    public Persona(String email, Name name, Picture picture) {
        this.email = email;

    }

    public Dob getEdad() {
        return edad;
    }


    public Login getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEmail() {
        return email;
    }


    public Name getName() {
        return name;
    }


    public Picture getPicture() {
        return picture;
    }


}
