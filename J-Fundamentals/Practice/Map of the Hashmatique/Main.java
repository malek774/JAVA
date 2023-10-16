import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Create a HashMap to store track titles as keys and lyrics as values
        HashMap<String, String> trackList = new HashMap<>();

        // Add songs to the trackList HashMap
        trackList.put("Song1", "Lyrics for Song 1...");
        trackList.put("Song2", "Lyrics for Song 2...");
        trackList.put("Song3", "Lyrics for Song 3...");
        trackList.put("Song4", "Lyrics for Song 4...");

        // Retrieve a song by its title
        String songTitle = "Song2";
        String songLyrics = trackList.get(songTitle);
        System.out.println("Retrieved Song:");
        System.out.println("Track: " + songTitle);
        System.out.println("Lyrics: " + songLyrics);

        // Print out all track names and lyrics
        System.out.println("\nAll Tracks and Lyrics:");
        for (String title : trackList.keySet()) {
            String lyrics = trackList.get(title);
            System.out.println("Track: " + title);
            System.out.println("Lyrics: " + lyrics);
            System.out.println("--------------");
        }
    }
}
