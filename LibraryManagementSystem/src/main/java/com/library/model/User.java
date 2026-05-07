package com.library.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 * Abstract base class for all users in the library system.
 * Demonstrates: Encapsulation (private fields + Lombok getters/setters),
 *               Abstraction (abstract methods), and
 *               Inheritance (AdminUser / RegularUser extend this).
 */
@Getter
@Setter
@NoArgsConstructor
public abstract class User {

    private String id;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String role;           // "ADMIN" or "USER"
    private String membershipType; // "REGULAR" or "PREMIUM"

    /**
     * Parameterised constructor.
     */
    public User(String id, String fullName, String username, String password,
                String email, String role, String membershipType) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.membershipType = membershipType;
    }

    /* --------------------------------------------------------
     * Abstract methods — subclasses MUST implement these.
     * Demonstrates: Abstraction + Polymorphism
     * -------------------------------------------------------- */

    /** Returns a description of the privileges this user role has. */
    public abstract String getPrivileges();

    /** Returns the dashboard path appropriate for this user role. */
    public abstract String getDashboardPath();

    /* --------------------------------------------------------
     * Concrete helper methods
     * -------------------------------------------------------- */

    /**
     * Serialize user to a pipe-delimited string for .txt persistence.
     */
    public String toFileString() {
        return String.join("|", id, fullName, username, password, email, role, membershipType);
    }

    /**
     * Utility: build a User subclass from a pipe-delimited line.
     */
    public static User fromFileString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length < 7) return null;

        String role = parts[5].trim();
        if ("ADMIN".equalsIgnoreCase(role)) {
            return new AdminUser(parts[0].trim(), parts[1].trim(), parts[2].trim(),
                    parts[3].trim(), parts[4].trim(), parts[5].trim(), parts[6].trim());
        } else {
            return new RegularUser(parts[0].trim(), parts[1].trim(), parts[2].trim(),
                    parts[3].trim(), parts[4].trim(), parts[5].trim(), parts[6].trim());
        }
    }

    @Override
    public String toString() {
        return "User{id='" + id + "', fullName='" + fullName + "', username='" + username +
                "', role='" + role + "', membership='" + membershipType + "'}";
    }
}
