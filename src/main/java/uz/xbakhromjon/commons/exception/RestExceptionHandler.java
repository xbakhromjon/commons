package uz.xbakhromjon.commons.exception;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.xbakhromjon.commons.http.ErrorResponse;
import uz.xbakhromjon.commons.http.GenericResponse;
import uz.xbakhromjon.commons.http.TranslatedContent;
import uz.xbakhromjon.commons.localization.Localizer;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class RestExceptionHandler {
    private final Localizer localizer;

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<GenericResponse<Void>> handleCustomExceptions(Exception ex) {
        HttpStatus status = status(ex.getType());
        TranslatedContent message = localizer.getTranslation(ex.getCode());
        ErrorResponse errorResponse = new ErrorResponse(ex.getCode(), message);
        return ResponseEntity.status(status).body(new GenericResponse<>(errorResponse));
    }

    @ExceptionHandler(value = {Throwable.class})
    public ResponseEntity<GenericResponse<Void>> handleExceptions(Throwable ex) {
        TranslatedContent message = localizer.getTranslation("something_went_wrong");
        ErrorResponse errorResponse = new ErrorResponse("something_went_wrong", message);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse<>(errorResponse));
    }

    private HttpStatus status(Type type) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        switch (type) {
            case NOT_FOUND -> status = HttpStatus.NOT_FOUND;
            case CONFLICT -> status = HttpStatus.CONFLICT;
            case BAD_REQUEST -> status = HttpStatus.BAD_REQUEST;
        }
        return status;
    }
}