package org.mule.extension.paubox.internal.error;

import org.mule.runtime.extension.api.annotation.error.ErrorTypeProvider;
import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

import static org.mule.extension.paubox.internal.error.ErrorTypes.*;

import java.util.HashSet;
import java.util.Set;

public class PauboxErrorProvider implements ErrorTypeProvider {

    @SuppressWarnings("rawtypes")
	@Override
    public Set<ErrorTypeDefinition> getErrorTypes() {
        HashSet<ErrorTypeDefinition> errors = new HashSet<>();
        errors.add(BAD_REQUEST);
        errors.add(UNAUTHORIZED);
        errors.add(FORBIDDEN);
        errors.add(NOT_FOUND);
        errors.add(METHOD_NOT_ALLOWED);
        errors.add(NOT_ACCEPTABLE);
        errors.add(REQUEST_TIMEOUT);
        errors.add(CONFLICT);
        errors.add(INTERNAL_SERVER_ERROR);
        errors.add(NOT_IMPLEMENTED);
        errors.add(BAD_GATEWAY);
        errors.add(SERVICE_UNAVAILABLE);
        errors.add(INVALID_CONFIG);
        errors.add(GENERIC_EXCEPTION);
        return errors;
    }
}