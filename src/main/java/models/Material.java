package models;

import java.util.*;

public enum Material {
    PHARMACEUTICALS("drugs", "pharmaceuticals"),
    FOOD("food"),
    ELECTRONICS("electronics");

    private final List<String> values;

    Material(String... values) {
        this.values = new ArrayList<String>(Arrays.asList(values));
    }

    public boolean contains(String material) {
        return values.contains(material.toLowerCase());
    }
}