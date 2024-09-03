package uz.xbakhromjon.commons.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse<T> {
    private T result;
    private ErrorResponse error;

    public GenericResponse(T result) {
        this.result = result;
    }

    public GenericResponse(ErrorResponse error) {
        this.error = error;
    }
}
