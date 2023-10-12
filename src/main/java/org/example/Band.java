package org.example;

import java.util.ArrayList;
import java.util.List;

public class Band extends Artist {
    private List<Artist> members;

    public Band(String name) {
        super(name);
        members = new ArrayList<>();
    }

    public void addMember(Artist member) {
        members.add(member);
    }

    public List<Artist> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        StringBuilder artistInfo = new StringBuilder("Band: " + name);
        return artistInfo.toString();
    }
}