package dev.emirman.util.response.base;

import org.springframework.http.HttpStatus;

import java.util.TreeMap;

public final class ResponseBuilder {
    private String message;
    private HttpStatus status;
    private String code;
    private TreeMap<String, ?> details;

    ResponseBuilder() {
    }

    public static ResponseBuilder newBuilder() {
        return new ResponseBuilder();
    }

    public ResponseBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseBuilder withStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public ResponseBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public ResponseBuilder withDetails(TreeMap<String, ?> details) {
        this.details = details;
        return this;
    }

    public Response build() {
        Response response = new Response();
        response.setMessage(message);
        response.setStatus(status);
        response.setCode(code);
        response.setDetails(details);
        return response;
    }
}
