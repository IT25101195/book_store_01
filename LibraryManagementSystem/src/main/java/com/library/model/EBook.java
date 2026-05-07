package com.library.model;

import lombok.NoArgsConstructor;

/**
 * Concrete EBook subclass – inherits from Book.
 * Demonstrates: Inheritance + Polymorphism.
 */
@NoArgsConstructor
public class EBook extends Book {

    public EBook(String id, String title, String author, String category,
                 String isbn, boolean available, String type) {
        super(id, title, author, category, isbn, available, type);
    }

    @Override
    public String getDisplayInfo() {
        return "[E-Book] " + getTitle() + " by " + getAuthor() +
                " | Category: " + getCategory() +
                " | Available: " + (isAvailable() ? "Yes" : "No");
    }

    @Override
    public int getMaxBorrowDays() {
        return 21; // e-books can be borrowed for 21 days
    }
}
