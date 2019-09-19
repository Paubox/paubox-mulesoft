package org.mule.extension.paubox.api;

import org.mule.runtime.api.util.MultiMap;

public class ResponseStatus {

    public ResponseStatus() {
    }

    private int statusCode;
    private MultiMap<String, String> headers;

    public MultiMap<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(MultiMap<String, String> headers) {
        this.headers = headers;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "Response Status{" +
                "Status Code =" + statusCode +
                ", Headers =" + headers +
                "}";
    }
}