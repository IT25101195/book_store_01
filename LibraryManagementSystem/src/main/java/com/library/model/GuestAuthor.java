package com.library.model;

import lombok.NoArgsConstructor;

/**
 * Concrete GuestAuthor subclass.
 * Demonstrates: Inheritance + Polymorphism.
 */
@NoArgsConstructor
public class GuestAuthor extends Author {

    public GuestAuthor(String authorId, String name, String type, String biography) {
        super(authorId, name, type, biography);
    }

    @Override
    public String getAuthorDetails() {
        return "[Guest Author] " + getName() + " — " + getBiography();
    }
}
