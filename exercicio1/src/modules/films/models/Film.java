package modules.films.models;

public class Film {
    public int environment;
    public int genre;
    public String title;

    public int getEnvironment() {
        return environment;
    }

    public int getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return this.title;
    }

    public Film(int environment, int genre, String title) {
        this.genre = genre;
        this.environment = environment;
        this.title = title;
    }
}
