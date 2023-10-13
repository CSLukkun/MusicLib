import org.example.Album;
import org.example.Artist;
import org.example.CompilationAlbum;
import org.example.MusicTrack;

import java.util.Random;

public class CompilationAlbumTest {

    public static void main(String[] args) {
        testAddTracksFromOneAlbum();
        testAddDifferentTracks();
    }


    public static void testAddDifferentTracks() {
        final int size = 10;
        CompilationAlbum compilationAlbum = generateCompilationAlbum();

        for (int i = 0; i < size; i++) {
            Artist artist = ArtistTest.generatAnArtist();
            Album album = AlbumTest.generateAnAlbum();
            MusicTrack track = TracksTest.generateAMusicTrack(artist);
            album.addTrack(track);

            compilationAlbum.addTrack(track);
        }

        System.out.println(compilationAlbum.getArtists());
        System.out.println(compilationAlbum.getOriginalAlbums());
    }

    public static void testAddTracksFromOneAlbum() {
        final int size = 10;
        CompilationAlbum compilationAlbum = generateCompilationAlbum();
        Album album = AlbumTest.generateAnAlbum();
        Artist artist = ArtistTest.generatAnArtist();

        for (int i = 0; i < size; i++) {
            MusicTrack track = TracksTest.generateAMusicTrack(artist);
            album.addTrack(track);

            compilationAlbum.addTrack(track);
        }

        System.out.println(compilationAlbum.getArtists());
        System.out.println(compilationAlbum.getOriginalAlbums());
    }



    public static CompilationAlbum generateCompilationAlbum() {
        return new CompilationAlbum(generateRandomAlbumName());
    }

    public static String generateRandomAlbumName() {
        final String[] albumNames = {
                "compilationAlbum1",
                "compilationAlbum2",
                "compilationAlbum3",
                "compilationAlbum4",
                "compilationAlbum5",
                "compilationAlbum6",
                "compilationAlbum7",
                "compilationAlbum8",
                "compilationAlbum9",
                "compilationAlbum10",
        };
        Random random = new Random();
        int randomIndex = random.nextInt(albumNames.length);
        return albumNames[randomIndex];
    }
}