package com.felipelauten.tradevalidation.dto.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Trade <code>type</code>.
 */
public enum Type {

    @JsonProperty("Spot")
    SPOT("Spot"),
    @JsonProperty("Forward")
    FORWARD("Forward"),
    @JsonProperty("VanillaOption")
    VANILLA_OPTION("VanillaOption");

    private String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Type type : Type.values()) {
            names.add(type.getName());
        }

        return names;
    }
}
