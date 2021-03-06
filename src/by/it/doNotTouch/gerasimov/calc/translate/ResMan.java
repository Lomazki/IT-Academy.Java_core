package by.it.doNotTouch.gerasimov.calc.translate;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private static final String BASE_NAME = "by.it.gerasimov.calc.translate.lang.messages";
    ResourceBundle bundle;

    ResMan() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(BASE_NAME, locale);
        Locale.setDefault(locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }
}
