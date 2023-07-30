package dev.emirman.util.response.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dev.emirman.util.response.serializer.ResponseSerializer;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.TreeMap;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;


@JsonSerialize(using = ResponseSerializer.class)
public class Response implements Serializable {
    private String message;
    private HttpStatus status;
    private String code;
    @JsonInclude(NON_NULL)
    private TreeMap<String, ?> details;

    public Response() {
        this.status = HttpStatus.OK;
    }

    public static ResponseBuilder builder() {
        return new ResponseBuilder();
    }

    public String message() {
        return message;
    }

    public Response message(String message) {
        this.message = message;
        return this;
    }

    public HttpStatus status() {
        return status;
    }

    public Response status(HttpStatus status) {
        this.status = status;
        return this;
    }

    public String code() {
        return code;
    }

    public Response code(String code) {
        this.code = code;
        return this;
    }

    public TreeMap<String, ?> details() {
        return details;
    }

    public Response details(TreeMap<String, ?> details) {
        this.details = details;
        return this;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
}
