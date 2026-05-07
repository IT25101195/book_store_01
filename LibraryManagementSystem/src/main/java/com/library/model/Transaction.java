package com.library.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Represents a borrowing/returning transaction.
 * Demonstrates: Encapsulation via Lombok.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    private String transactionId;
    private String userId;
    private String bookId;
    private String borrowDate;   // yyyy-MM-dd
    private String dueDate;      // yyyy-MM-dd
    private String returnDate;   // yyyy-MM-dd or empty
    private double fineAmount;

    /* --------------------------------------------------------
     * File persistence helpers
     * -------------------------------------------------------- */

    public String toFileString() {
        return String.join("|", transactionId, userId, bookId, borrowDate,
                dueDate, (returnDate != null ? returnDate : ""),
                String.valueOf(fineAmount));
    }

    public static Transaction fromFileString(String line) {
        String[] p = line.split("\\|");
        if (p.length < 7) return null;

        Transaction t = new Transaction();
        t.setTransactionId(p[0].trim());
        t.setUserId(p[1].trim());
        t.setBookId(p[2].trim());
        t.setBorrowDate(p[3].trim());
        t.setDueDate(p[4].trim());
        t.setReturnDate(p[5].trim().isEmpty() ? null : p[5].trim());
        t.setFineAmount(Double.parseDouble(p[6].trim()));
        return t;
    }

    @Override
    public String toString() {
        return "Transaction{id='" + transactionId + "', userId='" + userId +
                "', bookId='" + bookId + "'}";
    }
}
