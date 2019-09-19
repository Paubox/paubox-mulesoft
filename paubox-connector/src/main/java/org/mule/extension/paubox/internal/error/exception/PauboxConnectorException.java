package org.mule.extension.paubox.internal.error.exception;

import org.mule.runtime.extension.api.error.ErrorTypeDefinition;
import org.mule.runtime.extension.api.exception.ModuleException;

public class PauboxConnectorException extends ModuleException {

    public <T extends Enum<T>> PauboxConnectorException(String message, ErrorTypeDefinition<T> errorTypeDefinition) {
        super(message, errorTypeDefinition);
    }
}