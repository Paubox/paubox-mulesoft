/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
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
    @Summary("URL to access the Paubox REST API")
    protected static String apiURL;

    @Parameter
    @Summary("The API Key for the Paubox API's domain")
    protected static String apiKey;

    @Parameter
    @Summary("The API Endpoint username for the Paubox API's domain")
    protected static String apiUsername;


    public String getApiURL() {
        return apiURL;
    }

    public static String getApiURLValue(){
        return apiURL;
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