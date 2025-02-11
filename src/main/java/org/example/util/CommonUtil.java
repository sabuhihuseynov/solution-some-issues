package org.example.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CommonUtil {

    public static Map<String, String> findCountryIso2Code() {
        String[] isoCountries = Locale.getISOCountries();
        HashMap<String, String> countries = HashMap.newHashMap(isoCountries.length);
        for (String country : isoCountries) {
            Locale locale = Locale.of("", country);
            countries.put(locale.getISO3Country().toUpperCase(), locale.getCountry());
        }
        countries.put("GBR", "UK");
        return countries;
    }

}
