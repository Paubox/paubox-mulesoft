package org.mule.extension.paubox.internal.attributes;

import org.mule.extension.paubox.api.ResponseStatus;

import org.mule.runtime.http.api.domain.message.response.HttpResponse;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AttributesUtil {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(AttributesUtil.class);

    public AttributesUtil() {
    }

    public static ResponseStatus setResponseAttributes(CompletableFuture<HttpResponse> response) {
        try {
            ResponseStatus responseStatus = new ResponseStatus();
            responseStatus.setStatusCode(response.get().getStatusCode());
            responseStatus.setHeaders(response.get().getHeaders());
            return responseStatus;
        }catch (ExecutionException e){
            logger.info("Error : ", e);
        }catch (InterruptedException e){
            logger.info("Error : ", e);
        }
        return  null;
    }

}
