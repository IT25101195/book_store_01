package com.library.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 * Abstract base class for authors.
 * Demonstrates: Encapsulation, Abstraction, and Inheritance.
 */
@Getter
@Setter
@NoArgsConstructor
public abstract class Author {

    private String authorId;
    private String name;
    private String type;       // "GUEST" or "PERMANENT"
    private String biography;

    public Author(String authorId, String name, String type, String biography) {
        this.authorId = authorId;
        this.name = name;
        this.type = type;
        this.biography = biography;
    }

    /** Abstract method – polymorphic display */
    public abstract String getAuthorDetails();

    /* --------------------------------------------------------
     * File persistence helpers
     * -------------------------------------------------------- */

    public String toFileString() {
        return String.join("|", authorId, name, type, biography);
    }

    public static Author fromFileString(String line) {
        String[] p = line.split("\\|");
        if (p.length < 4) return null;

        String type = p[2].trim();
        if ("GUEST".equalsIgnoreCase(type)) {
            return new GuestAuthor(p[0].trim(), p[1].trim(), p[2].trim(), p[3].trim());
        } else {
            return new PermanentAuthor(p[0].trim(), p[1].trim(), p[2].trim(), p[3].trim());
        }
    }

    @Override
    public String toString() {
        return "Author{id='" + authorId + "', name='" + name + "', type='" + type + "'}";
    }
}
