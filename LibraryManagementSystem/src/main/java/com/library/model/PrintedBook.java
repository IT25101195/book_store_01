package com.library.model;

import lombok.NoArgsConstructor;

/**
 * Concrete PrintedBook subclass – inherits from Book.
 * Demonstrates: Inheritance + Polymorphism.
 */
@NoArgsConstructor
public class PrintedBook extends Book {

    public PrintedBook(String id, String title, String author, String category,
                       String isbn, boolean available, String type) {
        super(id, title, author, category, isbn, available, type);
    }

    @Override
    public String getDisplayInfo() {
        return "[Printed] " + getTitle() + " by " + getAuthor() +
                " | Category: " + getCategory() +
                " | Available: " + (isAvailable() ? "Yes" : "No");
    }

    @Override
    public int getMaxBorrowDays() {
        return 14; // printed books can be borrowed for 14 days
    }
}
