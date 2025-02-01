package hu.younes;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Book extends Item implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Set<String> authors;
    private int publicationYear;
    private double price;

    public Book() {
        super("Ismeretlen cim");
        this.authors = new HashSet<>();
        this.publicationYear = 0;
        this.price = 0.0;
    }

    public Book(String title, Set<String> authors, int publicationYear, double price) {
        super(title);
        this.authors = authors;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getItemInfo() {
        return super.getItemInfo() + ", Szerző: " + authors + ", Év: " + publicationYear + ", Ár: " + price + " Ft";
    }

    @Override
    public boolean matches(String keyword) {
        return super.matches(keyword) || authors.stream().anyMatch(author -> author.toLowerCase().contains(keyword.toLowerCase()));
    }
}
