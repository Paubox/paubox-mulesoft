package org.mule.extension.paubox.internal.util;

import org.mule.extension.paubox.internal.connection.PauboxConnection;
import org.mule.runtime.http.api.domain.message.request.HttpRequest;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.CompletableFuture;

public class RequestService {
	private static HttpResponse httpResponse;
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(RequestService.class);

	public static HttpResponse requestCall (HttpRequest request, boolean value, PauboxConnection connection){
		try {
			httpResponse = connection.getHttpClient().send(request,connection.getApiTimeout(),false,null);
			return httpResponse;
		} catch (IOException e) {
			logger.info("Error : ", e);
		} catch (TimeoutException e) {
			logger.info("Error : ", e);
		} catch (Exception e) {
			logger.info("Error : ", e);
		}
		return null;
	}

	public static CompletableFuture<HttpResponse> sendAsyncRequest(HttpRequest request, boolean value, PauboxConnection connection) {
		return connection.getHttpClient().sendAsync(request, connection.getApiTimeout(), false,null);
	}

}