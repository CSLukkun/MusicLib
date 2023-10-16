package org.example;
import java.util.ArrayList;

/**
 * Represent an Artist who is a band.
 * Extend the Artist class with extra functionality such as handling with band member.
 */
public class Band extends Artist {
    /**
     * All members in the band.
     */
    private ArrayList<Artist> members;

    /**
     * Constructor of a band object
     *
     * @param name the name of the band
     */
    public Band(String name) {
        super(name);
        members = new ArrayList<>();
    }

    /**
     * Add an Artist in the band.
     *
     * @param member An artist in the band.
     */
    public void addMember(Artist member) {
        if (members.contains(member)) {
            return;
        }
        members.add(member);
    }

    /**
     * Remove an Artist in the band
     *
     * @param artist An artist in the band
     */
    public void removeMember(Artist artist) {
        members.remove(artist);
    }

    /**
     * Return all members in the band.
     *
     * @return all members in the band.
     */
    public ArrayList<Artist> getMembers() {
        return members;
    }

    /**
     * Return formatted string including band's name and band's members.
     *
     * @return A formatted string including band's name and band's members.
     */
    @Override
    public String toString() {
        return "Band: " + name + "\n" + "Members: " + "\n" + members;
    }


    /**
     * Remove an artist in the band by artist id.
     *
     * @param id the id of the member included in the band
     */
    public void removeMemberById(String id) {
        for (Artist artist : members) {
            if (artist.getArtistId().equals(id)) {
                members.remove(artist);
                break;
            }
        }
    }
}