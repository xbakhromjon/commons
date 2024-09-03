package uz.xbakhromjon.commons.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private final String code;
    private final TranslatedContent message;
    private final Map<String, String> details;
    private final LocalDateTime timestamp;

    public ErrorResponse(String code, TranslatedContent message) {
        this.code = code;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.details = new HashMap<>();
    }
}
