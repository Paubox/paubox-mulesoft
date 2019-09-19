package org.mule.extension.paubox.internal.error.exception;

import org.mule.extension.paubox.internal.error.ErrorTypes;
import org.mule.runtime.core.api.util.IOUtils;
import org.mule.runtime.http.api.domain.message.response.HttpResponse;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ResponseValidator {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ResponseValidator.class);

    public static boolean checkErrorResponse(CompletableFuture<HttpResponse> response) {
        try {
            if (!(response.get().getStatusCode() == 200 || response.get().getStatusCode() == 201
                    || response.get().getStatusCode() == 202 || response.get().getStatusCode() == 207)) {
                InputStream str = response.get().getEntity().getContent();
                String errorPayload = IOUtils.toString(str, "UTF-8");
                throw new PauboxConnectorException(errorPayload, getError(response.get().getStatusCode()));
            }
            else
            	return true;
        } catch (InterruptedException ex) {
            logger.info("Error :", ex);
        } catch (ExecutionException ex) {
            logger.info("Error :", ex);
        } catch (Exception ex) {
            logger.info("Error :", ex);
        }
        return false;
    }

    private static ErrorTypes getError(Integer status) {
        return ErrorTypes.valueOf(status);
    }

}
