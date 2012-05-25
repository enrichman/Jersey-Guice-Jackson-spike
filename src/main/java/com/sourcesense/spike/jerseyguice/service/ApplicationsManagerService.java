package com.sourcesense.spike.jerseyguice.service;

import com.google.inject.Inject;
import com.sourcesense.spike.jerseyguice.*;
import com.sourcesense.spike.jerseyguice.model.BBCGenre;
import com.sourcesense.spike.jerseyguice.model.BBCProgram;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

@Path("/authorization")
public class ApplicationsManagerService {

    private ApplicationsManager applicationsManager;

    @Inject
    public ApplicationsManagerService(final ApplicationsManager am) {
        this.applicationsManager = am;
    }

    @GET
    @Path("/auth/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public BBCProgramPOJO isAuth( @PathParam("key") String apiKey ) {
        BBCProgram bbcProgram;
        try {
            bbcProgram = new BBCProgram(new URL("http://bbc.co.uk/program/fake"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        BBCGenre g1 = new BBCGenre("factual");
        g1.addSubGenre(new BBCGenre("subfactual1"));
        g1.addSubGenre(new BBCGenre("subfactual2"));
        bbcProgram.addGenre(g1);
        BBCGenre g2 = new BBCGenre("news");
        g2.addSubGenre(new BBCGenre("subnews1"));
        g2.addSubGenre(new BBCGenre("subnews2"));
        // bbcProgram.addGenre(g2);
        String test;
        try {
            test = (applicationsManager.isAuthorized(apiKey) ? "authorized" : "na");
        } catch (ApplicationsManagerException e) {
            throw new RuntimeException("Error [" + apiKey + "] cannot be verified", e);
        }
        return new BBCProgramPOJO(bbcProgram);
    }

}
