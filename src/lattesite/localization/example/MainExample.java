package lattesite.localization.example;

import lattesite.localization.locale.Locale;
import lattesite.localization.text.English;
import lattesite.localization.text.French;
import lattesite.localization.text.German;
import lattesite.localization.text.Swedish;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lattesite.localization.text.English.English;
import static lattesite.localization.text.French.French;
import static lattesite.localization.text.German.German;
import static lattesite.localization.text.Swedish.Swedish;

public class MainExample {

    public static void main(String[] args) throws Exception {

        // Define a list of locales for the example
        List<Locale> locales = new ArrayList<>();
        locales.add(new Locale("se-SE", "https://www.domain.com/fr/")); // Custom locale "fr"

        // Print out a translated text for each locale
        for (Locale locale : locales) {
            printHello(locale, "Homer Simpson", 36);
        }

        /*

Hello! My name is Homer Simpson and I am 36 years old.
Hej! Jag heter Homer Simpson och jag är 36 år gammal.
Hallo! Mein Name ist Homer Simpson und ich bin 36 Jahre alt.
Bonjour ! Je m'appelle Homer Simpson et j'ai 36 ans.

         */

    }

    private static void printHello(Locale locale, String name, int age) throws Exception {

        String text = TranslationUtil.translate(locale,
                English("Hello! My name is $name and I am $age years old."),
                Swedish("Hej! Jag heter $name och jag är $age år gammal."),
                German("Hallo! Mein Name ist $name und ich bin $age Jahre alt."),
                French("Bonjour ! Je m'appelle $name et j'ai $age ans."),
                Map.of(
                        "name", name,
                        "age", age
                )
        );

        System.out.println(text);

    }

    // Example of creating a translation utility class
    private abstract class TranslationUtil {

        public static String translate(
                Locale locale,
                English english,
                Swedish swedish,
                German german,
                French french
        ) {
            return translate(
                    locale,
                    english,
                    swedish,
                    german,
                    french
            );
        }

        public static String translate(
                Locale locale,
                English english,
                Swedish swedish,
                German german,
                French french,
                Map<String, Object> parameters
        ) throws Exception {

            String text;

            switch (locale.getCode()) {
                case "en": {
                    text = english.toString();
                    break;
                }
                case "sv": {
                    text = swedish.toString();
                    break;
                }
                case "de": {
                    text = german.toString();
                    break;
                }
                case "fr": {
                    text = french.toString();
                    break;
                }
                default: {
                    throw new Exception("Unknown localization \"" + locale.getCode() + "\".");
                }
            }

            // Replace $ parameters
            if (parameters != null) {
                for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                    text = text.replace("$" + entry.getKey(), entry.getValue().toString());
                }
            }

            return text;

        }

    }

}