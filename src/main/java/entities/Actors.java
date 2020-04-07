package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actors {

    @Id
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "pay")
    private double pay;

    @ManyToMany(cascade= {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "movieList")
    private List<Movies> moviesList = new ArrayList<Movies>();


    public Actors() {
    }

    public Actors(int id, String firstName, String lastName, double pay){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pay = pay;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Id" + getId() +
                " firstName" + getFirstName() +
                " lastName" + getLastName() +
                " pay" + getPay();
    }
}
