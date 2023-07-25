package dev.emirman.util.response.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import dev.emirman.util.response.base.Response;

import java.io.IOException;

public class ResponseSerializer extends JsonSerializer<Response> {
    @Override
    public void serialize(Response value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("message", value.message());
        gen.writeNumberField("status", value.status().value());
        if (value.code() != null)
            gen.writeStringField("code", value.code());
        if (value.details() != null)
            gen.writeObjectField("details", value.details());
        gen.writeEndObject();
    }
}
