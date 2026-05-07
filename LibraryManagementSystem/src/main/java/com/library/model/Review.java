package com.library.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Represents a book review submitted by a user.
 * Demonstrates: Encapsulation via Lombok.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    private String reviewId;
    private String userId;
    private String bookId;
    private int rating;          // 1-5
    private String comment;
    private String status;       // "PENDING", "APPROVED", "REJECTED"

    /* --------------------------------------------------------
     * File persistence helpers
     * -------------------------------------------------------- */

    public String toFileString() {
        return String.join("|", reviewId, userId, bookId,
                String.valueOf(rating), comment, status);
    }

    public static Review fromFileString(String line) {
        String[] p = line.split("\\|");
        if (p.length < 6) return null;

        Review r = new Review();
        r.setReviewId(p[0].trim());
        r.setUserId(p[1].trim());
        r.setBookId(p[2].trim());
        r.setRating(Integer.parseInt(p[3].trim()));
        r.setComment(p[4].trim());
        r.setStatus(p[5].trim());
        return r;
    }

    @Override
    public String toString() {
        return "Review{id='" + reviewId + "', bookId='" + bookId +
                "', rating=" + rating + "}";
    }
}
