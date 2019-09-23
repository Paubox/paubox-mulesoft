package org.mule.extension.paubox.internal.config;

import org.mule.extension.paubox.internal.connection.provider.PauboxConnectionProvider;
import org.mule.extension.paubox.internal.operations.PauboxOperations;
import org.mule.connectors.commons.template.config.ConnectorConfig;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.display.Summary;

/**
 * This class represents an extension configuration, values set in this class are commonly used across multiple
 * operations since they represent something core from the extension.
 */
@Operations({PauboxOperations.class})
@ConnectionProviders(PauboxConnectionProvider.class)
public class PauboxConfiguration implements ConnectorConfig {

    @Parameter
    @Optional(defaultValue = "https://api.paubox.net/v1/")
    @Summary("Base URL of the Paubox REST API")
    protected static String apiBaseURL;

    @Parameter
    @Summary("Paubox API Key")
    protected static String apiKey;

    @Parameter
    @Summary("Paubox API Username")
    protected static String apiUsername;


    public String getApiBaseURL() {
        return apiBaseURL;
    }

    public static String getApiBaseURLValue(){
        return apiBaseURL;
    }

    public String getApiUsername() {
        return apiUsername;
    }

    public static String getApiUsernameValue(){
        return apiUsername;
    }

    public String getApiKey() {
        return apiKey;
    }

    public static String getApiKeyValue(){
        return apiKey;
    }

}