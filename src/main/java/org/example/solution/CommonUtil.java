package org.example.solution;

import java.util.HashMap;
import java.util.Locale;

public class CommonUtil {

    public static HashMap<String, String> findCountryIso2Code() {
        String[] isoCountries = Locale.getISOCountries();
        HashMap<String, String> countries = new HashMap<>(isoCountries.length);
        for (String country : isoCountries) {
            Locale locale = new Locale("", country);
            countries.put(locale.getISO3Country().toUpperCase(), locale.getCountry());
        }
        countries.put("GBR", "UK");
        return countries;
    }

}
