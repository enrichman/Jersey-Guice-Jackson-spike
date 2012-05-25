package com.sourcesense.spike.jerseyguice.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Enrico Candino ( enrico.candino@gmail.com )
 */
@XmlRootElement
public class BBCGenre {

    private String name;

    private List<BBCGenre> subGenres = new ArrayList<BBCGenre>();

    public BBCGenre() {}

    public BBCGenre(String name) {
        this.name = name;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public List<BBCGenre> getSubGenres() {
        return subGenres;
    }

    public boolean addSubGenre(BBCGenre bbcGenre) {
        return subGenres.add(bbcGenre);
    }

    @Override
    public String toString() {
        return "BBCGenre{" +
                "name='" + name + '\'' +
                ", subGenres=" + subGenres +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubGenres(List<BBCGenre> subGenres) {
        this.subGenres = subGenres;
    }
}