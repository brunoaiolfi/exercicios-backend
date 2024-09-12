package modules.films.views;

import java.util.Scanner;

public class FilmView {

    private FilmViewModel filmViewModel = new FilmViewModel();

    public void render() {
        Scanner scanner = new Scanner(System.in);

        int filmEnviroment = 0;
        int filmGenre = 0;

        String tempFilmSetting, tempFilGenre = "";

        FilmViewModel filmViewModel = new FilmViewModel();
        boolean looper = true;

        while (looper) {
            System.out.println("Pergunta 1: Que ambientação você prefere?");
            System.out.println("1. Sci-fi");
            System.out.println("2. Medieval");

            tempFilmSetting = scanner.nextLine();

            looper = !filmViewModel.validateAnswer(Integer.parseInt(tempFilmSetting));

            if (!looper) filmEnviroment = Integer.parseInt(tempFilmSetting);
        }

        looper = true;

        while (looper) {
            System.out.println("Pergunta 2: Que gênero você prefere?");
            System.out.println("1. Comédia");
            System.out.println("2. Drama");

            tempFilGenre = scanner.nextLine();

            looper = !filmViewModel.validateAnswer(Integer.parseInt(tempFilGenre));

            if (!looper) filmGenre = Integer.parseInt(tempFilGenre);
        }

        filmViewModel.findRecommendedFilm(filmEnviroment, filmGenre);
    }


}
