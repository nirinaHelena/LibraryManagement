package com.libraryManagement.model;

import lombok.Setter;


public enum Topic {
    COMEDY, ROMANCE, OTHER;
    public static Topic toTopic(String value) {
        if (value != null) {
            for (Topic topic : values()) {
                if (topic.name().equalsIgnoreCase(value)) {
                    return topic;
                }
            }
        }
        throw new IllegalArgumentException("No enum constant for string: " + value);
    }
    @Override
    public String toString() {
        return name();
    }
}
