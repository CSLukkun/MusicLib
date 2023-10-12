package org.example;

public class Soloist extends Artist {
    public Soloist(String name) {
        super(name);
    }

    @Override
    public String toString() {
        StringBuilder artistInfo = new StringBuilder("Soloist: " + name);
        return artistInfo.toString();
    }
}