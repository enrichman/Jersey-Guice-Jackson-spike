package com.sourcesense.spike.jerseyguice;

import com.google.gson.Gson;
import com.google.inject.servlet.GuiceFilter;
import com.sourcesense.spike.jerseyguice.model.BBCProgram;
import com.sourcesense.spike.jerseyguice.service.ApplicationsManagerService;
import com.sourcesense.spike.jerseyguice.service.ProductionServiceConfig;
import com.sun.grizzly.http.SelectorThread;
import com.sun.grizzly.http.embed.GrizzlyWebServer;
import com.sun.grizzly.http.servlet.ServletAdapter;
import com.sun.grizzly.tcp.http11.GrizzlyAdapter;
import com.sun.grizzly.tcp.http11.GrizzlyRequest;
import com.sun.grizzly.tcp.http11.GrizzlyResponse;
import com.sun.jersey.api.container.grizzly.GrizzlyServerFactory;
import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import junit.framework.Assert;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApplicationsManagerServiceTestCase {

    private GrizzlyWebServer server;

    @BeforeTest
    public void setUp() throws IOException, InstantiationException {
        server = new GrizzlyWebServer(9999);
        ServletAdapter ga = new ServletAdapter();
        ga.addServletListener(TestServiceConfig.class.getName());
        ga.setServletPath("/authorization");
        ga.addFilter(new GuiceFilter(), "filter", null);
        server.addGrizzlyAdapter(ga, null);
        server.start();
    }

    @AfterTest
    public void tearDown() {
        server.stop();
    }

    @Test
    public void test() throws IOException {
        final String base_uri = "http://localhost:9999/authorization/auth/";
        final String apiKey = "abracadabra";

        // Perform GET
        GetMethod getMethod = new GetMethod(base_uri + apiKey);
        HttpClient client = new HttpClient();
        int result = client.executeMethod(getMethod);
        String responseBody = new String(getMethod.getResponseBody());
        System.out.print(responseBody);
        assert result == HttpStatus.SC_OK : "Unexpected result: \n" + result;
        BBCProgramPOJO prg = (new Gson()).fromJson(responseBody, BBCProgramPOJO.class);
        Assert.assertNotNull(prg);
    }

}
