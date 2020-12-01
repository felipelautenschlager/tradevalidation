package com.felipelauten.tradevalidation.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationBag {

    private List<ValidationEntry> entries;

    public ValidationBag() {
        this.entries = new ArrayList<>();
    }

    public void addValidationEntry(ValidationEntry entry) {
        if (entry != null) {
            this.entries.add(entry);
        }
    }

    public List<ValidationEntry> getEntries() {
        return entries;
    }
}
