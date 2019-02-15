package edu.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@ConfigurationProperties
public class YAMLConfig {
    private Locale locale;

    private MessageSource messageSource;

    private String country;
    private String language;
    private String messageSourceBasename;
    private String messageSourceEncoding;

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public Locale getLocale(){
        return locale;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setLanguage(String language){
        this.language = language;
    }

    public void setLocale(){
        if(locale == null) locale = new Locale(language, country);
    }

    public void setMessageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename(messageSourceBasename);
        ms.setDefaultEncoding(messageSourceEncoding);
        this.messageSource = ms;
    }

    public void setMessageSourceBasename(String messageSourceBasename){
        this.messageSourceBasename = messageSourceBasename;
    }

    public void setMessageSourceEncoding(String messageSourceEncoding){
        this.messageSourceEncoding = messageSourceEncoding;
    }
}
