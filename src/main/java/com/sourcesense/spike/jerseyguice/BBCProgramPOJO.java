package com.sourcesense.spike.jerseyguice;

import com.sourcesense.spike.jerseyguice.model.BBCProgram;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Enrico Candino ( enrico.candino@gmail.com )
 */
@XmlRootElement
public class BBCProgramPOJO implements POJOi<BBCProgram> {

    private BBCProgram bbcProgram;

    public BBCProgramPOJO() {}

    public BBCProgramPOJO(BBCProgram bbcProgram) {
        this.bbcProgram = bbcProgram;
    }

    public void setObject(BBCProgram bbcProgram) {
        this.bbcProgram = bbcProgram;
    }

    @XmlElement(name = "bbcProgram")
    public BBCProgram getObject() {
        return bbcProgram;
    }
}