package com.daw.jsfproject;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author MIsabelCarde
 */
@Named
@SessionScoped
public class LanguageBean implements Serializable {
    
    private Locale locale;
    private final String SPANISH = "es";
    private final String ENGLISH = "en";
    
    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(context != null){
            setLocale(context.getViewRoot().getLocale());
        }else{
            setLocale(new Locale(SPANISH));
        }
    }
    
    public void selectSpanish(){
        changeLocale(new Locale(SPANISH));
    }
    
    public void selectEnglish(){
        changeLocale(new Locale(ENGLISH));
    }
    
    public void changeLocale(Locale locale){
        setLocale(locale);
        FacesContext context = FacesContext.getCurrentInstance();
        if(context != null){
            context.getViewRoot().setLocale(getLocale());
        }
    }

    /**
     * @return the locale
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * @param locale the locale to set
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
}
