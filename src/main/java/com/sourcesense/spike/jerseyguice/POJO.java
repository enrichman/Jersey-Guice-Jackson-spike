package com.sourcesense.spike.jerseyguice;

import java.util.ArrayList;

public class POJO implements POJOi<ArrayList<String>> {

    private ArrayList<String> object;

    public POJO() {
        object = new ArrayList<String>();
    }

    public POJO(ArrayList<String> l) {
        this.object = l;
    }

    public ArrayList<String> getObject() {
        return object;
    }

}