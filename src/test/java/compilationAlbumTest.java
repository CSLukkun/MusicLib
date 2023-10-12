import org.example.Artist;
import org.example.CompilationAlbum;
import org.example.MusicTrack;

import javax.sound.midi.Track;

public class compilationAlbumTest {



    public static void testAddDifferentTracks() {
        final int size = 10;
        CompilationAlbum compilationAlbum = new CompilationAlbum();
        for (int i = 0; i < size; i++) {
            Artist artist = ArtistTest.generatAnArtist();
            MusicTrack track = TracksTest.generateAMusicTrack(artist);
        }
    }

    public static CompilationAlbum generateCompilationAlbum() {
        return new CompilationAlbum();
    }

    public static String generateRandomAlbumName() {

    }



}
