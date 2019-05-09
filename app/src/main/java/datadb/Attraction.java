package datadb;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Attraction {
    @Id
    public long id;
    //può essere solo uno tra Relax, Adventure, Museum e Night
    public String attraction;

    public Attraction(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAttraction() {
        return attraction;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }

    @Override
    public boolean equals(Object o){
        Attraction a = (Attraction) o;
        return a.getAttraction().equals(getAttraction());
    }
}