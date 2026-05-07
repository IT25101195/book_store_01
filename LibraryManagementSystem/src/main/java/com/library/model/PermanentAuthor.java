package com.library.model;

import lombok.NoArgsConstructor;

/**
 * Concrete PermanentAuthor subclass.
 * Demonstrates: Inheritance + Polymorphism.
 */
@NoArgsConstructor
public class PermanentAuthor extends Author {

    public PermanentAuthor(String authorId, String name, String type, String biography) {
        super(authorId, name, type, biography);
    }

    @Override
    public String getAuthorDetails() {
        return "[Permanent Author] " + getName() + " — " + getBiography();
    }
}
