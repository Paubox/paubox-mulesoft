/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.extension.paubox.internal.connection;

import java.util.concurrent.CompletableFuture;
import org.mule.extension.paubox.internal.util.Urls;
import org.mule.connectors.commons.template.connection.ConnectorConnection;
import org.mule.runtime.api.util.MultiMap;
import org.mule.runtime.http.api.HttpConstants;
import org.mule.runtime.http.api.client.HttpClient;
import org.mule.runtime.http.api.domain.entity.ByteArrayHttpEntity;
import org.mule.runtime.http.api.domain.message.request.HttpRequest;
import org.mule.runtime.http.api.domain.message.request.HttpRequestBuilder;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;
import org.slf4j.LoggerFactory;

public final class PauboxConnection implements ConnectorConnection {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(PauboxConnection.class);

    private HttpClient httpClient;
    private HttpRequestBuilder httpRequestBuilder;
    private int apiTimeout;

    public PauboxConnection(HttpClient httpClient, int timeout) {
        this.httpClient = httpClient;
        this.apiTimeout = timeout;
        this.httpRequestBuilder = HttpRequest.builder();
    }

    public CompletableFuture<HttpResponse> sendAsyncRequest(HttpConstants.Method method, String uri, MultiMap<String, String> parameterMap, String authHeader) {


        HttpRequestBuilder builder = HttpRequest.builder();

        return httpClient.sendAsync(builder
                .method(method)
                .uri(uri)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", authHeader)
                .queryParams(parameterMap)
                .build(), apiTimeout, true, null);
    }

    public CompletableFuture<HttpResponse> sendAsyncRequestWithoutQueryParam(HttpConstants.Method method, String uri, byte[] httpEntity, String authHeader) {


        HttpRequestBuilder builder = HttpRequest.builder();

        if (httpEntity != null) {
            builder.entity(new ByteArrayHttpEntity(httpEntity));
        }

        return httpClient.sendAsync(builder
                .method(method)
                .uri(uri)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", authHeader)
                .build(), apiTimeout, true, null);
    }

    public void invalidate() {
        httpClient.stop();
    }

    @Override
    public void disconnect() {
        httpClient.stop();
    }

    @Override
    public void validate() {
        try {

        } catch (Exception e) {
            logger.info("Error : ", e);
        }
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public HttpRequestBuilder getHttpRequestBuilder() {
        return httpRequestBuilder;
    }

    public int getApiTimeout() {
        return apiTimeout;
    }
}