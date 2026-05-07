package com.library.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 * Abstract base class for all books.
 * Demonstrates: Encapsulation, Abstraction, and Inheritance.
 */
@Getter
@Setter
@NoArgsConstructor
public abstract class Book {

    private String id;
    private String title;
    private String author;       // author name (display convenience)
    private String category;
    private String isbn;
    private boolean available;
    private String type;         // "EBOOK" or "PRINTED"

    public Book(String id, String title, String author, String category,
                String isbn, boolean available, String type) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isbn = isbn;
        this.available = available;
        this.type = type;
    }

    /* --------------------------------------------------------
     * Abstract methods — demonstrate Abstraction + Polymorphism
     * -------------------------------------------------------- */

    /** Returns a formatted display string for this book type. */
    public abstract String getDisplayInfo();

    /** Returns maximum borrowing days allowed for this book type. */
    public abstract int getMaxBorrowDays();

    /* --------------------------------------------------------
     * File persistence helpers
     * -------------------------------------------------------- */

    public String toFileString() {
        return String.join("|", id, title, author, category, isbn,
                String.valueOf(available), type);
    }

    public static Book fromFileString(String line) {
        String[] p = line.split("\\|");
        if (p.length < 7) return null;

        String type = p[6].trim();
        boolean avail = Boolean.parseBoolean(p[5].trim());
        if ("EBOOK".equalsIgnoreCase(type)) {
            return new EBook(p[0].trim(), p[1].trim(), p[2].trim(),
                    p[3].trim(), p[4].trim(), avail, type);
        } else {
            return new PrintedBook(p[0].trim(), p[1].trim(), p[2].trim(),
                    p[3].trim(), p[4].trim(), avail, type);
        }
    }

    @Override
    public String toString() {
        return "Book{id='" + id + "', title='" + title + "', type='" + type + "'}";
    }
}
