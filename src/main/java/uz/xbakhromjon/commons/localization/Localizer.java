package uz.xbakhromjon.commons.localization;

import uz.xbakhromjon.commons.http.TranslatedContent;

public interface Localizer {
    TranslatedContent getTranslation(String key);
}
