/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.extension.paubox.internal.error;

import org.mule.runtime.extension.api.annotation.error.ErrorTypeProvider;
import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

import static org.mule.extension.paubox.internal.error.ErrorTypes.BAD_REQUEST;
import static org.mule.extension.paubox.internal.error.ErrorTypes.UNAUTHORIZED;
import static org.mule.extension.paubox.internal.error.ErrorTypes.FORBIDDEN;
import static org.mule.extension.paubox.internal.error.ErrorTypes.NOT_FOUND;
import static org.mule.extension.paubox.internal.error.ErrorTypes.METHOD_NOT_ALLOWED;
import static org.mule.extension.paubox.internal.error.ErrorTypes.NOT_ACCEPTABLE;
import static org.mule.extension.paubox.internal.error.ErrorTypes.REQUEST_TIMEOUT;
import static org.mule.extension.paubox.internal.error.ErrorTypes.CONFLICT;
import static org.mule.extension.paubox.internal.error.ErrorTypes.INTERNAL_SERVER_ERROR;
import static org.mule.extension.paubox.internal.error.ErrorTypes.NOT_IMPLEMENTED;
import static org.mule.extension.paubox.internal.error.ErrorTypes.BAD_GATEWAY;
import static org.mule.extension.paubox.internal.error.ErrorTypes.SERVICE_UNAVAILABLE;
import static org.mule.extension.paubox.internal.error.ErrorTypes.INVALID_CONFIG;
import static org.mule.extension.paubox.internal.error.ErrorTypes.GENERIC_EXCEPTION;

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