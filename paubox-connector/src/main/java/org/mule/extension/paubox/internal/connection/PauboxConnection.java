package org.mule.extension.paubox.internal.connection;

import java.util.concurrent.CompletableFuture;


import org.mule.extension.paubox.internal.util.Urls;
import org.mule.connectors.commons.template.connection.ConnectorConnection;
import org.mule.runtime.api.util.MultiMap;
import org.mule.runtime.http.api.HttpConstants;
import org.mule.runtime.http.api.client.HttpClient;
import org.mule.runtime.http.api.domain.entity.ByteArrayHttpEntity;
//import org.mule.runtime.http.api.client.auth.HttpAuthentication;
//import org.mule.runtime.http.api.client.auth.HttpAuthenticationBuilder;
//import org.mule.runtime.http.api.domain.entity.ByteArrayHttpEntity;
import org.mule.runtime.http.api.domain.message.request.HttpRequest;
import org.mule.runtime.http.api.domain.message.request.HttpRequestBuilder;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;

import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * This class represents an extension connection just as example (there is no real connection with anything here c:).
 */
public final class PauboxConnection implements ConnectorConnection {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(PauboxConnection.class);

    //private HttpAuthentication authentication;
    private HttpClient httpClient;
    private HttpRequestBuilder httpRequestBuilder;
    private int apiTimeout;
    //private HttpAuthenticationBuilder auth1;
    //private HttpAuthentication auth;
//    private String username;
//    private String password;
    private String cacheControl;


    public PauboxConnection(HttpClient httpClient, int timeout) {
        this.httpClient = httpClient;
        this.apiTimeout = timeout;
        this.httpRequestBuilder = HttpRequest.builder();
//        this.username = username;
//        this.password = password;
    }

    public CompletableFuture<HttpResponse> sendAsyncRequest(HttpConstants.Method method, String uri, MultiMap<String, String> parameterMap, String authHeader) {


        HttpRequestBuilder builder = HttpRequest.builder();
        //auth1 = HttpAuthentication.basic(username, password);
        //auth = auth1.build();


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
//        auth1 = HttpAuthentication.basic(username, password);
//        auth = auth1.build();

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

//    public HttpAuthentication getAuthentication() {
//        return authentication;
//    }

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
