package com.sourcesense.spike.jerseyguice;

/**
 *
 */
public interface ApplicationsManager {

    public boolean isAuthorized(String apiKey) throws ApplicationsManagerException;

}
