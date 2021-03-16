package io.softgang.dictionary.model;

import java.util.List;

public class ExplainationData {
    private String partOfSpeech;
    private String example;
    private String definition;
    private String[] englishTranslation;

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String[] getEnglishTranslation() {
        return englishTranslation;
    }

    public void setEnglishTranslation(String[] englishTranslation) {
        this.englishTranslation = englishTranslation;
    }
}
