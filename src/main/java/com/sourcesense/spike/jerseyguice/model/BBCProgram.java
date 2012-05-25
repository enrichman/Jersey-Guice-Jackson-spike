package com.sourcesense.spike.jerseyguice.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Enrico Candino ( enrico.candino@gmail.com )
 */
@XmlRootElement
public class BBCProgram {

    private URL url;

    private List<BBCGenre> genres = new ArrayList<BBCGenre>();

    public BBCProgram() {}

    public BBCProgram(URL url) {
        this.url = url;
    }

    @XmlElement
    public URL getUrl() {
        return url;
    }

    @XmlElement
    public List<BBCGenre> getGenres() {
        return genres;
    }

    public boolean addGenre(BBCGenre bbcGenre) {
        return genres.add(bbcGenre);
    }

    @Override
    public String toString() {
        return "BBCProgram{" +
                "url=" + url +
                ", genres=" + genres +
                '}';
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public void setGenres(List<BBCGenre> genres) {
        this.genres = genres;
    }
}