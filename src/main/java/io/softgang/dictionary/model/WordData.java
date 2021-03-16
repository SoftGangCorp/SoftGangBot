package io.softgang.dictionary.model;

public class WordData {
    private String id;
    private WordIndexData data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WordIndexData getData() {
        return data;
    }

    public void setData(WordIndexData data) {
        this.data = data;
    }
}
