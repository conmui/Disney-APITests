import java.util.List;

public class Character {
    private int characterId;
    private List<String> films;
    private List<String> shortFilms;
    private List<String> tvShows;
    private List<String> videoGames;
    private List<String> parkAttractions;
    private List<String> allies;
    private List<String> enemies;
    private String sourceUrl;
    private String name;
    private String imageUrl;
    private String createdAt;
    private String updatedAt;
    private String url;
    private int version;

    public Character(int characterId, List<String> films, List<String> shortFilms, List<String> tvShows,  List<String> videoGames, List<String> parkAttractions, List<String> allies, List<String> enemies, String sourceUrl, String name, String imageUrl, String createdAt, String updatedAt, String url, int version) {
        this.characterId = characterId;
        this.films = films;
        this.shortFilms = shortFilms;
        this.tvShows = tvShows;
        this.videoGames = videoGames;
        this.parkAttractions = parkAttractions;
        this.allies = allies;
        this.enemies = enemies;
        this.sourceUrl = sourceUrl;
        this.name = name;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.url = url;
        this.version = version;
    }

    public int getCharacterId() {
        return characterId;
    }

    public List<String> getFilms() {
        return films;
    }

    public List<String> getShortFilms() {
        return shortFilms;
    }

    public List<String> getTVShows() {
        return tvShows;
    }

    public List<String> getVideoGames() {
        return videoGames;
    }

    public List<String> getParkAttractions() {
        return parkAttractions;
    }

    public List<String> getAllies() {
        return allies;
    }

    public List<String> getEnemies() {
        return enemies;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getUrl() {
        return url;
    }

    public int getVersion() {
        return version;
    }
}
