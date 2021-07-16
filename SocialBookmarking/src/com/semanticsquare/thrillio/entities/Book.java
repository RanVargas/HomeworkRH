package com.semanticsquare.thrillio.entities;

import com.semanticsquare.thrillio.partner.Shareable;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;

public class Book extends Bookmark implements Shareable {
    private int publicationYear;
    private String publisher;
    private String[] authors;
    private String genre;
    private double amazonRating;

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getAmazonRating() {
        return amazonRating;
    }

    public void setAmazonRating(double amazonRating) {
        this.amazonRating = amazonRating;
    }

    @Override
    public String toString(){
        return MessageFormat.format("Book [id={0}, title={1}, profileUrl={2}, publicationYear={3}," +
                        " publisher={4}, authors={5}, genre={6}, amazonRating={7}]", getId(), getTitle(),
                getProfileUrl(), publicationYear,
                publisher, authors, genre, amazonRating);
    }


    @Override
    public boolean isKidFriendlyElegible() {
        return false;
    }

    @Override
    public String getItemData() {
        StringBuilder builder = new StringBuilder();
        builder.append("<item>?");
            builder.append("<type>Book</type>");
            builder.append("<title>").append(getTitle()).append("</title>");
            builder.append("<authors>").append(StringUtils.join(authors, ", ")).append("</authors>");
            builder.append("<publisher>").append(publisher).append("</publisher>");
            builder.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
            builder.append("<genre>").append(genre).append("</genre>");
            builder.append("<amazonRating>").append(amazonRating).append("</amazonRating>");
        builder.append("</item>");

        return builder.toString();
    }
}
