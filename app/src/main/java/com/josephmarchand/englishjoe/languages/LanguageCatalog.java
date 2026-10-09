package com.josephmarchand.englishjoe.languages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class LanguageCatalog {

    private static final List<LanguageOption> LANGUAGES = createLanguages();

    private LanguageCatalog() {
    }

    private static List<LanguageOption> createLanguages() {
        List<LanguageOption> list = new ArrayList<>();

        list.add(new LanguageOption("fr", "French", "Français"));
        list.add(new LanguageOption("en", "English", "English"));
        list.add(new LanguageOption("ln", "Lingala", "Lingála"));
        list.add(new LanguageOption("sw", "Swahili", "Kiswahili"));
        list.add(new LanguageOption("es", "Spanish", "Español"));
        list.add(new LanguageOption("pt", "Portuguese", "Português"));
        list.add(new LanguageOption("de", "German", "Deutsch"));
        list.add(new LanguageOption("it", "Italian", "Italiano"));
        list.add(new LanguageOption("ar", "Arabic", "العربية"));
        list.add(new LanguageOption("zh", "Chinese", "中文"));

        return Collections.unmodifiableList(list);
    }

    public static List<LanguageOption> getAll() {
        return LANGUAGES;
    }

    public static LanguageOption findByCode(String code) {
        if (code == null) {
            return null;
        }

        for (LanguageOption language : LANGUAGES) {
            if (language.getCode().equalsIgnoreCase(code.trim())) {
                return language;
            }
        }

        return null;
    }

    public static List<LanguageOption> search(String query) {
        List<LanguageOption> results = new ArrayList<>();

        String normalized = query == null
                ? ""
                : query.trim().toLowerCase(Locale.ROOT);

        for (LanguageOption language : LANGUAGES) {
            if (language.getName().toLowerCase(Locale.ROOT).contains(normalized)
                    || language.getNativeName()
                    .toLowerCase(Locale.ROOT).contains(normalized)) {
                results.add(language);
            }
        }

        return results;
    }
}
