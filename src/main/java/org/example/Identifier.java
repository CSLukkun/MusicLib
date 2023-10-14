package org.example;

/**
 * Provide a interface for generate a unique identity
 */
public interface Identifier {
    /**
     * Generate a unique identifier in string format
     * Implementing classes should that the returned ID is distinct.
     *
     * @return A unique string identifier.
     */
    String generateUniqueId();
}
