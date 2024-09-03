package uz.xbakhromjon.commons.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TranslatedContent {
    private String text;
    private String uz;
    private String ru;
}
