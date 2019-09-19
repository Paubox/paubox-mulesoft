package org.mule.extension.paubox.internal.service;

import org.mule.extension.paubox.api.ResponseStatus;
import org.mule.extension.paubox.internal.config.PauboxConfiguration;
import org.mule.extension.paubox.internal.connection.PauboxConnection;
import org.mule.extension.paubox.internal.util.PauboxUtils;
import org.mule.extension.paubox.internal.util.Urls;
import org.mule.connectors.commons.template.service.DefaultConnectorService;
import org.mule.runtime.api.util.MultiMap;
import org.mule.runtime.extension.api.runtime.operation.Result;
import org.mule.runtime.http.api.HttpConstants;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.mule.runtime.core.api.util.IOUtils;

import static org.mule.extension.paubox.internal.attributes.AttributesUtil.setResponseAttributes;
import static org.mule.extension.paubox.internal.error.exception.ResponseValidator.checkErrorResponse;

public class APIServiceImpl extends DefaultConnectorService<PauboxConfiguration, PauboxConnection> implements APIService {
    public APIServiceImpl(PauboxConfiguration config, PauboxConnection connection) {
        super(config, connection);
    }

    public Result<InputStream, ResponseStatus> getEmailDispositionResult(String sourceTrackingId) {
    	String baseURI = getConfig().getAddress();
    	String apiUsername = getConfig().getApiUsername();
        String actualUrl = new StringBuilder(baseURI).append(Urls.SPLIT_EXPRESSION).append(apiUsername).append(Urls.SPLIT_EXPRESSION).append(Urls.MSG_RECEIPT).toString();

        MultiMap<String, String> qParams = new MultiMap<>();
        if (sourceTrackingId != null && !"".equals(sourceTrackingId)) {
            qParams.put("sourceTrackingId", sourceTrackingId);
        }

        CompletableFuture<HttpResponse> response = getConnection().sendAsyncRequest(HttpConstants.Method.GET,actualUrl,qParams, getAuthorizationHeader());

        checkErrorResponse(response);
        InputStream str = PauboxUtils.getContentInputStream(response);
        return Result.<InputStream,ResponseStatus>builder().output(str).attributes(setResponseAttributes(response)).build();

    }

    public Result<InputStream, ResponseStatus> getSendMessageResult(Map<String, Object> messageBody) {
    	String baseURI = getConfig().getAddress();
    	String apiUsername = getConfig().getApiUsername();
        String actualUrl = new StringBuilder(baseURI).append(Urls.SPLIT_EXPRESSION).append(apiUsername).append(Urls.SPLIT_EXPRESSION).append(Urls.MESSAGES).toString();

        byte[] byteArray = PauboxUtils.getByteArrayData(messageBody);

        CompletableFuture<HttpResponse> response = getConnection().sendAsyncRequestWithoutQueryParam(HttpConstants.Method.POST, actualUrl, byteArray, getAuthorizationHeader());
        checkErrorResponse(response);
        InputStream str = PauboxUtils.getContentInputStream(response);
        return Result.<InputStream,ResponseStatus>builder().output(str).attributes(setResponseAttributes(response)).build();
    }

    private String getAuthorizationHeader() {
		return "Token token=" + getConfig().getApiKey();
	}
}
