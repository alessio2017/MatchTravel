package datadb;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Kind {
    @Id
    public long id;
    //può essere solo uno tra Sea, mountain, art, Food e romantic
    public String kind;

    public Kind() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public boolean equals(Object o ){
        Kind k = (Kind) o;
        return k.getKind().equals(getKind());
    }
}