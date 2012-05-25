package com.sourcesense.spike.jerseyguice;

public class TestApplicationsManager implements ApplicationsManager {

    public boolean isAuthorized(String apiKey) throws ApplicationsManagerException {
        return false;
    }
}
