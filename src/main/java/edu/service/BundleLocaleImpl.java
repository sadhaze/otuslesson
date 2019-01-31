package edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service("Set bundle locale service")
public class BundleLocaleImpl implements BundleLocale {
    private Locale locale = null;

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
