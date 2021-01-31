package by.it.doNotTouch.zhilenkova.jd02.ZhilenkovaCalcAll.localization;


import java.util.Locale;
import java.util.ResourceBundle;

public enum TranslateManager implements Message {
    INSTANCE;

    private final String RESOURCE = "by.it.zhilenkova.jd02.ZhilenkovaCalcAll.localization.messages";

    private Locale locale;

    private ResourceBundle resourceBundle;


    TranslateManager(){
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(RESOURCE, locale);
    }
    public void setLocale(String language, String country){
        setLocale(new Locale(language, country));
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }





}
