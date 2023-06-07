package dev.emirman.util.response.base;

import org.springframework.http.HttpStatus;

import java.util.TreeMap;

public class Response {
    private String message;
    private HttpStatus status;
    private String code;
    private TreeMap<String, ?> details;

    public Response() {
    }

    public Response(String message, HttpStatus status, String code, TreeMap<String, ?> details) {
        this.message = message;
        this.status = status;
        this.code = code;
        this.details = details;
    }

    public static ResponseBuilder builder() {
        return new ResponseBuilder();
    }

    public String message() {
        return message;
    }

    public Response setMessage(String message) {
        this.message = message;
        return this;
    }

    public HttpStatus status() {
        return status;
    }

    public Response setStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public String code() {
        return code;
    }

    public Response setCode(String code) {
        this.code = code;
        return this;
    }

    public TreeMap<String, ?> details() {
        return details;
    }

    public Response setDetails(TreeMap<String, ?> details) {
        this.details = details;
        return this;
    }
}
