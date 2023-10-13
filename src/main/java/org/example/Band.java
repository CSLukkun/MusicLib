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
    public void removeMember(Artist artist) {
        members.remove(artist);
    }

    public List<Artist> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        StringBuilder artistInfo = new StringBuilder("Band: " + name + "\n" + "Members: " + "\n" + members);
        return artistInfo.toString();
    }


    public void removeMemberById(String id) {
        for (Artist artist : members) {
            if (artist.getArtistId().equals(id)) {
                members.remove(artist);
                break;
            }
        }
    }
}