package com.fluxit.desafioandroidmobile.model;

import java.io.Serializable;

public class Name implements Serializable {

    private String first;
    private String last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Name() {
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}
