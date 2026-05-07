package com.library.util;

/**
 * Interface for calculating fines.
 * Demonstrates: Abstraction via interface + Polymorphism.
 */
public interface FineCalculator {

    /**
     * Calculate fine based on overdue days.
     * @param overdueDays number of days past the due date
     * @return fine amount
     */
    double calculateFine(int overdueDays);
}
