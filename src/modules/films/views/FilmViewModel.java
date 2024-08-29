package modules.films.views;

import modules.films.models.Film;
import modules.films.repositories.FilmRepository;

import java.util.Optional;

public class FilmViewModel {
    private FilmRepository repository = new FilmRepository();

    public boolean validateAnswer(int answer) {
        return (answer == 1 || answer == 2);
    }

    public void findRecommendedFilm(int enviroment, int genre) {
        Optional<Film> filmRecommended = repository.findRecommendedFilm(enviroment, genre);

        if (filmRecommended.isPresent()) {
            System.out.println("Filme recomendado: " + filmRecommended.get().toString());
        } else {
            System.out.println("Filme recomendado não encontrado :(");
        }
    }
}
