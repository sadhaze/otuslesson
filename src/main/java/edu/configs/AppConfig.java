package edu.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@ConfigurationProperties
public class AppConfig {
    private MessageSource messageSource;

    public MessageSource getMessage() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/messages/messages");
        ms.setDefaultEncoding("Windows-1251");
        return ms;
    }

    public void setMessage(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
