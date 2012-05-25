package com.sourcesense.spike.jerseyguice.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sourcesense.spike.jerseyguice.ApplicationsManager;
import com.sourcesense.spike.jerseyguice.ProductionApplicationsManager;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import java.util.HashMap;
import java.util.Map;

public class ProductionServiceConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new JerseyServletModule() {
            @Override
            protected void configureServlets() {
                Map<String, String> initParams = new HashMap<String, String>();
                initParams.put(PackagesResourceConfig.PROPERTY_PACKAGES, "com.sourcesense.spike.jerseyguice.service");
                bind(ApplicationsManagerService.class);
                bind(ApplicationsManager.class).to(ProductionApplicationsManager.class);
                // Route all requests through GuiceContainer
                serve("/*").with(GuiceContainer.class);
                filter("/*").through(GuiceContainer.class, initParams);
            }
        });
    }
}
