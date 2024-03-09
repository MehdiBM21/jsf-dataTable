package com.example.demo14.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@FacesConverter(value = "localDateConverter", managed = true)
public class LocalDateConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            return LocalDate.parse(value, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (Exception e) {
            String language = FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage();
            String msg = language.equals("fr") ? "Format de date invalide (dd-MM-yyyy)" : "Invalid date format (dd-MM-yyyy)";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur de conversion", msg);
            context.addMessage(component.getClientId(context), message);
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }

        return ((LocalDate) value).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
