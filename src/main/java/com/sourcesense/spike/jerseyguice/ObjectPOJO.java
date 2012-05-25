package com.sourcesense.spike.jerseyguice;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Enrico Candino ( enrico.candino@gmail.com )
 */
@XmlRootElement
public class ObjectPOJO implements POJOi<List<String>> {

    @XmlElement
    private List<String> o;

    public ObjectPOJO() {}

    public ObjectPOJO(List<String> o) {
        this.o = o;
    }

    public List<String> getObject() {
        return o;
    }
}