package com.fluxit.desafioandroidmobile.model;

import java.io.Serializable;

public class Picture implements Serializable {

    private String thumbnail;
    private String large;

    public Picture() {
    }


    public String getLarge() {
        return large;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
