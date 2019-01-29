package edu.service;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class BundleLocaleService implements BundleLocaleImpl {
    private Locale locale;

    public void BundleLocaleService(){
        setLocale(Locale.ROOT);
    }

    public void BundleLocaleService(Locale locale){
        setLocale(locale);
    }

    public Locale getLocale(){
        return this.locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
