package edu.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@ConfigurationProperties
public class AppConfig {
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/messages/messages");
        ms.setDefaultEncoding("Windows-1251");
        //ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    public Locale getLocale(){
        return new Locale("en", "EN");
        //return new Locale("ru", "RU");
    }
}
