package com.example.movidle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import javafx.scene.layout.AnchorPane;

public class Controller {
    @FXML
    public TextField textField;
    @FXML
    public Label titleLabel;
    @FXML
    public Label yearLabel;
    @FXML
    public Label genreLabel;
    @FXML
    public Label originLabel;
    @FXML
    public Label directorLabel;
    @FXML
    public Label starLabel;
    @FXML
    public Label title1;
    @FXML
    public Label year1;
    @FXML
    public Label genre1;
    @FXML
    public Label origin1;
    @FXML
    public Label director1;
    @FXML
    public Label star1;
    @FXML
    public Label title2;
    @FXML
    public Label year2;
    @FXML
    public Label genre2;
    @FXML
    public Label origin2;
    @FXML
    public Label director2;
    @FXML
    public Label star2;
    @FXML
    public Label title3;
    @FXML
    public Label year3;
    @FXML
    public Label genre3;
    @FXML
    public Label origin3;
    @FXML
    public Label director3;
    @FXML
    public Label star3;
    @FXML
    public Label title4;
    @FXML
    public Label year4;
    @FXML
    public Label genre4;
    @FXML
    public Label origin4;
    @FXML
    public Label director4;
    @FXML
    public Label star4;
    @FXML
    public Label title5;
    @FXML
    public Label year5;
    @FXML
    public Label genre5;
    @FXML
    public Label origin5;
    @FXML
    public Label director5;
    @FXML
    public Label star5;
    @FXML
    private Label head;
    @FXML
    private Button guessBtn;
    @FXML
    private TextField searchBar;
    @FXML
    private AnchorPane rootPane;

    private int guessCount;
    private Movie slc;
    ArrayList<Movie> movieList = new ArrayList<>();

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setSelectedMovie() {
        slc = Movie.movieSelector(getMovieList());
    }

    public Movie getSelectedMovie() {
        return slc;
    }


    @FXML
    public void initialize() throws Exception {
        Movie.movieReader(getMovieList());
        setSelectedMovie();
        guessCount = 0;
    }

    @FXML
    private void won() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Movidle");
        alert.setHeaderText("You Won!");
        Button restartButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        restartButton.setText("Restart");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            alert.close();
            Platform.runLater(() -> {
                try {
                    restartApplication();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @FXML
    private void lost() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Movidle");
        alert.setHeaderText("You Lost!");
        Button restartButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        restartButton.setText("Restart");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            alert.close();
            Platform.runLater(() -> {
                try {
                    restartApplication();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @FXML
    private void restartApplication() throws Exception {
        rootPane.getScene().getWindow().hide();
        Main main = new Main();
        main.start(new Stage());
    }

    @FXML
    public void handleGuessButton(ActionEvent event){
        String userGuess = searchBar.getText();
        if (guessCount == 0) {

            title1.setText(userGuess);
            year1.setText(Movie.getLabelYear(getMovieList(), userGuess));
            genre1.setText(Movie.getLabelGenre(getMovieList(), userGuess));
            origin1.setText(Movie.getLabelOrigin(getMovieList(), userGuess));
            director1.setText(Movie.getLabelDirector(getMovieList(), userGuess));
            star1.setText(Movie.getLabelStar(getMovieList(), userGuess));

            if (Movie.titleComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                for (Label label : Arrays.asList(title1, year1, genre1, origin1, director1, star1)) {
                    label.setStyle("-fx-background-color: green");
                }
                won();
            } else {
                title1.setStyle("-fx-background-color: red");
                if (Movie.yearComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    year1.setStyle("-fx-background-color: green");
                } else {
                    year1.setStyle("-fx-background-color: red");
                }
                if (Movie.genreComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    genre1.setStyle("-fx-background-color: green");
                } else {
                    genre1.setStyle("-fx-background-color: red");
                }
                if (Movie.originComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    origin1.setStyle("-fx-background-color: green");
                } else {
                    origin1.setStyle("-fx-background-color: red");
                }
                if (Movie.directorComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    director1.setStyle("-fx-background-color: green");
                } else {
                    director1.setStyle("-fx-background-color: red");
                }
                if (Movie.starComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    star1.setStyle("-fx-background-color: green");
                } else {
                    star1.setStyle("-fx-background-color: red");
                }
            }
        } else if (guessCount == 1) {

            title2.setText(userGuess);
            year2.setText(Movie.getLabelYear(getMovieList(), userGuess));
            genre2.setText(Movie.getLabelGenre(getMovieList(), userGuess));
            origin2.setText(Movie.getLabelOrigin(getMovieList(), userGuess));
            director2.setText(Movie.getLabelDirector(getMovieList(), userGuess));
            star2.setText(Movie.getLabelStar(getMovieList(), userGuess));

            if (Movie.titleComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                for (Label label : Arrays.asList(title2, year2, genre2, origin2, director2, star2)) {
                    label.setStyle("-fx-background-color: green");
                }
                won();
            } else {
                title2.setStyle("-fx-background-color: red");
                if (Movie.yearComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    year2.setStyle("-fx-background-color: green");
                } else {
                    year2.setStyle("-fx-background-color: red");
                }
                if (Movie.genreComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    genre2.setStyle("-fx-background-color: green");
                } else {
                    genre2.setStyle("-fx-background-color: red");
                }
                if (Movie.originComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    origin2.setStyle("-fx-background-color: green");
                } else {
                    origin2.setStyle("-fx-background-color: red");
                }
                if (Movie.directorComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    director2.setStyle("-fx-background-color: green");
                } else {
                    director2.setStyle("-fx-background-color: red");
                }
                if (Movie.starComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    star2.setStyle("-fx-background-color: green");
                } else {
                    star2.setStyle("-fx-background-color: red");
                }
            }

        } else if (guessCount == 2) {

            title3.setText(userGuess);
            year3.setText(Movie.getLabelYear(getMovieList(), userGuess));
            genre3.setText(Movie.getLabelGenre(getMovieList(), userGuess));
            origin3.setText(Movie.getLabelOrigin(getMovieList(), userGuess));
            director3.setText(Movie.getLabelDirector(getMovieList(), userGuess));
            star3.setText(Movie.getLabelStar(getMovieList(), userGuess));

            if (Movie.titleComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                for (Label label : Arrays.asList(title3, year3, genre3, origin3, director3, star3)) {
                    label.setStyle("-fx-background-color: green");
                }
                won();
            } else {
                title3.setStyle("-fx-background-color: red");
                if (Movie.yearComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    year3.setStyle("-fx-background-color: green");
                } else {
                    year3.setStyle("-fx-background-color: red");
                }
                if (Movie.genreComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    genre3.setStyle("-fx-background-color: green");
                } else {
                    genre3.setStyle("-fx-background-color: red");
                }
                if (Movie.originComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    origin3.setStyle("-fx-background-color: green");
                } else {
                    origin3.setStyle("-fx-background-color: red");
                }
                if (Movie.directorComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    director3.setStyle("-fx-background-color: green");
                } else {
                    director3.setStyle("-fx-background-color: red");
                }
                if (Movie.starComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    star3.setStyle("-fx-background-color: green");
                } else {
                    star3.setStyle("-fx-background-color: red");
                }
            }

        } else if (guessCount == 3) {

            title4.setText(userGuess);
            year4.setText(Movie.getLabelYear(getMovieList(), userGuess));
            genre4.setText(Movie.getLabelGenre(getMovieList(), userGuess));
            origin4.setText(Movie.getLabelOrigin(getMovieList(), userGuess));
            director4.setText(Movie.getLabelDirector(getMovieList(), userGuess));
            star4.setText(Movie.getLabelStar(getMovieList(), userGuess));

            if (Movie.titleComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                for (Label label : Arrays.asList(title4, year4, genre4, origin4, director4, star4)) {
                    label.setStyle("-fx-background-color: green");
                }
                won();
            } else {
                title4.setStyle("-fx-background-color: red");
                if (Movie.yearComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    year4.setStyle("-fx-background-color: green");
                } else {
                    year4.setStyle("-fx-background-color: red");
                }
                if (Movie.genreComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    genre4.setStyle("-fx-background-color: green");
                } else {
                    genre4.setStyle("-fx-background-color: red");
                }
                if (Movie.originComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    origin4.setStyle("-fx-background-color: green");
                } else {
                    origin4.setStyle("-fx-background-color: red");
                }
                if (Movie.directorComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    director4.setStyle("-fx-background-color: green");
                } else {
                    director4.setStyle("-fx-background-color: red");
                }
                if (Movie.starComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    star4.setStyle("-fx-background-color: green");
                } else {
                    star4.setStyle("-fx-background-color: red");
                }
            }

        } else if (guessCount == 4) {

            title5.setText(userGuess);
            year5.setText(Movie.getLabelYear(getMovieList(), userGuess));
            genre5.setText(Movie.getLabelGenre(getMovieList(), userGuess));
            origin5.setText(Movie.getLabelOrigin(getMovieList(), userGuess));
            director5.setText(Movie.getLabelDirector(getMovieList(), userGuess));
            star5.setText(Movie.getLabelStar(getMovieList(), userGuess));

            if (Movie.titleComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                for (Label label : Arrays.asList(title5, year5, genre5, origin5, director5, star5)) {
                    label.setStyle("-fx-background-color: green");
                }
                won();
            } else {
                title5.setStyle("-fx-background-color: red");
                if (Movie.yearComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    year5.setStyle("-fx-background-color: green");
                } else {
                    year5.setStyle("-fx-background-color: red");
                }
                if (Movie.genreComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    genre5.setStyle("-fx-background-color: green");
                } else {
                    genre5.setStyle("-fx-background-color: red");
                }
                if (Movie.originComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    origin5.setStyle("-fx-background-color: green");
                } else {
                    origin5.setStyle("-fx-background-color: red");
                }
                if (Movie.directorComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    director5.setStyle("-fx-background-color: green");
                } else {
                    director5.setStyle("-fx-background-color: red");
                }
                if (Movie.starComparator(getMovieList(), getSelectedMovie(), userGuess)) {
                    star5.setStyle("-fx-background-color: green");
                } else {
                    star5.setStyle("-fx-background-color: red");
                }
                lost();
            }
        }
        guessCount++;
        searchBar.clear();
    }
}
