/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.extension.paubox.internal.connection.provider;

import org.mule.extension.paubox.internal.connection.PauboxConnection;
import org.mule.extension.paubox.internal.error.exception.PauboxConnectorException;
import org.mule.extension.paubox.internal.util.Urls;
import org.mule.connectors.commons.template.connection.ConnectorConnectionProvider;
import org.mule.runtime.api.connection.*;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.display.Placement;
import org.mule.runtime.http.api.HttpConstants;
import org.mule.runtime.http.api.HttpService;
import org.mule.runtime.http.api.client.HttpClient;
import org.mule.runtime.http.api.client.HttpClientConfiguration;
import org.mule.runtime.http.api.client.auth.HttpAuthentication;
import org.mule.runtime.http.api.domain.message.request.HttpRequest;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;
import org.mule.runtime.http.api.tcp.TcpClientSocketProperties;
import static org.mule.extension.paubox.internal.config.PauboxConfiguration.getApiBaseURLValue;
import static org.mule.extension.paubox.internal.config.PauboxConfiguration.getApiKeyValue;
import static org.mule.extension.paubox.internal.config.PauboxConfiguration.getApiUsernameValue;
import static org.mule.extension.paubox.internal.error.ErrorTypes.getError;
import static org.mule.extension.paubox.internal.util.RequestService.sendAsyncRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import java.util.concurrent.CompletableFuture;

public class PauboxConnectionProvider implements ConnectionProvider<PauboxConnection> {

	private static final Logger logger = LoggerFactory.getLogger(PauboxConnectionProvider.class);

	@Inject
	private HttpService httpService;

	@Override
	public PauboxConnection connect() throws ConnectionException {
		HttpClient httpClient = httpService.getClientFactory()
				.create(new HttpClientConfiguration.Builder().setName("PauboxConfiguration").build());
		httpClient.start();

		return new PauboxConnection(httpClient, 60000);
	}

	@Override
	public void disconnect(PauboxConnection connection) {
		try {
			connection.invalidate();
		} catch (Exception e) {
			logger.info("Error while disconnecting :", e);
		}
	}

	@Override
	public ConnectionValidationResult validate(PauboxConnection connection) {

		String baseURI = getApiBaseURLValue();
		String apiUsername = getApiUsernameValue();

		if (apiUsername == null || apiUsername.isEmpty()) {
			return ConnectionValidationResult.failure("API Username is empty.",
					new PauboxConnectorException("API Username is empty.", getError(1)));
		}

		String actualUrl = new StringBuilder(baseURI).append(Urls.SPLIT_EXPRESSION).append(apiUsername)
				.append(Urls.SPLIT_EXPRESSION).append(Urls.STATUS).toString();
		try {
			HttpRequest request = connection.getHttpRequestBuilder().method(HttpConstants.Method.GET).uri(actualUrl)
					.build();
			CompletableFuture<HttpResponse> response = sendAsyncRequest(request, true, connection);
			if (response.get().getStatusCode() != 200) {
				String str = response.get().getStatusCode() + "";
				return ConnectionValidationResult.failure(str, new PauboxConnectorException(
						response.get().getReasonPhrase(), getError(response.get().getStatusCode())));
			}
		} catch (Exception e) {
			logger.info("Error while validating the connection : " + e);
			return ConnectionValidationResult.failure("Unhandled Error",
					new PauboxConnectorException("Unhandled Error", getError(2)));
		}
		return ConnectionValidationResult.success();
	}
}