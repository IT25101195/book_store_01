package com.library.model;

import lombok.NoArgsConstructor;

/**
 * Concrete regular (non-admin) user – inherits from User.
 * Demonstrates: Inheritance + Polymorphism.
 */
@NoArgsConstructor
public class RegularUser extends User {

    public RegularUser(String id, String fullName, String username, String password,
                       String email, String role, String membershipType) {
        super(id, fullName, username, password, email, role, membershipType);
    }

    @Override
    public String getPrivileges() {
        return "Standard access: browse books, borrow/return, leave reviews.";
    }

    @Override
    public String getDashboardPath() {
        return "/user/dashboard";
    }
}
