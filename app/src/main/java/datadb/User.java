package datadb;

import java.util.Date;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

@Entity
public class User {
    @Id
    public long id;
    public String name;
    public String surname;
    public Date age;
    public String status;
    public String country;
    public String description;
    public ToMany<City> destinations;

    public User(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ToMany<City> getDestinations() {
        return destinations;
    }

    public void setDestinations(ToMany<City> destinations) {
        this.destinations = destinations;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o){
        User u = (User) o;
        return u.getName().equals(this.getName()) && u.getSurname().equals(this.getSurname()) &&
                u.getAge().equals(this.getAge()) && u.getCountry().equals(this.getCountry()) &&
                u.getDescription().equals(this.getDescription());
    }
}
