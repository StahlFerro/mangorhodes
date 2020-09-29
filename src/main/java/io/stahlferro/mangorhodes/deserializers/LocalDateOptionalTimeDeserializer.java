package io.stahlferro.mangorhodes.deserializers;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import io.stahlferro.mangorhodes.utility.models.TimeConstants;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LocalDateOptionalTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String dateText = p.getValueAsString();
        try {
            return LocalDateTime.parse(dateText, TimeConstants.LOCAL_DATE_OPTIONAL_TIME_FORMATTER);
        } catch (Exception e) {
            log.warn("Unable to deserialize date time string into LocalDateTime: " + dateText, e);
            return null;
        }
    }
}

