package com.josephmarchand.englishjoe.languages;

public class LanguageOption {

    private final String code;
    private final String name;
    private final String nativeName;

    public LanguageOption(String code, String name, String nativeName) {
        this.code = code == null ? "" : code;
        this.name = name == null ? "" : name;
        this.nativeName = nativeName == null ? "" : nativeName;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getNativeName() {
        return nativeName;
    }

    @Override
    public String toString() {
        return nativeName + " (" + name + ")";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof LanguageOption)) {
            return false;
        }

        LanguageOption other = (LanguageOption) object;
        return code.equalsIgnoreCase(other.code);
    }

    @Override
    public int hashCode() {
        return code.toLowerCase(java.util.Locale.ROOT).hashCode();
    }
}
