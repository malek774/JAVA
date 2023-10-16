import java.util.ArrayList;
import java.util.Collections;

public class Museum {
    public static void main(String[] args) {
        ArrayList<Art> museum = new ArrayList<>();

        museum.add(new Painting("Starry Night", "Vincent van Gogh", "Famous night sky painting", "Oil"));
        museum.add(new Painting("Mona Lisa", "Leonardo da Vinci", "Iconic portrait painting", "Oil"));
        museum.add(new Painting("The Persistence of Memory", "Salvador Dali", "Melting clocks painting", "Oil"));

        museum.add(new Sculpture("David", "Michelangelo", "Famous marble sculpture", "Marble"));
        museum.add(new Sculpture("The Thinker", "Auguste Rodin", "Contemplative man sculpture", "Bronze"));

        // Shuffle the artworks
        Collections.shuffle(museum);

        // Print information for each artwork in the museum
        for (Art artwork : museum) {
            artwork.viewArt();
        }
    }
}
