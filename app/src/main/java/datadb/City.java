package datadb;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

@Entity
public class City {
    @Id
    public long id;
    //nome città
    public String name;
    //descrizione città
    public String description;
    //può contenere i tag: Sea, mountain, art, Food, romantic
    public ToMany<Kind> kinds;
    //se la città è nello stato o all'estero
    public boolean local;
    //valore che varia tra 0 e 3, indicante il possibile costo
    public int budget;
    //può contenere i tag: Relax, Adventure, Museum, Night
    public ToMany<Attraction> activities;
    //valore che varia tra 0 e 3, indicante la quantità di turisti che possono essere presenti in città
    public int tourists;
    //valore che varia tra 0 e 2, rispettivamente 0 = Cold, 1 = Temperate, 2 = Hot
    public int temperature;

    public City(){}

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

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public ToMany<Kind> getKinds() {
        return kinds;
    }

    public void setKinds(ToMany<Kind> kinds) {
        this.kinds = kinds;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public ToMany<Attraction> getActivities() {
        return activities;
    }

    public void setActivities(ToMany<Attraction> activities) {
        this.activities = activities;
    }

    public int getTourists() {
        return tourists;
    }

    public void setTourists(int tourists) {
        this.tourists = tourists;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
