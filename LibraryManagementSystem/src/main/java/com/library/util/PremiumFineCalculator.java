package com.library.util;

/**
 * Fine calculator for PREMIUM users – lower rate.
 * Demonstrates: Polymorphism – different fine rate compared to RegularFineCalculator.
 */
public class PremiumFineCalculator implements FineCalculator {

    private static final double DAILY_RATE = 0.75; // $0.75 per overdue day

    @Override
    public double calculateFine(int overdueDays) {
        if (overdueDays <= 0) return 0.0;
        return overdueDays * DAILY_RATE;
    }
}
