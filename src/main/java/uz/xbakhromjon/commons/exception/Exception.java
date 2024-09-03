package uz.xbakhromjon.commons.exception;

import lombok.Getter;

@Getter
public class Exception extends RuntimeException {
    private final String code;
    private final Type type;

    public Exception(String code, Type type) {
        super();
        this.code = code;
        this.type = type;
    }
}
