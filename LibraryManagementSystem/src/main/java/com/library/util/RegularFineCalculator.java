package com.library.util;

/**
 * Fine calculator for REGULAR users.
 * Demonstrates: Polymorphism – different fine rate compared to PremiumFineCalculator.
 */
public class RegularFineCalculator implements FineCalculator {

    private static final double DAILY_RATE = 1.50; // $1.50 per overdue day

    @Override
    public double calculateFine(int overdueDays) {
        if (overdueDays <= 0) return 0.0;
        return overdueDays * DAILY_RATE;
    }
}
