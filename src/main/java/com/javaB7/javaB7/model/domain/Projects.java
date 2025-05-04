package com.javaB7.javaB7.model.domain;

public class Projects {
    private final String name;
    private final String description;

    public Projects(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
