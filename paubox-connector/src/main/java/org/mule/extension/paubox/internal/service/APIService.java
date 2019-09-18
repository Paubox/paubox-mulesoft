package org.mule.extension.paubox.internal.service;

import org.mule.extension.paubox.api.ResponseStatus;
import org.mule.connectors.commons.template.service.ConnectorService;
import org.mule.runtime.extension.api.runtime.operation.Result;

import java.io.InputStream;
import java.util.Map;

public interface APIService extends ConnectorService {

    Result<InputStream, ResponseStatus> getEmailDispositionResult(String sourceTrackingId);
    Result<InputStream, ResponseStatus> getSendMessageResult(Map<String, Object> messageBody);
}