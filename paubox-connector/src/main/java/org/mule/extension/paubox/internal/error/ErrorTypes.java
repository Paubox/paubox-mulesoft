package org.mule.extension.paubox.internal.error;

import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

import java.util.HashMap;
import java.util.Map;

public enum ErrorTypes implements ErrorTypeDefinition<ErrorTypes> {

    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    NOT_ACCEPTABLE(406),
    REQUEST_TIMEOUT(408),
    CONFLICT(409),
    INTERNAL_SERVER_ERROR(500),
    NOT_IMPLEMENTED(501),
    BAD_GATEWAY(502),
    SERVICE_UNAVAILABLE(503);

    private static Map<Integer, ErrorTypes> map = new HashMap<>();

    static {
        for (ErrorTypes error : ErrorTypes.values()) {
            map.put(error.status, error);
        }
    }

    private Integer status;
    private String message;

    ErrorTypes(Integer status) {
        this.status = status;
    }

    ErrorTypes(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ErrorTypes valueOf(int status) {
        return map.get(status);
    }

    public static ErrorTypes getError(Integer status) {
        return ErrorTypes.valueOf(status);
    }

}