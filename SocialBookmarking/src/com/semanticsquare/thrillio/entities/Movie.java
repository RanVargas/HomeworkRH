package com.semanticsquare.thrillio.entities;

import java.text.MessageFormat;

public class Movie extends Bookmark{
    private int releaseYear;
    private String[] cast;
    private String[] directors;
    private String genre;
    private double imdbRating;

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String[] getCast() {
        return cast;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public String[] getDirectors() {
        return directors;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    @Override
    public String toString(){
        return MessageFormat.format("Movie [id={0}, title={1}, profileUrl={2}, releaseYear={3}," +
                " cast={4}, directors={5}, genre={6}, imdbRating={7}]", getId(), getTitle(), getProfileUrl(),
                releaseYear, cast, directors, genre, imdbRating);
    }


    @Override
    public boolean isKidFriendlyElegible() {
        return false;
    }
}
