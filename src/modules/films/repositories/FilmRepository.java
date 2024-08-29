package modules.films.repositories;

import modules.films.models.Film;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FilmRepository {
    public List<Film> films = new ArrayList<Film>();

    public FilmRepository() {
        films.add(new Film(1, 1, "Homens de Preto"));
        films.add(new Film(1, 2, "Arrival"));
        films.add(new Film(2, 1, "Shrek"));
        films.add(new Film(2, 2, "Gladiador"));
    }

    public Optional<Film> findRecommendedFilm(int environment, int genre) {
        Optional<Film> filmRecommended = films.stream().filter(film -> environment == film.getEnvironment() && genre == film.getGenre()).findFirst();

        return filmRecommended;
    }

}
