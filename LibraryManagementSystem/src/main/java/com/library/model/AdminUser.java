package com.library.model;

import lombok.NoArgsConstructor;

/**
 * Concrete admin user – inherits from User.
 * Demonstrates: Inheritance + Polymorphism (overrides abstract methods).
 */
@NoArgsConstructor
public class AdminUser extends User {

    public AdminUser(String id, String fullName, String username, String password,
                     String email, String role, String membershipType) {
        super(id, fullName, username, password, email, role, membershipType);
    }

    @Override
    public String getPrivileges() {
        return "Full administrative access: manage books, users, reviews, and transactions.";
    }

    @Override
    public String getDashboardPath() {
        return "/admin/dashboard";
    }
}
