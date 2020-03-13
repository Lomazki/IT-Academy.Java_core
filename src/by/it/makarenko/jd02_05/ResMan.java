package by.it.makarenko.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum  ResMan {
    INSTANCE;


   private String baseName = "by.it.makarenko.jd02_05.trans.lang";

   ResourceBundle bundle;
   private ResMan(){
       setLocale(Locale.getDefault());
   }
  public void setLocale(Locale locale){
       bundle = ResourceBundle.getBundle(baseName,locale);
   }

   public String get(String key){
       return bundle.getString(key);
   }
 }
