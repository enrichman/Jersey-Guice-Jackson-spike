package com.sourcesense.spike.jerseyguice;

public class ProductionApplicationsManager implements ApplicationsManager {

    private final static String KEY = "abracadabra";

    public boolean isAuthorized(String apiKey) throws ApplicationsManagerException {
        return KEY.equals(apiKey);
    }
}
