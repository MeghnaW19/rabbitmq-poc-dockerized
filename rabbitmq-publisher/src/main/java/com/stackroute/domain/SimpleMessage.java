package com.stackroute.domain;

import java.io.Serializable;

public class SimpleMessage implements Serializable {
    private String name;
    private String description;

    /*
    default constructor
    */
    public SimpleMessage() {
    }

    /*
    parameterized constructor
    */
    public SimpleMessage(String name, String description) {
        this.name = name;
        this.description = description;
    }
    /*
    getters and setters
    */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*
    toString method
    */
    @Override
    public String toString() {
        return "SimpleMessage{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
