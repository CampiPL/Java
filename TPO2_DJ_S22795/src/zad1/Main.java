/**
 * @author Depka Jakub S22795
 */

package zad1;

import javax.swing.*;
import java.util.Currency;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Service s = new Service("Poland");
        String weatherJson = s.getWeather("Warsaw");
        Double rate1 = s.getRateFor("USD");
        Double rate2 = s.getNBPRate();
        // ...

        /*


        for (Locale availableLocale : Locale.getAvailableLocales()) {
            System.out.println(availableLocale.getDisplayCountry(Locale.forLanguageTag("pl")));
            try {
                System.out.println(Currency.getInstance(availableLocale));
            } catch (IllegalArgumentException e){

            }
            System.out.println(availableLocale.getISO3Language());
        }

         */

        SwingUtilities.invokeLater(() -> new WebGUI(s, weatherJson,rate1,rate2));

        // część uruchamiająca GUI
    }
}
