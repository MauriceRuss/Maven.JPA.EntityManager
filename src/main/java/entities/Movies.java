package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movies {

    @Id
    private int id;

    @Column(name = "title")
    private  String title;

    @Column(name = "genre")
    private String genre;

    @Column(name = "year")
    private Date year;

    @Column(name = "artist")
    private String artist;

    @Column(name = "price")
    private Double price;

    @OneToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "actorsCList")
    private List<Actors> actorsList = new ArrayList<Actors>();


    public Movies() {
    }

    public Movies(int id, String title, String genre, Date year, String artist, double price){
        this.id = id;
        this.title= title;
        this.genre = genre;
        this.year = year;
        this.artist = artist;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Id" + getId() +
                " title" + getTitle() +
                " genre'" + getGenre() +
                " year" + getYear() +
                ", artist'" + getArtist() +
                ", price" + getPrice();
    }


}
