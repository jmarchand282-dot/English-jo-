package com.josephmarchand.englishjoe.models;

public class Expression {

    private String english;
    private String french;
    private String pronunciation;
    private String example;

    public Expression(
            String english,
            String french,
            String pronunciation,
            String example
    ) {
        this.english = english;
        this.french = french;
        this.pronunciation = pronunciation;
        this.example = example;
    }

    public String getEnglish() {
        return english;
    }

    public String getFrench() {
        return french;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public String getExample() {
        return example;
    }
}
